package fr.mappy.fizzbuzz.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.mappy.fizzbuzz.data.models.FormEntity
import fr.mappy.fizzbuzz.domain.statistics.StatisticsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(private val statisticsRepository: StatisticsRepository) :
    ViewModel() {

    private val resultList = MutableLiveData<List<FormEntity>>(listOf())
    val statisticsResultList: LiveData<List<FormEntity>> get() = resultList

    fun retreiveTop5FormsByHits() {
        viewModelScope.launch(Dispatchers.IO) {
            val topFiveFormsByHits = statisticsRepository.getTopFiveFormsByHits()
            resultList.postValue(topFiveFormsByHits)
        }
    }

    fun getTotalHits(list: List<FormEntity>) =
        list.map { formEntity -> formEntity.hits }.reduce { acc, hit -> acc + hit }


}