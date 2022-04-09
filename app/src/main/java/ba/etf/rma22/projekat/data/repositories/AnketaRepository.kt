package ba.etf.rma22.projekat.data.repositories

import android.app.Application
import android.util.Log
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.AnketaData
import java.util.*

@Suppress("DEPRECATION")
internal class AnketaRepository : Application() {

    companion object {
        //Date now,best practice for testing hardcoded data
        private val dateNow = Date(122,4,1)
        val dodanaIstrazivanja = mutableListOf<Anketa>()

        fun dodjeliIstrazivanje(anketa: Anketa){
            dodanaIstrazivanja.add(anketa)
        }

        fun getAnketaByNazivIstrazivanja(naziv: String): Anketa?{
//            Log.d("AnketaRepository","Dobio sam anketu sa nazivom: $naziv")
            val sveAnkete = getAll()
            var tempAnketa: Anketa? = null
            sveAnkete.forEachIndexed { _, anketa ->
                if (anketa.nazivIstrazivanja == naziv){
                    tempAnketa = anketa
//                    Log.d("AnketaRepository", "Anketa pronađena - $anketa")
                }
            }
            return tempAnketa
        }

        fun getMyAnkete(): List<Anketa> {
            return dodanaIstrazivanja
        }

        fun getAll(): List<Anketa> {
            return AnketaData().listaAnketa().sortedBy { it.datumPocetak }
        }

        fun getDone(): List<Anketa> {
            return AnketaData().listaAnketa().filter { it.datumRada != null && it.datumPocetak.before(dateNow) }
        }

        fun getFuture(): List<Anketa> {
            return AnketaData().listaAnketa().filter { it.datumPocetak.after(dateNow) }
        }

        fun getNotTaken(): List<Anketa> {
            return AnketaData().listaAnketa().filter { it.datumKraj.before(dateNow) }
        }
    }
}