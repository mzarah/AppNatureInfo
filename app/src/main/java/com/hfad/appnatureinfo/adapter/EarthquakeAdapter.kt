package com.hfad.appnatureinfo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hfad.appnatureinfo.R
import com.hfad.appnatureinfo.model.Feature
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.floor
import kotlin.math.round
import kotlin.math.truncate


class EarthquakeAdapter: RecyclerView.Adapter<EarthquakeAdapter.MyViewHolder>() {
    private var earthquakeList:  List<Feature>? = emptyList<Feature>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.fragment_earthquake_list,
                        parent,
                        false
                )
        )
    }


    override fun getItemCount(): Int {
        return earthquakeList!!.size
    }


    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        val unixSeconds: Long = earthquakeList?.get(
                position
        )?.properties?.time!!.toLong()
        val date = Date(unixSeconds)
        val sdf = SimpleDateFormat("dd.MM.yy HH:mm z")
        sdf.timeZone = TimeZone.getTimeZone("GMT+4")
        val formattedDate = sdf.format(date)



        holder.itemView.findViewById<TextView>(R.id.textViewMagnitude).text = String.format("%.2f", earthquakeList?.get(
                position
        )?.properties?.mag!!.toDouble())

        holder.itemView.findViewById<TextView>(R.id.textViewLocation).text = earthquakeList?.get(
                position
        )?.properties?.place.toString()

        holder.itemView.findViewById<TextView>(R.id.textViewTime).text = formattedDate

    }

    fun setData(newList: List<Feature>?){
        earthquakeList = newList
        notifyDataSetChanged()
    }

        fun getMagnitudeColor(magnitude: Double): Int {
            val magnitudeColorResourceId: Int
            val magnitudeFloor: Int = floor(magnitude).toInt()

            magnitudeColorResourceId = when (magnitudeFloor) {
                //  1 -> magnitudeColorResourceId = R.color.magnitude1;
                1 -> R.color.magnitude8
                3 -> R.color.magnitude2
                4 -> R.color.magnitude4
                6 -> R.color.magnitude5
                7 -> R.color.magnitude7
                8 -> R.color.magnitude8
                else -> {
                    R.color.magnitude8
                }
            }

            return magnitudeColorResourceId
        }



}