package com.ahr.borutoapp.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.ahr.borutoapp.R

sealed class OnBoarding(
    @DrawableRes
    val photo: Int,
    @StringRes
    val title: Int,
    @StringRes
    val description: Int
) {
    object Greetings : OnBoarding(
        photo = R.drawable.greetings,
        title = R.string.greetings,
        description = R.string.greetings_description
    )
    object Explore : OnBoarding(
        photo = R.drawable.explore,
        title = R.string.explore,
        description = R.string.explore_description
    )
    object Power : OnBoarding(
        photo = R.drawable.power,
        title = R.string.power,
        description = R.string.power_description
    )
}
