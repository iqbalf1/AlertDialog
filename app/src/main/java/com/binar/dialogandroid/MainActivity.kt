package com.binar.dialogandroid

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.button)
        button1.setOnClickListener {
            AlertDialogStandart()
        }
        button2 = findViewById(R.id.button2)
        button2.setOnClickListener {
            AlertDialogClik()
        }
        button3 = findViewById(R.id.button3)
        button3.setOnClickListener {
            AlertDialogCustomLayout()
        }


    }

    private fun AlertDialogStandart() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Dialog Cancelable")
        dialog.setMessage("Dialog Cancelable bisa ditutup dengan klik luar bagian dialog")
        dialog.setCancelable(true)
        dialog.show()
    }

    private fun AlertDialogClik() {
        //AlertDialog dengan Tombol Aksi
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Dialog Dengan Button")
        dialog.setMessage("Dialog Dengan Button untuk berbagai aksi")
        dialog.setIcon(R.mipmap.ic_launcher)

        dialog.setCancelable(false)
        dialog.setPositiveButton("Possitive Button")
        { dialogInterface, p1 ->
            Snackbar.make(
                findViewById(R.id.parent_layout),
                "Positive Button Clicked",
                Snackbar.LENGTH_LONG
            ).show()

        }
        dialog.setNegativeButton("Negative Button")
        { dialogInterface, p1 ->
            Toast.makeText(this, "Negative Button Clicked", Toast.LENGTH_LONG).show()
        }
        dialog.setNeutralButton("Netral Button")
        { dialogInterface, p1 ->
            Toast.makeText(this, "Neutral Button Clicked", Toast.LENGTH_LONG).show()
        }
        dialog.show()
    }

    private fun AlertDialogCustomLayout() {
        val Dialoglayout = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null, true)
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(Dialoglayout)


        val dialog = dialogBuilder.create()
        dialog.setCancelable(false)
        val btnTutup = Dialoglayout.findViewById<Button>(R.id.btn_close)
        btnTutup.setOnClickListener {
            Toast.makeText(this, "Custom Dialog Closed", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }

        dialog.show()
    }
}