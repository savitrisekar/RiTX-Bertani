package com.sekar.ritxbertaniminiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.sekar.ritxbertaniminiapp.R
import com.sekar.ritxbertaniminiapp.model.DataItem

class LahanAdapter : RecyclerView.Adapter<LahanAdapter.ViewHolder>() {

    private var data: List<DataItem> = listOf()

    fun setData(dataList: List<DataItem>) {
        data = dataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LahanAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_lahan, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItems(data[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val serialNumber = itemView.findViewById<TextView>(R.id.tv_serial_number)

        fun bindItems(dataItem: DataItem) {
            name.text = dataItem.displayName
            serialNumber.text = dataItem.serialNumber

            itemView.setOnClickListener {
                Toast.makeText(it.context, "delete", Toast.LENGTH_SHORT).show()
            }
        }
    }
}