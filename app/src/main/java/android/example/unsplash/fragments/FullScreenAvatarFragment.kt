package android.example.unsplash.fragments

import android.example.unsplash.R
import android.example.unsplash.databinding.FragmentFullAvatarImageBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

class FullScreenAvatarFragment : Fragment(R.layout.fragment_full_avatar_image) {

    private var _binding: FragmentFullAvatarImageBinding? = null
    private val binding get() = _binding!!
    val args: FullScreenAvatarFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFullAvatarImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val photo = args.photo
        Glide.with(requireContext())
            .load(photo)
            .dontAnimate()
            .into(binding.ivRaw)
    }
}