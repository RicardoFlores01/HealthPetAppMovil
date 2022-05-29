package example.com.healthpetapp.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import example.com.healthpetapp.AddContact;
import example.com.healthpetapp.MyAppointment;
import example.com.healthpetapp.MyContact;
import example.com.healthpetapp.R;
import example.com.healthpetapp.adaptadores.listaContactosAdapter;
import example.com.healthpetapp.databinding.FragmentGalleryBinding;
import example.com.healthpetapp.db.DbContactos;
import example.com.healthpetapp.entidades.Contactos;
import example.com.healthpetapp.shedule_appointment;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    TextView contact;
    FloatingActionButton floating_add;
    RecyclerView listaContactos;

    ArrayList<Contactos> listasArrayContactos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        floating_add = (FloatingActionButton) root.findViewById(R.id.floatingActionButton);
        floating_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), AddContact.class);
                startActivity(intent);
            }
        });

       // final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            //    textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}