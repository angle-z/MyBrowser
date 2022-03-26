package com.example.mybrowserapplication.ui.collections;

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

import com.example.mybrowserapplication.databinding.FragmentCollectionsBinding;

public class CollectionsFragment extends Fragment {

    private CollectionsViewModel collectionsViewModel;
    private @NonNull FragmentCollectionsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        collectionsViewModel =
                new ViewModelProvider(this).get(CollectionsViewModel.class);

        binding = FragmentCollectionsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCollections;
        collectionsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
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