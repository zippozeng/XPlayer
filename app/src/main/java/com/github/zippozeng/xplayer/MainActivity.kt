package com.github.zippozeng.xplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.zippozeng.xplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = stringFromJNI()
    }

    /**
     * A native method that is implemented by the 'xplayer' native library,
     * which is packaged with this application.
     */
    private external fun stringFromJNI(): String

    companion object {
        // Used to load the 'xplayer' library on application startup.
        init {
            System.loadLibrary("xplayer")
        }
    }
}