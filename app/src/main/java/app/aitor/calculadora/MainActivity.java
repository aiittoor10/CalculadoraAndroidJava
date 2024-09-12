package app.aitor.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import app.aitor.calculadora.R;

public class MainActivity extends AppCompatActivity {

    private TextView tvNum1, tvNum2;
    private double num1 = 0, num2 = 0, resultado = 0;
    private String operacion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvNum2 = findViewById(R.id.tv_num2);

        // Botones numéricos
        Button btn0 = findViewById(R.id.btn_0);
        Button btn1 = findViewById(R.id.btn_1);
        Button btn2 = findViewById(R.id.btn_2);
        Button btn3 = findViewById(R.id.btn_3);
        Button btn4 = findViewById(R.id.btn_4);
        Button btn5 = findViewById(R.id.btn_5);
        Button btn6 = findViewById(R.id.btn_6);
        Button btn7 = findViewById(R.id.btn_7);
        Button btn8 = findViewById(R.id.btn_8);
        Button btn9 = findViewById(R.id.btn_9);
        Button btnPunto = findViewById(R.id.btn_punto);

        // Botones de operación
        Button btnSuma = findViewById(R.id.btn_suma);
        Button btnResta = findViewById(R.id.btn_resta);
        Button btnMulti = findViewById(R.id.btn_multi);
        Button btnDiv = findViewById(R.id.btn_div);
        Button btnIgual = findViewById(R.id.btn_igual);
        Button btnBorrar = findViewById(R.id.btn_borrar);

        // Escuchar los eventos de los botones numéricos
        View.OnClickListener listenerNumeros = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                String texto = button.getText().toString();
                tvNum2.setText(tvNum2.getText().toString() + texto);
            }
        };

        btn0.setOnClickListener(listenerNumeros);
        btn1.setOnClickListener(listenerNumeros);
        btn2.setOnClickListener(listenerNumeros);
        btn3.setOnClickListener(listenerNumeros);
        btn4.setOnClickListener(listenerNumeros);
        btn5.setOnClickListener(listenerNumeros);
        btn6.setOnClickListener(listenerNumeros);
        btn7.setOnClickListener(listenerNumeros);
        btn8.setOnClickListener(listenerNumeros);
        btn9.setOnClickListener(listenerNumeros);
        btnPunto.setOnClickListener(listenerNumeros);

        // Escuchar los eventos de las operaciones
        btnSuma.setOnClickListener(v -> {
            num1 = Double.parseDouble(tvNum2.getText().toString());
            operacion = "+";
            tvNum2.setText("");
        });

        btnResta.setOnClickListener(v -> {
            num1 = Double.parseDouble(tvNum2.getText().toString());
            operacion = "-";
            tvNum2.setText("");
        });

        btnMulti.setOnClickListener(v -> {
            num1 = Double.parseDouble(tvNum2.getText().toString());
            operacion = "*";
            tvNum2.setText("");
        });

        btnDiv.setOnClickListener(v -> {
            num1 = Double.parseDouble(tvNum2.getText().toString());
            operacion = "/";
            tvNum2.setText("");
        });

        // Botón igual para realizar la operación
        btnIgual.setOnClickListener(v -> {
            num2 = Double.parseDouble(tvNum2.getText().toString());
            switch (operacion) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        tvNum1.setText("Error");
                        return;
                    }
                    break;
            }
            tvNum2.setText(String.valueOf(resultado));
        });

        // Botón para borrar
        btnBorrar.setOnClickListener(v -> {
            tvNum2.setText("");
            tvNum1.setText("0.0");
            num1 = 0;
            num2 = 0;
            resultado = 0;
            operacion = "";
        });
    }
}
