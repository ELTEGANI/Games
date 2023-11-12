package com.example.games.data.repository

import coil.size.Dimension
import com.example.games.core.common.Resource
import com.example.games.data.FreeGamesApi
import com.example.games.data.remote.mapper.toDomainFreeGames
import com.example.games.domain.model.FreeGames
import com.example.games.domain.repositry.FreeGameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FreeGamesRepositoryImp @Inject constructor(private val freeGamesApi: FreeGamesApi):FreeGameRepository {
    override fun getFreeGames(): Flow<Resource<List<FreeGames>>> = flow{
       emit(Resource.Loading())
        try{
          val result = freeGamesApi.getFreeGame().map {
              it.toDomainFreeGames()
          }
          emit(Resource.Success(result))
        }catch (ex:Exception){
           emit(Resource.Error(ex.message.toString()))
        }
    }.flowOn(Dispatchers.IO).catch {
        emit(Resource.Error(it.message.toString()))
    }
}