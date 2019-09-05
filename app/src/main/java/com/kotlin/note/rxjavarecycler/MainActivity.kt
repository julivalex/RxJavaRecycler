package com.kotlin.note.rxjavarecycler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var disposable: Disposable? = null
    private val listAdapter = ListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = listAdapter
        }

        setupItemClick()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }

    private fun setupItemClick() {
        disposable = listAdapter.subject
            .subscribe {
                Toast.makeText(this, "Clicked on $it", Toast.LENGTH_LONG).show()
            }
    }
}
