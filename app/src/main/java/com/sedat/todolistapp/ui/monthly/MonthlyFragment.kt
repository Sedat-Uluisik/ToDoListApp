package com.sedat.todolistapp.ui.monthly

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.sedat.todolistapp.R
import com.sedat.todolistapp.constants.CustomAlertDialog
import com.sedat.todolistapp.databinding.FragmentMonthlyBinding
import com.sedat.todolistapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MonthlyFragment : Fragment(R.layout.fragment_monthly) {

    private val binding by viewBinding(FragmentMonthlyBinding::bind)
    private val viewModel: MonthlyViewModel by viewModels()

    @Inject
    lateinit var customAlertDialog: CustomAlertDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabMonthly.setOnClickListener {
            customAlertDialog.showAlertDialog(requireContext(), R.color.monthly_2)
        }
    }
}