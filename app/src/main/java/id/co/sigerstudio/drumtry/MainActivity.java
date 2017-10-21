package id.co.sigerstudio.drumtry;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private SoundPool soundPool;
    int streamId;
    private AudioManager audioManager;

    // Maximumn sound stream.
    private static final int MAX_STREAMS = 5;

    // Stream type.
    private static final int streamType = AudioManager.STREAM_MUSIC;

    private boolean loaded;

    private int soundA, soundB, soundC, soundD, soundE, soundF, soundG, soundH, soundI, soundJ, soundK, soundL;

    private float volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AudioManager audio settings for adjusting the volume
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        // Current volumn Index of particular stream type.
        float currentVolumeIndex = (float) audioManager.getStreamVolume(streamType);

        // Get the maximum volume index for a particular stream type.
        float maxVolumeIndex = (float) audioManager.getStreamMaxVolume(streamType);

        // Volumn (0 --> 1)
        this.volume = currentVolumeIndex / maxVolumeIndex;

        // Suggests an audio stream whose volume should be changed by
        // the hardware volume controls.
        this.setVolumeControlStream(streamType);

        // For Android SDK >= 21
        if (Build.VERSION.SDK_INT >= 21) {

            AudioAttributes audioAttrib = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            SoundPool.Builder builder = new SoundPool.Builder();
            builder.setAudioAttributes(audioAttrib).setMaxStreams(MAX_STREAMS);

            this.soundPool = builder.build();
        }
        // for Android SDK < 21
        else {
            // SoundPool(int maxStreams, int streamType, int srcQuality)
            this.soundPool = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
        }

        // When Sound Pool load complete.
        this.soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });

        // Load sound file (destroy.wav) into SoundPool.
        soundA = soundPool.load(this, R.raw.destroy, 1);

        // Load sound file (gun.wav) into SoundPool.
        this.soundB = this.soundPool.load(this, R.raw.gun, 1);

        this.soundC = this.soundPool.load(this, R.raw.ride, 1);
        this.soundD = this.soundPool.load(this, R.raw.hihat, 1);
        this.soundE = this.soundPool.load(this, R.raw.kick, 1);
        this.soundF = this.soundPool.load(this, R.raw.crash, 1);
        this.soundG = this.soundPool.load(this, R.raw.snare, 1);
        this.soundH = this.soundPool.load(this, R.raw.snare, 1);
        this.soundI = this.soundPool.load(this, R.raw.snare, 1);
        this.soundJ = this.soundPool.load(this, R.raw.tom1, 1);
        this.soundK = this.soundPool.load(this, R.raw.tom2, 1);
        this.soundL = this.soundPool.load(this, R.raw.tom3, 1);

        findViewById(R.id.tombolA).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    playASound(soundA);
                }
                return false;
            }
        });

    }

    public void playASound(int sound) {
        //if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;
            // Play sound of gunfire. Returns the ID of the new stream.
                soundPool.stop(streamId);

                streamId = soundPool.play(sound, leftVolumn, rightVolumn, 1, 0, 1f);
           // }
            //streamId = soundPool.play(sound, leftVolumn, rightVolumn, 1, 0, 1f);


    }

    public void playBSound(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Play sound objects destroyed. Returns the ID of the new stream.
            int streamId = this.soundPool.play(this.soundA, leftVolumn, rightVolumn, 1, 0, 1f);
            soundPool.stop(streamId);
            streamId = soundPool.play(soundA, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playCSound(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Play sound objects destroyed. Returns the ID of the new stream.
            int streamId = this.soundPool.play(this.soundC, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playDSound(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Play sound objects destroyed. Returns the ID of the new stream.
            int streamId = this.soundPool.play(this.soundD, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playESound(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Play sound objects destroyed. Returns the ID of the new stream.
            int streamId = this.soundPool.play(this.soundE, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playFSound(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Play sound objects destroyed. Returns the ID of the new stream.
            int streamId = this.soundPool.play(this.soundF, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playGSound(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Play sound objects destroyed. Returns the ID of the new stream.
            int streamId = this.soundPool.play(this.soundG, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playHSound(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Play sound objects destroyed. Returns the ID of the new stream.
            int streamId = this.soundPool.play(this.soundH, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playISound(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Play sound objects destroyed. Returns the ID of the new stream.
            int streamId = this.soundPool.play(this.soundI, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playJSound(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Play sound objects destroyed. Returns the ID of the new stream.
            int streamId = this.soundPool.play(this.soundJ, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playKSound(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Play sound objects destroyed. Returns the ID of the new stream.
            int streamId = this.soundPool.play(this.soundK, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playLSound(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Play sound objects destroyed. Returns the ID of the new stream.
            int streamId = this.soundPool.play(this.soundL, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }
}
