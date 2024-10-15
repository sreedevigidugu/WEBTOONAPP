package com.example.webtoon



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WebtoonAdapter(
    private val webtoons: List<Webtoon>,
    private val onClick: (Webtoon) -> Unit
) : RecyclerView.Adapter<WebtoonAdapter.WebtoonViewHolder>() {

    class WebtoonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(webtoon: Webtoon, onClick: (Webtoon) -> Unit) {
            titleTextView.text = webtoon.title
            descriptionTextView.text = webtoon.description
            imageView.setImageResource(webtoon.imageResId) // Set image resource

            itemView.setOnClickListener {
                onClick(webtoon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebtoonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.webtoon_item, parent, false) // Ensure this layout exists
        return WebtoonViewHolder(view)
    }

    override fun onBindViewHolder(holder: WebtoonViewHolder, position: Int) {
        val webtoon = webtoons[position]
        holder.bind(webtoon, onClick)
    }

    override fun getItemCount(): Int = webtoons.size
}
