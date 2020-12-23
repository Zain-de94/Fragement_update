package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private int mAudioResourceID;

    private static final int NO_IMAGE_PROVIDED =-1 ;


    public Word(String defaultTranslation , String miwokTranslation , int audioResourceId)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation  = miwokTranslation;
        mAudioResourceID = audioResourceId;
    }

    public Word(String defaultTranslation , String miwokTranslation , int imageResourceId , int audioResourceId)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation  = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceID = audioResourceId;
    }


    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation()
    {
        return  mMiwokTranslation;
    }

    public int getImageResourceId()
    {
        return mImageResourceId;
    }

    public boolean hasImage()
    {
      return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId()
    {
        return mAudioResourceID;
    }



}
