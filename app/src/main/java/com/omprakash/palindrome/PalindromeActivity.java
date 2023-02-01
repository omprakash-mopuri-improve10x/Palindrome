package com.omprakash.palindrome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.omprakash.palindrome.databinding.ActivityPalindromeBinding;
import com.omprakash.palindrome.databinding.CustomAlertDialogBinding;

public class PalindromeActivity extends AppCompatActivity implements PalindromeView {

    private ActivityPalindromeBinding binding;
    private CustomAlertDialogBinding itemBinding;
    String input;
    String output;

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
            if (input.equals("") == false) {
                output = new PalindromeControllerImpl().findPalindrome(input);
                showDialog();
            } else {
                Toast.makeText(this, "Please enter the word", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showErrorMessage() {

    }

    @Override
    public void showDialog() {
        itemBinding = CustomAlertDialogBinding.inflate(getLayoutInflater());
        Dialog dialog = new Dialog(this);
        dialog.setContentView(itemBinding.getRoot());
        itemBinding.messageTxt.setText(output);
        itemBinding.imageView.setOnClickListener(v -> {
            dialog.cancel();
        });
        dialog.show();
    }
}