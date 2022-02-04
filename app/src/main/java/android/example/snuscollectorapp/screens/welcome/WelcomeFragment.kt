package android.example.snuscollectorapp.screens.welcome

import android.example.snuscollectorapp.R
import android.example.snuscollectorapp.databinding.FragmentWelcomeBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

class WelcomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcome, container, false
        )

        binding.welcomeButton.setOnClickListener {
            navigateToInstruction()
        }
        return binding.root
    }



    private fun navigateToInstruction() {
        val action = WelcomeFragmentDirections.actionWelcomeToInstruction()
        findNavController().navigate(action)
    }


}