package tk.alltrue.testfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView imCat;
    private TextView tCat;
    private int mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imCat = (ImageView) findViewById(R.id.imageView);
        tCat = findViewById(R.id.textView);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                imCat.setImageResource(R.drawable.ryzh);
                tCat.setText("Ryzhik");
                break;
            case R.id.button2:
                imCat.setImageResource(R.drawable.bars);
                tCat.setText("Barsik");
                break;
            case R.id.button3:
                imCat.setImageResource(R.drawable.murz);
                tCat.setText("Murzik");
                break;
        }
    }
}
