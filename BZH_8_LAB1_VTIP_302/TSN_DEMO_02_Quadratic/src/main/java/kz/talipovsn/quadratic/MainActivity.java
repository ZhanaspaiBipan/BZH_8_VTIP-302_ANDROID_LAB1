package kz.talipovsn.quadratic;

import android.annotation.SuppressLint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText_a, editText_b, editText_x;
    private TextView textView_y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_a = findViewById(R.id.editText_a);
        editText_b = findViewById(R.id.editText_b);
        editText_x = findViewById(R.id.editText_x);
        textView_y = findViewById(R.id.textView_y);


    }



    // МЕТОД ДЛЯ КНОПКИ РАСЧЕТА
    @SuppressLint("DefaultLocale")
    public void onCalc(View v) {

        double a, b, x, y;

        try {
            // Считывание введенных входных значений в переменные
            a = Double.parseDouble(editText_a.getText().toString());
            b = Double.parseDouble(editText_b.getText().toString());
            x = Double.parseDouble(editText_x.getText().toString());
        } catch (Exception e) {
            // Выдача всплывающего сообщения на экран об ошибке
            Toast.makeText(MainActivity.this, "Неверные данные!",
                    Toast.LENGTH_LONG).show();
            return;
        }

        // Расчет значений x1 и x2

        if (x <= 9) {
            y = Math.pow((a+b),2) / Math.pow(x,2);
        } else {
            y = x * (Math.pow(a,2) + Math.pow(b,2));
        }
        if (!Double.isNaN(y) && !Double.isInfinite(y)) {
            textView_y.setText(String.format("y = %.2f", y));
        } else {
            String err = "Обнаружена ошибка!";
            textView_y.setText(err);
        }

    }

}
