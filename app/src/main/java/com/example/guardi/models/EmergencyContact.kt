package com.example.guardi.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class EmergencyContact (
    @PrimaryKey
    val contactId: String = UUID.randomUUID().toString(),
    val name: String,
    val phoneNumber: String
)