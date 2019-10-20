package com.aad_team_42.travelmanticsrebranded.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.aad_team_42.travelmanticsrebranded.R

enum class OnboardingPage(@StringRes val titleResource: Int,
                          @StringRes val subTitle: Int,
                     @StringRes val descriptionResource: Int,
                     @DrawableRes val logoResource: Int) {

    TOUR(R.string.title, R.string.sub_title,R.string.tour_describe, R.drawable.tour),
    EVENT(R.string.title, R.string.sub_title, R.string.event_describe,R.drawable.pass),
}