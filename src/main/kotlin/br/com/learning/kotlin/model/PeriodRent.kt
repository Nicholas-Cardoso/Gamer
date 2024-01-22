package br.com.learning.kotlin.model

import java.time.LocalDate
import java.time.Period

data class PeriodRent(
    val startDate: LocalDate,
    val endDate: LocalDate
) {
    val inDays = Period.between(startDate, endDate).days
}
