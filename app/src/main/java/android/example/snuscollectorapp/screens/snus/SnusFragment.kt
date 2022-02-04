package android.example.snuscollectorapp.screens.snus

import android.example.snuscollectorapp.R
import android.example.snuscollectorapp.databinding.FragmentSnusBinding
import android.example.snuscollectorapp.databinding.TemplateSnusItemBinding
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import android.example.snuscollectorapp.models.SnusViewModel

class SnusFragment : Fragment() {


    private val viewModel: SnusViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSnusBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_snus, container, false)



        viewModel.snusList.observe(this as LifecycleOwner,{
            for(Item in viewModel.snusList.value!!){
                val snusItemBinding = TemplateSnusItemBinding.inflate(layoutInflater)
                snusItemBinding.snusDataVariable = Item
                binding.scrollLayout.addView(snusItemBinding.root)
            }
        })



        binding.newSnusButton.setOnClickListener{
            navigateToDetail()
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }





    private fun navigateToDetail() {
        val action = SnusFragmentDirections.actionSnusToSnusDetail()
        findNavController().navigate(action)
    }

}