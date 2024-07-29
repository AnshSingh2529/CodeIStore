package dev.codeiansh.game.recommended.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.codeiansh.game.R
import dev.codeiansh.game.recommended.models.RecommendedAppsData

class VpAppsAdapter(private val pagesItems: List<List<RecommendedAppsData>>) :
    RecyclerView.Adapter<VpAppsAdapter.VpAppsViewHolder>() {

    class VpAppsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.findViewById(R.id.recommended_apps)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VpAppsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recommendedapp, parent, false)
        return VpAppsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pagesItems.size
    }

    override fun onBindViewHolder(holder: VpAppsViewHolder, position: Int) {
            val itemAdapter = RecommendedAppsAdapter(pagesItems[position])
        holder.recyclerView.adapter = itemAdapter
        holder.recyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.VERTICAL, false)
    }
}