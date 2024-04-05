package dev.jianastrero.tempertamer.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.jianastrero.tempertamer.domain.entity.Level
import dev.jianastrero.tempertamer.data.repository.level.ILevelRepository
import javax.inject.Inject
import javax.inject.Named
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    @Named("level_api") private val levelRepository: ILevelRepository
) : ViewModel() {

    private val _levels = MutableStateFlow(emptyList<Level>())
    val levels: StateFlow<List<Level>> = _levels.asStateFlow()

    fun fetchLevels() = viewModelScope.launch {
        levelRepository.getLevels()
    }
}
