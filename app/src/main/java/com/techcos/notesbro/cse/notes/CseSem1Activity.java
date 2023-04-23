package com.techcos.notesbro.cse.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.techcos.notesbro.R;

public class CseSem1Activity extends AppCompatActivity {

    TextView m1,phy,che,beee,td,cp;
    LinearLayout m1Group,phyGroup,cheGroup,beeeGroup,tdGroup,cpGroup;
    boolean switchm1 = true;
    boolean switchche = true;
    boolean switchphy = true;
    boolean switchbeee = true;
    boolean switchtd = true;
    boolean switchcp = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_sem1);

        findIDs();


        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchm1){
                    if (!switchphy){
                        switchphy=true;
                        phyGroup.setVisibility(View.GONE);
                    }
                    if (!switchche){
                        switchche=true;
                        cheGroup.setVisibility(View.GONE);
                    }
                    if (!switchbeee){
                        switchbeee=true;
                        beeeGroup.setVisibility(View.GONE);
                    }
                    if (!switchcp){
                        switchcp=true;
                        cpGroup.setVisibility(View.GONE);
                    }
                    if (!switchtd){
                        switchtd=true;
                        tdGroup.setVisibility(View.GONE);
                    }
                    m1Group.setVisibility(View.VISIBLE);
                    switchm1=false;
                }else{
                    m1Group.setVisibility(View.GONE);
                    switchm1=true;
                }
            }
        });

        phy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchphy){
                    if (!switchm1){
                        switchm1=true;
                        m1Group.setVisibility(View.GONE);
                    }
                    if (!switchche){
                        switchche=true;
                        cheGroup.setVisibility(View.GONE);
                    }
                    if (!switchbeee){
                        switchbeee=true;
                        beeeGroup.setVisibility(View.GONE);
                    }
                    if (!switchcp){
                        switchcp=true;
                        cpGroup.setVisibility(View.GONE);
                    }
                    if (!switchtd){
                        switchtd=true;
                        tdGroup.setVisibility(View.GONE);
                    }
                    phyGroup.setVisibility(View.VISIBLE);
                    switchphy=false;
                }else{
                    phyGroup.setVisibility(View.GONE);
                    switchphy=true;
                }
            }
        });

        che.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchche){
                    if (!switchm1){
                        switchm1=true;
                        m1Group.setVisibility(View.GONE);
                    }
                    if (!switchphy){
                        switchphy=true;
                        phyGroup.setVisibility(View.GONE);
                    }
                    if (!switchbeee){
                        switchbeee=true;
                        beeeGroup.setVisibility(View.GONE);
                    }
                    if (!switchcp){
                        switchcp=true;
                        cpGroup.setVisibility(View.GONE);
                    }
                    if (!switchtd){
                        switchtd=true;
                        tdGroup.setVisibility(View.GONE);
                    }
                    cheGroup.setVisibility(View.VISIBLE);
                    switchche=false;
                }else{
                    cheGroup.setVisibility(View.GONE);
                    switchche=true;
                }
            }
        });

        beee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchbeee){
                    if (!switchm1){
                        switchm1=true;
                        m1Group.setVisibility(View.GONE);
                    }
                    if (!switchphy){
                        switchphy=true;
                        phyGroup.setVisibility(View.GONE);
                    }
                    if (!switchche){
                        switchche=true;
                        cheGroup.setVisibility(View.GONE);
                    }
                    if (!switchcp){
                        switchcp=true;
                        cpGroup.setVisibility(View.GONE);
                    }
                    if (!switchtd){
                        switchtd=true;
                        tdGroup.setVisibility(View.GONE);
                    }

                    beeeGroup.setVisibility(View.VISIBLE);
                    switchbeee=false;
                }else{
                    beeeGroup.setVisibility(View.GONE);
                    switchbeee=true;
                }
            }
        });

        td.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchtd){
                    if (!switchm1){
                        switchm1=true;
                        m1Group.setVisibility(View.GONE);
                    }
                    if (!switchphy){
                        switchphy=true;
                        phyGroup.setVisibility(View.GONE);
                    }
                    if (!switchche){
                        switchche=true;
                        cheGroup.setVisibility(View.GONE);
                    }
                    if (!switchbeee){
                        switchbeee=true;
                        beeeGroup.setVisibility(View.GONE);
                    }
                    if (!switchcp){
                        switchcp=true;
                        cpGroup.setVisibility(View.GONE);
                    }

                    tdGroup.setVisibility(View.VISIBLE);
                    switchtd=false;
                }else{
                    tdGroup.setVisibility(View.GONE);
                    switchtd=true;
                }
            }
        });

        cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchcp){
                    if (!switchm1){
                        switchm1=true;
                        m1Group.setVisibility(View.GONE);
                    }
                    if (!switchphy){
                        switchphy=true;
                        phyGroup.setVisibility(View.GONE);
                    }
                    if (!switchche){
                        switchche=true;
                        cheGroup.setVisibility(View.GONE);
                    }
                    if (!switchbeee){
                        switchbeee=true;
                        beeeGroup.setVisibility(View.GONE);
                    }
                    if (!switchtd){
                        switchtd=true;
                        tdGroup.setVisibility(View.GONE);
                    }

                    cpGroup.setVisibility(View.VISIBLE);
                    switchcp=false;
                }else{
                    cpGroup.setVisibility(View.GONE);
                    switchcp=true;
                }
            }
        });
    }

    void findIDs(){
        m1 = findViewById(R.id.m1);
        phy = findViewById(R.id.phy);
        che = findViewById(R.id.che);
        beee = findViewById(R.id.beee);
        td = findViewById(R.id.td);
        cp = findViewById(R.id.cp);
        m1Group = findViewById(R.id.m1Group);
        phyGroup = findViewById(R.id.physicsGroup);
        cheGroup = findViewById(R.id.cheGroup);
        beeeGroup = findViewById(R.id.beeeGroup);
        tdGroup = findViewById(R.id.tdGroup);
        cpGroup = findViewById(R.id.cpGroup);
    }
}