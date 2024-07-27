package dev.codeiansh.game.rcv_adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.codeiansh.game.R
import dev.codeiansh.game.rcv_model.GamesModel

class GamesViewPagerAdapter(private val pages: List<List<GamesModel>>) :
    RecyclerView.Adapter<GamesViewPagerAdapter.GamesViewPagerViewHolder>() {

    class GamesViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.findViewById(R.id.rcv_games_page)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewPagerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rcv_games_page, parent, false)
        return GamesViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pages.size

    }

    override fun onBindViewHolder(holder: GamesViewPagerViewHolder, position: Int) {
        val itemAdapter = GamesAdapter(pages[position])
        holder.recyclerView.adapter = itemAdapter
        holder.recyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)

    }
}