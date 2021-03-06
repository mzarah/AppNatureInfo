package com.hfad.appnatureinfo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hfad.appnatureinfo.R
import com.hfad.appnatureinfo.model.DisasterDeclarationsSummary
import java.util.Collections.emptyList


class DisasterAdapter: RecyclerView.Adapter<DisasterAdapter.MyViewHolder>() {
    private var disasterList:  List<DisasterDeclarationsSummary>? = emptyList<DisasterDeclarationsSummary>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.fragment_disaster_list,
                        parent,
                        false
                )
        )
    }


    override fun getItemCount(): Int {
        return disasterList!!.size
    }


    @SuppressLint("SimpleDateFormat", "CutPasteId", "SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.findViewById<TextView>(R.id.textViewType).text = disasterList?.get(
                position
        )?.incidentType

                holder.itemView.findViewById<TextView>(R.id.textViewPlace).text = "USA, " + disasterList?.get(
                position
        )?.state

        holder.itemView.findViewById<TextView>(R.id.textViewDate).text = disasterList?.get(
                position
        )?.incidentBeginDate!!.split("T")[0]



        val backgroudRsrc = getTypeColor(disasterList!!.get(
                position
        ).incidentType)

       holder.itemView.findViewById<TextView>(R.id.textViewType).setBackgroundResource(backgroudRsrc)


    }

    fun setData(newList: List<DisasterDeclarationsSummary>?){
        disasterList = newList
        notifyDataSetChanged()
    }

        fun getTypeColor(type: String): Int {

            return when (type) {
                "Flood" -> R.drawable.flood
                "Fire" -> R.drawable.fire
                "Tornado" -> R.drawable.tornado
                "Severe Storm(s)" -> R.drawable.severe
                "Earthquake" -> R.drawable.earthquake
                "Hurricane" -> R.drawable.hurricane
                "Drought" -> R.drawable.drought
                "Toxic Substances" -> R.drawable.toxic
                "Typhoon" -> R.drawable.typhoon
                "Dam/Levee Break" -> R.drawable.severe
                "Other" -> R.drawable.other
                else -> {
                    R.drawable.other
                }
            }
        }



}