  package com.skillacademy.sabegin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.skillacademy.sabegin.R
import com.skillacademy.sabegin.data.Result
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

  class HomeActivity : DaggerAppCompatActivity(), HomeView {

      @Inject
      lateinit var presenter: HomePresenter

      private lateinit var progressBar: ProgressBar
      private lateinit var recyclerView: RecyclerView

      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        progressBar = findViewById(R.id.pb_home)
        recyclerView = findViewById(R.id.rv_home)

          //presenter = HomePresenter(this)
          presenter.discoverMovie()
      }

      override fun onDestroy() {
          super.onDestroy()
          presenter.onDetach()
      }

      override fun showLoading() {
          progressBar.visibility = View.VISIBLE

      }

      override fun hideLoading() {
          progressBar.visibility = View.INVISIBLE
          recyclerView.visibility = View.VISIBLE
      }

      override fun onResponse(results: List<Result>) {
          recyclerView.addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
          recyclerView.adapter = HomeAdapter(results)

      }

      override fun onFailure(error: Throwable) {
          Log.e(HomeAdapter::class.java.simpleName,"${error.printStackTrace()}")

      }
}
