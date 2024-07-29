package com.anonymous.surveyheartllp.API

import com.anonymous.surveyheartllp.AllTodo.model.TodoResponse
import retrofit2.Response
import retrofit2.http.GET

interface APIinterface {


        @GET("/todos")
        suspend fun getAllTodos(): Response<TodoResponse>


}