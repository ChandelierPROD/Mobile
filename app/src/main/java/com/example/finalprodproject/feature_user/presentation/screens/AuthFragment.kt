package com.example.finalprodproject.feature_user.presentation.screens

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation

import com.example.finalprodproject.R
import com.example.finalprodproject.databinding.AuthFragmentBinding
import com.example.finalprodproject.feature_user.domain.helpers.UserStorageHandler
import com.example.finalprodproject.utils.enums.LoaderState
import com.example.finalprodproject.feature_user.presentation.viewmodels.UserViewModel

class AuthFragment: Fragment() {
    private var _binding: AuthFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = AuthFragmentBinding.inflate(inflater, container, false)

        val userViewModel: UserViewModel by viewModels() { UserViewModel.provideFactory( UserStorageHandler(requireContext())) }
        this.userViewModel = userViewModel

        binding.successLayout.nextButton.setOnClickListener {
            val email: String = binding.successLayout.inputPhone.getText().toString()
            val login: String = binding.successLayout.inputName.getText().toString()
            val password: String = binding.successLayout.inputPassword.getText().toString()
            userViewModel.register(email, login, password)
        }

        binding.successLayout.nextButton1.setOnClickListener {
            val login: String = binding.successLayout.inputPhone1.getText().toString()
            val password: String = binding.successLayout.inputPassword1.getText().toString()
            userViewModel.login(login, password)
        }

        binding.successLayout.registrationTv.setOnClickListener {
            binding.successLayout.viewSwitcher.setDisplayedChild(0)
            binding.successLayout.loginTv.setBackgroundDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.inactive_button))
            binding.successLayout.registrationTv.setBackgroundDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.active_button))
            binding.successLayout.registrationTv.setTextColor(Color.BLACK)
            binding.successLayout.loginTv.setTextColor(Color.parseColor("#818C99"))
        }


        binding.successLayout.loginTv.setOnClickListener {
            binding.successLayout.viewSwitcher.setDisplayedChild(1)
            binding.successLayout.loginTv.setBackgroundDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.active_button))
            binding.successLayout.registrationTv.setBackgroundDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.inactive_button))
            binding.successLayout.loginTv.setTextColor(Color.BLACK)
            binding.successLayout.registrationTv.setTextColor(Color.parseColor("#818C99"))
        }

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel.checkAuth().observe(getViewLifecycleOwner()) { isAuth ->
            if (isAuth) Navigation.findNavController(requireView())
                .navigate(R.id.action_authFragment_to_shopFragment)
        }

        userViewModel.getRegisterLoader().observe(getViewLifecycleOwner()) { loaderState ->
            if (loaderState != null) {
                when (loaderState) {
                    LoaderState.LOADING -> binding.loadingLayout.visibility = View.VISIBLE
                    LoaderState.SUCCESS -> {
                        binding.loadingLayout.visibility = View.GONE
                        binding.successLayout.loginTv.setBackgroundDrawable(
                            ContextCompat.getDrawable(requireContext(), R.drawable.active_button)
                        )
                        binding.successLayout.registrationTv.setBackgroundDrawable(
                            ContextCompat.getDrawable(requireContext(), R.drawable.inactive_button)
                        )
                        binding.successLayout.loginTv.setTextColor(Color.BLACK)
                        binding.successLayout.registrationTv.setTextColor(Color.parseColor("#818C99"))
                        binding.successLayout.viewSwitcher.setDisplayedChild(1)
                    }

                    LoaderState.ERROR -> binding.loadingLayout.visibility = View.GONE
                    else -> binding.loadingLayout.visibility = View.GONE
                }

                userViewModel.getLoginLoader().observe(getViewLifecycleOwner()) { loaderState1 ->
                    if (loaderState1 != null) {
                        when (loaderState1) {
                            LoaderState.LOADING -> binding.loadingLayout.visibility = View.VISIBLE
                            LoaderState.SUCCESS -> {
                                binding.loadingLayout.visibility = View.GONE
                                Navigation.findNavController(requireView())
                                    .navigate(R.id.shopFragment)
                                Log.d("navigation", "nav")
                            }
                            LoaderState.ERROR -> binding.loadingLayout.visibility = View.VISIBLE
                            else -> binding.loadingLayout.visibility = View.GONE
                        }
                    }
                }

                userViewModel.getLoaderCheckAuth().observe(getViewLifecycleOwner()) { loaderState2 ->
                    if (loaderState2 != null) {
                        when (loaderState2) {
                            LoaderState.LOADING -> {
                                binding.loadingLayout.visibility = View.VISIBLE
                                binding.successAuth.visibility = View.GONE
                            }
                            else -> binding.successAuth.visibility = View.VISIBLE
                        }
                    }
                }

                userViewModel.getStatusCode().observe(getViewLifecycleOwner()) { statusCode ->
                    when (statusCode) {
                        400 -> {
                            binding.successLayout.authErrorIcon.visibility = View.VISIBLE
                            binding.successLayout.text2.visibility = View.VISIBLE
                            binding.successLayout.authError.text = "Неправильный формат ввода данных"
                        }
                        401 -> {
                            binding.successLayout.authErrorIcon.visibility = View.VISIBLE
                            binding.successLayout.text2.visibility = View.GONE
                            binding.successLayout.authError.text = "Не авторизован"
                        }
                        404 -> {
                            binding.successLayout.authErrorIcon.visibility = View.VISIBLE
                            binding.successLayout.text2.visibility = View.GONE
                            binding.successLayout.authError.text = "Не найден"
                        }
                        409 -> {
                            binding.successLayout.authErrorIcon.visibility = View.VISIBLE
                            binding.successLayout.text2.visibility = View.GONE
                            binding.successLayout.authError.text = "Пользователь с такими данными уже существует"
                        }
                        else -> {
                            binding.successLayout.authErrorIcon.visibility = View.GONE
                            binding.successLayout.text2.visibility = View.GONE
                            binding.successLayout.authError.text = ""
                        }
                    }
                }
            }
        }
    }

   override fun onDestroyView() {
        super.onDestroyView()
        userViewModel.updateStatusCode(0)
        userViewModel.updateRegisterLoader(null)
        userViewModel.updateLoginLoader(null)
    }

}