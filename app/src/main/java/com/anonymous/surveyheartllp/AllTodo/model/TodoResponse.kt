package com.anonymous.surveyheartllp.AllTodo.model

import com.google.gson.annotations.SerializedName

data class TodoResponse(

    @SerializedName("todos") val todos : List<Todos>,
    @SerializedName("total") val total : Int,
    @SerializedName("skip") val skip : Int,
    @SerializedName("limit") val limit : Int
)

