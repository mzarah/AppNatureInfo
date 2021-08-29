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
import com.hfad.appnatureinfo.adapter.DisasterAdapter
import com.hfad.appnatureinfo.adapter.EarthquakeAdapter
import com.hfad.appnatureinfo.repository.DisasterRepository
import com.hfad.appnatureinfo.repository.NetworkState.Companion.LOADING
import com.hfad.appnatureinfo.repository.EarthquakeRepository
import com.hfad.appnatureinfo.viewmodel.DisasterViewModel
import com.hfad.appnatureinfo.viewmodel.DisasterViewModelFactory
import com.hfad.appnatureinfo.viewmodel.EarthquakeViewModel
import com.hfad.appnatureinfo.viewmodel.EarthquakeViewModelFactory
import kotlinx.android.synthetic.main.fragment_disasters.*
import kotlinx.android.synthetic.main.fragment_earthquake.*
import kotlinx.android.synthetic.main.fragment_earthquake.earthquakeRecycler
import kotlinx.android.synthetic.main.fragment_earthquake.loadingBar


class DisasterFragment : Fragment() {


    private val disasterAdapter: DisasterAdapter? = DisasterAdapter()
    private var viewModel: DisasterViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_disasters, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        disasterRecycler.adapter = disasterAdapter
        disasterRecycler.layoutManager = LinearLayoutManager(context)

        val repository = DisasterRepository()
        val viewModelFactory = DisasterViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DisasterViewModel::class.java)

        viewModel!!.getDisaster()

        viewModel!!.disasterResponse.observe(viewLifecycleOwner, {
            if (it.isSuccessful) {
                it.body()?.disasterDeclarationsSummaries.let { disasterAdapter?.setData(it) }
            } else {
                Log.d("ERROR", it.errorBody().toString())
                Toast.makeText(context, it.code().toString(), Toast.LENGTH_SHORT).show()
            }
        })


        viewModel!!.networkState.observe(viewLifecycleOwner, {
            if (it == LOADING) {
                loadingBar.visibility = View.VISIBLE
                disasterRecycler.visibility = View.GONE
            } else {
                loadingBar.visibility = View.GONE
                disasterRecycler.visibility = View.VISIBLE
            }

        })


    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)


    }


}