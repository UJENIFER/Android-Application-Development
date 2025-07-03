package com.example.expensetracker;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
public class ExpenseAdapter extends ArrayAdapter<String> {
 private Context context;
 private ArrayList<String> expenses;
 public ExpenseAdapter(Context context, ArrayList<String> expenses) {
 super(context, R.layout.expense_item, expenses);
 this.context = context;
 this.expenses = expenses;
 }
 @NonNull
 @Override
 public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
 if (convertView == null) {
 convertView = LayoutInflater.from(context).inflate(R.layout.expense_item, parent, false);return convertView;
 }
}
