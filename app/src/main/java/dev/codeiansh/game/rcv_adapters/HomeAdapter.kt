package dev.codeiansh.game.rcv_adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.codeiansh.game.R
import dev.codeiansh.game.rcv_model.HomeModel

class HomeAdapter(private val homeList: List<HomeModel>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.rcvHome_text)
        private val image: ImageView = itemView.findViewById(R.id.rcvHome_image)

        fun bind(homeModel: HomeModel) {
            name.text = homeModel.name
            image.setImageResource(homeModel.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        return HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rcv_home, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return homeList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val homeModel = homeList[position]
        holder.bind(homeModel)
    }
}