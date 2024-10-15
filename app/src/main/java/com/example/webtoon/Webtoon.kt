/*
@Parcelize
data class Webtoon(
    val title: String,
    val description: String,
    val imageResId: Int // This should reference your drawable resources
) : Parcelable
*/
package com.example.webtoon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Webtoon(
    val title: String,
    val description: String,
    val imageResId: Int,
    private val ratings: MutableList<Int> = mutableListOf() // Store ratings as a list
) : Parcelable {

    // Function to add a rating
    fun addRating(rating: Int) {
        if (rating in 1..5) {
            ratings.add(rating)
        }
    }

    // Calculate average rating
    fun averageRating(): Float {
        return if (ratings.isNotEmpty()) {
            ratings.average().toFloat()
        } else {
            0f
        }
    }
}
