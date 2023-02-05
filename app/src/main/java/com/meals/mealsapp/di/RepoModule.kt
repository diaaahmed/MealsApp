package com.meals.mealsapp.di

import com.meals.data.remote.ApiService
import com.meals.data.repo.MealsRepoImpl
import com.meals.domain.repo.MealsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule
{
    @Provides
    fun provideRepo(apiService: ApiService):MealsRepo{
        return MealsRepoImpl(apiService)
    }
}