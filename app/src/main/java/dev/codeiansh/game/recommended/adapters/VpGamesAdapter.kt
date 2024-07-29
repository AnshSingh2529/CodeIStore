package dev.codeiansh.game.recommended.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.codeiansh.game.R
import dev.codeiansh.game.recommended.models.RecommendedGamesData

class VpGamesAdapter(private val pagesItems: List<List<RecommendedGamesData>>) :
    RecyclerView.Adapter<VpGamesAdapter.VpGamesViewHolder>() {
    class VpGamesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.findViewById(R.id.recommended_games)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VpGamesAdapter.VpGamesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recommendedgame, parent, false)
        return VpGamesViewHolder(view)
    }

    override fun onBindViewHolder(holder: VpGamesAdapter.VpGamesViewHolder, position: Int) {
        val itemAdapter = RecommendedGamesAdapter(pagesItems[position])
        holder.recyclerView.adapter = itemAdapter
        holder.recyclerView.layoutManager =
            LinearLayoutManager(holder.itemView.context, LinearLayoutManager.VERTICAL, false)

    }

    override fun getItemCount(): Int {
        return pagesItems.size
    }
}