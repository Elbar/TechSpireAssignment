package com.example.presentation.ui.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Point
import com.example.presentation.databinding.ItemPointBinding

class PointsAdapter : RecyclerView.Adapter<PointsAdapter.PointViewHolder>() {
    private val items = mutableListOf<Point>()

    fun submitList(points: List<Point>) {
        items.clear()
        items.addAll(points)
        notifyDataSetChanged()
    }

    inner class PointViewHolder(private val binding: ItemPointBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(point: Point) {
            binding.tvX.text = "X: ${point.x}"
            binding.tvY.text = "Y: ${point.y}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointViewHolder {
        val binding = ItemPointBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PointViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PointViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}

