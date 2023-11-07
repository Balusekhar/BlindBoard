package com.keyboard.blindboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.keyboard.blindboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor=ContextCompat.getColor(this@MainActivity,R.color.black)
        binding.apply {
            //check keyboard status
            about.setOnClickListener {
                startActivity(Intent(this@MainActivity,About::class.java))
            }
            if(isKeyboardEnabled())
                btnEnableKeyboard.isEnabled = false

            btnEnableKeyboard.setOnClickListener {
                if (!isKeyboardEnabled())
                    openKeyboardSettings()
            }
            btnChooseKeyboard.setOnClickListener {

                    openKeyboardChooserSettings()

            }
        }
    }
    private fun openKeyboardSettings() {
        val intent = Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)
        startActivity(intent)
    }

    // Function to check if a specific keyboard is enabled
    private fun isKeyboardEnabled(): Boolean {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val enabledInputMethodIds = inputMethodManager.enabledInputMethodList.map { it.id }
        return enabledInputMethodIds.contains(  "com.keyboard.blindboard/.Blind Board")
    }

    // Function to open the keyboard settings to choose a keyboard
    private fun openKeyboardChooserSettings() {
        val im = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        im.showInputMethodPicker()
    }

}