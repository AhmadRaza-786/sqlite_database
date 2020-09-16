package com.example.sqlitedatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase databaseBank = openOrCreateDatabase("app", MODE_PRIVATE, null);

            databaseBank.execSQL("CREATE TABLE IF NOT EXISTS people (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age INT(3) ) ");

            //databaseBank.execSQL("DROP TABLE people ");



         // databaseBank.execSQL("INSERT INTO people(name, age) VALUES('Maria', 30)");
          // databaseBank.execSQL("INSERT INTO people(name, age) VALUES('Anderi', 40)");

         //   databaseBank.execSQL("UPDATE people SET age = 19, name = 'Maria' WHERE id = 3 ");

            databaseBank.execSQL("DELETE FROM people ");

            //String query = "SELECT name, age  " + "FROM people WHERE name = 'Ahmad' AND age = 23 ";

            //String query = "SELECT name, age  " + "FROM people WHERE age >= 23 OR age = 18 ";

           // String query = "SELECT name, age  " + "FROM people WHERE name IN('Raza', 'Ahmad') ";

            //String query = "SELECT name, age FROM people " + " WHERE age  BETWEEN 22 AND 23 ";

           // String query = "SELECT name, age FROM people " + " WHERE name  LIKE 'Ahmad' ";

            String query = "SELECT * FROM people " + " WHERE 1=1  ";

          Cursor cursor = databaseBank.rawQuery(query, null);

          int indexName = cursor.getColumnIndex("name");
          int indexAge = cursor.getColumnIndex("age");
          int indexId = cursor.getColumnIndex("id");


          cursor.moveToFirst();
          while (cursor != null) {

              String name = cursor.getString(indexName);
              String age = cursor.getString(indexAge);
              String id = cursor.getString(indexId);

              Log.i("Result - id ", id + " / name " + name + " / age: " + age);

              cursor.moveToNext();
          }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}