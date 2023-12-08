package com.example.adi_mobiledev_morning_a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adi_mobiledev_morning_a.databinding.FragmentRetrofitBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Retrofit : Fragment() {
    private var _binding: FragmentRetrofitBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRetrofitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adi = view.findViewById<RecyclerView>(R.id.rv_character)

        ApiConfig.getService().getAdi().enqueue(object : Callback<ResponseAdi> {
            override fun onResponse(call: Call<ResponseAdi>, response: Response<ResponseAdi>) {
                if (response.isSuccessful) {
                    val responseAdi = response.body()
                    val dataAdi = responseAdi?.results
                    val AdiAdapter = AdiAdapter(dataAdi as List<ResultsItem>)
                    adi.apply {
                        layoutManager = LinearLayoutManager(binding.root.context)
                        adapter = AdiAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseAdi>, t: Throwable) {
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
