package com.project.recipee.ui

import android.database.DatabaseErrorHandler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.recipee.data.network.ApiClient
import com.project.recipee.data.response.RandomResponse
import com.project.recipee.data.response.SearchResponse
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers


class MainViewModel : ViewModel() {
    // inisialisasi
    // randomresponse
    val randomResponse = MutableLiveData<List<RandomResponse>>()
    // searchresponse
    val searchResponse = MutableLiveData<List<SearchResponse>>()
    val isLoading = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Throwable>()

//    private fun getRandom(responHandler: (List<RandomResponse>) -> Unit, errorHandler: (Throwable) -> Unit){
//        ApiClient.getApiService().getRandom()
//            // subscribeOn utk menyediakan prosses async, menempatkan Api di background ata
//            .subscribeOn(Schedulers.io())
//            // nge get data utk menmpilkan dimana data nya akan ditampung (di )
//            .observeOn(AndroidSchedulers.mainThread())
//            // utk menentukan apakah akan direspon atau eror
//            .subscribe({
//                responHandler(it)
//            }, {
//                errorHandler(it)
//            })
//    }


}