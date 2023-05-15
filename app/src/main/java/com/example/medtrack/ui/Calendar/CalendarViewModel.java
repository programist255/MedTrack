package com.example.medtrack.ui.Calendar;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

//public class CalendarViewModel extends ViewModel {
//    private final MutableLiveData<String> mText;
//
//    public CalendarViewModel() {
//        mText = new MutableLiveData<>();
//        mText.setValue("This is home fragment");
//    }
//
//    public LiveData<String> getText() {
//        return mText;
//    }
//}

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class CalendarViewModel extends ViewModel {

    private final MutableLiveData<List<NewReportActivity>> reports;

    public CalendarViewModel() {
        reports = new MutableLiveData<>();
        reports.setValue(new ArrayList<>());
    }

    public MutableLiveData<List<NewReportActivity>> getReports() {
        return reports;
    }

    public void addReport(NewReportActivity report) {
        List<NewReportActivity> reportList = reports.getValue();
        assert reportList != null;
        reportList.add(report);
        reports.setValue(reportList);
    }
//
    public List<NewReportActivity> getReportsByDate(long dateInMillis) {
        List<NewReportActivity> reportList = reports.getValue();
        List<NewReportActivity> reportsByDate = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dateInMillis);
        int selectedDay = calendar.get(Calendar.DAY_OF_MONTH);
        int selectedMonth = calendar.get(Calendar.MONTH);
        int selectedYear = calendar.get(Calendar.YEAR);

        assert reportList != null;
        for (NewReportActivity report : reportList) {
            calendar.setTimeInMillis(report.getDateInMillis());
            int reportDay = calendar.get(Calendar.DAY_OF_MONTH);
            int reportMonth = calendar.get(Calendar.MONTH);
            int reportYear = calendar.get(Calendar.YEAR);

            if (selectedDay == reportDay && selectedMonth == reportMonth && selectedYear == reportYear) {
                reportsByDate.add(report);
            }
        }
        return reportsByDate;
    }
}


