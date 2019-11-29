package com.devcoder.mvvmexample2.repositories

import androidx.lifecycle.MutableLiveData
import com.devcoder.mvvmexample.R.drawable
import com.devcoder.mvvmexample.utils.Coroutines
import com.devcoder.mvvmexample2.models.DataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class MyRepositories {
    private val list =
        ArrayList<DataModel>()

    // pretend to get the data from webservice
    val androidList: MutableLiveData<List<DataModel>>
        get() {
            val data = MutableLiveData<List<DataModel>>()

//            GlobalScope.launch {
//                withContext(Dispatchers.Default) { }
//            }
            data.value = setAndroidData()
            return data
        }

    private fun setAndroidData(): ArrayList<DataModel> {
        list.add(
            DataModel(
                "Oreo",
                "8.0",
                "https://picsum.photos/200/300.webp",
                drawable.oreo
            )
        )
        list.add(
            DataModel(
                "Nought",
                "7.0",
                "https://picsum.photos/200/300.webp",
                drawable.nought
            )
        )
        list.add(
            DataModel(
                "Marshmallow",
                "6.0",
                "https://picsum.photos/200/300.webp",
                drawable.marshmallow
            )
        )
        list.add(
            DataModel(
                "Lollipop",
                "5.0",
                "https://picsum.photos/200/300.webp",
                drawable.lolipop
            )
        )
        list.add(
            DataModel(
                "Kitkat",
                "4.0",
                "https://picsum.photos/200/300.webp",
                drawable.kitkate
            )
        )
        return list
    }

    companion object {
        var instance: MyRepositories? = null
            get() {
                if (field == null) {
                    field = MyRepositories()
                }
                return field
            }
            private set
    }
}