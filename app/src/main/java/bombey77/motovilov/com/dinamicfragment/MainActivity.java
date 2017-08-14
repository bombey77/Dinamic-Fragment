package bombey77.motovilov.com.dinamicfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;

    private Switch isBackStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        isBackStack = (Switch) findViewById(R.id.switchIsBackStack);

        fragmentManager = getSupportFragmentManager();
    }

    public void onClick(final View view) {

        fragmentTransaction = fragmentManager.beginTransaction();

        switch (view.getId()) {
            case R.id.btnFirst:
                if (fragmentManager.findFragmentByTag(FragmentOne.TAG) == null) {
                    fragmentTransaction.add(R.id.container, fragmentOne, FragmentOne.TAG);
                }
                break;

            case R.id.btnSecond:
                if (fragmentManager.findFragmentByTag(FragmentTwo.TAG) == null) {
                    fragmentTransaction.add(R.id.container, fragmentTwo, FragmentTwo.TAG);
                }
                break;

            case R.id.btnRemove:
                if (fragmentManager.findFragmentByTag(FragmentOne.TAG) != null) {
                    fragmentTransaction.remove(fragmentOne);
                }
                if (fragmentManager.findFragmentByTag(FragmentTwo.TAG) != null) {
                    fragmentTransaction.remove(fragmentTwo);
                }
                break;

            case R.id.btnReplace:
                if (fragmentManager.findFragmentByTag(FragmentOne.TAG) != null) {
                    fragmentTransaction.replace(R.id.container, fragmentTwo, FragmentTwo.TAG);
                }
                if (fragmentManager.findFragmentByTag(FragmentTwo.TAG) != null) {
                    fragmentTransaction.replace(R.id.container, fragmentOne, FragmentOne.TAG);
                }
                break;
        }

        if (isBackStack.isChecked()) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }
}
