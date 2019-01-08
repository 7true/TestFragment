package tk.alltrue.testfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    private TextView mInfoTextView;
    private ImageView mCatImageView;
    private String[] mCatDescriptionArray;

    public static final String BUTTON_INDEX = "button_index";
    private static final int BUTTON_INDEX_DEFAULT = -1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment2, container, false);

        mInfoTextView = (TextView) rootView.findViewById(R.id.textView);
        mCatImageView = (ImageView) rootView.findViewById(R.id.imageView);
        mCatDescriptionArray = getResources().getStringArray(R.array.cats);


        Bundle args = getArguments();
        int buttonIndex = args != null ? args.getInt(BUTTON_INDEX,
                BUTTON_INDEX_DEFAULT) : BUTTON_INDEX_DEFAULT;
        if (buttonIndex != BUTTON_INDEX_DEFAULT)
            setDescription(buttonIndex);

        return rootView;
    }


    public void setDescription(int buttonIndex) {
        String catDescription = mCatDescriptionArray[buttonIndex];
        mInfoTextView.setText(catDescription);

        switch (buttonIndex) {
            case 1:
                mCatImageView.setImageResource(R.drawable.ryzh);
                break;
            case 2:
                mCatImageView.setImageResource(R.drawable.bars);
                break;
            case 3:
                mCatImageView.setImageResource(R.drawable.murz);
                break;

            default:
                break;
        }
    }

}
