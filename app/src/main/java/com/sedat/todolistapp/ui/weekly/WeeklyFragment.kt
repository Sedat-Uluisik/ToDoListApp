package com.sedat.todolistapp.ui.weekly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.sedat.todolistapp.R
import com.sedat.todolistapp.utils.CustomAlertDialog
import com.sedat.todolistapp.databinding.FragmentWeeklyBinding
import com.sedat.todolistapp.listener.CustomAlertDialogListener
import com.sedat.todolistapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeeklyFragment : Fragment(R.layout.fragment_weekly), CustomAlertDialogListener {

    private val binding by viewBinding(FragmentWeeklyBinding::bind)
    private val viewModel: WeeklyViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabWeekly.setOnClickListener {
            CustomAlertDialog().showAlertDialog(requireContext(), ContextCompat.getColor(requireContext(), R.color.weekly_2), this)
        }
    }

    override fun insertBtnClick(title: String) {
        TODO("Not yet implemented")
    }

}