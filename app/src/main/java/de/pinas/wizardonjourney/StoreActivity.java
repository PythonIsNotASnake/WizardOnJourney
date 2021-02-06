package de.pinas.wizardonjourney;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StoreActivity extends AppCompatActivity {

    private List<Button> buyButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        buyButtons = new ArrayList<>();
        buyButtons.add((Button) findViewById(R.id.buttonAxe));
        buyButtons.add((Button) findViewById(R.id.buttonLance));
        buyButtons.add((Button) findViewById(R.id.buttonPotion));
        buyButtons.add((Button) findViewById(R.id.buttonSpellFire));
        buyButtons.add((Button) findViewById(R.id.buttonSpellIce));
        buyButtons.add((Button) findViewById(R.id.buttonSword));

        for(int i=0; i<buyButtons.size();i++) {
            buyButtons.get(i).setSelected(true);
        }
    }
}