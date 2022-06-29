package ru.dw.composition.domain.usecases

import ru.dw.composition.domain.entity.GameSettings
import ru.dw.composition.domain.entity.Level
import ru.dw.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}