package com.example.genericadapterexperiment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondActivityVM : ViewModel() {

    private var mutableLiveData = MutableLiveData<String>()
    fun setLiveData(str: String?) {
        mutableLiveData?.value = str
    }

    fun getLiveData(): MutableLiveData<String>? {
        //return testLiveData
        return if (!mutableLiveData.value.isNullOrEmpty()!!) {
            mutableLiveData
        } else {
            mutableLiveData?.value = "nothing mutableLiveData"
            mutableLiveData
        }

    }
}