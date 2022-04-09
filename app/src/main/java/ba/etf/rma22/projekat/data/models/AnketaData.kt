package ba.etf.rma22.projekat.data.models

import java.io.Serializable
import java.util.*

class AnketaData : Serializable{
    @Suppress("DEPRECATION")
    fun listaAnketa(): List<Anketa> {
        val cal = Calendar.getInstance()
        return listOf(
            // Naziv - Istraživanje - Datum početak - Datum kraj - Datum rada - Trajanje - Naziv Grupe - Progres
            Anketa("Anketa 1","Istrazivanje1",
                Date(122,1,30),
                Date(122,5,30),null,90,"RMA",0.33.toFloat()),
            Anketa("Anketa 2","Istrazivanje2",
                Date(122,2,20),
                Date(122,3,30),null,90,"RMA 1",0.0.toFloat()),
            Anketa("Anketa 1","Istrazivanje3",
                Date(122,1,30),
                Date(122,5,30),Date(122,2,30),90,"RMA 2",1.0.toFloat()),
            Anketa("Anketa 3","Istrazivanje4",
                Date(122,2,25),
                Date(122,5,30),Date(122,3,30),90,"RMA",0.33.toFloat()),
            Anketa("Anketa 2","Istrazivanje5",
                Date(122,1,20),
                Date(122,5,30),null,90,"RMA 1",0.53.toFloat()),
            Anketa("Anketa 4","Istrazivanje6",
                Date(122,2,30),
                Date(122,3,30),null,90,"RMA 2",0.33.toFloat()),
            Anketa("Anketa 1","Istrazivanje7",
                Date(122,4,20),
                Date(122,5,30),null,90,"RMA",0.23.toFloat()),
        )
    }
}