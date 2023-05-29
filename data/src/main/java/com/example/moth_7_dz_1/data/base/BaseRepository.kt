package com.example.moth_7_dz_1.data.base

import com.example.moth_7_dz_1.domain.utils.Resource
import kotlinx.coroutines.flow.flow
import java.lang.Exception

abstract class BaseRepository {

    protected fun <T> doRequest (request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        } catch (e: Exception) {
            emit(
                Resource.Error(e.localizedMessage?: "unknown error")
            )
        }
    }

}