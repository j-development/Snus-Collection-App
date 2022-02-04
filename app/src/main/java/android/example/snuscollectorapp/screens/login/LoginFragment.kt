package android.example.snuscollectorapp.screens.login

import android.example.snuscollectorapp.R
import android.example.snuscollectorapp.databinding.FragmentLoginBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.createLoginButton.setOnClickListener {
            viewModel.onCreateLogin()
        }

        binding.loginButton.setOnClickListener {
            viewModel.onLogin()
        }


        viewModel.actionState.observe(this as LifecycleOwner, { action ->
            when (action) {
                LoginState.CREATE -> {
                    navigateToWelcome()
                    viewModel.onLoginStateActionComplete()
                }
                LoginState.LOGIN -> {
                    navigateToSnus()
                    viewModel.onLoginStateActionComplete()
                }
                else -> {}
            }
        })
        return binding.root

    }

    private fun navigateToWelcome() {
        val action = LoginFragmentDirections.actionLoginToWelcome()
        findNavController().navigate(action)
    }
    private fun navigateToSnus() {
        val action = LoginFragmentDirections.actionLoginToSnus()
        findNavController().navigate(action)
    }

}