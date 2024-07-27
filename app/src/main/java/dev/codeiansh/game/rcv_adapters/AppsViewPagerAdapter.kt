package dev.codeiansh.game.rcv_adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.codeiansh.game.R
import dev.codeiansh.game.rcv_model.AppsModel

class AppsViewPagerAdapter(private val pages: List<List<AppsModel>>) :
    RecyclerView.Adapter<AppsViewPagerAdapter.AppsViewPagerViewHolder>() {

    class AppsViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.findViewById(R.id.rcv_apps_page)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppsViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rcv_apps_page, parent, false)
        return AppsViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pages.size
    }

    override fun onBindViewHolder(holder: AppsViewPagerViewHolder, position: Int) {
            val itemAdapter = AppsAdapter(pages[position])
            holder.recyclerView.adapter = itemAdapter
            holder.recyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)

        }
}