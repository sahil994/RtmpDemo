package com.example.sahilgoyal.rtmpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private String path;
    //private HashMap<String, String> options;
    private VideoView mVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!LibsChecker.checkVitamioLibs(this))
            return;
        setContentView(R.layout.activity_main);
        mVideoView = (VideoView) findViewById(R.id.vidoeview);
        path = "rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov";
        /*options = new HashMap<>();
        options.put("rtmp_playpath", "");
        options.put("rtmp_swfurl", "");
        options.put("rtmp_live", "1");
        options.put("rtmp_pageurl", "");*/
        mVideoView.setVideoPath(path);
        //mVideoView.setVideoURI(Uri.parse(path), options);
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.requestFocus();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setPlaybackSpeed(1.0f);

            }
        });

    }
}
