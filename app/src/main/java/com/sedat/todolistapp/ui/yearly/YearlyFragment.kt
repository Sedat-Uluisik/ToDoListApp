package com.sedat.todolistapp.ui.yearly

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.sedat.todolistapp.R
import com.sedat.todolistapp.constants.CustomAlertDialog
import com.sedat.todolistapp.databinding.FragmentYearlyBinding
import com.sedat.todolistapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class YearlyFragment : Fragment(R.layout.fragment_yearly) {

    private val binding by viewBinding(FragmentYearlyBinding::bind)
    private val viewModel: YearlyViewModel by viewModels()

    @Inject
    lateinit var customAlertDialog: CustomAlertDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.fabYarly.setOnClickListener {
            customAlertDialog.showAlertDialog(requireContext(), R.color.yearly_1)
        }
    }

}