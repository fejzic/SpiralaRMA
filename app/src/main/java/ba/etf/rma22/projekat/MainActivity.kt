package ba.etf.rma22.projekat

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma22.projekat.data.adapter.AnketaAdapter
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var anketaAdapter: AnketaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val korisnikData = ArrayList<String>()

        //Actual logic
        val listaAnketa = this.findViewById<RecyclerView>(R.id.listaAnketa)
        val filterAnketa = this.findViewById<Spinner>(R.id.filterAnketa)
        val upisDugme = this.findViewById<FloatingActionButton>(R.id.upisDugme)


        listaAnketa.layoutManager = GridLayoutManager(this, 2)
        anketaAdapter = AnketaAdapter(AnketaRepository.getAll())
        listaAnketa.adapter = anketaAdapter
        filterAnketa.onItemSelectedListener = this
        filterAnketa.setSelection(1)

        upisDugme.setOnClickListener {
            val extra = Bundle()
            extra.putSerializable("data", korisnikData)

            val intent = Intent(this, UpisIstrazivanje::class.java)
            intent.putExtra("extra", extra)
            startActivity(intent)
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        // Array lista iz strings.xml
        // 0 - Sve moje ankete
        // 1 - Sve ankete
        // 2 - Urđene ankete
        // 3 - Buduće ankete
        // 4 - Prošle ankete
        when (p2) {
            0 -> {
                anketaAdapter.updateAnketa(AnketaRepository.getMyAnkete())
            }
            1 -> {
                anketaAdapter.updateAnketa(AnketaRepository.getAll())
            }
            2 ->{
                anketaAdapter.updateAnketa(AnketaRepository.getDone())
            }
            3 ->{
                anketaAdapter.updateAnketa(AnketaRepository.getFuture())
            }
            4 ->{
                anketaAdapter.updateAnketa(AnketaRepository.getNotTaken())
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        //Boze moj
    }
}