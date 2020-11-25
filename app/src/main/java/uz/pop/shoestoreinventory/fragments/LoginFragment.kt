package uz.pop.shoestoreinventory.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.pop.shoestoreinventory.R
import uz.pop.shoestoreinventory.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.login.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionToWelcome())
        }

        binding.createLogin.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionToWelcome())
        }
    }
}