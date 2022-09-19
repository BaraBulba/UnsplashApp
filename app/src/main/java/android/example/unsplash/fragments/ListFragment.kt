package android.example.unsplash.fragments

import android.example.unsplash.R
import android.example.unsplash.adapter.UnsplashAdapter
import android.example.unsplash.databinding.FragmentListBinding
import android.example.unsplash.models.UnsplashResponseItem
import android.example.unsplash.repository.PhotosRepository
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

class ListFragment: Fragment(R.layout.fragment_list) {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var vm: ListViewModel
    private val myAdapter by lazy { UnsplashAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        val repository = PhotosRepository()
        val viewModelFactory = ListViewModelFactory(repository = repository)
        vm = ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)
        vm.getPhotos()
        vm.myPhotos.observe(viewLifecycleOwner, Observer{ response ->
            if (response.isSuccessful){
                    response.body()?.let {
                        myAdapter.setData(it as List<UnsplashResponseItem>)
                    }
            }
        })
    }

    private fun setupRecyclerView(){
        binding.rvItems.layoutManager = LinearLayoutManager(context)
        binding.rvItems.adapter = myAdapter
        myAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("photo", it.regular)
            }
            findNavController().navigate(R.id.action_listFragment_to_fullScreenAvatarFragment, bundle)
        }
    }
}