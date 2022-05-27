package example.com.healthpetapp.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import example.com.healthpetapp.MyAppointment;
import example.com.healthpetapp.R;
import example.com.healthpetapp.entidades.Citas;

public class listaCitasAdapter extends RecyclerView.Adapter<listaCitasAdapter.CitasViewHolder> {

    ArrayList<Citas> listaCitas;

    public listaCitasAdapter(ArrayList<Citas> listaCitas){
        this.listaCitas = listaCitas;
    }

    @NonNull
    @Override
    public CitasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_citas,null, false);
        return new CitasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CitasViewHolder holder, int position) {
        holder.viewService.setText(listaCitas.get(position).getService());
        holder.viewRedmin.setText(listaCitas.get(position).getRemind());
        holder.viewFecha.setText(listaCitas.get(position).getFecha());
        holder.viewHora.setText(listaCitas.get(position).getHora());

    }

    @Override
    public int getItemCount() {
        return listaCitas.size();
    }

    public class CitasViewHolder extends RecyclerView.ViewHolder {
        TextView viewService, viewRedmin, viewFecha, viewHora, viewName, viewDesc;
        public CitasViewHolder(@NonNull View itemView) {
            super(itemView);

            viewName = itemView.findViewById(R.id.viewName);
            viewService = itemView.findViewById(R.id.viewService);
            viewDesc = itemView.findViewById(R.id.viewDesc);
            viewRedmin = itemView.findViewById(R.id.viewRedmin);
            viewFecha = itemView.findViewById(R.id.viewFecha);
            viewHora = itemView.findViewById(R.id.viewHora);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, MyAppointment.class);

                    intent.putExtra("ID", listaCitas.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
