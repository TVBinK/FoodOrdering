package com.example.foododering.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foododering.databinding.MenuItemBinding

class AdapterMenu(private var menuImages:MutableList<Int>, private var menuItemsName:MutableList<String>, private var menuPrices:MutableList<String>): RecyclerView.Adapter<AdapterMenu.MenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMenu.MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)



    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuImages.size

    inner class MenuViewHolder(private val binding: MenuItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
                binding.apply {
                    tvFoodName.text = menuItemsName[position]
                    tvPrice.text = menuPrices[position].toString()
                    imgViewPopularItem.setImageResource(menuImages[position])
                }
        }

    }
}