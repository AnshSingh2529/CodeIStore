package dev.codeiansh.game.vp_adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import dev.codeiansh.game.R
import dev.codeiansh.game.vp_model.GamesModel_vp

class GamesAdapter_vp(private val gamesList: List<GamesModel_vp>) :
    RecyclerView.Adapter<GamesAdapter_vp.GamesViewHolder>() {

    class GamesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.vp_Games_image)
        fun bind(gamesModel: GamesModel_vp) {
            image.setImageResource(gamesModel.image)
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GamesAdapter_vp.GamesViewHolder {
        return GamesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.vp_games, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GamesAdapter_vp.GamesViewHolder, position: Int) {
        holder.bind(gamesList[position])
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }
}