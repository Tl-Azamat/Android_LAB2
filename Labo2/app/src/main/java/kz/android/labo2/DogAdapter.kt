package kz.android.labo2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.android.labo2.databinding.DogBinding

class DogAdapter : ListAdapter<Dog, DogAdapter.DogViewHolder>(DogBreedDiffCallback()) {


    class DogBreedDiffCallback : DiffUtil.ItemCallback<Dog>() {
        override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem == newItem
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DogBinding.inflate(layoutInflater, parent, false)
        return DogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dogBreed = getItem(position)
        holder.bind(dogBreed)
    }

    class DogViewHolder(private val binding: DogBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(dogBreed: Dog) {
            with(binding) {
                tvDogName.text = dogBreed.name
                tvGoodWithChildren.text = "Good with Children: ${dogBreed.goodWithChildren}"
                tvGoodWithOtherDogs.text = "Good with Other Dogs: ${dogBreed.goodWithOtherDogs}"
                tvEnergy.text = "Energy: ${dogBreed.energy}"
                tvLifeExpectancy.text = "Life Expectancy: ${dogBreed.minLifeExpectancy}-${dogBreed.maxLifeExpectancy} years"

                Glide.with(ivDogImage.context)
                    .load(dogBreed.imageLink)
                    .into(ivDogImage)
            }
        }
    }
}