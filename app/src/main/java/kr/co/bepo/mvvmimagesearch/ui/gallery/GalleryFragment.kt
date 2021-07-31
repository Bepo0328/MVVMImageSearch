package kr.co.bepo.mvvmimagesearch.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.co.bepo.mvvmimagesearch.databinding.FragmentGalleryBinding

@AndroidEntryPoint
class GalleryFragment : Fragment() {

    private val viewModel: GalleryViewModel by viewModels()

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    private val adapter = UnsplashPhotoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentGalleryBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        observeData()
    }

    private fun initViews() = with(binding) {
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    private fun observeData() = viewModel.photos.observe(viewLifecycleOwner) {
        adapter.submitData(viewLifecycleOwner.lifecycle, it)
    }
}