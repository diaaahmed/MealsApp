package com.meals.domain.usecase

import com.meals.domain.repo.MealsRepo

class GetMeals(private val mealsRepo: MealsRepo)
{
    suspend operator fun invoke() = mealsRepo.getMealsFromRemote()
}