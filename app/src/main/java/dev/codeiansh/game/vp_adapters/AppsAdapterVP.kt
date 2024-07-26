package dev.codeiansh.game.vp_adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.codeiansh.game.R
import dev.codeiansh.game.vp_model.AppsModel_vp

class AppsAdapterVP :
    androidx.recyclerview.widget.ListAdapter<AppsModel_vp, AppsAdapterVP.AppsViewHolder>(DiffUtil()) {


    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<AppsModel_vp>() {
        override fun areItemsTheSame(oldItem: AppsModel_vp, newItem: AppsModel_vp): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AppsModel_vp, newItem: AppsModel_vp): Boolean {
            return oldItem == newItem
        }
    }

    class AppsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image = itemView.findViewById<ImageView>(R.id.vp_Apps_image)
        fun bind(appsModel: AppsModel_vp) {
            Glide.with(itemView)
                .load(appsModel.url)
                .into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppsViewHolder {
        return AppsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.vp_apps, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AppsViewHolder, position: Int) {
        val appsModel = getItem(position)
        holder.bind(appsModel)
    }
}


// (private val appsList: List<AppsModel_vp>,val context: Context) :
//    RecyclerView.Adapter<AppsAdapterVP.AppsViewHolder>() {
//
//    class AppsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val image = itemView.findViewById<ImageView>(R.id.vp_Apps_image)
//        fun bind(appsModel: AppsModel_vp) {
//            Glide.with(itemView)
//                .load(appsModel.url)
//                .into(image)
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppsViewHolder {
//
//        return AppsViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.vp_apps, parent, false)
//        )
//    }
//
//    override fun getItemCount(): Int {
//        return appsList.size
//    }
//
//    override fun onBindViewHolder(holder: AppsViewHolder, position: Int) {
//        holder.bind(appsList[position])
//    }

