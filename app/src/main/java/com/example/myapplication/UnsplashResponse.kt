package com.example.myapplication

import android.os.Parcelable
import com.example.myapplication.model.UnsplashItem
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class UnsplashResponse(
    val unsplashItem : List<UnsplashItem>

)