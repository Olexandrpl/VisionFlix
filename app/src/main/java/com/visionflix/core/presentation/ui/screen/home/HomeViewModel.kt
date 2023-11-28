package com.visionflix.core.presentation.ui.screen.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.visionflix.common.Resources
import com.visionflix.core.domain.use_case.HomeUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.Locale

class HomeViewModel(
    private val homeUseCase: HomeUseCase
) : ViewModel() {
    private val _trendingMoviesState: MutableState<MoviesState> = mutableStateOf(MoviesState())
    val trendingMoviesState: State<MoviesState> = _trendingMoviesState

    private val _popularMoviesState: MutableState<MoviesState> = mutableStateOf(MoviesState())
    val popularMoviesState: State<MoviesState> = _popularMoviesState

    private val _upcomingMoviesState: MutableState<MoviesState> = mutableStateOf(MoviesState())
    val upcomingMoviesState: State<MoviesState> = _upcomingMoviesState

    private val _trendingTvState: MutableState<TvState> = mutableStateOf(TvState())
    val trendingTvState: State<TvState> = _trendingTvState

    init {
        getPopularMovies(
            Locale.getDefault().toLanguageTag(),
            1
        )
        getUpcomingMovies(
            Locale.getDefault().toLanguageTag(),
            1
        )
        getTrendingMovies(
            "day",
            Locale.getDefault().toLanguageTag()
        )
        getTrendingTv(
            "day",
            Locale.getDefault().toLanguageTag()
        )
    }

    private fun getUpcomingMovies(language: String, page: Int) {
        homeUseCase.getUpcomingMovies(language, page).onEach { resources ->
            when (resources) {
                is Resources.Success -> {
                    resources.data?.let {
                        _upcomingMoviesState.value = MoviesState(
                            it.movies,
                            it.page,
                            it.totalPages
                        )
                    }
                }

                is Resources.Loading -> {
                    _upcomingMoviesState.value = MoviesState(
                        loading = true
                    )
                }

                is Resources.Error -> {
                    _upcomingMoviesState.value = MoviesState(
                        error = resources.message ?: ""
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getPopularMovies(language: String, page: Int) {
        homeUseCase.getPopularMovies(language, page).onEach { resources ->
            when (resources) {
                is Resources.Success -> {
                    resources.data?.let {
                        _popularMoviesState.value = MoviesState(
                            it.movies,
                            it.page,
                            it.totalPages
                        )
                    }
                }

                is Resources.Loading -> {
                    _popularMoviesState.value = MoviesState(
                        loading = true
                    )
                }

                is Resources.Error -> {
                    _popularMoviesState.value = MoviesState(
                        error = resources.message ?: ""
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getTrendingMovies(timeZone: String, language: String) {
        homeUseCase.getTrendingMovies(timeZone, language).onEach { resources ->
            when (resources) {
                is Resources.Success -> {
                    resources.data?.let {
                        _trendingMoviesState.value = MoviesState(
                            movies = it.movies,
                            page = it.page,
                            totalPages = it.totalPages
                        )
                    }
                }

                is Resources.Loading -> {
                    _trendingMoviesState.value = MoviesState(
                        loading = true
                    )
                }

                is Resources.Error -> {
                    _trendingMoviesState.value = MoviesState(
                        error = resources.message ?: ""
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getTrendingTv(timeZone: String, language: String) {
        homeUseCase.getTrendingTv(timeZone, language).onEach { resources ->
            when (resources) {
                is Resources.Success -> {
                    resources.data?.let {
                        _trendingTvState.value = TvState(
                            tvs = it.tvs,
                            page = it.page,
                            totalPages = it.totalPages
                        )
                    }
                }

                is Resources.Loading -> {
                    _trendingTvState.value = TvState(
                        loading = true
                    )
                }

                is Resources.Error -> {
                    _trendingTvState.value = TvState(
                        error = resources.message ?: ""
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}