package id.co.sigerstudio.drumtry;

import android.content.Intent;
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
    int streamA, streamB, streamC, streamD, streamE, streamF, streamG, streamH, streamI, streamJ, streamK, streamL;
    private AudioManager audioManager;
    Intent intent;

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
        intent = getIntent();

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

        soundA = soundPool.load(this, intent.getIntExtra("soundA",0), 1);
        soundB = soundPool.load(this, intent.getIntExtra("soundB",0), 1);
        soundC = soundPool.load(this, intent.getIntExtra("soundC",0), 1);
        soundD = soundPool.load(this, intent.getIntExtra("soundD",0), 1);
        soundE = soundPool.load(this, intent.getIntExtra("soundE",0), 1);
        soundF = soundPool.load(this, intent.getIntExtra("soundF",0), 1);
        soundG = soundPool.load(this, intent.getIntExtra("soundG",0), 1);
        soundH = soundPool.load(this, intent.getIntExtra("soundH",0), 1);
        soundI = soundPool.load(this, intent.getIntExtra("soundI",0), 1);
        soundJ = soundPool.load(this, intent.getIntExtra("soundJ",0), 1);
        soundK = soundPool.load(this, intent.getIntExtra("soundK",0), 1);
        soundL = soundPool.load(this, intent.getIntExtra("soundL",0), 1);

        findViewById(R.id.tombolA).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    playASound(soundA);
                }
                return true;
            }
        });
        findViewById(R.id.tombolB).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    playBSound(soundB);
                }
                return true;
            }
        });
        findViewById(R.id.tombolC).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    playCSound();
                }
                return true;
            }
        });
        findViewById(R.id.tombolD).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    playDSound();
                }
                return true;
            }
        });
        findViewById(R.id.tombolE).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    playESound();
                }
                return true;
            }
        });
        findViewById(R.id.tombolF).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    playFSound();
                }
                return true;
            }
        });
        findViewById(R.id.tombolG).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    playGSound();
                }
                return true;
            }
        });
        findViewById(R.id.tombolH).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    playHSound();
                }
                return true;
            }
        });
        findViewById(R.id.tombolI).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    playISound();
                }
                return true;
            }
        });
        findViewById(R.id.tombolJ).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    playJSound();
                }
                return true;
            }
        });
        findViewById(R.id.tombolK).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    playKSound();
                }
                return true;
            }
        });
        findViewById(R.id.tombolL).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    playLSound();
                }
                return true;
            }
        });
    }


    public void playASound(int sound) {
        float leftVolumn = volume;
        float rightVolumn = volume;
        soundPool.stop(streamA);
        streamA = soundPool.play(sound, leftVolumn, rightVolumn, 1, 0, 1f);
    }

    public void playBSound(int sound) {
        float leftVolumn = volume;
        float rightVolumn = volume;
        soundPool.stop(streamB);
        streamB = soundPool.play(sound, leftVolumn, rightVolumn, 1, 0, 1f);
    }

    public void playCSound() {
        float leftVolumn = volume;
        float rightVolumn = volume;
        soundPool.stop(streamC);
        streamC = soundPool.play(soundC, leftVolumn, rightVolumn, 1, 0, 1f);
    }

    public void playDSound() {
        float leftVolumn = volume;
        float rightVolumn = volume;
        soundPool.stop(streamD);
        streamD = soundPool.play(soundD, leftVolumn, rightVolumn, 1, 0, 1f);

    }

    public void playESound() {
        float leftVolumn = volume;
        float rightVolumn = volume;
        soundPool.stop(streamD);
        streamE = soundPool.play(soundE, leftVolumn, rightVolumn, 1, 0, 1f);

    }

    public void playFSound() {
        float leftVolumn = volume;
        float rightVolumn = volume;
        soundPool.stop(streamD);
        streamF = soundPool.play(soundF, leftVolumn, rightVolumn, 1, 0, 1f);

    }

    public void playGSound() {
        float leftVolumn = volume;
        float rightVolumn = volume;
        soundPool.stop(streamD);
        streamG = soundPool.play(soundG, leftVolumn, rightVolumn, 1, 0, 1f);

    }

    public void playHSound() {
        float leftVolumn = volume;
        float rightVolumn = volume;
        soundPool.stop(streamD);
        streamH = soundPool.play(soundH, leftVolumn, rightVolumn, 1, 0, 1f);

    }

    public void playISound() {
        float leftVolumn = volume;
        float rightVolumn = volume;
        soundPool.stop(streamD);
        streamI = soundPool.play(soundI, leftVolumn, rightVolumn, 1, 0, 1f);

    }

    public void playJSound() {
        float leftVolumn = volume;
        float rightVolumn = volume;
        soundPool.stop(streamD);
        streamJ = soundPool.play(soundJ, leftVolumn, rightVolumn, 1, 0, 1f);

    }

    public void playKSound() {
        float leftVolumn = volume;
        float rightVolumn = volume;
        soundPool.stop(streamK);
        streamK = soundPool.play(soundK, leftVolumn, rightVolumn, 1, 0, 1f);

    }

    public void playLSound() {
        float leftVolumn = volume;
        float rightVolumn = volume;
        soundPool.stop(streamL);
        streamL = soundPool.play(soundL, leftVolumn, rightVolumn, 1, 0, 1f);

    }

}
