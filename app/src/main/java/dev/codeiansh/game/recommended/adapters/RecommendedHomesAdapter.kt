package dev.codeiansh.game.recommended.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.codeiansh.game.R
import dev.codeiansh.game.recommended.models.RecommendedHomesData

class RecommendedHomesAdapter(private val recommendedHomesList: List<RecommendedHomesData>): RecyclerView.Adapter<RecommendedHomesAdapter.RecommendedHomesViewHolder>() {

    class RecommendedHomesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.recommended_home_image)
        val name: TextView = itemView.findViewById(R.id.recommended_home_text)
        private val type: TextView = itemView.findViewById(R.id.type)
        private val rating: TextView = itemView.findViewById(R.id.rating)

        fun bind(recommendedHomesModel: RecommendedHomesData) {
            image.setImageResource(recommendedHomesModel.image)
            name.text = recommendedHomesModel.name
            type.text = recommendedHomesModel.type
            rating.text = recommendedHomesModel.rating
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommendedHomesAdapter.RecommendedHomesViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.recommendedhome_lay, parent, false)
        return RecommendedHomesViewHolder(view)
    }


    override fun onBindViewHolder(
        holder: RecommendedHomesAdapter.RecommendedHomesViewHolder,
        position: Int
    ) {
        val itemPosition = recommendedHomesList[position]
        holder.bind(itemPosition)
    }

    override fun getItemCount(): Int {
        return recommendedHomesList.size
    }
}