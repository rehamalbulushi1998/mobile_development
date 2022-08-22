package com.example.myapplication.model

data class UnsplashItem(
    val downloads: Int,
    val exif: Exif,
    val height: Int,
    val likes: Int,
    val location: Location,
    val profile_image: ProfileImage,
    val urls: Urls,
    val user: User,
    val views: Int,
    val width: Int
)