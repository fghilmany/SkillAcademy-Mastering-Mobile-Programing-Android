  package com.skillacademy.sabegin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.skillacademy.sabegin.R
import com.skillacademy.sabegin.data.Result
import com.skillacademy.sabegin.databinding.ActivityHomeBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

  class HomeActivity : DaggerAppCompatActivity(), HomeViewModelCallback {

      @Inject
      lateinit var viewModel: HomeViewModel

      private lateinit var binding:ActivityHomeBinding

      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

          binding = DataBindingUtil.setContentView<ActivityHomeBinding>(
              this,
              R.layout.activity_home)
              .apply { viewmodel = this@HomeActivity.viewModel }
              .also { viewModel.discoverMoview() }
      }

      override fun onSuccess(results: List<Result>) {

          binding.rvHome.addItemDecoration(DividerItemDecoration(this@HomeActivity,
              DividerItemDecoration.VERTICAL))
          binding.rvHome.adapter = HomeAdapter(results)

      }

      override fun onError(error: Throwable) {
          Log.e(HomeActivity::class.java.simpleName, "${error.printStackTrace()}")

      }

      override fun onDestroy() {
          super.onDestroy()
          viewModel.onDetach()
      }
}
