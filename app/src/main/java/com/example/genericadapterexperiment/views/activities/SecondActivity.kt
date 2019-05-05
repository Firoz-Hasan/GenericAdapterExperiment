package com.example.genericadapterexperiment.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.genericadapterexperiment.R
import com.example.genericadapterexperiment.viewmodel.SecondActivityVM
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private lateinit var secondViewModel: SecondActivityVM
    var liveData = " nothing added so far"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        secondViewModel = ViewModelProviders.of(this)?.get(SecondActivityVM::class.java)
        secondViewModel.getLiveData()?.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {
                Log.d("SecondActivity", "Value: $t")
                tv1.text = "OnStateChanged $t"
                Toast.makeText(this@SecondActivity, t, Toast.LENGTH_LONG).show()
            }
        })
        btn1?.setOnClickListener {
            liveData = et1.text.toString()
            secondViewModel.setLiveData(liveData)
            Log.d("SecondActivity", "Value: $liveData")
            //Toast.makeText(this@MainActivity, str, Toast.LENGTH_LONG).show()
            tv1.text = "OnButtonClicked $liveData"
        }

    }
}
