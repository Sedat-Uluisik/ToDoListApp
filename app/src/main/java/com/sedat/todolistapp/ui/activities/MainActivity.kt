package com.sedat.todolistapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayoutMediator
import com.sedat.todolistapp.R
import com.sedat.todolistapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun showBottomSheetDialog(){
        val dialog = BottomSheetDialog(this, R.style.BottomSheetTheme)
        val view = layoutInflater.inflate(R.layout.bottom_sheet_layout, null)

        dialog.setCancelable(true)
        dialog.setContentView(view)
        dialog.show()
    }
}