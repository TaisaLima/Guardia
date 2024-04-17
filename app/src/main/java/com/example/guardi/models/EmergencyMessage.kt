package com.example.guardi.models

import androidx.room.PrimaryKey
import java.util.UUID

data class EmergencyMessage (
    @PrimaryKey
    val messageId: String = UUID.randomUUID().toString(),
    val message: String,
    val time: String,
    val latitude: Float,
    val longitude: Float
)