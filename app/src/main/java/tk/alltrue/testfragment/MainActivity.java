package tk.alltrue.testfragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fragment1.OnSelectedButtonListener {
    private ImageView imCat;
    private TextView tCat;
    private int mText;

    private boolean mIsDynamic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment2 fragment2 = (Fragment2) fragmentManager
                .findFragmentById(R.id.fragment2);
        mIsDynamic = fragment2 == null || !fragment2.isInLayout();
        Toast.makeText(getApplicationContext(), mIsDynamic + "", Toast.LENGTH_SHORT).show();

        if (mIsDynamic) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            Fragment1 fragment1 = new Fragment1();
            ft.add(R.id.content, fragment1, "fragment1");
            ft.commit();
        }

    }

    @Override
    public void onButtonSelected(int buttonIndex) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment2 fragment2 = (Fragment2) fragmentManager
                .findFragmentById(R.id.fragment2);

        if (fragment2 == null || !fragment2.isVisible()) {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("buttonIndex", buttonIndex);
            startActivity(intent);
        } else {
            fragment2.setDescription(buttonIndex);
        }
    }
}
