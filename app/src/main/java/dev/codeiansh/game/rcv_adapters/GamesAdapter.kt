package dev.codeiansh.game.rcv_adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.codeiansh.game.R
import dev.codeiansh.game.rcv_model.GamesModel

class GamesAdapter(private val gamesList: List<GamesModel>) :
    RecyclerView.Adapter<GamesAdapter.GamesViewHolder>() {

    class GamesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.rcv_Games_text)
        private val image: ImageView = itemView.findViewById(R.id.rcv_Games_image)
        private val type: TextView = itemView.findViewById(R.id.type)
        private val rating: TextView = itemView.findViewById(R.id.rating)

        fun bind(gamesModel: GamesModel) {
            name.text = gamesModel.name
            image.setImageResource(gamesModel.image)
            type.text = gamesModel.type
            rating.text = gamesModel.rating
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {

        return GamesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rcv_games, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        val gamesModel = gamesList[position]
        holder.bind(gamesModel)
    }
}