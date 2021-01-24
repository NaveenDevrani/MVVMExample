package com.devcoder.mvvmexample2.repositories

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.devcoder.R
import com.devcoder.mvvmexample2.models.DataModel
import java.util.*

class MyRepositories(val context: Context) {
    private val list = ArrayList<DataModel>()

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
                ContextCompat.getDrawable(context, R.drawable.oreo)
            )
        )
        list.add(
            DataModel(
                "Nought",
                "7.0",
                "https://picsum.photos/200/300.webp",
                ContextCompat.getDrawable(context, R.drawable.nought)
            )
        )
        list.add(
            DataModel(
                "Marshmallow",
                "6.0",
                "https://picsum.photos/200/300.webp",
                ContextCompat.getDrawable(context, R.drawable.marshmallow)
            )
        )
        list.add(
            DataModel(
                "Lollipop",
                "5.0",
                "https://picsum.photos/200/300.webp",
                ContextCompat.getDrawable(context, R.drawable.lolipop)
            )
        )
        list.add(
            DataModel(
                "Kitkat",
                "4.0",
                "https://picsum.photos/200/300.webp",
                ContextCompat.getDrawable(context, R.drawable.kitkate)
            )
        )
        return list
    }

    companion object {
        var field: MyRepositories? = null
        fun getInstance(context: Context): MyRepositories {

            if (field == null) {
                field = MyRepositories(context = context)
            }
            return field!!
        }
    }
}