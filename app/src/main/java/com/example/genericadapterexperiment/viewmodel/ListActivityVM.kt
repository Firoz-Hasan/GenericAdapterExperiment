package com.example.genericadapterexperiment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.genericadapterexperiment.models.Demo
import com.example.genericadapterexperiment.repositories.ProjectRepository



class ListActivityVM(application: Application) : AndroidViewModel(application) {

    private var projectListObservable: LiveData<Demo>? = null

    init {
        projectListObservable = ProjectRepository().getInstance().getDemoData()
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    fun getUserListObservable(): LiveData<Demo> {
        return projectListObservable!!
    }
}