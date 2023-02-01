package com.omprakash.palindrome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.omprakash.palindrome.databinding.ActivityPalindromeBinding;
import com.omprakash.palindrome.databinding.CustomAlertDialogBinding;

public class PalindromeActivity extends AppCompatActivity implements PalindromeView {

    private ActivityPalindromeBinding binding;
    private CustomAlertDialogBinding itemBinding;
    String input;
    boolean output;

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
            input = binding.inputTxt.getText().toString();
            output = new PalindromeControllerImpl().isPalindrome(input);
            if (input.equals("") == false) {
                if (output) {
                    showDialog(input + " is a Palindrome", R.drawable.correct, Color.GREEN);
                } else if (input.length() >= 20) {
                    binding.showErrorMsgTxt.setVisibility(View.VISIBLE);
                    binding.showErrorMsgTxt.setTextColor(Color.RED);
                } else {
                    showDialog(input + " is not a Palindrome", R.drawable.incorrect, Color.RED);
                }
            } else {
                Toast.makeText(this, "Please enter the input", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public void showErrorMessage() {

    }

    @Override
    public void showDialog(String text, int imageResourceId, int textColor) {
        itemBinding = CustomAlertDialogBinding.inflate(getLayoutInflater());
        Dialog dialog = new Dialog(this);
        dialog.setContentView(itemBinding.getRoot());
        itemBinding.showImg.setImageResource(imageResourceId);
        itemBinding.messageTxt.setText(text);
        itemBinding.messageTxt.setTextColor(textColor);
        itemBinding.crossImg.setOnClickListener(v -> {
            dialog.cancel();
        });
        dialog.show();
    }
}