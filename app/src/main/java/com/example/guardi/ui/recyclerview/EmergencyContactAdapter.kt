package com.example.guardi.ui.recyclerview

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.guardi.R
import com.example.guardi.databinding.CardviewAddEmergencyContactBinding
import com.example.guardi.databinding.CardviewEmergencyContactBinding
import com.example.guardi.models.EmergencyContact
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.UUID

class EmergencyContactAdapter(
    private val context: Context,
    contacts: List<EmergencyContact> = emptyList(),
    var setItemClick: (contact: EmergencyContact) -> Unit = { _: EmergencyContact -> }
) : RecyclerView.Adapter<EmergencyContactAdapter.ViewHolder>() {

    private val contacts = contacts.toMutableList()

    inner class ViewHolder(private val binding: CardviewAddEmergencyContactBinding) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var contact: EmergencyContact

        init {
            itemView.setOnClickListener {
                if (::contact.isInitialized) {
                    setItemClick(contact)
                }
            }
        }

        fun setItemInfo(contact: EmergencyContact) {
            this.contact = contact

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmergencyContactAdapter.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = CardviewAddEmergencyContactBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmergencyContactAdapter.ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.setItemInfo(contact)
    }

    override fun getItemCount(): Int = contacts.size

    fun refresh(contacts: List<EmergencyContact>) {
        this.contacts.clear()
        this.contacts.addAll(contacts)
    }
}