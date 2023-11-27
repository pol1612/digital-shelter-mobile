package personal.pol.sanejove.scrollable_list_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import personal.pol.sanejove.digital_shelter.R
import personal.pol.sanejove.digital_shelter.model.Dog

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Dog>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(private val view : View) : RecyclerView.ViewHolder(view){
        val ageTextView : TextView = view.findViewById(R.id.dog_age)
        val nameTextView : TextView = view.findViewById(R.id.dog_name)
        val imageView : ImageView = view.findViewById(R.id.dog_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.dog_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.nameTextView.text = item.name
        holder.ageTextView.text = item.age.toString()
        holder.imageView.setImageResource(R.drawable.generic_dog_image)

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}