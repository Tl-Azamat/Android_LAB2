package kz.android.labo2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kz.android.labo2.databinding.FragmentDogBinding
import kz.android.labo2.network.RetrofitObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DogFragment:Fragment() {


    private var _binding: FragmentDogBinding? = null
    private val binding get() = _binding!!
    private val adapter = DogAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(requireContext())


        binding.searchBtn.setOnClickListener {
            searchDogs(binding.searchEt.text.toString())
        }


    }
    private fun searchDogs(dogName: String) {
        RetrofitObject.apiService.getDogs(dogName).enqueue(object : Callback<List<Dog>> {
            override fun onResponse(call: Call<List<Dog>>, response: Response<List<Dog>>) {
                if (response.isSuccessful) {
                    adapter.submitList(response.body())
                }
                else{
                    Log.e("Response", response.errorBody().toString())
                }
            }
            override fun onFailure(call: Call<List<Dog>>, t: Throwable) {
                Log.e("Network", t.message.toString())
            }

        })
    }
}