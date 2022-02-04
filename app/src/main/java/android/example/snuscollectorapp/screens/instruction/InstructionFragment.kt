package android.example.snuscollectorapp.screens.instruction

import android.example.snuscollectorapp.R
import android.example.snuscollectorapp.databinding.FragmentInstructionBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
class InstructionFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInstructionBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instruction, container, false
        )
        binding.instructionButton.setOnClickListener {
            NavigateToSnus()
        }
        return binding.root
    }

    private fun NavigateToSnus() {
        val action = InstructionFragmentDirections.actionInstructionToSnus()
        findNavController().navigate(action)
    }

}