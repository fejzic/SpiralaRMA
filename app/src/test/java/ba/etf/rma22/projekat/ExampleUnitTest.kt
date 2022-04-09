package ba.etf.rma22.projekat

import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.Istrazivanje
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import ba.etf.rma22.projekat.data.repositories.GrupaRepository
import ba.etf.rma22.projekat.data.repositories.IstrazivanjeRepository
import junit.framework.Assert
import org.hamcrest.CoreMatchers
import org.hamcrest.Matchers
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    val ankete = listOf<Anketa>(
        // Naziv - Istraživanje - Datum početak - Datum kraj - Datum rada - Trajanje - Naziv Grupe - Progres
        Anketa("Anketa 1","Istrazivanje1",
            Date(122,1,30),
            Date(122,5,30),null,90,"RMA",0.33.toFloat()),
        Anketa("Anketa 2","Istrazivanje2",
            Date(122,2,20),
            Date(122,3,30),null,90,"RMA 1",0.0.toFloat()),
        Anketa("Anketa 1","Istrazivanje3",
            Date(122,1,30),
            Date(122,5,30), Date(122,2,30),90,"RMA 2",1.0.toFloat()),
        Anketa("Anketa 3","Istrazivanje4",
            Date(122,2,25),
            Date(122,5,30), Date(122,3,30),90,"RMA",0.33.toFloat()),
        Anketa("Anketa 2","Istrazivanje5",
            Date(122,1,20),
            Date(122,5,30),null,90,"RMA 1",0.53.toFloat()),
        Anketa("Anketa 4","Istrazivanje6",
            Date(122,2,30),
            Date(122,3,30),null,90,"RMA 2",0.33.toFloat()),
        Anketa("Anketa 1","Istrazivanje7",
            Date(122,4,20),
            Date(122,5,30),null,90,"RMA",0.23.toFloat())

    )


    @Test
    fun testGetAllAnkete() {
        val survey = AnketaRepository.getAll()
        assertEquals(survey.size,ankete.size)

    }
    @Test
    fun testGetMyAnkete() {
        val anketa = AnketaRepository.getMyAnkete()
        Assert.assertEquals(anketa.size, 0)
    }

    @Test
    fun testGetDoneAnkete() {
        val anketa = AnketaRepository.getDone()
        Assert.assertEquals(anketa.size, 2)

    }
    @Test
    fun testGetFutureAnketa() {
        val anketa = AnketaRepository.getFuture()
        Assert.assertEquals(anketa.size, 1)

    }
    @Test
    fun testGetNotTakenAnketa() {
        val anketa = AnketaRepository.getNotTaken()
        Assert.assertEquals(anketa.size, 2)

    }


    @Test
    fun testgetAllIstazivanja() {
        val istazivanja = IstrazivanjeRepository.getAll()
        Assert.assertEquals(istazivanja.size, 7)
        assertThat(istazivanja,
            Matchers.hasItem<Istrazivanje>(Matchers.hasProperty("naziv", CoreMatchers.`is`("Istrazivanje1")))
        )
        assertThat(istazivanja,
            Matchers.hasItem<Istrazivanje>(Matchers.hasProperty("naziv", CoreMatchers.`is`("Istrazivanje3")))
        )
        assertThat(istazivanja,
            Matchers.hasItem<Istrazivanje>(Matchers.hasProperty("naziv", CoreMatchers.`is`("Istrazivanje4")))
        )
        assertThat(istazivanja,
            Matchers.hasItem<Istrazivanje>(Matchers.hasProperty("naziv", CoreMatchers.`is`("Istrazivanje7")))
        )
    }

    @Test
    fun testgetIstrazivanjeByGodina() {
        val istrazivanje = IstrazivanjeRepository.getIstrazivanjeByGodina(4)
        Assert.assertEquals(istrazivanje.size, 2)
        assertThat(istrazivanje,
            Matchers.hasItem<Istrazivanje>(Matchers.hasProperty("naziv", CoreMatchers.`is`("Istrazivanje5")))
        )
        assertThat(istrazivanje,
            Matchers.hasItem<Istrazivanje>(Matchers.hasProperty("naziv", CoreMatchers.`is`("Istrazivanje6")))
        )

    }

    @Test
    fun testgetGroupsByIstrazivanje() {
        val grupe = GrupaRepository.getGroupsByIstrazivanjet("Istrazivanje1")
        Assert.assertEquals(grupe.size, 2)

    }

    @Test
    fun testgetAnketaByNazivIstrazivanja(){

        val anketa = AnketaRepository.getAnketaByNazivIstrazivanja("Istrazivanje1")
        Assert.assertEquals(anketa?.nazivIstrazivanja, "Istrazivanje1")
    }







}