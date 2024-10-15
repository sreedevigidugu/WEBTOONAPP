/*package com.example.webtoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val addToFavoritesButton: Button = view.findViewById(R.id.addToFavoritesButton)

        val webtoon = args.webtoon // Retrieve the webtoon passed as an argument

        titleTextView.text = webtoon.title
        descriptionTextView.text = webtoon.description
        imageView.setImageResource(webtoon.imageResId)

        addToFavoritesButton.setOnClickListener {
            // Add logic to save webtoon to favorites
        }

        return view
    }
}*/


/*class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val addToFavoritesButton: Button = view.findViewById(R.id.addToFavoritesButton)

        val webtoon = args.webtoon

        titleTextView.text = webtoon.title
        descriptionTextView.text = webtoon.description
        imageView.setImageResource(webtoon.imageResId)

        addToFavoritesButton.setOnClickListener {
            FavoritesRepository.addToFavorites(webtoon) // Save to favorites
        }

        return view
    }
}*/
package com.example.webtoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val addToFavoritesButton: Button = view.findViewById(R.id.addToFavoritesButton)
        val ratingBar: RatingBar = view.findViewById(R.id.ratingBar)
        val averageRatingTextView: TextView = view.findViewById(R.id.averageRatingTextView)

        val webtoon = args.webtoon

        titleTextView.text = webtoon.title
        descriptionTextView.text = webtoon.description
        imageView.setImageResource(webtoon.imageResId)

        // Display the average rating
        averageRatingTextView.text = "Average Rating: ${webtoon.averageRating()}"

        addToFavoritesButton.setOnClickListener {
            FavoritesRepository.addToFavorites(webtoon)
        }

        // Listener for rating changes
        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            webtoon.addRating(rating.toInt())
            averageRatingTextView.text = "Average Rating: ${webtoon.averageRating()}"
        }

        return view
    }
}

