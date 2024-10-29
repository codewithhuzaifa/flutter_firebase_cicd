package com.example.firebase_app_distribution

import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import com.google.firebase.appdistribution.FirebaseAppDistribution

class MainActivity: FlutterActivity() {
    private val CHANNEL = "com.example.firebase_app_distribution/feedback"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MethodChannel(flutterEngine?.dartExecutor?.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            if (call.method == "startFeedback") {
                FirebaseAppDistribution.getInstance().startFeedback(R.string.feedbackMessage)
                result.success(null)
            } else {
                result.notImplemented()
            }
        }
    }
}
