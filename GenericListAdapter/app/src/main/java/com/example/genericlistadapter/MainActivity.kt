package com.example.genericlistadapter

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.genericlistadapter.adapter.GenericListAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerViewText = findViewById<RecyclerView>(R.id.recyclerText)
        val recyclerViewImage = findViewById<RecyclerView>(R.id.recyclerImage)

        recyclerViewText.adapter = object : GenericListAdapter<String>(
            R.layout.adapter_item_text,
            bind = { item, holder, itemCount ->
                with(holder.itemView) {
                    this.findViewById<TextView>(R.id.textView).text =
                        "index: ${holder.adapterPosition} $item - itemCount: $itemCount "
                }

            }
        ) {}.apply {
            submitList(
                ("Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                        "when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                        "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                        "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
                        "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. " +
                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                        "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                        "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
                        "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.").split(
                    "."
                )
            )
        }

        recyclerViewImage.adapter = object : GenericListAdapter<Int>(
            R.layout.adapter_item_image,
            bind = { item, holder, _ ->
                with(holder.itemView) {
                    this.findViewById<ImageView>(R.id.imageView).setImageResource(item)
                }

            }
        ) {}.apply {
            submitList(
                listOf(
                    R.drawable.ic_bike,
                    R.drawable.ic_car,
                    R.drawable.ic_bike,
                    R.drawable.ic_car,
                    R.drawable.ic_bike,
                    R.drawable.ic_car,
                    R.drawable.ic_bike,
                    R.drawable.ic_car,
                    R.drawable.ic_bike,
                    R.drawable.ic_car
                )
            )
        }

    }

}