package dev.codeiansh.game.vp_adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.codeiansh.game.R
import dev.codeiansh.game.vp_model.HomeModel_vp

class HomeAdapterVP : ListAdapter<HomeModel_vp, HomeAdapterVP.HomeViewHolder>(DiffUtil()) {

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<HomeModel_vp>() {
        override fun areItemsTheSame(oldItem: HomeModel_vp, newItem: HomeModel_vp): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: HomeModel_vp, newItem: HomeModel_vp): Boolean {
            return oldItem == newItem
        }

    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.vp_Home_image)
        fun bind(homeModel: HomeModel_vp) {
            Glide.with(itemView)
                .load(homeModel.url)
                .into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.vp_home, parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
    val homeModel = getItem(position)
        holder.bind(homeModel)
    }


}