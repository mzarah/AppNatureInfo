package com.hfad.appnatureinfo.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hfad.appnatureinfo.R
import com.hfad.appnatureinfo.adapter.EarthquakeAdapter
import com.hfad.appnatureinfo.repository.NetworkState.Companion.LOADING
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
        })

        viewModel!!.networkState.observe(viewLifecycleOwner, {
            if (it == LOADING) {
                loadingBar.visibility = View.VISIBLE
                earthquakeRecycler.visibility = View.GONE
            } else {
                loadingBar.visibility = View.GONE
                earthquakeRecycler.visibility = View.VISIBLE
            }

        })


    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)


    }


}