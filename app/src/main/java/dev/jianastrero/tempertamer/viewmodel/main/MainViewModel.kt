package dev.jianastrero.tempertamer.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.jianastrero.tempertamer.data.service.level.LevelService
import dev.jianastrero.tempertamer.domain.entity.Level
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val levelService: LevelService
) : ViewModel() {

    private val _levels = MutableStateFlow(emptyList<Level>())
    val levels: StateFlow<List<Level>> = _levels.asStateFlow()

    fun fetchLevels() = viewModelScope.launch {
        _levels.emit(levelService.getLevels())
    }
}
