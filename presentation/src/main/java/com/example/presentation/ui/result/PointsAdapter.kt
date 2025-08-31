package com.example.presentation.ui.result

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Point
import com.example.presentation.R

class PointsAdapter(private val points: List<Point>) :
    RecyclerView.Adapter<PointsAdapter.PointViewHolder>() {

    inner class PointViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvX: TextView = itemView.findViewById(R.id.tvX)
        val tvY: TextView = itemView.findViewById(R.id.tvY)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_point, parent, false)
        return PointViewHolder(view)
    }

    override fun onBindViewHolder(holder: PointViewHolder, position: Int) {
        val point = points[position]
        holder.tvX.text = "x: ${point.x}"
        holder.tvY.text = "y: ${point.y}"
    }

    override fun getItemCount() = points.size
}
