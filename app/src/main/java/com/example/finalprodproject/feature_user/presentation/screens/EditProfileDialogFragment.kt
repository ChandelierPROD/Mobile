package com.example.finalprodproject.feature_user.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels

import com.example.finalprodproject.databinding.ChangeFragmentBinding
import com.example.finalprodproject.feature_user.domain.helpers.UserStorageHandler
import com.example.finalprodproject.utils.enums.LoaderState
import com.example.finalprodproject.feature_user.presentation.viewmodels.UserViewModel

class EditProfileDialogFragment: DialogFragment() {
    private var _binding: ChangeFragmentBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var viewModel: UserViewModel
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = ChangeFragmentBinding.inflate(inflater, container, false)
        val userViewModel: UserViewModel by viewModels { UserViewModel.provideFactory(UserStorageHandler(requireContext())) }
        viewModel = userViewModel
        
         binding.btnDialog.setOnClickListener {
             val name: String = binding.inputFirstname.getText().toString()
             val lastname: String = binding.inputLastname.getText().toString()
             val surname: String = binding.inputOtchestvo.getText().toString()

             viewModel.updateProfile(name, lastname, surname).observe(requireActivity()) { loaderState ->
                 if (loaderState == LoaderState.ERROR) {
                     binding.updateProfileError.text = "Произошла ошибка"
                     binding.updateProfileError.visibility = View.VISIBLE
                     binding.btnDialog.setEnabled(true)
                 } else if (loaderState == LoaderState.SUCCESS) {
                     binding.updateProfileError.text = ""
                     binding.updateProfileError.visibility = View.GONE

                     binding.inputFirstname.setText("")
                     binding.inputLastname.setText("")
                     binding.inputOtchestvo.setText("")
                     binding.btnDialog.setEnabled(true)

                     dismiss()
                 } else if (loaderState == LoaderState.LOADING) {
                     binding.updateProfileError.text = ""
                     binding.updateProfileError.visibility = View.GONE
                     binding.btnDialog.setEnabled(false)
                 }
             }
         }


         return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
