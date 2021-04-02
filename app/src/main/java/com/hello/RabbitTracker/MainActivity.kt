package com.hello.RabbitTracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.hello.RabbitTracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var backPressedTime: Long = 0
    private val testList: ArrayList<Todo> = arrayListOf(
        Todo("흠냐흠냐"),
        Todo("흠냐뤼"),
        Todo("과연 될까~~~~")
    )

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val todoListAdapter = TodoListAdapter(testList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        binding.rvTodoList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = todoListAdapter
        }

        binding.addTodolistBtn.setOnClickListener {
            val todoListString = binding.editAddTodoList.text.toString()
            if (todoListString.isEmpty()) {
                Toast.makeText(applicationContext, "주라 주라 입력해주라", Toast.LENGTH_SHORT).show()
            } else {
                testList.add(Todo(todoListString))
                todoListAdapter.notifyDataSetChanged()
                binding.tvNum.text = "지금 리스트는 ${todoListAdapter.itemCount} 개"
                Toast.makeText(applicationContext, "'$todoListString' 이/가 추가되었다!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvNum.text = "지금 리스트는 ${todoListAdapter.itemCount} 개"
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - backPressedTime >= 2000) {
            backPressedTime = System.currentTimeMillis()
            Toast.makeText(applicationContext, "한 번 더 누르면 종료", Toast.LENGTH_SHORT).show()
        }
        else {
            finish()
        }
    }
}