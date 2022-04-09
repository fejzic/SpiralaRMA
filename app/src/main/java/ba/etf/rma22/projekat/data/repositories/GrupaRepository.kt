package ba.etf.rma22.projekat.data.repositories

import ba.etf.rma22.projekat.data.models.Grupa

class GrupaRepository {

    companion object {
        val grupa = listOf<Grupa>(
            Grupa("grupa1","Istrazivanje1"),
            Grupa("grupa2","Istrazivanje1"),
            Grupa("grupa1","Istrazivanje2"),
            Grupa("grupa2","Istrazivanje2"),
            Grupa("grupa3","Istrazivanje2"),
            Grupa("grupa4","Istrazivanje2"),
            Grupa("grupa1","Istrazivanje3"),
            Grupa("grupa2","Istrazivanje3"),
            Grupa("grupa1","Istrazivanje4"),
            Grupa("grupa2","Istrazivanje4"),
            Grupa("grupa1","Istrazivanje5"),
            Grupa("grupa2","Istrazivanje5"),
            Grupa("grupa1","Istrazivanje6"),
            Grupa("grupa2","Istrazivanje6"),
            Grupa("grupa1","Istrazivanje7"),
            Grupa("grupa2","Istrazivanje7")

        )

        fun getGroupsByIstrazivanjet(nazivIstrazivanja:String) : List<Grupa> {

            return grupa.filter { it.nazivIstrazivanja == nazivIstrazivanja }
        }
    }
}