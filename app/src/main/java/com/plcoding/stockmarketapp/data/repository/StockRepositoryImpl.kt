package com.plcoding.stockmarketapp.data.repository

import com.plcoding.stockmarketapp.data.local.StockDatabase
import com.plcoding.stockmarketapp.data.remote.StockApi
import com.plcoding.stockmarketapp.domain.model.CompanyListing
import com.plcoding.stockmarketapp.domain.repository.StockRepository
import com.plcoding.stockmarketapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    private val api: StockApi,
    private val db: StockDatabase
) : StockRepository {

        private val dao = db.dao
        override suspend fun getCompanyListings(
            fetchFromRemote: Boolean,
            query: String
        ): Flow<Resource<List<CompanyListing>>> {
            return flow {
                emit(Resource.Loading(true))
                val localListings = dao.searchCompanyListings(query)
                emit(Resource.Success(
                    data = localListings.map { it.toCompanyListing() }
                ))

                val isDbEmpty = localListings.isEmpty() &&
            }
        }
}