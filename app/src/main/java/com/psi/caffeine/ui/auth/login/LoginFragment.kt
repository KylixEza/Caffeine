package com.psi.caffeine.ui.auth.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.psi.caffeine.R
import com.psi.caffeine.databinding.FragmentLoginBinding
import com.psi.caffeine.ui.auth.register.RegisterFragment
import com.psi.caffeine.ui.main.MainActivity

class LoginFragment : Fragment() {
    
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding
    
    private lateinit var viewModel: LoginViewModel
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        
        binding?.apply {
            btnLogin.setOnClickListener {
                val username = tilUsername.text.toString()
                val password = tilPassword.text.toString()
                viewModel.login(username, password)?.observe(viewLifecycleOwner) {
                    if (it != null) {
                        val intent = Intent(requireContext(), MainActivity::class.java)
                        startActivity(intent)
                        activity?.finish()
                    } else {
                        Toast.makeText(requireContext(), "Invalid username or password", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            
            tvDontHaveAnAccount.setOnClickListener {
                parentFragmentManager.commit {
                    replace(R.id.fragment_container_auth, RegisterFragment())
                    addToBackStack(null)
                }
            }
        }
    }
    
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
    
}