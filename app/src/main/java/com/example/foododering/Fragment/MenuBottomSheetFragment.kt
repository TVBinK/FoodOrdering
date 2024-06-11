package com.example.foododering.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foododering.Adapter.AdapterMenu
import com.example.foododering.R
import com.example.foododering.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)
        binding.btnBack.setOnClickListener {
            dismiss()
        }
        val item = listOf("Hot Dog", "Sanwich", "Salad", "Spaghetti", "Bánh Mì", "Phở", "Bánh Giò","Bún Thang","Bún Đậu")
        val price = listOf("5", "10", "8", "11", "2", "3","4","1","2")
        val image = listOf(
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

        val adapter = AdapterMenu(ArrayList(image), ArrayList(item), ArrayList(price))
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}