package ru.mirea.khokhlov.myapplication.presentation;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ru.mirea.khokhlov.domain.models.Star;
import ru.mirea.khokhlov.myapplication.R;

public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder> {

    private List<Star> stars;

    public StarAdapter(List<Star> stars) {
        this.stars = stars;
    }

    public void updateStars(List<Star> newStars) {
        this.stars = newStars;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_star, parent, false);
        return new StarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarViewHolder holder, int position) {
        Star star = stars.get(position);
        holder.nameTextView.setText(star.getName());
        Picasso.get()
                .load(star.getPhotoUrl())
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.error_image)
                .resize(1200, 800)
                .into(holder.starImage);

        // Обработчик нажатия
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), StarDetailsActivity.class);
            intent.putExtra("STAR_ID", star.getId());
            v.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return stars == null ? 0 : stars.size();
    }

    static class StarViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        ImageView starImage;

        public StarViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.starName);
            //descriptionTextView = itemView.findViewById(R.id.starDescription);
            starImage = itemView.findViewById(R.id.starImage);
        }
    }
}
