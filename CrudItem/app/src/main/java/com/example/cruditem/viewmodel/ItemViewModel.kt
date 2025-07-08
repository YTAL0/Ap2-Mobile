package com.example.cruditem.viewmodel 

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.cruditem.model.Item
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration

class ItemViewModel: ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private var listenerRegistration : ListenerRegistration ? = null

    var items = mutableStateOf<List<Item>>(listOf())
        private set
    init {
        listenerToItems()
    }
    private fun listenerToItems(){
        listenerRegistration = db.collection("items").addSnapshotListener{ snapshot, exception ->
            if(exception != null){
                return@addSnapshotListener
            }
            if(snapshot != null){
                val fetchItems = snapshot.documents.map { document ->
                    document.toObject(Item::class.java)?.copy(id = document.id)
                }.filterNotNull()
                items.value = fetchItems
            }
        }
    }


    fun addItem(item : Item){
        db.collection("items").add(item)
    }

    fun deleteItem(itemId : String){
        db.collection("items").document(itemId).delete()
    }

    override fun onCleared() {
        super .onCleared()
        listenerRegistration?.remove()
    }

    fun updateItem(item : Item){
        db.collection("items").document(item.id).set(item).addOnSuccessListener {
            Log.d("viewmodel", "Item atulizado com sucesso.")
        }.addOnFailureListener {
            Log.d("viewmodel", "Item não atualizado com sucesso.")
        }
    }
}