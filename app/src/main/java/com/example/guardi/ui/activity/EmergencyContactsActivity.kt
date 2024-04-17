package com.example.guardi.ui.activity

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.guardi.database.AppDataBase
import com.example.guardi.database.dao.EmergencyContactDao
import com.example.guardi.databinding.ActivityEmergencyContactsBinding
import com.example.guardi.databinding.AlertdialogEmergencyContactBinding
import com.example.guardi.databinding.CardviewAddEmergencyContactBinding
import com.example.guardi.models.EmergencyContact
import com.example.guardi.ui.recyclerview.EmergencyContactAdapter
import java.util.UUID

class EmergencyContactsActivity : AppCompatActivity() {

    private val binding by lazy {ActivityEmergencyContactsBinding.inflate(layoutInflater)}
    private val emergencyContactDao by lazy {AppDataBase.instantiate(this).emergencyContactDao()}
    private val emergencyContactAdapter = EmergencyContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        contactsRecyclerView(binding.emergencyContactsRecyclerView, emergencyContactAdapter)
        addEmergencyNumber()
    }

    private fun contactsRecyclerView(recyclerView: RecyclerView, previewAdapter: EmergencyContactAdapter) {
        val itemList = emergencyContactDao.getAll()

        itemList?.takeIf {it.isNotEmpty()}?.let {
            recyclerView.adapter = previewAdapter

            previewAdapter.setItemClick = {
                emergencyContactDao.remove(it.name)

                emergencyContactDao.getAll()?.let {
                    previewAdapter.refresh(it)
                }
            }

            previewAdapter.refresh(itemList)
        }
    }

    private fun addEmergencyNumber() {
        binding.addEmergencyContacts.setOnClickListener {

            val ticketDialog = AlertdialogEmergencyContactBinding.inflate(layoutInflater)

            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(ticketDialog.root)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            ticketDialog.confirmButton.setOnClickListener {
                Toast.makeText(this, emergencyContactDao.getAll()?.size.toString(), Toast.LENGTH_SHORT).show()
            }

            ticketDialog.cancelButton.setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()
        }
    }
}