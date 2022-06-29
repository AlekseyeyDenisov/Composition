package ru.dw.composition.domain.repository

import ru.dw.composition.domain.entity.GameSettings
import ru.dw.composition.domain.entity.Level
import ru.dw.composition.domain.entity.Question

interface GameRepository {
    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}