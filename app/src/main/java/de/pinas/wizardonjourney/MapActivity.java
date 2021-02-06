package de.pinas.wizardonjourney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MapActivity extends AppCompatActivity {

    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        ProgressBar lifeBar = findViewById(R.id.progressBar);
        lifeBar.setProgress(Globals.getInstance().getCharacter().getHealth());
        TextView gold = findViewById(R.id.goldText);
        gold.setText(Globals.getInstance().getCharacter().getGold() + " Gold");

        GridLayout gridLayout = findViewById(R.id.grid_layout);

        if (Globals.getInstance().getMap() == null) {
            Field[][] fields = new Field[20][20];

            for (int row = 0; row < fields.length; row++) {
                for (int column = 0; column < fields[row].length; column++) {
                    Button btn = new Button(this);

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(GridLayout.LayoutParams.WRAP_CONTENT, GridLayout.LayoutParams.WRAP_CONTENT);
                    params.gravity = Gravity.CENTER;
                    params.height = 200;
                    params.width = 200;
                    params.setMargins(1, 1, 1, 1);
                    btn.setLayoutParams(params);

                    if (column == Globals.getInstance().getColumnCharacter() && row == Globals.getInstance().getRowCharacter()) {
                        btn.setBackgroundResource(R.mipmap.charactermap);
                    } else {
                        btn.setBackgroundResource(R.mipmap.terrain);

                        /*btn.setBackgroundColor(Color.parseColor("#fafafa"));
                        float alpha = 0.30f;
                        AlphaAnimation alphaUp = new AlphaAnimation(alpha, alpha);
                        alphaUp.setFillAfter(true);
                        btn.startAnimation(alphaUp);*/
                    }

                    Field f = new Field(column, row, btn, false);
                    fields[column][row] = f;
                }
            }
            Globals.getInstance().setMap(fields);

            for (int row = 0; row < Globals.getInstance().getMap().length; row++) {
                for (int column = 0; column < Globals.getInstance().getMap()[row].length; column++) {
                    gridLayout.addView(Globals.getInstance().getMap()[column][row].getButton());
                }
            }
        }

        ImageButton save = findViewById(R.id.buttonSave);
        Button inventar = findViewById(R.id.buttonInventar);
        Button shop = findViewById(R.id.buttonShop);

        file = this.getExternalFilesDir(null);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Calendar kalender = Calendar.getInstance();
                    SimpleDateFormat datumsformat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("rowCharacter", Globals.getInstance().getRowCharacter());
                    jsonObject.put("columnCharacter", Globals.getInstance().getColumnCharacter());
                    JSONObject characterJson = new JSONObject();
                    characterJson.put("gold", Globals.getInstance().getCharacter().getGold());
                    characterJson.put("health", Globals.getInstance().getCharacter().getHealth());
                    characterJson.put("level", Globals.getInstance().getCharacter().getLevel());
                    characterJson.put("experience", Globals.getInstance().getCharacter().getExperience());

                    jsonObject.put("character", characterJson);

                    File testFile = new File(file, "TestFile.txt");
                    if (testFile.exists()) {
                        testFile.delete();
                    }
                    testFile.createNewFile();

                    // Adds a line to the file
                    BufferedWriter writer = new BufferedWriter(new FileWriter(testFile, true /*append*/));
                    writer.write(jsonObject.toString());
                    writer.close();

                    Toast toast = Toast.makeText(v.getContext(), getString(R.string.save_action) + "",
                            Toast.LENGTH_SHORT);
                    toast.show();

                    Toast toast2 = Toast.makeText(v.getContext(), jsonObject + "",
                            Toast.LENGTH_SHORT);
                    toast2.show();

                } catch (IOException | JSONException e) {
                    Log.e("ReadWriteFile", "Unable to write to the TestFile.txt file.");
                }
            }
        });

        inventar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToStart = new Intent(MapActivity.this, BattleActivity.class);
                startActivity(goToStart);
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToStart = new Intent(MapActivity.this, StoreActivity.class);
                startActivity(goToStart);
                /*String textFromFile = "";
// Gets the file from the primary external storage space of the
// current application.
                File testFile = new File(file, "TestFile.txt");
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

                        Toast toast = Toast.makeText(v.getContext(), textFromFile,
                                Toast.LENGTH_SHORT);
                        toast.show();

                        JSONObject jsonObject = new JSONObject(textFromFile);
                        System.out.println("HIER IST DAS JSONOBJECT: " + jsonObject.getInt("rowCharacter"));

                    } catch (Exception e) {
                        Log.e("ReadWriteFile", "Unable to read the TestFile.txt file.");
                    }
                }
            */

            }
        });

    }

    public Context getContext() {
        return this;
    }
}