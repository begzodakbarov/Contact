package com.example.kontakt.db

import com.example.kontakt.models.User

interface MyDbService {
    fun addKontakt(user: User)
    fun getAllKontakt():List<User>
}