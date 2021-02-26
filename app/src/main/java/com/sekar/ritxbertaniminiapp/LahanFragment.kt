package com.sekar.ritxbertaniminiapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sekar.ritxbertaniminiapp.adapter.LahanAdapter
import com.sekar.ritxbertaniminiapp.model.CreateRequest
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
        setupDelete()

        viewModel.getSensor()
    }

    private fun setupDelete() {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.deleteSensor(
                    adapterLahan.getDataAt(viewHolder.adapterPosition).toString()
                )
                Toast.makeText(requireContext(), "Data deleted", Toast.LENGTH_LONG).show()
            }
        }).attachToRecyclerView(rv_lahan)
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
                progressbar.visibility = View.GONE
            }
        })

        viewModel.showFailure.observe(viewLifecycleOwner, Observer { isFailed ->

            isFailed?.let {
                Toast.makeText(context, "Oops! something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == AppCompatActivity.RESULT_OK && data != null) {

            val createRequest = CreateRequest()
            viewModel.createSensor(createRequest)
            Toast.makeText(requireContext(), "Contact Saved!", Toast.LENGTH_SHORT).show()
        }

    }

}