package com.omprakash.palindrome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.omprakash.palindrome.databinding.ActivityPalindromeBinding;
import com.omprakash.palindrome.databinding.CustomAlertDialogBinding;

public class PalindromeActivity extends AppCompatActivity implements PalindromeView {

    private ActivityPalindromeBinding binding;
    private CustomAlertDialogBinding itemBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPalindromeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        handleCheckPalindrome();
    }

    @Override
    public void handleCheckPalindrome() {
        binding.checkPalindromeBtn.setOnClickListener(v -> {
            String input = binding.inputTxt.getText().toString();
            boolean output = new PalindromeControllerImpl().isCheckPalindrome(input);
            if (input.equals("") == false) {
                if (output) {
                    showDialog(input + " is a Palindrome", R.drawable.correct, Color.GREEN);
                } else {
                    showDialog(input + " is not a Palindrome", R.drawable.incorrect, Color.RED);
                }
            } else {
                Toast.makeText(this, "Please enter the input", Toast.LENGTH_SHORT).show();
            }
        });
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