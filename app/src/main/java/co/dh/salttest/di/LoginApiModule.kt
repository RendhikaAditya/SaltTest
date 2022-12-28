package co.dh.salttest.di

import co.dh.salttest.data.api.ApiConstans
import co.dh.salttest.data.api.LoginApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginApiModule {
    @Provides
    @Singleton
    fun profideApi(builder: Builder): LoginApi {
        return builder.build().create(LoginApi::class.java)
    }

    @Provides
    @Singleton
    fun profideRetrofit(): Retrofit.Builder{
        return Retrofit.Builder().baseUrl(ApiConstans.BASE_URL).addConverterFactory(
            MoshiConverterFactory.create())
    }
}