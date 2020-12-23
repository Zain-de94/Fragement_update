package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mMediaplayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();


        words.add(new Word("where are you going ?","minto wuksus",R.raw.phrase_where_are_you_going));
        words.add(new Word("what is your name","tinna oyaasina",R.raw.phrase_what_is_your_name));
        words.add(new Word("my name is","oyyasit",R.raw.phrase_my_name_is));
        words.add(new Word("how are you feeling","michaksas",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("i'm feeling good","kuchi achit",R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming ","aanas'aa",R.raw.phrase_are_you_coming));
        words.add(new Word("yes , i'm coming","haa'aanam",R.raw.phrase_yes_im_coming));
        words.add(new Word("i'm coming","aanam",R.raw.phrase_im_coming));


        WordAdapter Adapter = new WordAdapter(this , words ,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();
                mMediaplayer = MediaPlayer.create(PhrasesActivity.this , word.getAudioResourceId());
                mMediaplayer.start();

                mMediaplayer.setOnCompletionListener(mCompletionListener);
            }
        });

    }

    @Override
    protected void onStop()
    {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer()
    {
        if(mMediaplayer!=null)
        {
            mMediaplayer.release();

            mMediaplayer =null;
        }
    }

}