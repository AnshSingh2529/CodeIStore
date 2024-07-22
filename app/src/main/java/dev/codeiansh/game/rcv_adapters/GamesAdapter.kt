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

class GamesAdapter(private val gamesList: List<GamesModel>, val context: Context) :
    RecyclerView.Adapter<GamesAdapter.GamesViewHolder>() {

    class GamesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.rcv_Games_text)
        private val image: ImageView = itemView.findViewById(R.id.rcv_Games_image)

        fun bind(gamesModel: GamesModel) {
            name.text = gamesModel.name
            image.setImageResource(gamesModel.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {

        return GamesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_game, parent, false)
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