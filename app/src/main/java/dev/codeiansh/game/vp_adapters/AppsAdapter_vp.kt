package dev.codeiansh.game.vp_adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import dev.codeiansh.game.R
import dev.codeiansh.game.vp_model.AppsModel_vp

class AppsAdapter_vp(private val appsList: List<AppsModel_vp>) :
    RecyclerView.Adapter<AppsAdapter_vp.AppsViewHolder>() {

    class AppsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image = itemView.findViewById<ImageView>(R.id.vp_Apps_image)
        fun bind(appsModel: AppsModel_vp) {
            image.setImageResource(appsModel.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppsViewHolder {

        return AppsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.vp_apps, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return appsList.size
    }

    override fun onBindViewHolder(holder: AppsViewHolder, position: Int) {
        holder.bind(appsList[position])
    }
}