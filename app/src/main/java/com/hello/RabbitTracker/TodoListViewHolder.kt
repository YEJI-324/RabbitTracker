package com.hello.RabbitTracker

import androidx.recyclerview.widget.RecyclerView
import com.hello.RabbitTracker.databinding.TodoListItemBinding

class TodoListViewHolder(private val binding: TodoListItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(item: Todo) {
        with(binding) {
            tvTodoListItem.text = item.todo
        }
    }
}