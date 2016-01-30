package com.mobile.appd2.MVPAppd2.UI;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.mobile.appd2.MVPAppd2.R;
import com.viewpagerindicator.CirclePageIndicator;

/**
 * Created by david on 6/12/15.
 */
public class WizardActivity extends AppCompatActivity {
    private class ImagePagerAdapter extends PagerAdapter {

        private final Bitmap[] bitmapArray = new Bitmap[]{
                BitmapFactory.decodeResource(getResources(), R.drawable.wizard1),
                BitmapFactory.decodeResource(getResources(),R.drawable.wizard2),
                BitmapFactory.decodeResource(getResources(),R.drawable.wizard3),
                BitmapFactory.decodeResource(getResources(),R.drawable.wizard3),


        };

        final int sdk = android.os.Build.VERSION.SDK_INT;

        @Override
        public void destroyItem(final ViewGroup container, final int position, final Object object) {
            ((ViewPager) container).removeView((ImageView) object);
        }

        @Override
        public int getCount() {
            return this.bitmapArray.length;
        }

        @Override
        public Object instantiateItem(final ViewGroup container, final int position) {
            final Context context = WizardActivity.this;
            final ImageView imageView = new ImageView(context);
            final int padding = context.getResources().getDimensionPixelSize(
                    R.dimen.padding_medium);
            imageView.setPadding(padding, padding, padding, padding);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                imageView.setBackgroundDrawable( new BitmapDrawable(getResources(), bitmapArray[position]) );
            } else {
                imageView.setBackground( new BitmapDrawable(getResources(), bitmapArray[position]));
            }

            ((ViewPager) container).addView(imageView, 0);
            return imageView;
        }

        @Override
        public boolean isViewFromObject(final View view, final Object object) {
            return view == ((ImageView) object);
        }
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_gallery);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        final ImagePagerAdapter adapter = new ImagePagerAdapter();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                String positions = position + "";
                Toast.makeText(WizardActivity.this, positions, Toast.LENGTH_SHORT).show();

                if (positions.equals("3")) {
                    Intent loginIntent = new Intent().setClass(
                            WizardActivity.this, FacebookLoginActivity.class);
                    startActivity(loginIntent);

                    // Close the activity so the user won't able to go back this
                    // activity pressing Back button
                    finish();
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        viewPager.setAdapter(adapter);

        final CirclePageIndicator circleIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        circleIndicator.setViewPager(viewPager);

    }
}
