package com.plcoding.stockmarketapp.presentation.company_listing

import com.plcoding.stockmarketapp.domain.model.CompanyListing

data class CompanyListingsState (
    val isLoading: Boolean = false,
    val companies: List<CompanyListing> = emptyList(),
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)