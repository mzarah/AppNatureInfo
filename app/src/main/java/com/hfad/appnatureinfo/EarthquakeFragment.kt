package com.hfad.appnatureinfo

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hfad.appnatureinfo.adapter.EarthquakeAdapter
import com.hfad.appnatureinfo.repository.Repository
import kotlinx.android.synthetic.main.fragment_earthquake.*





class EarthquakeFragment : Fragment() {


    private val earthquakeAdapter: EarthquakeAdapter? = EarthquakeAdapter()
    private var viewModel: EarthquakeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_earthquake, container, false)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        earthquakeRecycler.adapter = earthquakeAdapter
        earthquakeRecycler.layoutManager = LinearLayoutManager(context)

        val repository = Repository()
        val viewModelFactory = EarthquakeViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(EarthquakeViewModel::class.java)

        viewModel!!.getEarthquake()

        viewModel!!.earthquakeResponse.observe(viewLifecycleOwner, {
            if (it.isSuccessful) {
                it.body()?.features.let { earthquakeAdapter?.setData(it) }
            } else {
                Log.d("ERROR", it.errorBody().toString())
                Toast.makeText(context, it.code().toString(), Toast.LENGTH_SHORT).show()
            }


        }
        )


    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)


    }


}