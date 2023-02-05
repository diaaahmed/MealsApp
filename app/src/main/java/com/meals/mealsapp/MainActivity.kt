package com.meals.mealsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.meals.mealsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint

class MainActivity : AppCompatActivity()
{
    private val mealsViewModel: MealsViewModel by viewModels()

    private val ui by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mealsAdapter by lazy{
        MealsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(ui.root)

        ui.categoryRv.setHasFixedSize(true)
        ui.categoryRv.layoutManager = LinearLayoutManager(this)

        mealsViewModel.getMeals()

        lifecycleScope.launch {

            mealsViewModel.categories.collect{
                mealsAdapter.submitList(it?.categories)
                ui.categoryRv.adapter = mealsAdapter
            }
        }
    }
}