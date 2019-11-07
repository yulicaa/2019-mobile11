package id.ac.polinema.settingsexample.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.ac.polinema.settingsexample.Application;
import id.ac.polinema.settingsexample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WidgetsFragment extends Fragment {

    // widgets keys
    public static final String CHECKBOX_KEY = "checkbox";
    public static final String SWITCH_KEY = "switch";
    public static final String DROPDOWN_KEY = "dropdown";
    public static final String SEEKBAR_KEY = "seekbar";

    private SharedPreferences preferences;

    public WidgetsFragment() {
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
        return inflater.inflate(R.layout.fragment_widgets, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView checkboxText = view.findViewById(R.id.text_checkbox_preference);
        TextView switchText = view.findViewById(R.id.text_switch_preference);
        TextView dropdownText = view.findViewById(R.id.text_dropdown_preference);
        TextView seekbarText = view.findViewById(R.id.text_seekbar_preference);

        boolean checkboxValue = preferences.getBoolean(CHECKBOX_KEY, false);
        boolean switchValue = preferences.getBoolean(SWITCH_KEY, false);
        String dropdownValue = preferences.getString(DROPDOWN_KEY, null);
        int seekbarValue = preferences.getInt(SEEKBAR_KEY, 0);

        checkboxText.setText((checkboxValue) ? "enable" : "disable");
        switchText.setText((switchValue) ? "enable" : "disable");
        dropdownText.setText(dropdownValue);
        seekbarText.setText(String.valueOf(seekbarValue));
    }
}
