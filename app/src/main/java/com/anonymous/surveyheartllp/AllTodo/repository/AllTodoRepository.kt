package com.anonymous.surveyheartllp.AllTodo.repository

import com.anonymous.surveyheartllp.API.APIinterface
import com.anonymous.surveyheartllp.AllTodo.model.TodoResponse
import retrofit2.Response
import javax.inject.Inject

class AllTodoRepository @Inject constructor (val apIinterface: APIinterface) {

    suspend fun getAllTodos(): Response<TodoResponse> {
        return apIinterface.getAllTodos()
    }
}