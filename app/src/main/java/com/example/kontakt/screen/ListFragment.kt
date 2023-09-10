package com.example.kontakt.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kontakt.R
import com.example.kontakt.adapter.Adapter
import com.example.kontakt.databinding.FragmentListBinding
import com.example.kontakt.db.MyDbHelper
import com.example.kontakt.models.User


class ListFragment : Fragment() {
    private val binding by lazy { FragmentListBinding.inflate(layoutInflater) }
    private lateinit var adapter: Adapter
    private lateinit var myDbHalper: MyDbHelper
    private lateinit var list: ArrayList<User>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        list = ArrayList()
        myDbHalper = MyDbHelper(binding.root.context)
        list.addAll(myDbHalper.getAllKontakt())
        adapter = Adapter(list)
        binding.rv.adapter = adapter

        return binding.root
    }

}