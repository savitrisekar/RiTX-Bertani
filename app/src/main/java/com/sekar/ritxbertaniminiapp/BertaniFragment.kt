package com.sekar.ritxbertaniminiapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.sekar.ritxbertaniminiapp.adapter.MyAdapter
import kotlinx.android.synthetic.main.fragment_bertani.*

class BertaniFragment : Fragment() {

//    lateinit var myAdapter: MyAdapter

    private val myContext = FragmentActivity()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bertani, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureTopNavigation()
    }

    private fun configureTopNavigation(){
        viewPager.adapter = MyAdapter(
            childFragmentManager,
            3
        )

        viewPager.offscreenPageLimit = 3
        tabLayout.setupWithViewPager(viewPager)
    }
}