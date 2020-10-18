package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.shape.MarkerEdgeTreatment;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_datePicker; //Creación de boton para elegir DATE PICKER
    private Button btn_datePickerR; //Creacion de boton para elegir DATE RANGE PICKER
    private TextView tv_fecha; //Creacion de texto donde se mostrara la fecha seleccionada
    int hora, minutos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_datePicker = findViewById(R.id.btn_datepicker);
        btn_datePickerR = findViewById(R.id.btn_datepickerR);
        tv_fecha = findViewById(R.id.tv_date);

        btn_datePicker.setOnClickListener(this);
        btn_datePickerR.setOnClickListener(this);



        // Material Datepicker
        //MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();

        //builder.setTitleText("Selecciona una fecha");

        //final MaterialDatePicker materialDatePicker = builder.build();

            /*btn_datePicker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
                }
            });

            materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                @Override
                public void onPositiveButtonClick(Object selection) {
                    tv_fecha.setText(materialDatePicker.getHeaderText());
                }
            });*/

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_datepicker:
                MaterialDatePicker.Builder builder1 = MaterialDatePicker.Builder.datePicker();
                final MaterialDatePicker materialDatePicker = builder1.build();
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");

                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        tv_fecha.setText(materialDatePicker.getHeaderText());
                    }
                });
                break;
            case R.id.btn_datepickerR:
                MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.dateRangePicker();
                final MaterialDatePicker materialDatePicker1 = builder.build();
                MaterialDatePicker.Builder<Pair<Long, Long>> pairBuilder = MaterialDatePicker.Builder.dateRangePicker();
                materialDatePicker1.show(getSupportFragmentManager(), "DATE_RANGE_PICKER");

                materialDatePicker1.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        tv_fecha.setText(materialDatePicker1.getHeaderText());
                    }
                });
                break;
        }

    }
}
