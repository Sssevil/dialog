package com.example.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button

class CustomDialog(context: Context):Dialog(context) {
    private var btn:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)
        window?.setBackgroundDrawableResource(R.drawable.dg_custom)
        setCancelable(false)
        setupView()
        setupListeners()
    }

    private fun setupView() {
        btn=findViewById(R.id.btn)
    }

    private fun setupListeners() {
        btn?.setOnClickListener(){
            dismiss()
        }
    }
}