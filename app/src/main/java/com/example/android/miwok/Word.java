package com.example.android.miwok;


public class Word   {


    /** Default translation for the word */
    private String mDefaultTranslation;

    private int mAudioResourceId;

    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;



    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     */
    public Word(String defaultTranslation,int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mAudioResourceId = audioResourceId;

    }


    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     */
    public Word(String defaultTranslation,int imageResourceId,int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;

    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getImageResourceId(){
        return  mImageResourceId;
    }


    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Return the audio resource ID of the word.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }



}
