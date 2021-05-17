package com.udacity.shoestore.shoeList

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.marginTop
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_list,
            container,
            false)

        binding.lifecycleOwner = this
        setHasOptionsMenu(true)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoes: MutableList<Shoe> ->
            for(shoe in shoes){
                bindTextViewShoe(shoe, binding.linearLayoutShoes)
            }
        })

        binding.btnAdd.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_addShoeFragment)
        }

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun bindTextViewShoe(shoe: Shoe, linearLayout: LinearLayout){
        val textView = TextView(context)

        var params = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0, 32, 0, 0)

        textView.layoutParams = params
        textView.setTextAppearance(R.style.LabelStyle)

        textView.text = "Name: ${shoe.name} \n Size: ${shoe.size} \n Company: ${shoe.company} \n Description: ${shoe.description}"
        linearLayout.addView(textView)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}