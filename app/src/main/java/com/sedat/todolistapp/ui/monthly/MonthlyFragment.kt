package com.sedat.todolistapp.ui.monthly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.sedat.todolistapp.R
import com.sedat.todolistapp.utils.CustomAlertDialog
import com.sedat.todolistapp.databinding.FragmentMonthlyBinding
import com.sedat.todolistapp.listener.CustomAlertDialogListener
import com.sedat.todolistapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MonthlyFragment : Fragment(R.layout.fragment_monthly), CustomAlertDialogListener {

    private val binding by viewBinding(FragmentMonthlyBinding::bind)
    private val viewModel: MonthlyViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabMonthly.setOnClickListener {
            CustomAlertDialog().showAlertDialog(requireContext(), ContextCompat.getColor(requireContext(), R.color.monthly_2), this)
        }
    }

    override fun insertBtnClick(title: String) {
        TODO("Not yet implemented")
    }
}