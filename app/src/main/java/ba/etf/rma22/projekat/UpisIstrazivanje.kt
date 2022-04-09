package ba.etf.rma22.projekat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import ba.etf.rma22.projekat.data.repositories.GrupaRepository
import ba.etf.rma22.projekat.data.repositories.IstrazivanjeRepository

class UpisIstrazivanje : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var odabirIstrazivanje: Spinner
    private lateinit var odabirGrupa: Spinner
    private lateinit var odabirGodina: Spinner
    private lateinit var dodajButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upis_istrazivanje)

        odabirIstrazivanje = this.findViewById(R.id.odabirIstrazivanja)
        val temp = this
        odabirGodina = this.findViewById(R.id.odabirGodina)
        odabirGrupa = this.findViewById(R.id.odabirGrupa)
        dodajButton = this.findViewById(R.id.dodajIstrazivanjeDugme)
        odabirGodina.onItemSelectedListener = this
        odabirIstrazivanje.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //Do nothing
            }


            override fun onItemSelected(adapt: AdapterView<*>, view: View, i: Int, l: Long) {

                Log.d("UpisiIstrazivanje", "Naziv izbranog polja = ${odabirIstrazivanje.selectedItem}")
                val grupaTemp =
                    GrupaRepository.getGroupsByIstrazivanjet(odabirIstrazivanje.selectedItem.toString())
                val grupaNaziv = mutableListOf<String>()

                grupaTemp.forEachIndexed { index, grupa ->
                    grupaNaziv.add(grupa.naziv)
                }

                val spinnerAdapterGrupa = ArrayAdapter(
                    temp,
                    android.R.layout.simple_spinner_item,
                    grupaNaziv
                )
                spinnerAdapterGrupa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                odabirGrupa.adapter = spinnerAdapterGrupa

            }
        }




        dodajButton.isEnabled = false

        dodajButton.setOnClickListener {
            val getAnketaByName =
                AnketaRepository.getAnketaByNazivIstrazivanja(odabirIstrazivanje.selectedItem.toString())
            if (getAnketaByName != null) {
                AnketaRepository.dodjeliIstrazivanje(getAnketaByName)
                Toast.makeText(this, "Uspjesno ste dodani na istrazivanje!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(
                    this,
                    "Desio se problem pri dodjelivanju ankete!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when (p2) {
            0 -> {
                val istrazivanjeTemp = IstrazivanjeRepository.getIstrazivanjeByGodina(1)

                val istrazivanjeNaziv = mutableListOf<String>()
                istrazivanjeTemp.forEachIndexed { _, istrazivanje ->
                    val anketaTemp =
                        AnketaRepository.getAnketaByNazivIstrazivanja(istrazivanje.naziv)
                    if (!AnketaRepository.dodanaIstrazivanja.contains(anketaTemp)) {
                        istrazivanjeNaziv.add(istrazivanje.naziv)
                    }
                }

                val grupaNaziv = mutableListOf<String>()
                Log.d("UpisIstraivanje","Size of istrazivanjeNaziv = ${istrazivanjeNaziv.size}")
                if (istrazivanjeNaziv.size > 0) {
                    val grupaTemp = GrupaRepository.getGroupsByIstrazivanjet(istrazivanjeNaziv[0])
                    grupaTemp.forEachIndexed { _, grupa ->
                        grupaNaziv.add(grupa.naziv)
                    }
                    dodajButton.isEnabled = true
                }else{
                    dodajButton.isEnabled = false
                }

                val spinnerAdapter =
                    ArrayAdapter(this, android.R.layout.simple_spinner_item, istrazivanjeNaziv)
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                odabirIstrazivanje.adapter = spinnerAdapter
                val spinnerAdapterGrupa = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item,
                    grupaNaziv
                )
                spinnerAdapterGrupa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                odabirGrupa.adapter = spinnerAdapterGrupa
            }
            1 -> {
                val istrazivanjeTemp = IstrazivanjeRepository.getIstrazivanjeByGodina(2)

                val istrazivanjeNaziv = mutableListOf<String>()
                istrazivanjeTemp.forEachIndexed { _, istrazivanje ->
                    val anketaTemp =
                        AnketaRepository.getAnketaByNazivIstrazivanja(istrazivanje.naziv)
                    if (!AnketaRepository.dodanaIstrazivanja.contains(anketaTemp)) {
                        istrazivanjeNaziv.add(istrazivanje.naziv)
                    }
                }

                val grupaNaziv = mutableListOf<String>()
                Log.d("UpisIstraivanje","Size of istrazivanjeNaziv = ${istrazivanjeNaziv.size}")
                if (istrazivanjeNaziv.size > 0) {
                    val grupaTemp = GrupaRepository.getGroupsByIstrazivanjet(istrazivanjeNaziv[0])
                    grupaTemp.forEachIndexed { _, grupa ->
                        grupaNaziv.add(grupa.naziv)
                    }
                    dodajButton.isEnabled = true
                }else{
                    dodajButton.isEnabled = false
                }

                val spinnerAdapter =
                    ArrayAdapter(this, android.R.layout.simple_spinner_item, istrazivanjeNaziv)
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                odabirIstrazivanje.adapter = spinnerAdapter
                val spinnerAdapterGrupa = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item,
                    grupaNaziv
                )
                spinnerAdapterGrupa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                odabirGrupa.adapter = spinnerAdapterGrupa
            }
            2 -> {
                val istrazivanjeTemp = IstrazivanjeRepository.getIstrazivanjeByGodina(3)

                val istrazivanjeNaziv = mutableListOf<String>()
                istrazivanjeTemp.forEachIndexed { _, istrazivanje ->
                    val anketaTemp =
                        AnketaRepository.getAnketaByNazivIstrazivanja(istrazivanje.naziv)
                    if (!AnketaRepository.dodanaIstrazivanja.contains(anketaTemp)) {
                        istrazivanjeNaziv.add(istrazivanje.naziv)
                    }
                }

                val grupaNaziv = mutableListOf<String>()
                Log.d("UpisIstraivanje","Size of istrazivanjeNaziv = ${istrazivanjeNaziv.size}")
                if (istrazivanjeNaziv.size > 0) {
                    val grupaTemp = GrupaRepository.getGroupsByIstrazivanjet(istrazivanjeNaziv[0])
                    grupaTemp.forEachIndexed { _, grupa ->
                        grupaNaziv.add(grupa.naziv)
                    }
                    dodajButton.isEnabled = true
                }else{
                    dodajButton.isEnabled = false
                }

                val spinnerAdapter =
                    ArrayAdapter(this, android.R.layout.simple_spinner_item, istrazivanjeNaziv)
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                odabirIstrazivanje.adapter = spinnerAdapter
                val spinnerAdapterGrupa = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item,
                    grupaNaziv
                )
                spinnerAdapterGrupa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                odabirGrupa.adapter = spinnerAdapterGrupa
            }
            3 -> {
                val istrazivanjeTemp = IstrazivanjeRepository.getIstrazivanjeByGodina(4)

                val istrazivanjeNaziv = mutableListOf<String>()
                istrazivanjeTemp.forEachIndexed { _, istrazivanje ->
                    val anketaTemp =
                        AnketaRepository.getAnketaByNazivIstrazivanja(istrazivanje.naziv)
                    if (!AnketaRepository.dodanaIstrazivanja.contains(anketaTemp)) {
                        istrazivanjeNaziv.add(istrazivanje.naziv)
                    }
                }

                val grupaNaziv = mutableListOf<String>()
                Log.d("UpisIstraivanje","Size of istrazivanjeNaziv = ${istrazivanjeNaziv.size}")
                if (istrazivanjeNaziv.size > 0) {
                    val grupaTemp = GrupaRepository.getGroupsByIstrazivanjet(istrazivanjeNaziv[0])
                    grupaTemp.forEachIndexed { _, grupa ->
                        grupaNaziv.add(grupa.naziv)
                    }
                    dodajButton.isEnabled = true
                }else{
                    dodajButton.isEnabled = false
                }

                val spinnerAdapter =
                    ArrayAdapter(this, android.R.layout.simple_spinner_item, istrazivanjeNaziv)
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                odabirIstrazivanje.adapter = spinnerAdapter
                val spinnerAdapterGrupa = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item,
                    grupaNaziv
                )
                spinnerAdapterGrupa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                odabirGrupa.adapter = spinnerAdapterGrupa
            }
            4 -> {
                val istrazivanjeTemp = IstrazivanjeRepository.getIstrazivanjeByGodina(5)

                val istrazivanjeNaziv = mutableListOf<String>()
                istrazivanjeTemp.forEachIndexed { _, istrazivanje ->
                    val anketaTemp =
                        AnketaRepository.getAnketaByNazivIstrazivanja(istrazivanje.naziv)
                    if (!AnketaRepository.dodanaIstrazivanja.contains(anketaTemp)) {
                        istrazivanjeNaziv.add(istrazivanje.naziv)
                    }
                }

                val grupaNaziv = mutableListOf<String>()
                Log.d("UpisIstraivanje","Size of istrazivanjeNaziv = ${istrazivanjeNaziv.size}")
                if (istrazivanjeNaziv.size > 0) {
                    val grupaTemp = GrupaRepository.getGroupsByIstrazivanjet(istrazivanjeNaziv[0])
                    grupaTemp.forEachIndexed { _, grupa ->
                        grupaNaziv.add(grupa.naziv)
                    }
                    dodajButton.isEnabled = true
                }else{
                    dodajButton.isEnabled = false
                }

                val spinnerAdapter =
                    ArrayAdapter(this, android.R.layout.simple_spinner_item, istrazivanjeNaziv)
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                odabirIstrazivanje.adapter = spinnerAdapter
                val spinnerAdapterGrupa = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item,
                    grupaNaziv
                )
                spinnerAdapterGrupa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                odabirGrupa.adapter = spinnerAdapterGrupa
            }
        }
    }


    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}


