package com.sekar.ritxbertaniminiapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.sekar.ritxbertaniminiapp.model.CreateRequest
import com.sekar.ritxbertaniminiapp.model.DataItem
import com.sekar.ritxbertaniminiapp.repository.SensorViewModel
import kotlinx.android.synthetic.main.activity_input_lahan.*

class InputLahanActivity : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtSerial: EditText

    private lateinit var viewModel: SensorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_lahan)

        viewModel = ViewModelProviders.of(this).get(SensorViewModel::class.java)

        val adapaterRegion = ArrayAdapter.createFromResource(
            this,
            R.array.province_list,
            android.R.layout.simple_spinner_item
        )
        adapaterRegion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin_province.adapter = adapaterRegion

        val adapaterCity = ArrayAdapter.createFromResource(
            this,
            R.array.city_list,
            android.R.layout.simple_spinner_item
        )
        adapaterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin_city.adapter = adapaterCity

        initView()
    }

    private fun initView() {

        edtName = findViewById(R.id.edt_nama_lahan)
        edtSerial = findViewById(R.id.edt_id_sensor)

        ll_add_lahan.setOnClickListener {
            saveLahan()
        }
    }

    private fun saveLahan() {

        val result = DataItem()
        val id = result.id
        val name = edtName.text.toString().trim()
        val serial = edtSerial.text.toString().trim()

        if (!name.isEmpty() || !serial.isEmpty()) {
            val createRequest = CreateRequest(
                null, null, "",
                serial, "", name, "", ""
            )
            viewModel.createSensor(createRequest)  //  insert note to db

            val data = Intent()
            data.putExtra("EXTRA_ID", "${id}")
            data.putExtra("EXTRA_NAME_LAHAN", "${name}")
            data.putExtra("EXTRA_ID_SENSOR", "${serial}")
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}