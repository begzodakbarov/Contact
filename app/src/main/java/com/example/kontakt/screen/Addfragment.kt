package com.example.kontakt.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.kontakt.databinding.FragmentAddBinding
import com.example.kontakt.databinding.FragmentListBinding
import com.example.kontakt.db.MyDbHelper
import com.example.kontakt.models.User


class Addfragment : Fragment() {
    private val binding by lazy { FragmentAddBinding.inflate(layoutInflater) }
    private lateinit var myDbHelper: MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View{

        myDbHelper = MyDbHelper(binding.root.context)
        binding.btnSave.setOnClickListener {
            val user = User(name = binding.edtName.text.toString(), number = binding.edtNumber.text.toString())
            myDbHelper.addKontakt(user)
            Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }

        return binding.root
    }
}