package android.example.snuscollectorapp.screens.snus_detail

import android.example.snuscollectorapp.databinding.FragmentSnusDetailBinding
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import android.example.snuscollectorapp.models.Snus
import android.example.snuscollectorapp.models.SnusState
import android.example.snuscollectorapp.models.SnusViewModel
import android.example.snuscollectorapp.models.Snustype

class SnusDetailFragment : Fragment() {

    private val viewModel: SnusViewModel by activityViewModels()

    private val snusDataVariable = Snus("", 0.0, Snustype.PORTION, 0)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentSnusDetailBinding.inflate(inflater, container, false)


        binding.snusDetailCancelButton.setOnClickListener {
            navigateToSnus()
        }

        binding.snusViewModel = viewModel
        binding.lifecycleOwner = this
        binding.snusDataVariable = snusDataVariable


        viewModel.snusState.observe(this as LifecycleOwner) { state ->
            when (state) {
                SnusState.SAVE -> {
                    navigateToSnus()
                    viewModel.onSnusStateActionComplete()
                }
                else -> {}
            }
        }


        return binding.root
    }


    private fun navigateToSnus() {
        val action = SnusDetailFragmentDirections.actionSnusDetailToSnus()
        findNavController().navigate(action)
    }


}