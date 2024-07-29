package com.anonymous.surveyheartllp.AllTodo.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anonymous.surveyheartllp.AllTodo.model.Todos
import com.anonymous.surveyheartllp.databinding.ItemTodoBinding

class TodoAdapter(var todolist :List<Todos>) :RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {


    inner class TodoViewHolder(val binding :ItemTodoBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.TodoViewHolder {

        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TodoViewHolder(binding)

    }

    override fun onBindViewHolder(holder: TodoAdapter.TodoViewHolder, position: Int) {
      var data = todolist.get(position)
        holder.binding.todoId.text = data.id.toString()

        holder.binding.todoTodo.text = data.todo.toString()

        holder.binding.todoComplete.text = data.completed.toString()

        holder.binding.todoUserid.text = data.userId.toString()

    }

    override fun getItemCount(): Int =  todolist.size
}