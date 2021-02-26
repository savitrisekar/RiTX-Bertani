package com.sekar.ritxbertaniminiapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.sekar.ritxbertaniminiapp.AktivitasFragment
import com.sekar.ritxbertaniminiapp.KomoditasFragment
import com.sekar.ritxbertaniminiapp.LahanFragment

class MyAdapter(fm : FragmentManager, val fragmentCount : Int): FragmentStatePagerAdapter(fm) {

    private val fragmentTitleList = mutableListOf("Lahan", "Komoditas","Aktivitas")

    override fun getItem(position:Int): Fragment {

        when(position){
            0-> return LahanFragment()
            1-> return KomoditasFragment()
            2-> return AktivitasFragment()
            else -> return LahanFragment()
        }
    }

    override fun getPageTitle(position: Int):CharSequence?{
        return fragmentTitleList[position]
    }
    override fun getCount(): Int = fragmentCount
}