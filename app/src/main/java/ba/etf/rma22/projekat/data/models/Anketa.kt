package ba.etf.rma22.projekat.data.models

import androidx.annotation.FloatRange
import java.util.*

data class Anketa(
    val naziv: String,
    val nazivIstrazivanja: String,
    val datumPocetak: Date,
    val datumKraj: Date,
    val datumRada: Date?,
    val trajanje: Int,
    val nazivGrupe: String,
    @FloatRange(from = 0.0, to = 1.0)
    val progres: Float
)
