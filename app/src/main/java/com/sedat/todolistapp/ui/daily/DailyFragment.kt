package com.sedat.todolistapp.ui.daily

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.sedat.todolistapp.R
import com.sedat.todolistapp.constants.CustomAlertDialog
import com.sedat.todolistapp.databinding.FragmentDailyBinding
import com.sedat.todolistapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DailyFragment : Fragment(R.layout.fragment_daily) {

    private val binding by viewBinding(FragmentDailyBinding::bind)
    private val viewModel: DailyViewModel by viewModels()

    @Inject
    lateinit var customAlertDialog: CustomAlertDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.fabDaily.setOnClickListener {
            customAlertDialog.showAlertDialog(requireContext(), R.color.daily_2)
        }
    }

}