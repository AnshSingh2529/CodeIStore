package dev.codeiansh.game.recommended.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.codeiansh.game.R
import dev.codeiansh.game.recommended.models.RecommendedAppsData

class RecommendedAppsAdapter(private val recommendedAppsList: List<RecommendedAppsData>) :
    RecyclerView.Adapter<RecommendedAppsAdapter.RecommendedAppsViewHolder>() {

    class RecommendedAppsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.recommended_app_image)
        val name: TextView = itemView.findViewById(R.id.recommended_app_text)
        val type: TextView = itemView.findViewById(R.id.type)
        val rating: TextView = itemView.findViewById(R.id.rating)

        fun bind(recommendedAppsModel: RecommendedAppsData) {
            image.setImageResource(recommendedAppsModel.image)
            name.text = recommendedAppsModel.name
            type.text = recommendedAppsModel.type
            rating.text = recommendedAppsModel.rating
        }
    }

    class RecommendedGamesViewHolder {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedAppsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recommendedapp_lay, parent, false)
        return RecommendedAppsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return recommendedAppsList.size
    }

    override fun onBindViewHolder(holder: RecommendedAppsViewHolder, position: Int) {
        val itemPosition = recommendedAppsList[position]
        holder.bind(itemPosition)
    }
}