package ru.kpfu.itis.android.screens.samokatus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_samokatus.*
import ru.kpfu.itis.android.screens.R

class SamokatusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_samokatus)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        rv_categories_samokatus.adapter = CategoryAdapter()
        (rv_categories_samokatus.adapter as CategoryAdapter).submitList(
            mutableListOf(
                "Трипы", "Трипушки", "ЯПодТрипом", "Трииип", "Словим", "сТобойТрип"
            )
        )

        rv_tours_samokatus.adapter = ToursAdapter()
        (rv_tours_samokatus.adapter as ToursAdapter).submitList(
            mutableListOf(
                "It is JojoReference?",
                "It is JojoReference?",
                "It is JojoReference?",
                "It is JojoReference?",
                "It is JojoReference?",
                "It is JojoReference?",
                "It is JojoReference?"
            )
        )
    }
}
