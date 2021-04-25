package com.example.worshippad.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.worshippad.R;
import com.example.worshippad.model.AudioModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView btC, btCSustenido, btD, btDSustenido, btE, btF, btFSustenido, btG, btGSustenido, btA, btASustenido, btB;
    private ImageView btPause;
    private MediaPlayer audioC, audioCSustenido, audioD, audioDSustenido, audioE, audioESustenido, audioF, audioFSustenido,
            audioG, audioGSustenido, audioA, audioASustenido, audioB;
    private int imgPlay, imgPause;
    private SeekBar sbProgressoAudio;
    private Runnable context;


    private Handler handler = new Handler();

    AudioModel tomC = new AudioModel(audioC);
    AudioModel tomCSustenido = new AudioModel(audioCSustenido);
    AudioModel tomD = new AudioModel(audioD);
    AudioModel tomDSustenido = new AudioModel(audioDSustenido);
    AudioModel tomE = new AudioModel(audioE);
    AudioModel tomF = new AudioModel(audioF);
    AudioModel tomFSustenido = new AudioModel(audioFSustenido);
    AudioModel tomG = new AudioModel(audioG);
    AudioModel tomGSustenido = new AudioModel(audioGSustenido);
    AudioModel tomA = new AudioModel(audioA);
    AudioModel tomASustenido = new AudioModel(audioASustenido);
    AudioModel tomB = new AudioModel(audioB);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Imagem de play e pause
        imgPlay = R.drawable.botaoselecionado;
        imgPause = R.drawable.botaopadrao;

        //Arquivos de audio
        audioC = MediaPlayer.create(getApplicationContext(), R.raw.c_ambience);
        audioCSustenido = MediaPlayer.create(getApplicationContext(), R.raw.db_ambience);
        audioD = MediaPlayer.create(getApplicationContext(), R.raw.d_ambience);
        audioDSustenido = MediaPlayer.create(getApplicationContext(), R.raw.eb_ambience);
        audioE = MediaPlayer.create(getApplicationContext(), R.raw.e_ambience);
        audioF = MediaPlayer.create(getApplicationContext(), R.raw.f_ambience);
        audioFSustenido = MediaPlayer.create(getApplicationContext(), R.raw.gb_ambience);
        audioG = MediaPlayer.create(getApplicationContext(), R.raw.g_ambience);
        audioGSustenido = MediaPlayer.create(getApplicationContext(), R.raw.ab_ambience);
        audioA = MediaPlayer.create(getApplicationContext(), R.raw.a_ambience);
        audioASustenido = MediaPlayer.create(getApplicationContext(), R.raw.bb_ambience);
        audioB = MediaPlayer.create(getApplicationContext(), R.raw.b_ambience);

        //Configura botões
        btC = findViewById(R.id.ivC);
        btCSustenido = findViewById(R.id.ivCSustenido);
        btD = findViewById(R.id.ivD);
        btDSustenido = findViewById(R.id.ivDSustenido);
        btE = findViewById(R.id.ivE);
        btF = findViewById(R.id.ivF);
        btFSustenido = findViewById(R.id.ivFSustenido);
        btG = findViewById(R.id.ivG);
        btGSustenido = findViewById(R.id.ivGSustenido);
        btA = findViewById(R.id.ivA);
        btASustenido = findViewById(R.id.ivASustenido);
        btB = findViewById(R.id.ivB);
        btPause = findViewById(R.id.btPause);

        //Configura Click dos botões
        btC.setOnClickListener(this);
        btCSustenido.setOnClickListener(this);
        btD.setOnClickListener(this);
        btDSustenido.setOnClickListener(this);
        btE.setOnClickListener(this);
        btF.setOnClickListener(this);
        btFSustenido.setOnClickListener(this);
        btG.setOnClickListener(this);
        btGSustenido.setOnClickListener(this);
        btA.setOnClickListener(this);
        btASustenido.setOnClickListener(this);
        btB.setOnClickListener(this);
        btPause.setOnClickListener(this);

        //Configura SeekBar
        sbProgressoAudio = findViewById(R.id.sbProgressoAudio);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ivC:
                stopAudio(tomCSustenido, btCSustenido);
                stopAudio(tomD, btD);
                stopAudio(tomDSustenido,btDSustenido);
                stopAudio(tomE,btE);
                stopAudio(tomF,btF);
                stopAudio(tomFSustenido,btFSustenido);
                stopAudio(tomG,btG);
                stopAudio(tomGSustenido,btGSustenido);
                stopAudio(tomA,btA);
                stopAudio(tomASustenido, btASustenido);
                stopAudio(tomB, btB);

                tomC = new AudioModel(audioC);
                tomC.duracaoTotalAudio(sbProgressoAudio);
                configuraSeekBar(tomC);
                reproduzirAudio(tomC, btC);
                break;


            case R.id.ivCSustenido:
                stopAudio(tomC,btC);
                stopAudio(tomD, btD);
                stopAudio(tomDSustenido,btDSustenido);
                stopAudio(tomE,btE);
                stopAudio(tomF,btF);
                stopAudio(tomFSustenido,btFSustenido);
                stopAudio(tomG,btG);
                stopAudio(tomGSustenido,btGSustenido);
                stopAudio(tomA,btA);
                stopAudio(tomASustenido, btASustenido);
                stopAudio(tomB, btB);

                tomCSustenido = new AudioModel(audioCSustenido);
                tomCSustenido.duracaoTotalAudio(sbProgressoAudio);
                configuraSeekBar(tomCSustenido);
                reproduzirAudio(tomCSustenido, btCSustenido);
                break;

            case R.id.ivD:
                stopAudio(tomC,btC);
                stopAudio(tomCSustenido, btCSustenido);
                stopAudio(tomDSustenido,btDSustenido);
                stopAudio(tomE,btE);
                stopAudio(tomF,btF);
                stopAudio(tomFSustenido,btFSustenido);
                stopAudio(tomG,btG);
                stopAudio(tomGSustenido,btGSustenido);
                stopAudio(tomA,btA);
                stopAudio(tomASustenido, btASustenido);
                stopAudio(tomB, btB);

                tomD = new AudioModel(audioD);
                tomD.duracaoTotalAudio(sbProgressoAudio);
                configuraSeekBar(tomD);
                reproduzirAudio(tomD, btD);
                break;

            case R.id.ivDSustenido:
                stopAudio(tomC,btC);
                stopAudio(tomCSustenido, btCSustenido);
                stopAudio(tomD, btD);
                stopAudio(tomE,btE);
                stopAudio(tomF,btF);
                stopAudio(tomFSustenido,btFSustenido);
                stopAudio(tomG,btG);
                stopAudio(tomGSustenido,btGSustenido);
                stopAudio(tomA,btA);
                stopAudio(tomASustenido, btASustenido);
                stopAudio(tomB, btB);

                tomDSustenido = new AudioModel(audioDSustenido);
                tomDSustenido.duracaoTotalAudio(sbProgressoAudio);
                configuraSeekBar(tomDSustenido);
                reproduzirAudio(tomDSustenido, btDSustenido);
                break;

            case R.id.ivE:
                stopAudio(tomC,btC);
                stopAudio(tomCSustenido, btCSustenido);
                stopAudio(tomD, btD);
                stopAudio(tomDSustenido, btDSustenido);
                stopAudio(tomF,btF);
                stopAudio(tomFSustenido,btFSustenido);
                stopAudio(tomG,btG);
                stopAudio(tomGSustenido,btGSustenido);
                stopAudio(tomA,btA);
                stopAudio(tomASustenido, btASustenido);
                stopAudio(tomB, btB);

                tomE = new AudioModel(audioE);
                tomE.duracaoTotalAudio(sbProgressoAudio);
                configuraSeekBar(tomE);
                reproduzirAudio(tomE, btE);
                break;

            case R.id.ivF:
                stopAudio(tomC,btC);
                stopAudio(tomCSustenido, btCSustenido);
                stopAudio(tomD, btD);
                stopAudio(tomDSustenido, btDSustenido);
                stopAudio(tomE,btE);
                stopAudio(tomFSustenido,btFSustenido);
                stopAudio(tomG,btG);
                stopAudio(tomGSustenido,btGSustenido);
                stopAudio(tomA,btA);
                stopAudio(tomASustenido, btASustenido);
                stopAudio(tomB, btB);

                tomF = new AudioModel(audioF);
                tomF.duracaoTotalAudio(sbProgressoAudio);
                configuraSeekBar(tomF);
                reproduzirAudio(tomF, btF);
                break;

            case R.id.ivFSustenido:
                stopAudio(tomC,btC);
                stopAudio(tomCSustenido, btCSustenido);
                stopAudio(tomD, btD);
                stopAudio(tomDSustenido, btDSustenido);
                stopAudio(tomE,btE);
                stopAudio(tomF,btF);
                stopAudio(tomG,btG);
                stopAudio(tomGSustenido,btGSustenido);
                stopAudio(tomA,btA);
                stopAudio(tomASustenido, btASustenido);
                stopAudio(tomB, btB);

                tomFSustenido = new AudioModel(audioFSustenido);
                tomFSustenido.duracaoTotalAudio(sbProgressoAudio);
                configuraSeekBar(tomFSustenido);
                reproduzirAudio(tomFSustenido, btFSustenido);
                break;

            case R.id.ivG:
                stopAudio(tomC,btC);
                stopAudio(tomCSustenido, btCSustenido);
                stopAudio(tomD, btD);
                stopAudio(tomDSustenido, btDSustenido);
                stopAudio(tomE,btE);
                stopAudio(tomF,btF);
                stopAudio(tomFSustenido,btFSustenido);
                stopAudio(tomGSustenido,btGSustenido);
                stopAudio(tomA,btA);
                stopAudio(tomASustenido, btASustenido);
                stopAudio(tomB, btB);

                tomG = new AudioModel(audioG);
                tomG.duracaoTotalAudio(sbProgressoAudio);
                configuraSeekBar(tomG);
                reproduzirAudio(tomG, btG);
                break;

            case R.id.ivGSustenido:
                stopAudio(tomC,btC);
                stopAudio(tomCSustenido, btCSustenido);
                stopAudio(tomD, btD);
                stopAudio(tomDSustenido, btDSustenido);
                stopAudio(tomE,btE);
                stopAudio(tomF,btF);
                stopAudio(tomFSustenido,btFSustenido);
                stopAudio(tomG,btG);
                stopAudio(tomA,btA);
                stopAudio(tomASustenido, btASustenido);
                stopAudio(tomB, btB);

                tomGSustenido = new AudioModel(audioGSustenido);
                tomGSustenido.duracaoTotalAudio(sbProgressoAudio);
                configuraSeekBar(tomGSustenido);
                reproduzirAudio(tomGSustenido, btGSustenido);
                break;

            case R.id.ivA:
                stopAudio(tomC,btC);
                stopAudio(tomCSustenido, btCSustenido);
                stopAudio(tomD, btD);
                stopAudio(tomDSustenido, btDSustenido);
                stopAudio(tomE,btE);
                stopAudio(tomF,btF);
                stopAudio(tomFSustenido,btFSustenido);
                stopAudio(tomG,btG);
                stopAudio(tomGSustenido,btGSustenido);
                stopAudio(tomASustenido, btASustenido);
                stopAudio(tomB, btB);

                tomA = new AudioModel(audioA);
                tomA.duracaoTotalAudio(sbProgressoAudio);
                configuraSeekBar(tomA);
                reproduzirAudio(tomA, btA);
                break;

            case R.id.ivASustenido:
                stopAudio(tomC,btC);
                stopAudio(tomCSustenido, btCSustenido);
                stopAudio(tomD, btD);
                stopAudio(tomDSustenido, btDSustenido);
                stopAudio(tomE,btE);
                stopAudio(tomF,btF);
                stopAudio(tomFSustenido,btFSustenido);
                stopAudio(tomG,btG);
                stopAudio(tomGSustenido,btGSustenido);
                stopAudio(tomA,btA);
                stopAudio(tomB, btB);

                tomASustenido = new AudioModel(audioASustenido);
                tomASustenido.duracaoTotalAudio(sbProgressoAudio);
                configuraSeekBar(tomASustenido);
                reproduzirAudio(tomASustenido, btASustenido);
                break;

            case R.id.ivB:
                stopAudio(tomC,btC);
                stopAudio(tomCSustenido, btCSustenido);
                stopAudio(tomD, btD);
                stopAudio(tomDSustenido, btDSustenido);
                stopAudio(tomE,btE);
                stopAudio(tomF,btF);
                stopAudio(tomFSustenido,btFSustenido);
                stopAudio(tomG,btG);
                stopAudio(tomGSustenido,btGSustenido);
                stopAudio(tomA,btA);
                stopAudio(tomASustenido, btASustenido);

                tomB = new AudioModel(audioB);
                tomB.duracaoTotalAudio(sbProgressoAudio);
                configuraSeekBar(tomB);
                reproduzirAudio(tomB, btB);
                break;

            case R.id.btPause:
                view.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_item));
                stopAudio(tomC,btC);
                stopAudio(tomCSustenido, btCSustenido);
                stopAudio(tomD, btD);
                stopAudio(tomDSustenido, btDSustenido);
                stopAudio(tomE,btE);
                stopAudio(tomF,btF);
                stopAudio(tomFSustenido,btFSustenido);
                stopAudio(tomG,btG);
                stopAudio(tomGSustenido,btGSustenido);
                stopAudio(tomA,btA);
                stopAudio(tomASustenido, btASustenido);
                stopAudio(tomB, btB);
                //
                break;

                default:
                    Toast.makeText(getApplicationContext(), "Aperte um botão válido", Toast.LENGTH_LONG).show();
        }

    }


    public void reproduzirAudio(AudioModel audioModel, ImageView botao){
        audioModel.executarAudio(imgPlay, imgPause);
        botao.setImageResource(audioModel.getImagemBotao());
    }

    public void stopAudio(AudioModel audioModel, ImageView botao) {
        if(audioModel.getAudio() != null) {
            if (audioModel.getAudio().isPlaying()) {
                audioModel.getAudio().pause();
                audioModel.getAudio().seekTo(0);
                handler.removeCallbacks(context);
                botao.setImageResource(imgPause);
            }
        }
    }

    public void configuraSeekBar(final AudioModel audioModel){
        handler.removeCallbacks(context);
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(audioModel.getAudio() != null){
                    int posicaoCorretaAudio = audioModel.getAudio().getCurrentPosition()/1000;
                    sbProgressoAudio.setProgress(posicaoCorretaAudio);
                }
                handler.postDelayed(this, 1000);
                context = this;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        tomC.destroiMedia();
        tomCSustenido.destroiMedia();
        tomD.destroiMedia();
        tomDSustenido.destroiMedia();
        tomE.destroiMedia();
        tomF.destroiMedia();
        tomFSustenido.destroiMedia();
        tomG.destroiMedia();
        tomGSustenido.destroiMedia();
        tomA.destroiMedia();
        tomASustenido.destroiMedia();
        tomB.destroiMedia();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemSobre:
                Intent intent = new Intent(getApplicationContext(), SobreActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


