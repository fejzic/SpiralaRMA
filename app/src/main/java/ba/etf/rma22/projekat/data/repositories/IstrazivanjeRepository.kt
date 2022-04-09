package ba.etf.rma22.projekat.data.repositories

import ba.etf.rma22.projekat.data.models.Grupa
import ba.etf.rma22.projekat.data.models.Istrazivanje

class IstrazivanjeRepository {
    companion object {
        val istrazivanje = listOf<Istrazivanje>(
            Istrazivanje("Istrazivanje1", 1),
            Istrazivanje("Istrazivanje2", 1),
            Istrazivanje("Istrazivanje3", 2),
            Istrazivanje("Istrazivanje4", 3),
            Istrazivanje("Istrazivanje5", 4),
            Istrazivanje("Istrazivanje6", 4),
            Istrazivanje("Istrazivanje7", 5),
        )

        fun getIstrazivanjeByGodina(godina:Int) : List<Istrazivanje> {
            // TODO: Implementirati
            return istrazivanje.filter { it.godina == godina}
        }
         fun getAll() : List<Istrazivanje>{
             // TODO: Implementirati
             return istrazivanje;
         }
        fun getUpisani() : List<Istrazivanje> {
            // TODO: Implementirati
            return emptyList()
        }
    }
}