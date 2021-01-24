package com.devcoder.mvvmexpectlevel.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.devcoder.R
import com.devcoder.databinding.FragmentLoginBinding
import com.devcoder.mvvmdemo.util.hide
import com.devcoder.mvvmdemo.util.show
import com.devcoder.mvvmexpectlevel.network.ApiService
import com.devcoder.mvvmexpectlevel.network.Resource
import com.devcoder.mvvmexpectlevel.repository.BaseRepository
import com.devcoder.mvvmexpectlevel.repository.LoginRepository

class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding, BaseRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            binding.progressBar.hide()
            when (it) {
                is Resource.Success -> {
                    it.value.userInfo?.let {
                        if (it.auth == 1) {
                            Toast.makeText(requireContext(), "LoginSuccess", Toast.LENGTH_LONG)
                                .show()
                        } else {
                            Toast.makeText(requireContext(), "Invalid username and password", Toast.LENGTH_LONG).show()
                        }
                    } ?: run {
                        Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
                    }

                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Login Failed ", Toast.LENGTH_LONG).show()
                }
            }
        })
        binding.buttonSubmit.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            if (loginValidation(username, password)) {
                binding.progressBar.show()
                viewModel.login(username = username, password = password)
            }
        }
    }

    override fun getViewModel() = LoginViewModel::class.java


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)

    override fun getFragmentRepository(): BaseRepository =
        LoginRepository(remoteDataSource.buildApi(ApiService::class.java))

    private fun loginValidation(username: String, password: String): Boolean {

        return when {
            username.trim { it <= ' ' }.isEmpty() -> {
                binding.etUsername?.error = getString(R.string.required)
                binding.etUsername?.requestFocus()
                binding.etUsername?.requestFocusFromTouch()
                false
            }
            password.trim { it <= ' ' }.isEmpty() -> {
                binding.etPassword?.error = getString(R.string.required)
                binding.etPassword?.requestFocus()
                binding.etPassword?.requestFocusFromTouch()
                false
            }
            else -> true
        }
    }
}