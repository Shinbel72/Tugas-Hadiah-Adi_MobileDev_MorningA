package com.example.adi_mobiledev_morning_a

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adi_mobiledev_morning_a.Data.DataAdapter
import com.example.adi_mobiledev_morning_a.Data.DataDatabaseHelper
import com.example.adi_mobiledev_morning_a.databinding.FragmentHomeBinding



class home : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var db: DataDatabaseHelper
    private lateinit var dataAdapter: DataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        db = DataDatabaseHelper(requireContext())
        dataAdapter = DataAdapter(db.getAllData(), requireContext())

        binding.dataRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.dataRecycleView.adapter = dataAdapter

        binding.addButton.setOnClickListener {
            val intent = Intent(requireContext(), add_data::class.java)
            startActivity(intent)
        }

        binding.dataHeading.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        dataAdapter.refreshData(db.getAllData())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}