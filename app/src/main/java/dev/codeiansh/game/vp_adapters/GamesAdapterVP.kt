package dev.codeiansh.game.vp_adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.codeiansh.game.R
import dev.codeiansh.game.vp_model.GamesModel_vp

class GamesAdapterVP : ListAdapter<GamesModel_vp, GamesAdapterVP.GamesViewHolder>(DiffUtil()) {


    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<GamesModel_vp>() {
        override fun areItemsTheSame(oldItem: GamesModel_vp, newItem: GamesModel_vp): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: GamesModel_vp,
            newItem: GamesModel_vp
        ): Boolean {
            return oldItem == newItem
        }

    }

    class GamesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.vp_Games_image)
        fun bind(gamesModel: GamesModel_vp) {
            Glide.with(itemView)
                .load(gamesModel.url)
                .into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        return GamesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.vp_games, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        val gamesModel = getItem(position)
        holder.bind(gamesModel)
    }
}