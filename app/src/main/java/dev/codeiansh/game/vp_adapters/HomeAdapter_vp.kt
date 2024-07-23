package dev.codeiansh.game.vp_adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import dev.codeiansh.game.R
import dev.codeiansh.game.vp_model.HomeModel_vp

class HomeAdapter_vp(private val homeList: List<HomeModel_vp>) :
    RecyclerView.Adapter<HomeAdapter_vp.HomeViewHolder>() {

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.vp_Home_image)
        fun bind(homeModel: HomeModel_vp) {
            image.setImageResource(homeModel.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.vp_home, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return homeList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(homeList[position])
    }

}