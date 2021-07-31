package kr.co.bepo.mvvmimagesearch.data

import kr.co.bepo.mvvmimagesearch.api.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor(
    private val unsplashApi: UnsplashApi
) {
}