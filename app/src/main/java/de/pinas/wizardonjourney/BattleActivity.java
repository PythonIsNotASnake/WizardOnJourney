package de.pinas.wizardonjourney;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class BattleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        TextView battleLog = findViewById(R.id.battleLog);
        battleLog.setSelected(true);
        //battleLog.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        //battleLog.setSingleLine(true);
    }
}