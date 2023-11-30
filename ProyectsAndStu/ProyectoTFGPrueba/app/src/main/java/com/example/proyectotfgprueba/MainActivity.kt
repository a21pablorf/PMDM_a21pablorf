package com.example.proyectotfgprueba

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var soundLevelTextView: TextView
    private lateinit var recorder: MediaRecorder

    private var isRecording = false

    companion object {
        private const val RECORD_AUDIO_PERMISSION_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        soundLevelTextView = findViewById(R.id.soundLevelTextView)

        // Check for RECORD_AUDIO permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // Permission not granted, request it
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.RECORD_AUDIO),
                RECORD_AUDIO_PERMISSION_CODE
            )
        } else {
            // Permission already granted, start recording
            startRecording()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == RECORD_AUDIO_PERMISSION_CODE && grantResults.isNotEmpty()
            && grantResults[0] == PackageManager.PERMISSION_GRANTED
        ) {
            // Permission granted, start recording
            startRecording()
        } else {
            // Permission denied, handle accordingly (e.g., show a message)
            soundLevelTextView.text = "Permission denied. App cannot measure sound level."
        }
    }

    private fun startRecording() {
//        mediaRecorder = MediaRecorder.Builder
//            .setAudioSource(MediaRecorder.AudioSource.MIC)
//            .setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
//            .setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
//            .setOutputFile("/dev/null")
//            .build()

            recorder=MediaRecorder(this)
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC)
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
            recorder.setOutputFile("/dev/null")

            try {
                recorder.prepare()
                recorder.start()
                updateSoundLevel()
            } catch (e: IllegalStateException) {
                e.printStackTrace()
                soundLevelTextView.text = "Error starting recording."
            }
            isRecording = true

        recorder.stop()

    }

    fun stopRecording() {
        if (recorder != null) {
            if (isRecording) {
                try {
                    recorder.stop()
                    recorder.release()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            isRecording = false
        }
    }


    private fun updateSoundLevel() {
        if (isRecording) {
            val amplitude = recorder.maxAmplitude.toDouble()
            val soundLevel = 20 * Math.log10(amplitude / 32767.0)
            soundLevelTextView.text = "Sound Level: ${"%.2f".format(soundLevel)} dB"

            // Schedule the next update after a short delay
            soundLevelTextView.postDelayed({ updateSoundLevel() }, 1000)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isRecording) {
            recorder.stop()
            recorder.release()
            isRecording = false
        }
    }
}
