package com.meals.mealsapp.di

import com.meals.domain.repo.MealsRepo
import com.meals.domain.usecase.GetMeals
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCase(repo: MealsRepo): GetMeals{
        return GetMeals(repo)
    }
}