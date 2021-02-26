package com.sekar.ritxbertaniminiapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.sekar.ritxbertaniminiapp.adapter.LahanAdapter
import com.sekar.ritxbertaniminiapp.repository.SensorViewModel
import kotlinx.android.synthetic.main.fragment_lahan.*

class LahanFragment : Fragment() {

    private lateinit var viewModel: SensorViewModel
    private lateinit var adapterLahan: LahanAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lahan, container, false)

        viewModel = ViewModelProviders.of(this).get(SensorViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        setupRecyclerView()
        setupObservers()

        viewModel.getSensor()
    }

    private fun initView() {

        btn_add_lahan.setOnClickListener {
            val intent = Intent(requireContext(), InputLahanActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        adapterLahan = LahanAdapter()
        rv_lahan.layoutManager = LinearLayoutManager(requireContext())
        rv_lahan.adapter = adapterLahan
    }

    private fun setupObservers() {
        viewModel.showSuccess.observe(viewLifecycleOwner, Observer { lahan ->

            lahan?.let {
                adapterLahan.setData(it)
            }
        })

        viewModel.showFailure.observe(viewLifecycleOwner, Observer { isFailed ->

            isFailed?.let {
                Toast.makeText(context, "Oops! something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
    }
}