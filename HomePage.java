package com.example.vaccinator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class HomePage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    //the Spinner widget is used to create drop-down menus
    private Spinner selectRegion;
    TextView place1, name1, quantity1, place2, name2, quantity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);



        selectRegion = (Spinner)findViewById(R.id.spinner);
        place1 = (TextView)findViewById(R.id.textPlace1);
        name1 = (TextView)findViewById(R.id.textName1);
        quantity1 = (TextView)findViewById(R.id.textQuantity1);
        place2 = (TextView)findViewById(R.id.textPlace2);
        name2 = (TextView)findViewById(R.id.textName2);
        quantity2 = (TextView)findViewById(R.id.textQuantity2);

        selectRegion.setOnItemSelectedListener(this); //this line is needed to execute some code when the user selects a certain field from the drop-down menu
        String[] regions = {"Bangalore", "Mumbai"};

        //the following lines actually invoke the function which is responsible for making the values appear in the drop-down menu
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, regions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectRegion.setAdapter(adapter);
        //so basically we need to create an array of values which we want to appear in the drop-down menu and then pass it into the ArrayAdapter() function

    }

    //the following function contains the code which is to be executed when the user selects any item from the drop-down menu
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId()==R.id.spinner){
            String spinnerValue = parent.getItemAtPosition(position).toString();
            if(spinnerValue=="Bangalore"){

                DocumentReference docref1 = db.collection("Bangalore").document("binNEN3N58F3gFEaXvKo");
                docref1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document != null) {
                                place1.setText(document.getString("Place"));
                                name1.setText(document.getString("Name"));
                                quantity1.setText(document.getString("Quantity"));
                            } else {
                                Log.d("LOGGER", "No such document");
                            }
                        } else {
                            Log.d("LOGGER", "get failed with ", task.getException());
                        }
                    }
                });

                DocumentReference docref2 = db.collection("Bangalore").document("LkLKP5MKx94goui28uDQ");
                docref2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document != null) {
                                place2.setText(document.getString("Place"));
                                name2.setText(document.getString("Name"));
                                quantity2.setText(document.getString("Quantity"));
                            } else {
                                Log.d("LOGGER", "No such document");
                            }
                        } else {
                            Log.d("LOGGER", "get failed with ", task.getException());
                        }
                    }
                });

            }

            else{

                DocumentReference docref1 = db.collection("Mumbai").document("QvsNEnTjUeH7pjcPstJd");
                docref1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document != null) {
                                place1.setText(document.getString("Place"));
                                name1.setText(document.getString("Name"));
                                quantity1.setText(document.getString("Quantity"));
                            } else {
                                Log.d("LOGGER", "No such document");
                            }
                        } else {
                            Log.d("LOGGER", "get failed with ", task.getException());
                        }
                    }
                });

                DocumentReference docref2 = db.collection("Mumbai").document("GyU6H4mwK0OvwN9EEwgL");
                docref2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document != null) {
                                place2.setText(document.getString("Place"));
                                name2.setText(document.getString("Name"));
                                quantity2.setText(document.getString("Quantity"));
                            } else {
                                Log.d("LOGGER", "No such document");
                            }
                        } else {
                            Log.d("LOGGER", "get failed with ", task.getException());
                        }
                    }
                });

            }
        }
    }

    //the following function contains the code which is to be executed when the user doesn't select any item from the drop-down menu
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}