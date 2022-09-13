package com.sedat.todolistapp.constants

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.drawable.DrawableCompat
import com.sedat.todolistapp.R
import com.sedat.todolistapp.databinding.ItemLayoutAddForAlertDialogBinding

class CustomAlertDialog() {
    fun showAlertDialog(
        context: Context,
        backgroundColor: Int
    ){
        val view = ItemLayoutAddForAlertDialogBinding.inflate(LayoutInflater.from(context))
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setCancelable(true)
        alertDialog.setView(view.root)

        val dialog = alertDialog.create()
        if(dialog != null){
            if(dialog.window != null)
                dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
            dialog.show()
        }

        with(view){
            var layoutDrawable: Drawable = rootLayout.background
            layoutDrawable = DrawableCompat.wrap(layoutDrawable)
            DrawableCompat.setTint(layoutDrawable, backgroundColor)

            rootLayout.background = layoutDrawable

        }
    }
}