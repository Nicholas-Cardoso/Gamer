import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.formatterDateOfBirth (): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val dateOfBirth = LocalDate.parse(this, formatter)
    val today = LocalDate.now()

    val period = Period.between(dateOfBirth, today)

    return period.years
}