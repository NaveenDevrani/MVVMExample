package com.devcoder.mvvmexample2.viewmodels

import android.annotation.SuppressLint
import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devcoder.mvvmexample2.models.DataModel
import com.devcoder.mvvmexample2.repositories.MyRepositories

class MyViewModel(val context: Context) : ViewModel() {
    private var list: MutableLiveData<List<DataModel>>? =
        null
    private var myRepositories: MyRepositories? = null
    private val isDataLoaded = MutableLiveData<Boolean>()

    fun init() {
        if (list != null) return
        myRepositories = MyRepositories.getInstance(context = context)
        Thread.sleep(4000)
        list = myRepositories!!.androidList
        isDataLoaded.postValue(true)

    }

    @SuppressLint("StaticFieldLeak")
    fun loadData() {
//        isDataLoaded.value = false
//        Thread.sleep(4000)
//        list = myRepositories!!.androidList
//        isDataLoaded.postValue(true)

        object : AsyncTask<Void?, Void?, Void?>() {
            override fun onPreExecute() {
                super.onPreExecute()
                isDataLoaded.value = false
            }

            override fun doInBackground(vararg voids: Void?): Void? {

                return null
            }

            override fun onPostExecute(aVoid: Void?) {
                super.onPostExecute(aVoid)
                try {
                    Thread.sleep(3000)

                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                list = myRepositories!!.androidList
                isDataLoaded.postValue(true)
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
    }

    @SuppressLint("StaticFieldLeak")
    fun addNewItems(dataModel: DataModel) {

        object : AsyncTask<Void?, Void?, Void?>() {
            override fun onPreExecute() {
                super.onPreExecute()
                isDataLoaded.value = false
            }

            override fun doInBackground(vararg voids: Void?): Void? {
                try {
                    Thread.sleep(4000)
                    val currentList: ArrayList<DataModel>? = list?.value as ArrayList<DataModel>?
                    currentList?.add(dataModel)
                    list?.postValue(currentList)
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