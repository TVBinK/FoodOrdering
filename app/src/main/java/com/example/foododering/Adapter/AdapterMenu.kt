package com.example.foododering.Adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foododering.databinding.MenuItemBinding
import com.example.foododering.model.AllMenu
import com.google.firebase.database.DatabaseReference

class AdapterMenu(
    private val context: Context,
    private val menuList : ArrayList<AllMenu>,
    private val databaseReference: DatabaseReference
) : RecyclerView.Adapter<AdapterMenu.MenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMenu.MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding) 
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuList.size

    inner class MenuViewHolder(private val binding: MenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val menuItem = menuList[position]
                val uriString = menuItem.foodImage
                val uri = Uri.parse(uriString)
                Glide.with(context).load(uri).into(imgViewItem)
                tvFoodName.text = menuItem.foodName
                tvPrice.text = menuItem.foodPrice
            }
        }

    }
}