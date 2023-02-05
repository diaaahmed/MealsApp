package com.meals.domain.repo

import com.meals.domain.entity.CategoryResponse

interface MealsRepo
{
    suspend fun getMealsFromRemote():CategoryResponse
}