package au.edu.unsw.infs3634.cryptobag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = "MainActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    int number = 10;
    Log.d(TAG, "Line 15:: " + String.valueOf(number));
    Button btnLauncher = findViewById(R.id.btnLaunchActivity);
    btnLauncher.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        launchDetailActivity("Message from MainActivity");
      }
    });
  }

  void launchDetailActivity(String message){
    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
    intent.putExtra("key", message);
    startActivity(intent);
  }

}