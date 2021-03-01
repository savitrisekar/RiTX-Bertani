package com.sekar.ritxbertaniminiapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sekar.ritxbertaniminiapp.InputLahanActivity
import com.sekar.ritxbertaniminiapp.R
import com.sekar.ritxbertaniminiapp.model.DataItem

class LahanAdapter(private val context: Context) : RecyclerView.Adapter<LahanAdapter.ViewHolder>() {

    private var data: List<DataItem> = listOf()
    private var listener: OnItemClickListener? = null

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
        val dataList = data[position]

        holder.name.text = dataList.displayName
        holder.serialNumber.text = dataList.serialNumber

        holder.itemView.setOnClickListener {
//            listener!!.OnItemClick(data[position])
            val intent = Intent(context, InputLahanActivity::class.java)
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val serialNumber = itemView.findViewById<TextView>(R.id.tv_serial_number)
    }

    fun getDataAt(position: Int): String? {
        return data[position].id
    }

    interface OnItemClickListener {
        abstract fun OnItemClick(dataItem: DataItem)
    }
}