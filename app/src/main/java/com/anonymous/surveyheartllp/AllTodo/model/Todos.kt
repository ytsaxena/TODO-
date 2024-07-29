package com.anonymous.surveyheartllp.AllTodo.model

import com.google.gson.annotations.SerializedName

data class Todos(@SerializedName("id") val id : Int,
                 @SerializedName("todo") val todo : String,
                 @SerializedName("completed") val completed : Boolean,
                 @SerializedName("userId") val userId : Int)
