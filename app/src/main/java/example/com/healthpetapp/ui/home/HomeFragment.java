package example.com.healthpetapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import example.com.healthpetapp.AddContact;
import example.com.healthpetapp.LoginActivity;
import example.com.healthpetapp.MyAppointment;
import example.com.healthpetapp.R;
import example.com.healthpetapp.RegisterActivity;
import example.com.healthpetapp.VerCitas;
import example.com.healthpetapp.databinding.FragmentHomeBinding;
import example.com.healthpetapp.shedule_appointment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    TextView my_appointment;
    FloatingActionButton floating_add;
    Button Ver_citas;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        floating_add = (FloatingActionButton) root.findViewById(R.id.floatingActionButton);
        floating_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), shedule_appointment.class);
                startActivity(intent);
            }
        });


        Ver_citas = (Button) root.findViewById(R.id.btnVercitas);
        Ver_citas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), VerCitas.class);
                startActivity(intent);
            }
        });


       // final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
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