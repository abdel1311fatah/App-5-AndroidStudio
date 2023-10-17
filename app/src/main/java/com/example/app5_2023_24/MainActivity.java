// Abel Ibarra

package com.example.app5_2023_24;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner sp1;
    private EditText n1, n2;
    private TextView result;
    private Button clean_btn;
    private Button exit_btn;
    private Button calculate_btn;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioButton rb5;
    private RadioButton rb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = findViewById(R.id.sp1);
        String[] opcions = {"suma", "resta", "multiplicacio", "divisio", "elevar", "mod"};

        ArrayAdapter<String> adaptar = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcions);
        sp1.setAdapter(adaptar);

        n1 = (EditText) findViewById(R.id.n1);
        n2 = (EditText) findViewById(R.id.n2);
        result = (TextView) findViewById(R.id.result);

        clean_btn = (Button) findViewById(R.id.clean_btn);
        exit_btn = (Button) findViewById(R.id.exit_btn);
        calculate_btn = (Button) findViewById(R.id.calculate_btn);

        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        rb5 = (RadioButton) findViewById(R.id.rb5);
        rb6 = (RadioButton) findViewById(R.id.rb6);
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
                long resultat = 1;

                for (int i = 0; i < n2; i++) {
                    resultat *= n1;
                }

                String resultat_elevar = String.valueOf(resultat);
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

    public void fontSize(View view) {
        if (rb1.isChecked()) {
            result.setTextSize(20);
        } else if (rb2.isChecked()) {
            result.setTextSize(24);
        } else if (rb3.isChecked()) {
            result.setTextSize(34);
        }
    }

    public void font(View view) {
        // https://stackoverflow.com/questions/20142852/set-custom-fonts-in-strings
        //Creem la carpeta de assets, dins de la de assets la de fonts, aixo dins del src del main, li fiquem els arxius .ttf del tipus de lletra que volguem ficar,
        //llavors creem un objecte de tipus Typeface del tipus de lletra que volem, llavors amb el setTypeface li fiquem el Typeface del tipus de lletra que volem
        try {
            if (rb4.isChecked()) {
                Typeface arialFont = Typeface.createFromAsset(getAssets(), "fonts/Arial.ttf");
                result.setTypeface(arialFont);
            } else if (rb5.isChecked()) {
                Typeface latoFont = Typeface.createFromAsset(getAssets(), "fonts/Lato.ttf");
                result.setTypeface(latoFont);
            } else if (rb6.isChecked()) {
                Typeface calibriFont = Typeface.createFromAsset(getAssets(), "fonts/calibri.ttf");
                result.setTypeface(calibriFont);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
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