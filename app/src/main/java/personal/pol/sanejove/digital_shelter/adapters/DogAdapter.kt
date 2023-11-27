package personal.pol.sanejove.scrollable_list_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import okhttp3.Callback
import personal.pol.sanejove.digital_shelter.R
import personal.pol.sanejove.digital_shelter.model.Dog

class DogAdapter(

    private val dataset: List<Dog>
) : RecyclerView.Adapter<DogAdapter.DogViewHolder>() {


    class DogViewHolder(private val view : View) : RecyclerView.ViewHolder(view){
        val ageTextView : TextView = view.findViewById(R.id.dog_age)
        val nameTextView : TextView = view.findViewById(R.id.dog_name)
        val imageView : ImageView = view.findViewById(R.id.dog_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.dog_item, parent, false)
        return DogViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val item = dataset[position]
        holder.nameTextView.text = item.name
        holder.ageTextView.text = item.age.toString()
        holder.imageView.setImageResource(R.drawable.generic_dog_image)

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}