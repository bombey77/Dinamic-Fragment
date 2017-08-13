package bombey77.motovilov.com.dinamicfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends FragmentActivity {

    private static final String LOG = "myLogs";

    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        fragmentManager = getSupportFragmentManager();
    }

    public void onAdd(final View view) {

        fragmentTransaction = fragmentManager.beginTransaction();

        switch (view.getId()) {
            case R.id.btnAdd:
                Log.i(LOG, "view = " + view.getId());
                fragmentTransaction.add(R.id.container, fragmentOne);
                break;
        }
        fragmentTransaction.commit();
    }
}
