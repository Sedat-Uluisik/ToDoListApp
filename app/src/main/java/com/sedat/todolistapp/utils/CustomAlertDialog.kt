package com.sedat.todolistapp.utils

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.sedat.todolistapp.databinding.ItemLayoutAddForAlertDialogBinding
import com.sedat.todolistapp.listener.CustomAlertDialogListener

class CustomAlertDialog {
    fun showAlertDialog(
        context: Context,
        backgroundColor: Int,
        listener: CustomAlertDialogListener
    ){
        val view = ItemLayoutAddForAlertDialogBinding.inflate(LayoutInflater.from(context))
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setCancelable(false)
        alertDialog.setView(view.root)

        val dialog = alertDialog.create()
        if(dialog != null){
            if(dialog.window != null)
                dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
            dialog.show()
        }

        with(view){
            /*var layoutDrawable: Drawable = rootLayout.background
            layoutDrawable = DrawableCompat.wrap(layoutDrawable)
            DrawableCompat.setTint(layoutDrawable, backgroundColor)

            rootLayout.background = layoutDrawable*/
            rootLayout.setBackgroundColor(backgroundColor)

            btnCancel.setOnClickListener {
                dialog.dismiss()
            }

            btnInsert.setOnClickListener {
                edittextTitle.text?.let {
                    if(it.isNotEmpty()){
                        listener.insertBtnClick(it.toString())
                        dialog.dismiss()
                    }else
                        Toast.makeText(context, "Title field cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}