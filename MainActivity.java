package com.example.expensetracker;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class MainActivity extends AppCompatActivity {
 private EditText etDescription, etAmount;
 private Button btnAdd;
 private TableLayout tableLayout;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
12
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 // Initialize UI elements
 etDescription = findViewById(R.id.et_description);
 etAmount = findViewById(R.id.et_amount);
 btnAdd = findViewById(R.id.btn_add);
 tableLayout = findViewById(R.id.table_layout);
 // Add Table Header Row
 addTableHeader();
 // Add Expense Button Click Listener
 btnAdd.setOnClickListener(v -> {
 String description = etDescription.getText().toString().trim();
 String amount = etAmount.getText().toString().trim();
 if (description.isEmpty() || amount.isEmpty()) {
 Toast.makeText(MainActivity.this, "Please enter all details", Toast.LENGTH_SHORT).show();
 return;
 }
 // Get current date
 String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
 // Add expense to table
 addTableRow(description, amount, currentDate);
 // Clear input fields
 etDescription.setText("");
 etAmount.setText("");
 });
 }
 // Method to add table header
 private void addTableHeader() {
 TableRow headerRow = new TableRow(this);
 String[] headers = {"Description", "Amount (₹)", "Date", "Delete"};
 for (String header : headers) {
 TextView tvHeader = new TextView(this);
 tvHeader.setText(header);
 tvHeader.setPadding(16, 8, 16, 8);
 tvHeader.setTextSize(16);
 tvHeader.setGravity(Gravity.CENTER);
 tvHeader.setTextColor(Color.BLACK);
13
 tvHeader.setBackgroundColor(Color.LTGRAY);
 headerRow.addView(tvHeader);
 }
 tableLayout.addView(headerRow);
 }
 // Method to add a new row
 private void addTableRow(String description, String amount, String date) {
 TableRow row = new TableRow(this);
 // Create TextViews for data
 TextView tvDescription = createTextView(description);
 TextView tvAmount = createTextView("₹" + amount); // Updated to Rupees (₹)
 TextView tvDate = createTextView(date);
 // Create Delete Button
 Button btnDelete = new Button(this);
 btnDelete.setText("Delete");
 btnDelete.setBackgroundColor(Color.RED);
 btnDelete.setTextColor(Color.WHITE);
 btnDelete.setPadding(16, 8, 16, 8);
 // Set Delete Functionality
 btnDelete.setOnClickListener(v -> tableLayout.removeView(row));
 // Add views to the row
 row.addView(tvDescription);
 row.addView(tvAmount);
 row.addView(tvDate);
 row.addView(btnDelete);
 // Add row to the table
 tableLayout.addView(row);
 }
 // Helper method to create TextViews for table
 private TextView createTextView(String text) {
 TextView textView = new TextView(this);
 textView.setText(text);
 textView.setPadding(16, 8, 16, 8);
 textView.setTextSize(16);
 textView.setGravity(Gravity.CENTER);
 return textView;
 }
}
