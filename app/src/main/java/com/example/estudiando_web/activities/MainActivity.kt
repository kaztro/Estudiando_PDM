package com.example.estudiando_web.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.estudiando_web.R
import com.example.estudiando_web.adapters.PokemonsAdapter
import com.example.estudiando_web.database.viewmodels.PokeApiViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: PokemonsAdapter
    lateinit var viewModel: PokeApiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
    }

    private fun bind(){
        adapter = PokemonsAdapter(ArrayList())
        viewModel = ViewModelProviders.of(this).get(PokeApiViewModel::class.java)
        rv_repos.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        viewModel.getAll().observe(this, Observer {
            adapter.updateList(it)
        })

        btn_poke.setOnClickListener {
            viewModel.retrieveRepo(et_poke.text.toString())
        }
    }
}
