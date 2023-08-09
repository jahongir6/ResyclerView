package com.example.resyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.resyclerview.RvAdapter.UserAdapter
import com.example.resyclerview.databinding.ActivityMainBinding
import com.example.resyclerview.model.User

class MainActivity : AppCompatActivity(),UserAdapter.RvClick {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
     var list = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter(rvClick = this, list = list)
        binding.btnBos.setOnClickListener {
            binding.rv.adapter = userAdapter
            var user = User(
                binding.edtName.text.toString(),
                binding.edtNumber.text.toString().toInt()
            )
            list.add(user)
            userAdapter.notifyDataSetChanged()
        }
    }

    override fun onClick(user: User) {
        Toast.makeText(this, "salim", Toast.LENGTH_SHORT).show()
    }

}