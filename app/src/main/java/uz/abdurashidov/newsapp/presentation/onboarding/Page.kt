package uz.abdurashidov.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import uz.abdurashidov.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages= listOf(
    Page(
        title = "Lorem ipsum simply dummy",
        description = "Lorem ipsum simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Lorem ipsum simply dummy",
        description = "Lorem ipsum simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Lorem ipsum simply dummy",
        description = "Lorem ipsum simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboarding3
    ),
)
