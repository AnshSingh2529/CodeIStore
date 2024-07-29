package dev.codeiansh.game.recommended.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.codeiansh.game.R
import dev.codeiansh.game.recommended.models.RecommendedHomesData

class VpHomesAdapter(private val pageItems: List<List<RecommendedHomesData>>) :
    RecyclerView.Adapter<VpHomesAdapter.VpHomeViewHolder>() {
    class VpHomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.findViewById(R.id.recommended_homes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VpHomeViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recommendedhome, parent, false)
        return VpHomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pageItems.size
    }

    override fun onBindViewHolder(holder: VpHomeViewHolder, position: Int) {
        val itemAdapter = RecommendedHomesAdapter(pageItems[position])
        holder.recyclerView.adapter = itemAdapter
        holder.recyclerView.layoutManager =
            LinearLayoutManager(holder.itemView.context, LinearLayoutManager.VERTICAL, false)
    }
}