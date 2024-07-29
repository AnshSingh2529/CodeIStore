package dev.codeiansh.game.recommended.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.codeiansh.game.R
import dev.codeiansh.game.recommended.models.RecommendedGamesData

class RecommendedGamesAdapter(private val recommendedGamesList: List<RecommendedGamesData>) :
    RecyclerView.Adapter<RecommendedGamesAdapter.RecommendedGamesViewHolder>() {

    class RecommendedGamesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.recommended_game_image)
        val name: TextView = itemView.findViewById(R.id.recommended_game_text)
        val type: TextView = itemView.findViewById(R.id.type)
        val rating: TextView = itemView.findViewById(R.id.rating)

        fun bind(recommendedGamesModel: RecommendedGamesData) {
            image.setImageResource(recommendedGamesModel.image)
            name.text = recommendedGamesModel.name
            type.text = recommendedGamesModel.type
            rating.text = recommendedGamesModel.rating
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedGamesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recommendedgame_lay, parent, false)
        return RecommendedGamesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecommendedGamesViewHolder, position: Int) {
        val itemPosition = recommendedGamesList[position]
        holder.bind(itemPosition)
    }


    override fun getItemCount(): Int {
        return recommendedGamesList.size
    }

}