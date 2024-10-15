package com.example.webtoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController // Import this line
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var webtoonRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        webtoonRecyclerView = view.findViewById(R.id.webtoonRecyclerView)
        webtoonRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val webtoons = listOf(
            Webtoon(
                title = "Lore Olympus",
                description = "Lore Olympus is a romance webcomic created by New Zealand artist Rachel Smythe.[2] The comic is a modern retelling of the relationship between the Greek goddess and god Persephone and Hades. It began publishing weekly on the platform Webtoon in March 2018.[3] Lore Olympus is currently the most popular comic on Webtoon; as of March 2024, it has 1.4 billion views and 6.5 million subscribers. The comic has won two Eisner Awards,two Harvey Awards, and two Ringo Awards.[9][10] It was announced in 2019 that a television adaptation was under development",
                imageResId = R.drawable.lore_olympus // Replace with your actual image resource
            ),
            Webtoon(
                title = "Tower of God",
                description = "Tower of God is so popular that it was the first manhwa to receive an anime adaption by Crunchyroll. The series' first 13 episodes are already available, and a second season is on the way. This dark fantasy manhwa is a perfect choice for those who enjoy a survival-type plot and a storyline full of mind games.",
                imageResId = R.drawable.tower_of_god // Replace with your actual image resource
            )
            // Add more webtoons as needed
        )

        val adapter = WebtoonAdapter(webtoons) { webtoon ->
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(webtoon)
            findNavController().navigate(action)
        }
        webtoonRecyclerView.adapter = adapter

        return view
    }
}
