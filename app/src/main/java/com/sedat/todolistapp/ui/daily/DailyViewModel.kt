package com.sedat.todolistapp.ui.daily

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sedat.todolistapp.data.repository.ToDoRepository
import com.sedat.todolistapp.model.Title
import com.sedat.todolistapp.utils.Resource
import com.sedat.todolistapp.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DailyViewModel @Inject constructor(
    private val repository: ToDoRepository
) : ViewModel() {

    init {
        getDailyTitleList()
    }

    fun insertTitle(title: String): LiveData<Long?>{
        val data = MutableLiveData<Long?>()
        viewModelScope.launch {
            val newTitle = Title(
                0,
                title,
                1
            )
            when(val response =  repository.insertTitle(newTitle)){
                is Resource.Loading ->{
                    data.value = -10
                }
                is Resource.Error ->{
                    data.value = -20
                }
                is Resource.Success ->{
                    data.value = response.data
                }
            }
        }
        return data
    }

    private val _titleList = MutableLiveData(TitleState(true, listOf(), ""))
    val titleList: LiveData<TitleState> get() = _titleList

    private fun getDailyTitleList() = viewModelScope.launch{

        delay(2000)

        try {
            val response = repository.getTitles(1)
            response.collect{ list ->
                _titleList.value = TitleState(false, list, null)
            }
        }catch (e: Exception){
            _titleList.value = TitleState(null, null, e.message)
        }
    }
}

data class TitleState(
    val loading: Boolean ?= null,
    val titleResponse: List<Title> ?= null,
    val error: String ?= null
)