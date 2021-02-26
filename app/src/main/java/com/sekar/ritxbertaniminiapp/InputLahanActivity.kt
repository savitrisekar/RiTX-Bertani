package com.sekar.ritxbertaniminiapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input_lahan.*

class InputLahanActivity : AppCompatActivity() {

    lateinit var lahanName: EditText
    lateinit var idSensor: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_lahan)

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

        lahanName = findViewById(R.id.edt_nama_lahan)
        idSensor = findViewById(R.id.edt_id_sensor)

        ll_add_lahan.setOnClickListener {
            saveLahan()
        }
    }

    private fun saveLahan() {
        if (lahanName.text.isNotEmpty() || spin_province != null || spin_city != null || idSensor.text.isNotEmpty()
        ) {

            val data = Intent()
            data.putExtra("EXTRA_NAME_LAHAN", "${lahanName.text}")
            data.putExtra("EXTRA_ID_SENSOR", "${idSensor.text}")
            setResult(Activity.RESULT_OK, data)
            finish()

        } else {
            Toast.makeText(this, "Provide Complete Data", Toast.LENGTH_SHORT).show()
        }
    }
}