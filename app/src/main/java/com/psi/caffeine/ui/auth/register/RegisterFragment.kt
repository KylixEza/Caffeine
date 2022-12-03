package com.psi.caffeine.ui.auth.register

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.psi.caffeine.R
import com.psi.caffeine.databinding.FragmentRegisterBinding
import com.psi.caffeine.model.User
import com.psi.caffeine.ui.main.MainActivity
import java.util.UUID

class RegisterFragment : Fragment() {
    
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding
    
    private var isFromSuccessRegister = false
    
    private lateinit var viewModel: RegisterViewModel
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding?.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        
        binding?.apply {
            btnRegister.setOnClickListener {
                val username = tilUsername.text.toString()
                val email = tilEmail.text.toString()
                val password = tilPassword.text.toString()
                
                val user = User(
                    UUID.randomUUID().toString(),
                    username,
                    email,
                    password,
                    "https://picsum.photos/200/300?random=1",
                    false
                )
    
                viewModel.isEmailExist(email).observe(viewLifecycleOwner) { isExists ->
                    if(isExists) {
                        if (!isFromSuccessRegister)
                            Toast.makeText(requireContext(), "Email already exists", Toast.LENGTH_SHORT).show()
                    } else {
                        isFromSuccessRegister = true
                        viewModel.register(user)
                        val intent = Intent(requireContext(), MainActivity::class.java)
                        startActivity(intent)
                        activity?.finish()
                    }
                }
            }
        }
    }
    
}