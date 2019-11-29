package com.devcoder.mvvmexample2.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.devcoder.mvvmexample.R
import com.devcoder.mvvmexample2.adapters.AndroidAdapter
import com.devcoder.mvvmexample2.models.DataModel
import com.devcoder.mvvmexample2.viewmodels.MyViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var adapter: AndroidAdapter? = null
    private var myViewModel: MyViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        myViewModel?.init()
        myViewModel?.androidVersion?.observe(this,
            Observer<List<DataModel>> {
                adapter?.notifyDataSetChanged()

            })
        initRecyclerView()

        myViewModel?.isViewUpdated?.observe(this, Observer<Boolean> { t ->
            if (!t) {
                showProgressBar()
            } else
                hideProgressBar()
        })

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            myViewModel?.addNewItems(
                DataModel(
                    "Oreo",
                    "8.0",
                    "https://picsum.photos/200/300.webp",
                    R.drawable.oreo
                )
            )
        }
    }

    private fun initRecyclerView() {
        val list = myViewModel?.androidVersion?.value
        if (list != null) {
            adapter = AndroidAdapter(this, list)
            recyclerView?.adapter = adapter
        }
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }
}
