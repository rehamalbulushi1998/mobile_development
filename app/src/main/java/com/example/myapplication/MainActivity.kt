package com.example.myapplication

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.UnsplashItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_second.*
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_image_list.layoutManager = LinearLayoutManager(this)
        rv_image_list.setHasFixedSize(true)
        getMovieData { unsplashItem : List<UnsplashItem> ->
            rv_image_list.adapter = UnsplashAdapter(unsplashItem)
        }

    }

    private fun getMovieData(callback: (List<UnsplashItem>) -> Unit){
        val apiService = UnsplashApiService.getInstance().create(UnsplashApiInterface::class.java)
        apiService.getUnsplashList().enqueue(object : Callback<UnsplashResponse> {
            override fun onFailure(call: Call<UnsplashResponse>, t: Throwable) {

            }


            override fun onResponse(
                call: Call<UnsplashResponse>,
                response: retrofit2.Response<UnsplashResponse>
            ) {
                return callback(response.body()!!.unsplashItem)
            }

        })
    }
}