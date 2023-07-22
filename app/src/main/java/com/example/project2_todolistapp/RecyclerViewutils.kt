package com.example.project2_todolistapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project2_todolistapp.databinding.TodoListItemBinding
import com.example.project2_todolistapp.db.Todo

class ToDoListViewHolder(
    private val itemBinding: TodoListItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bindData(todo: Todo) {
        itemBinding.cbItemTodo.isChecked = todo.isDone
        itemBinding.tvItemTodoTitle.text = todo.title
        itemBinding.tvItemTodoDesc.text = todo.Desc
        itemBinding.tvItemTodoDate.text = todo.date.toString()
    }
}

class TodoListAdapter(
    //List of elements to be populated here
    private var listOfTodos: MutableList<Todo>

) : RecyclerView.Adapter<ToDoListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoListViewHolder {
        return ToDoListViewHolder(
            TodoListItemBinding
                .inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun getItemCount() = listOfTodos.size

    override fun onBindViewHolder(holder: ToDoListViewHolder, position: Int) {
            holder.bindData(listOfTodos[position])
    }
    fun updateData(newList : MutableList<Todo>) {
        listOfTodos = newList
        notifyDataSetChanged()
    }

    fun addNewItem (todo: Todo) {
        listOfTodos.add(0,todo)
        notifyItemInserted(0)
    }
}

interface TodoStateChangedListener {
    fun onChangeStateChanged(position: Int)
}