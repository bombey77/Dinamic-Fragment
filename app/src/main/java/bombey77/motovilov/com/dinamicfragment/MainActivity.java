package bombey77.motovilov.com.dinamicfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String LOG = "myLogs";

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
    }

    public void onFirst(final View view) {

        fragmentTransaction = fragmentManager.beginTransaction();

        switch (view.getId()) {
            case R.id.btnFirst:
                if (fragmentManager.findFragmentByTag(FragmentOne.TAG) == null) {
                    fragmentTransaction.add(R.id.container, fragmentOne, FragmentOne.TAG);
                    fragmentTransaction.commit();
                }
                break;

            case R.id.btnSecond:
                if (fragmentManager.findFragmentByTag(FragmentTwo.TAG) == null) {
                    fragmentTransaction.add(R.id.container, fragmentTwo, FragmentTwo.TAG);
                    fragmentTransaction.commit();
                }
                break;
        }
    }
}
