package com.example.worshippad.model;

import android.app.Activity;
import android.media.MediaPlayer;
import android.widget.SeekBar;


public class AudioModel extends Activity {

    private MediaPlayer audio;
    private int imagemBotao;
    private int duraçãoTotalAudio;



    public AudioModel(MediaPlayer audio) {
        this.audio = audio;
    }

    public int getImagemBotao() {
        return imagemBotao;
    }

    public void setImagemBotao(int imagemBotao) {
        this.imagemBotao = imagemBotao;
    }

    public MediaPlayer getAudio() {
        return audio;
    }

    public void setAudio(MediaPlayer audio) {
        this.audio = audio;
    }


    public void executarAudio(int imgPlay, int imgPause){
        if(getAudio() != null){
            if(getAudio().isPlaying()){
                getAudio().pause();
                getAudio().seekTo(0);
                setImagemBotao(imgPause);
            }else{
                getAudio().start();
                //getAudio().setLooping(true);
                setImagemBotao(imgPlay);
                getAudio().setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        getAudio().isLooping();
                    }
                });
            }
        }
    }


    public void pararMedia(){
        getAudio().stop();
        getAudio().release();
        setAudio(null);
    }

    public void destroiMedia(){
        if (getAudio() != null && getAudio().isPlaying()){
            pararMedia();
        }
    }

    public void duracaoTotalAudio(SeekBar seekBar){
        seekBar.setMax(getAudio().getDuration()/1000);
    }


}
