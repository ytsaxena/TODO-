package com.anonymous.surveyheartllp.AllTodo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anonymous.surveyheartllp.AllTodo.model.TodoResponse
import com.anonymous.surveyheartllp.AllTodo.repository.AllTodoRepository
import com.anonymous.surveyheartllp.util.DataHandler
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AllTodoViewModel @Inject constructor(val allTodoRepository: AllTodoRepository): ViewModel() {


    private val _alltodolivedata = MutableLiveData<DataHandler<TodoResponse>?>()
    val alltodolivedata: LiveData<DataHandler<TodoResponse>?> = _alltodolivedata

    fun getAllTodos() {

        _alltodolivedata.postValue(DataHandler.LOADING())
        viewModelScope.launch {
            val response = allTodoRepository.getAllTodos()
            _alltodolivedata.postValue(handleResponse(response))
        }

    }

    private fun handleResponse(response: Response<TodoResponse>): DataHandler<TodoResponse>? {
    if (response.isSuccessful){
    response.body()?.let { it ->
        return DataHandler.SUCCESS(it)
    }
}
        return DataHandler.ERROR(message = response.errorBody().toString())
    }


}