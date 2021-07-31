package kr.co.bepo.mvvmimagesearch.api

import kr.co.bepo.mvvmimagesearch.data.UnsplashPhoto

data class UnsplashResponse(
    val results: List<UnsplashPhoto>
)