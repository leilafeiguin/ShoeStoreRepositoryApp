package com.udacity.shoestore.shoeList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentAddShoeBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

class AddShoeFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding: FragmentAddShoeBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_add_shoe,
            container,
            false)

        binding.lifecycleOwner = this
        binding.shoeListViewModel = viewModel

        binding.btnSave.setOnClickListener{view: View ->
            viewModel.addShoe()
            view.findNavController().navigate(R.id.action_addShoeFragment_to_shoeListFragment)
        }

        binding.btnCancel.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_addShoeFragment_to_shoeListFragment)
        }

        return binding.root
    }
}