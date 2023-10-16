package com.example.app5_2023_24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner sp1;
    private EditText n1, n2;
    private TextView result;
    private Button clean_btn;
    private Button exit_btn;
    private Button calculate_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = findViewById(R.id.sp1);
        String[] opcions = {"suma", "resta", "multiplicacio", "divisio", "elevar", "mod"};

        ArrayAdapter<String> adaptar = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcions);
        sp1.setAdapter(adaptar);

        n1 = (EditText) findViewById(R.id.n1);
        n2 = (EditText) findViewById(R.id.n1);
        result = (TextView) findViewById(R.id.result);

        clean_btn = (Button) findViewById(R.id.clean_btn);
        exit_btn = (Button) findViewById(R.id.exit_btn);
        calculate_btn = (Button) findViewById(R.id.calculate_btn);
    }

    public void calcular(View view) { // agafa nomes els valors de n1

        String valor1 = n1.getText().toString();
        String valor2 = n2.getText().toString();

        String seleccio = sp1.getSelectedItem().toString();

        if (seleccio.equalsIgnoreCase("suma")) {
            try {
                long n1 = Long.parseLong(valor1);
                long n2 = Long.parseLong(valor2);

                long suma = n1 + n2;

                String resultat_suma = String.valueOf(suma);
                result.setText(resultat_suma);

            } catch (
                    NumberFormatException e) { // Per si fiques caracters no valids, en aquest cas deixar en blanc
                result.setText("Ingresa numeros valids");
            }
        } else if (seleccio.equalsIgnoreCase("resta")) {
            try {
                long n1 = Long.parseLong(valor1);
                long n2 = Long.parseLong(valor2);

                long resta = n1 - n2;

                String resultat_resta = String.valueOf(resta);
                result.setText(resultat_resta);

            } catch (
                    NumberFormatException e) { // Per si fiques caracters no valids, en aquest cas deixar en blanc
                result.setText("Ingresa numeros valids");
            }
        } else if (seleccio.equalsIgnoreCase("multiplicacio")) {
            try {
                long n1 = Long.parseLong(valor1);
                long n2 = Long.parseLong(valor2);

                long multi = n1 * n2;

                String resultat_multi = String.valueOf(multi);
                result.setText(resultat_multi);

            } catch (
                    NumberFormatException e) { // Per si fiques caracters no valids, en aquest cas deixar en blanc
                result.setText("Ingresa numeros valids");
            }
        } else if (seleccio.equalsIgnoreCase("divisio")) {
            try {
                long n1 = Long.parseLong(valor1);
                long n2 = Long.parseLong(valor2);

                long div = n1 / n2;

                String resultat_div = String.valueOf(div);
                result.setText(resultat_div);

            } catch (
                    NumberFormatException e) { // Per si fiques caracters no valids, en aquest cas deixar en blanc
                result.setText("Ingresa numeros valids");
            }
        } else if (seleccio.equalsIgnoreCase("elevar")) {
            try {
                long n1 = Long.parseLong(valor1);
                long n2 = Long.parseLong(valor2);

                for (int i = 0; i < n2; i++) {
                    n1 *= n1;
                }

                long elevar = n1;

                String resultat_elevar = String.valueOf(elevar);
                result.setText(resultat_elevar);

            } catch (
                    NumberFormatException e) { // Per si fiques caracters no valids, en aquest cas deixar en blanc
                result.setText("Ingresa numeros valids");
            }
        } else if (seleccio.equalsIgnoreCase("mod")) {
            try {
                long n1 = Long.parseLong(valor1);
                long n2 = Long.parseLong(valor2);

                long mod = n1 % n2;

                String resultat_mod = String.valueOf(mod);
                result.setText(resultat_mod);

            } catch (
                    NumberFormatException e) { // Per si fiques caracters no valids, en aquest cas deixar en blanc
                result.setText("Ingresa numeros valids");
            }
        }
    }

    public void clean(View view) {

        n1.setText(""); //neteje el texte de l edittext
        n2.setText("");
        result.setText("");

        clean_btn.setPressed(false); //desactive el boto per a que no es quedi presionat
    }

    public void exit(View view) {
        finish();
        System.exit(0);
        // https://stackoverflow.com/questions/6014028/closing-application-with-exit-button
    }

}