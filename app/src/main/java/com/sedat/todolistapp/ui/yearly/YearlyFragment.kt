package com.sedat.todolistapp.ui.yearly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.sedat.todolistapp.R
import com.sedat.todolistapp.utils.CustomAlertDialog
import com.sedat.todolistapp.databinding.FragmentYearlyBinding
import com.sedat.todolistapp.listener.CustomAlertDialogListener
import com.sedat.todolistapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YearlyFragment : Fragment(R.layout.fragment_yearly), CustomAlertDialogListener {

    private val binding by viewBinding(FragmentYearlyBinding::bind)
    private val viewModel: YearlyViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.fabYarly.setOnClickListener {
            CustomAlertDialog().showAlertDialog(requireContext(), ContextCompat.getColor(requireContext(), R.color.yearly_2), this)
        }
    }

    override fun insertBtnClick(title: String) {
        TODO("Not yet implemented")
    }

}