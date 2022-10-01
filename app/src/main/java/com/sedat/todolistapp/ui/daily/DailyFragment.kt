package com.sedat.todolistapp.ui.daily

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.sedat.todolistapp.R
import com.sedat.todolistapp.utils.CustomAlertDialog
import com.sedat.todolistapp.databinding.FragmentDailyBinding
import com.sedat.todolistapp.listener.CustomAlertDialogListener
import com.sedat.todolistapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DailyFragment : Fragment(R.layout.fragment_daily), CustomAlertDialogListener {

    private val binding by viewBinding(FragmentDailyBinding::bind)
    private val viewModel: DailyViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.fabDaily.setOnClickListener {
            CustomAlertDialog().showAlertDialog(requireContext(), ContextCompat.getColor(requireContext(), R.color.daily_3), this)
        }
    }

    override fun insertBtnClick(title: String) {
        Toast.makeText(requireContext(), title, Toast.LENGTH_SHORT).show()
    }

}