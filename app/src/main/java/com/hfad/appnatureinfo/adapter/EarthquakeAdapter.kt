package com.hfad.appnatureinfo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hfad.appnatureinfo.R
import com.hfad.appnatureinfo.model.Feature
import com.hfad.appnatureinfo.model.Properties

class EarthquakeAdapter: RecyclerView.Adapter<EarthquakeAdapter.MyViewHolder>() {
    private var earthquakeList:  List<Feature>? = emptyList<Feature>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_earthquake_list, parent, false))
    }


    override fun getItemCount(): Int {
        return earthquakeList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.findViewById<TextView>(R.id.textViewMagnitude).text = earthquakeList?.get(position)?.properties?.mag.toString()
        holder.itemView.findViewById<TextView>(R.id.textViewLocation).text = earthquakeList?.get(position)?.properties?.place.toString()
        holder.itemView.findViewById<TextView>(R.id.textViewTime).text = earthquakeList?.get(position)?.properties?.time.toString()
    }

    fun setData(newList: List<Feature>?){
        earthquakeList = newList
        notifyDataSetChanged()
    }

    fun test() {

    }
}