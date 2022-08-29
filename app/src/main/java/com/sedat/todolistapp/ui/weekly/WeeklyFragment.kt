package com.sedat.todolistapp.ui.weekly

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.sedat.todolistapp.R
import com.sedat.todolistapp.databinding.FragmentWeeklyBinding
import com.sedat.todolistapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeeklyFragment : Fragment(R.layout.fragment_weekly) {

    private val binding by viewBinding(FragmentWeeklyBinding::bind)
    private val viewModel: WeeklyViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}