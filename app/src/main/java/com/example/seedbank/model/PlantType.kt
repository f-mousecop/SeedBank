package com.example.seedbank.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PlantType(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
) {

}
