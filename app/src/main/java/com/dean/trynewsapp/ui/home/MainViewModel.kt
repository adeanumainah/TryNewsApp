package com.dean.trynewsapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dean.trynewsapp.data.model.ResponseNews
import com.dean.trynewsapp.data.repository.NewsRepository
import com.dean.trynewsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    init {
        fetchNewsViewModel()
    }

    //2 variable, 1 transaksi didalam viewmodel, yg lainnya di dalam activity/fragment
    private val _newsData = MutableLiveData<Resource<ResponseNews>>()
    val newsData = _newsData


    //ngefetch data
    //ngejalanin coroutine flow nya di dalam viewmodelscope
    private fun fetchNewsViewModel() = viewModelScope.launch {
        _newsData.value = Resource.Loading

        repository.fetchNewsRepository().collect { news ->
            _newsData.value = news
        }
    }



}