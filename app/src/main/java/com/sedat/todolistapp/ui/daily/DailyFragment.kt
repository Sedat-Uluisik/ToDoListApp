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
import com.sedat.todolistapp.ui.daily.adapter.DailyAdapter
import com.sedat.todolistapp.utils.DeviceUtils
import com.sedat.todolistapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DailyFragment : Fragment(R.layout.fragment_daily), CustomAlertDialogListener {

    private val binding by viewBinding(FragmentDailyBinding::bind)
    private val viewModel: DailyViewModel by viewModels()

    @Inject
    lateinit var adapter: DailyAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        observeData()

    }

    private fun observeData() {
        viewModel.titleList.observe(viewLifecycleOwner){
            it.loading?.let { bool ->
                if(bool)
                    binding.progressBar.visibility = View.VISIBLE
                else
                    binding.progressBar.visibility = View.GONE
            }
            it.error?.let { error ->
                if(error.isNotEmpty())
                    Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
            }
            it.titleResponse?.let { list ->
                //binding.progressBar.visibility = View.GONE
                if(list.isNotEmpty())
                    adapter.submitList(list)
            }
        }
    }

    private fun initViews() {
        DeviceUtils.closeKeyboard(requireActivity())

        binding.rvDaily.adapter = adapter


        binding.fabDaily.setOnClickListener {
            CustomAlertDialog().showAlertDialog(requireContext(), ContextCompat.getColor(requireContext(), R.color.daily_3), this)
        }
    }

    override fun insertBtnClick(title: String) {
        viewModel.insertTitle(title).observe(viewLifecycleOwner){
            println(it)
        }
    }

}