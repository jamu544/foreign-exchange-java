package android.com.jamsand.io.foreignexchangerateapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentOne extends Fragment implements View.OnClickListener{

    private Button btnGotoFragment2;
    private EditText editTextAustralia;
    private EditText editTextEuros;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String AUSTRALIAN_DOLLAR = "australianDollar";
        private static final String EUROS = "euros";

    // TODO: Rename and change types of parameters
    private String australianDollar;
    private String euros;

    public FragmentOne() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentOne.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentOne newInstance(String param1, String param2) {
        FragmentOne fragment = new FragmentOne();
        Bundle args = new Bundle();
        args.putString(AUSTRALIAN_DOLLAR, param1);
        args.putString(EUROS, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            australianDollar = getArguments().getString(AUSTRALIAN_DOLLAR);
            euros = getArguments().getString(EUROS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);
        // Inflate the layout for this fragment
        editTextAustralia = view.findViewById(R.id.textViewAustralianDollar);
        editTextEuros = view.findViewById(R.id.textViewEuros);

        australianDollar = editTextAustralia.getText().toString();
        euros = editTextEuros.getText().toString();
        btnGotoFragment2 = view.findViewById(R.id.btnFxRate);
        btnGotoFragment2.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        final Bundle bundle = new Bundle();
        bundle.putString(AUSTRALIAN_DOLLAR, australianDollar);
        bundle.putString(EUROS, euros);
        Navigation.findNavController(view).navigate(R.id.action_fragmentOne_to_fragmentTwo,bundle);
    }
}