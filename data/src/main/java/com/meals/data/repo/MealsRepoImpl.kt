package com.meals.data.repo

import com.meals.data.remote.ApiService
import com.meals.domain.entity.CategoryResponse
import com.meals.domain.repo.MealsRepo

class MealsRepoImpl(private val apiService: ApiService)
    : MealsRepo{
    override suspend fun getMealsFromRemote(): CategoryResponse = apiService.getMeals()
}