package com.example.medtrack.ui.Calendar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medtrack.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NewReportActivity extends AppCompatActivity {
        private EditText titleEditText, dateEditText, opisEditText;
        private Button saveButton;
        private String defaultDate;

    public NewReportActivity(String toString, String date, String toString1) {

    }
    public NewReportActivity() {
        // пустий конструктор
    }

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_new_report);

            // Отримання дати за замовчуванням з попередньої сторінки
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                defaultDate = extras.getString("selectedDate");
            }

            // Знаходження елементів у макеті
//            titleEditText = findViewById(R.id.title_edit_text);
//            dateEditText = findViewById(R.id.date_edit_text);
//            opisEditText = findViewById(R.id.opis_edit_text);
//            saveButton = findViewById(R.id.save_button);

            // Задання дати за замовчуванням
            dateEditText.setText(defaultDate);

            // Обробник натискання на кнопку "Зберегти"
            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Отримання введених користувачем даних
                    String title = titleEditText.getText().toString();
                    String date = dateEditText.getText().toString();
                    String opis = opisEditText.getText().toString();

                    // Перевірка на заповненість полів
                    if (TextUtils.isEmpty(title)) {
                        titleEditText.setError("Поле заголовку не може бути порожнім");
                        return;
                    }

                    if (TextUtils.isEmpty(opis)) {
                        opisEditText.setError("Поле опису не може бути порожнім");
                        return;
                    }

                    // Збереження даних у базу даних або файл
                    saveReportToDatabase(title, date, opis);

                    // Повернення до попередньої сторінки
                    finish();
                }
            });
//
//            // отримуємо дані з інтенту
            Intent intent = getIntent();
            String date = intent.getStringExtra("selectedDate");
            String defaultDate = intent.getStringExtra("defaultDate");
//
//// створюємо об'єкт Report з отриманими даними
            NewReportActivity report = new NewReportActivity(titleEditText.getText().toString(), date, opisEditText.getText().toString());
//
//// отримуємо список звітів з файлу
            List<NewReportActivity> reportList = loadReportsFromFile();
//
//// додаємо новий звіт до списку
            reportList.add(report);
//
//// зберігаємо оновлений список звітів у файлі
            saveReportsToFile(reportList);
//
//// перехід до списку звітів
            Intent listIntent = new Intent(NewReportActivity.this, CalendarViewModel.class);
            listIntent.putExtra("selectedDate", date);
            listIntent.putExtra("defaultDate", defaultDate);
            startActivity(listIntent);
//
//
        }

    private List<NewReportActivity> loadReportsFromFile() {
        List<NewReportActivity> reportList = new ArrayList<>();

        try {
            FileInputStream inputStream = openFileInput("reports.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, "UTF-8");

            Gson gson = new Gson();
            Type listType = new TypeToken<List<NewReportActivity>>() {
            }.getType();
            reportList = gson.fromJson(json, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return reportList;
    }
//
    private void saveReportsToFile(List<NewReportActivity> reportList) {
        try {
            FileOutputStream outputStream = openFileOutput("reports.json", Context.MODE_PRIVATE);
            Gson gson = new Gson();
            String json = gson.toJson(reportList);
            outputStream.write(json.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        // Метод для збереження звіту у базу даних або файл
        private void saveReportToDatabase(String title, String date, String opis) {
            // Реалізація збереження даних у базу даних або файл
        }

    public int getDateInMillis() {
        return 0;
    }

}



