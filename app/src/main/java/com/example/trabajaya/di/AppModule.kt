package com.example.trabajaya.di

import android.content.Context
import androidx.room.Room
import com.example.trabajaya.data.local.Database
import com.example.trabajaya.data.remote.EmpleoApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    @Singleton
    @Provides
    fun providesEmpleoApi(moshi: Moshi): EmpleoApi {
        return Retrofit.Builder().baseUrl("http://miempleoapiap.somee.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
            .create(EmpleoApi::class.java)
    }

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext appContext: Context): Database = Room.databaseBuilder(
        appContext, Database::class.java, "Database.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun providesEmpleoLocal(db: Database) = db.EmpleoDao()
}