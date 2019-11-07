package id.ac.polinema.settingsexample.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import id.ac.polinema.settingsexample.Application;
import id.ac.polinema.settingsexample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdvancedFragment extends Fragment {

    // advanced keys
    public static final String PARENT_KEY = "parent";
    public static final String CHILD_KEY = "child";

    private SharedPreferences preferences;

    public AdvancedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = Application.getPreferences();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_advanced, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView parentText = view.findViewById(R.id.text_parent_preference);
        TextView childText = view.findViewById(R.id.text_child_preference);

        boolean parentValue = preferences.getBoolean(PARENT_KEY, false);
        boolean childValue = preferences.getBoolean(CHILD_KEY, false);

        parentText.setText((parentValue) ? "enable" : "disable");
        childText.setText((parentValue && childValue) ? "enable" : "disable");
    }
}
