package com.sekar.ritxbertaniminiapp.utils

import android.view.View
import com.sekar.ritxbertaniminiapp.model.DataItem

interface RecyclerViewClickListener {
    // method yang akan dipanggil di MainActivity atau Fragment
    fun onItemClicked(view: View, dataItem: DataItem)
}