package com.example.videocompressor;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.Toast;
import com.arthenica.mobileffmpeg.FFmpeg;

public class MainActivity extends Activity {
    private static final int PICK_VIDEO_REQUEST = 1;
    private Uri videoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button selectButton = findViewById(R.id.select_button);
        Button compressButton = findViewById(R.id.compress_button);

        selectButton.setOnClickListener(v -> selectVideoFile());
        compressButton.setOnClickListener(v -> compressVideo());
    }

    private void selectVideoFile() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("video/*");
        startActivityForResult(intent, PICK_VIDEO_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_VIDEO_REQUEST && resultCode == RESULT_OK) {
            videoUri = data.getData();
            Toast.makeText(this, "Video Selected: " + videoUri.getPath(), Toast.LENGTH_SHORT).show();
        }
    }

    private void compressVideo() {
        if (videoUri != null) {
            String inputPath = videoUri.getPath();
            String outputPath = getExternalFilesDir(null) + "/compressed_video.mp4";
            String command = "-i " + inputPath + " -vcodec libx264 -crf 28 " + outputPath;

            FFmpeg.executeAsync(command, (executionId, returnCode) -> {
                if (returnCode == 0) {
                    Toast.makeText(this, "Video compression successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Video compression failed.", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "No video selected!", Toast.LENGTH_SHORT).show();
        }
    }
}
