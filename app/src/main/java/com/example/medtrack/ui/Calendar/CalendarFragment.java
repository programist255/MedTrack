package com.example.medtrack.ui.Calendar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.medtrack.databinding.FragmentCalendarBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CalendarFragment extends Fragment {

    private FragmentCalendarBinding binding;
    private CalendarViewModel calendarViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CalendarViewModel calendarViewModel =
                new ViewModelProvider(this).get(CalendarViewModel.class);
        binding = FragmentCalendarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Оновлюємо список звітів, якщо він змінюється
        calendarViewModel.getReports().observe(getViewLifecycleOwner(), this::updateReportsList);

        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        // Створюємо список днів для GridView
        ArrayList<String> daysList = new ArrayList<>();

        // Встановлюємо календарь на перший день місяця
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // Отримуємо номер дня тижня першого дня місяця
        int startDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // Додаємо пусті елементи до списку перед першим днем місяця
        for (int i = 1; i < startDayOfWeek; i++) {
            daysList.add("");
        }

        // Отримуємо останній день місяця
        int lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Додаємо дні місяця до списку
        SimpleDateFormat dayFormat = new SimpleDateFormat("d", Locale.getDefault());
        for (int i = 1; i <= lastDayOfMonth; i++) {
            daysList.add(dayFormat.format(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

//        final TextView textView = binding.textCalendar;
//        calendarViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
    private void updateReportsList(List<NewReportActivity> reports) {

    }

        @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

