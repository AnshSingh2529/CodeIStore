package dev.codeiansh.game.rcv_adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.codeiansh.game.R
import dev.codeiansh.game.rcv_model.HomeModel

class HomeViewPagerAdapter(private val pages: List<List<HomeModel>>) :
    RecyclerView.Adapter<HomeViewPagerAdapter.HomeViewPagerViewHolder>() {
    class HomeViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.findViewById(R.id.rcv_home_page)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeViewPagerAdapter.HomeViewPagerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rcv_home_page, parent, false)
        return HomeViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: HomeViewPagerAdapter.HomeViewPagerViewHolder,
        position: Int
    ) {
        val itemAdapter = HomeAdapter(pages[position])
        holder.recyclerView.adapter = itemAdapter
        holder.recyclerView.layoutManager =
            LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun getItemCount(): Int {
        return pages.size
    }
}