package ba.etf.rma22.projekat.data.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma22.projekat.R
import ba.etf.rma22.projekat.data.models.Anketa
import java.text.SimpleDateFormat
import java.util.*

class AnketaAdapter(private var ankete: List<Anketa>) :
    RecyclerView.Adapter<AnketaAdapter.AnketaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnketaViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.lista_anketa_item, parent, false)
        return AnketaViewHolder(view)
    }

    inner class AnketaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val anketaTitle: TextView = itemView.findViewById(R.id.anketaTitle)
        val anketaStatusImage: ImageView = itemView.findViewById(R.id.anketaStatus_image)
        val anketaIstrazivanjeText: TextView = itemView.findViewById(R.id.anketaIstrazivanje_text)
        val progresZavrsetka: ProgressBar = itemView.findViewById(R.id.progresZavrsetka)
        val anketaStatus: TextView = itemView.findViewById(R.id.anketaStatus)
        val anketaDatum: TextView = itemView.findViewById(R.id.anketaDatum)


    }

    @Suppress("DEPRECATION")
    override fun onBindViewHolder(holder: AnketaAdapter.AnketaViewHolder, position: Int) {
        holder.anketaTitle.text = ankete[position].naziv
        //Date now
        val dateNow = Date(122,4,1)
        if (ankete[position].datumPocetak.after(dateNow)){
            holder.anketaStatusImage.setImageDrawable(ResourcesCompat.getDrawable(holder.itemView.context.resources,R.drawable.zuta,null))
            holder.anketaStatus.text = "Vrijeme aktiviranja:"
            holder.anketaDatum.text = simplifyDate(ankete[position].datumPocetak)
        } else if(ankete[position].datumKraj.before(dateNow)){
            holder.anketaStatusImage.setImageDrawable(ResourcesCompat.getDrawable(holder.itemView.context.resources,R.drawable.crvena,null))
            holder.anketaStatus.text = "Anketa zatvorena:"
            holder.anketaDatum.text = simplifyDate(ankete[position].datumKraj)
        } else if(ankete[position].datumRada != null){
            holder.anketaStatusImage.setImageDrawable(ResourcesCompat.getDrawable(holder.itemView.context.resources,R.drawable.plava,null))
            holder.anketaStatus.text = "Anketa urađena:"
            holder.anketaDatum.text = simplifyDate(ankete[position].datumRada!!)
        } else if (ankete[position].datumPocetak.before(dateNow) && ankete[position].datumRada == null){
            holder.anketaStatusImage.setImageDrawable(ResourcesCompat.getDrawable(holder.itemView.context.resources,R.drawable.zelena,null))
            holder.anketaStatus.text = "Vrijeme zatvaranja:"
            holder.anketaDatum.text = simplifyDate(ankete[position].datumKraj)
        }
        holder.anketaIstrazivanjeText.text = ankete[position].nazivIstrazivanja
        holder.progresZavrsetka.progress = progressWholeNumber(ankete[position].progres)
    }

    override fun getItemCount(): Int {
        return ankete.size
    }

    private fun progressWholeNumber(progress : Float): Int {
        return when ((progress * 100).toInt()) {
            in 0..20 -> 20
            in 20..40 -> 40
            in 40..60 -> 60
            in 40..80 -> 80
            in 80..100 -> 100
            else -> 0
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun simplifyDate(date: Date): String {
        val format = SimpleDateFormat("dd.MM.yyyy.")
        return format.format(date)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAnketa(anketeNew: List<Anketa>) {
        this.ankete = anketeNew
        notifyDataSetChanged()
    }
}
