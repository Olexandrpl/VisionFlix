package com.visionflix.di

import com.visionflix.core.data.remote.MovieApi
import com.visionflix.core.data.remote.TvApi
import com.visionflix.core.data.repostirory.MovieRemoteRepositoryImpl
import com.visionflix.core.data.repostirory.TvRemoteRepositoryImpl
import com.visionflix.core.domain.use_case.HomeUseCase
import com.visionflix.core.presentation.viewmodel.HomeScreenViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    viewModel {
        HomeScreenViewModel(get())
    }
}

val useCaseModule = module {
    single {
        HomeUseCase(get(), get())
    }
}

val repositoryModule = module {
    single {
        MovieRemoteRepositoryImpl(get())
    }
    single {
        TvRemoteRepositoryImpl(get())
    }
}

val apiModule = module {
    single {
        get<Retrofit>().create(
            MovieApi::class.java
        )
    }
    single {
        get<Retrofit>().create(
            TvApi::class.java
        )
    }
}

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(get<String>())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(get())
            .build()
    }
    single {
        OkHttpClient.Builder().addInterceptor(get<HttpLoggingInterceptor>()).build()
    }
    single {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    single {
        "https://api.themoviedb.org"
    }
}