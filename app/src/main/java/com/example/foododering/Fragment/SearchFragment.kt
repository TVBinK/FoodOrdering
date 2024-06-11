package com.example.foododering.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foododering.Adapter.AdapterMenu
import com.example.foododering.R
import com.example.foododering.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter : AdapterMenu
    private val originFoodName = listOf("Hot Dog", "Sanwich", "Salad", "Spaghetti", "Bánh Mì", "Phở", "Bánh Giò","Bún Thang","Bún Đậu")
    private val originFoodPrice = listOf("5", "10", "8", "11", "2", "3","4","1","2")
    private val originFoodImage = listOf(
        R.drawable.hotdog,
        R.drawable.sandwich,
        R.drawable.salad,
        R.drawable.spaghetti,
        R.drawable.banhmi,
        R.drawable.pho,
        R.drawable.banhgio,
        R.drawable.bunthang,
        R.drawable.bundau
    )
    private var filterFoodName = mutableListOf<String>()
    private var filterFoodImage = mutableListOf<Int>()
    private var filterFoodPrice = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = AdapterMenu(filterFoodImage,filterFoodName,filterFoodPrice)
        binding.SearchRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.SearchRecyclerView.adapter = adapter
        showAllMenu()
        setup()
        return binding.root
    }

    private fun showAllMenu() {
        filterFoodName.clear()
        filterFoodImage.clear()
        filterFoodPrice.clear()

        filterFoodName.addAll(originFoodName)
        filterFoodImage.addAll(originFoodImage)
        filterFoodPrice.addAll(originFoodPrice)
        adapter.notifyDataSetChanged()
    }

    private fun setup() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterItem(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterItem(newText)
                return true
            }
        })
    }

    private fun filterItem(query: String) {
        filterFoodName.clear()
        filterFoodImage.clear()
        filterFoodPrice.clear()

        originFoodName.forEachIndexed { index, name ->
            if(name.contains(query,ignoreCase = true)){
                filterFoodName.add(name)
                filterFoodImage.add(originFoodImage[index])
                filterFoodPrice.add(originFoodPrice[index])
            }
        }
        adapter.notifyDataSetChanged()
    }


    companion object {

    }
}