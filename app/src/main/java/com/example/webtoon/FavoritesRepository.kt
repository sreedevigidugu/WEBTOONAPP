package com.example.webtoon

object FavoritesRepository {
    private val favoritesList = mutableListOf<Webtoon>()

    fun addToFavorites(webtoon: Webtoon) {
        if (!favoritesList.contains(webtoon)) {
            favoritesList.add(webtoon)
        }
    }

    fun getFavorites(): List<Webtoon> {
        return favoritesList
    }
}
