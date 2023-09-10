package com.example.kontakt.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kontakt.R
import com.example.kontakt.databinding.FragmentHomeBinding
import com.example.kontakt.databinding.FragmentListBinding


class HomeFragment : Fragment() {
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addFragment)
        }
        binding.btnMenyu.setOnClickListener {
            findNavController().navigate(R.id.listFragment)
        }

        return binding.root
    }


}