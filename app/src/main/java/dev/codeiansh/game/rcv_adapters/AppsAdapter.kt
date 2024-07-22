package dev.codeiansh.game.rcv_adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.codeiansh.game.R
import dev.codeiansh.game.rcv_model.AppsModel

class AppsAdapter(private val appsList: List<AppsModel>, val context: Context) :
    RecyclerView.Adapter<AppsAdapter.AppsViewHolder>() {

    class AppsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image = itemView.findViewById<ImageView>(R.id.rcv_Apps_image)
        private val name = itemView.findViewById<TextView>(R.id.rcv_Apps_text)

        fun bind(appsModel: AppsModel) {
            image.setImageResource(appsModel.image)
            name.text = appsModel.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppsViewHolder {

        return AppsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_apps, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AppsViewHolder, position: Int) {
        val appsModel = appsList[position]
        holder.bind(appsModel)
    }

    override fun getItemCount(): Int {
        return appsList.size
    }
}