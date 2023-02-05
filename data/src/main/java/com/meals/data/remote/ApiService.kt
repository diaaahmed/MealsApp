package com.meals.data.remote

import com.meals.domain.entity.CategoryResponse
import retrofit2.http.GET

interface ApiService
{
    @GET("categories.php")
    suspend fun getMeals():CategoryResponse
}