package com.omprakash.palindrome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PalindromeActivity extends AppCompatActivity implements PalindromeActivityView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome);
    }

    @Override
    public void checkPalindrome() {

    }

    @Override
    public void showErrorMessage() {

    }
}