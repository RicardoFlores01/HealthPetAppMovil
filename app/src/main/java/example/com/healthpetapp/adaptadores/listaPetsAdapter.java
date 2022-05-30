package example.com.healthpetapp.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import example.com.healthpetapp.R;
import example.com.healthpetapp.entidades.Contactos;
import example.com.healthpetapp.entidades.Pets;

public class listaPetsAdapter extends RecyclerView.Adapter<listaPetsAdapter.PetViewHolder> {

    ArrayList<Pets> listaMascotas;

    public listaPetsAdapter(ArrayList<Pets> listaMascotas){
        this.listaMascotas = listaMascotas;
    }
    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_pets,null, false);
        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolder holder, int position) {
        holder.viewNamePet.setText(listaMascotas.get(position).getNamePet());
        holder.viewAge.setText(listaMascotas.get(position).getAge());
        holder.viewRace.setText(listaMascotas.get(position).getRace());

    }

    @Override
    public int getItemCount() {
        return listaMascotas.size();

    }

    public class PetViewHolder extends RecyclerView.ViewHolder {
       TextView viewNamePet, viewAge, viewRace;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNamePet = itemView.findViewById(R.id.viewNamePet);
            viewAge = itemView.findViewById(R.id.viewAge);
            viewRace = itemView.findViewById(R.id.viewRace);
        }
    }
}
