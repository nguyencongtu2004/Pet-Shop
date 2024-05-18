package com.example.petshop.database.controller

import com.example.petshop.database.model.Account
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.DatabaseReference

class AccountController {
    private val database: DatabaseReference = FirebaseDatabase.getInstance().reference

    fun registerAccount(numberphone: String, password: String, callback: (Boolean, String?) -> Unit) {
        val userId = database.push().key
        if (userId == null) {
            callback(false, "Failed to generate user ID")
            return
        }
        val account = Account(user_id = userId, numberphone = numberphone, password = password)
        database.child("Accounts").child(userId).setValue(account)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    callback(true, null)
                } else {
                    callback(false, task.exception?.message)
                }
            }
    }

//    fun loginAccount(numberphone: String, password: String, callback: (Boolean, String?) -> Unit) {
//        database.child("Accounts").orderByChild("numberphone").equalTo(numberphone)
//            .addListenerForSingleValueEvent(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    if (snapshot.exists()) {
//                        for (accountSnapshot in snapshot.children) {
//                            val account = accountSnapshot.getValue(Account::class.java)
//                            if (account != null && account.password == password) {
//                                callback(true, null)
//                                return
//                            }
//                        }
//                        callback(false, "Incorrect password")
//                    } else {
//                        callback(false, "Account does not exist")
//                    }
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                    callback(false, error.message)
//                }
//            })
//    }
}
