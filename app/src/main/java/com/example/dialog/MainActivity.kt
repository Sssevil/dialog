package com.example.dialog

import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {
    private var edFirst:EditText?=null
    private var edLast:EditText?=null
    private var edBirth:EditText?=null
    private var btnSave:Button?=null
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        setupClick()
    }

    private fun setupViews() {
        edFirst = findViewById(R.id.edFirst)
        edLast = findViewById(R.id.edLast)
        edBirth = findViewById(R.id.edBirth)
        btnSave = findViewById(R.id.Save)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun datePickerDialog(){
       val dialog= DatePickerDialog(this)
        dialog.setOnDateSetListener { view, year, month, dateOfMonth ->
            edBirth?.setText(getString(R.string.data,dateOfMonth,month,year))
        }
        dialog.setCancelable(false)
        dialog.datePicker.maxDate= Date().time
        dialog.show()

    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setupClick() {
        btnSave?.setOnClickListener{
            setupAlertDialog()
        }
        edBirth?.setOnClickListener{
            datePickerDialog()
        }
    }
    private fun setupAlertDialog(){
        AlertDialog.Builder(ContextThemeWrapper(this, R.style.myDialog))
            .setTitle(getString(R.string.dan))
            .setPositiveButton(getString(R.string.yes)) { dialog_, which_ ->
                getShared()
                setupCustomDialog()
            }
            .setNegativeButton(getString(R.string.no)) { dialog_, which_ ->
                finish()

            }
            .setCancelable(false)
            .show()

    }
    private fun getShared(){
        val preference=getSharedPreferences("Preference",Context.MODE_PRIVATE)

        val edFirst=edFirst?.text.toString()
        preference.edit().putString("edFirst",edFirst).apply()
        val edLast=edLast?.text.toString()
        preference.edit().putString("edLast",edLast).apply()
        val edBirth=edBirth?.text.toString()
        preference.edit().putString("edBirth",edBirth).apply()


    }

    private fun setupCustomDialog(){
        CustomDialog(this).show()
    }


}
