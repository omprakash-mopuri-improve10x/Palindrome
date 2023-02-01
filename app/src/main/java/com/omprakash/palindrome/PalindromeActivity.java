package com.omprakash.palindrome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.omprakash.palindrome.databinding.ActivityPalindromeBinding;

public class PalindromeActivity extends AppCompatActivity implements PalindromeView {

    private ActivityPalindromeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPalindromeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        checkPalindrome();
    }

    @Override
    public void checkPalindrome() {
        binding.checkPalindromeBtn.setOnClickListener(v -> {
            String input = binding.inputTxt.getText().toString();
            String output = new PalindromeControllerImpl().findPalindrome(input);
            Toast.makeText(this, output, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void showErrorMessage() {

    }
}