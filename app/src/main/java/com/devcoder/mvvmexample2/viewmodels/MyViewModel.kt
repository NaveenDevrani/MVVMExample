package com.devcoder.mvvmexample2.viewmodels

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devcoder.mvvmexample2.models.DataModel
import com.devcoder.mvvmexample2.repositories.MyRepositories

class MyViewModel : ViewModel() {
    private var list: MutableLiveData<List<DataModel>>? =
        null
    private var myRepositories: MyRepositories? = null
    private val isDataLoaded = MutableLiveData<Boolean>()

    fun init() {
        if (list != null) return
        myRepositories = MyRepositories.instance
        loadData()
    }

    @SuppressLint("StaticFieldLeak")
    fun loadData() {
        object : AsyncTask<Void?, Void?, Void?>() {
            override fun onPreExecute() {
                super.onPreExecute()
                isDataLoaded.value = false
            }

            override fun doInBackground(vararg voids: Void?): Void? {
                try {
                    Thread.sleep(4000)
                    list = myRepositories!!.androidList
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                return null
            }

            override fun onPostExecute(aVoid: Void?) {
                super.onPostExecute(aVoid)
                isDataLoaded.postValue(true)
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
    }

    val androidVersion: LiveData<List<DataModel>>?
        get() = list

    val isViewUpdated: LiveData<Boolean>
        get() = isDataLoaded
}