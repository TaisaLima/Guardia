package com.example.guardi.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class User (
    @PrimaryKey
    val userId: String = UUID.randomUUID().toString(),
    val email: String,
    val password: String,
    val phoneNumber:String,
    val cpf: String
)