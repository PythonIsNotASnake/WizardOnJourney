package de.pinas.wizardonjourney;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Explode;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import de.pinas.wizardonjourney.character.Character;

public class MainActivity extends AppCompatActivity {

    private final int LOAD_TIME = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String textFromFile = "";

        File testFile = new File(this.getExternalFilesDir(null), "TestFile.txt");
        if (testFile != null) {
            StringBuilder stringBuilder = new StringBuilder();
            // Reads the data from the file
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(testFile));
                String line;

                while ((line = reader.readLine()) != null) {
                    textFromFile += line.toString();
                    textFromFile += "\n";
                }
                reader.close();

                Toast toast = Toast.makeText(this, textFromFile,
                        Toast.LENGTH_SHORT);
                toast.show();

                JSONObject jsonObject = new JSONObject(textFromFile);

                Globals.getInstance().setRowCharacter(jsonObject.getInt("rowCharacter"));
                Globals.getInstance().setColumnCharacter(jsonObject.getInt("columnCharacter"));

                Character character = new Character(jsonObject.getJSONObject("character").getInt("gold"), jsonObject.getJSONObject("character").getInt("health"), jsonObject.getJSONObject("character").getInt("level"), jsonObject.getJSONObject("character").getInt("experience"));
                Globals.getInstance().setCharacter(character);

                //Globals.getInstance().setCharacter(jsonObject.getJSONObject("character"));
                //Globals.getInstance().setHealth(jsonObject.getInt("health"));

                System.out.println("HIER IST DAS JSONOBJECT: " + jsonObject);

            } catch (Exception e) {
                Log.e("ReadWriteFile", "Unable to read the TestFile.txt file.");
            }
        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goToStart = new Intent(MainActivity.this, MapActivity.class);
                //Intent goToStart = new Intent(MainActivity.this, BattleActivity.class);
                startActivity(goToStart);
                finish();
            }
        }, this.LOAD_TIME);
    }
}