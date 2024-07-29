package com.anonymous.surveyheartllp.AllTodo.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.anonymous.surveyheartllp.AllTodo.model.Todos
import com.anonymous.surveyheartllp.AllTodo.viewmodel.AllTodoViewModel
import com.anonymous.surveyheartllp.databinding.ActivityMainBinding
import com.anonymous.surveyheartllp.util.DataHandler
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val allTodoViewModel: AllTodoViewModel by viewModels()


    lateinit var mytodolist :ArrayList<Todos>
    lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mytodolist =ArrayList<Todos>()
        allTodoViewModel.getAllTodos()


        setupRV()





        allTodoViewModel.alltodolivedata.observe(this) { dataHandler ->

            when (dataHandler) {
                is DataHandler.LOADING -> {

                }

                is DataHandler.SUCCESS -> {

                    val todo = dataHandler.data?.todos
                    mytodolist.clear() // Clear the old data
                    mytodolist.addAll(todo ?: emptyList()) // Add the new data
                    todoAdapter.notifyDataSetChanged()


                }

                is DataHandler.ERROR -> {
                    Toast.makeText(this, "Something error happend", Toast.LENGTH_SHORT).show()
                }

                null -> TODO()
            }

        }

    }


    private fun setupRV() {
        val layoutManager = LinearLayoutManager(this@MainActivity)

        binding.todoRV.apply {
            setLayoutManager(layoutManager)
            todoAdapter=TodoAdapter(mytodolist)
            adapter = todoAdapter
        }
    }

}

