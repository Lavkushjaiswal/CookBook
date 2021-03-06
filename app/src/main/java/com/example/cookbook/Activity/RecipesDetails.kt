package com.example.cookbook.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookbook.R
import com.example.cookbook.adapter.ComentAdapter

class RecipesDetails : AppCompatActivity() {

    private lateinit var comment_recylerview:RecyclerView
    private lateinit var input_comment:EditText
    private lateinit var recipe_name: TextView
    private lateinit var commentAdapter: ComentAdapter

    val list: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes_d_etails)
        supportActionBar?.hide()
        val recipeName:String= intent.getStringExtra("recipeName").toString()

        comment_recylerview=findViewById(R.id.comment_recylerview)
        input_comment=findViewById(R.id.comment_input)
        recipe_name=findViewById(R.id.recipe_name)
        recipe_name.setText(recipeName)

        initRecylerview()


    }

    private fun initRecylerview() {
        comment_recylerview.apply {
            layoutManager=LinearLayoutManager(this@RecipesDetails)
            list.add("Testy")
            list.add("Osm")
            commentAdapter= ComentAdapter(list)
            adapter=commentAdapter
        }
    }

    fun onBack(view: View) {
    }

    fun addComment(view: View) {
        var input_comments: String = input_comment.text.toString().trim()
        list.add(input_comments)
        input_comment.text?.clear()

    }

}