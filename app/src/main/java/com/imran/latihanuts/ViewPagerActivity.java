package com.imran.latihanuts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;


/*
    Mohamad Imran 10117170 IF5
    Tanggal pengerjaan Selasa - Rabu 12-13 Mei
 */


public class ViewPagerActivity extends AppCompatActivity {

    private OnboardingAdapter onboardingAdapter;
    private LinearLayout layoutOnboardingIndicators;
    private MaterialButton buttonOnboardingAction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        layoutOnboardingIndicators = findViewById(R.id.layoutOnboardingIndicator);
        buttonOnboardingAction = findViewById(R.id.buttonOnboardingAction);

        setupOnboardingItems();
        final ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewPager);
        onboardingViewPager.setAdapter(onboardingAdapter);

        setupOnboardingIndicators();
        setCurrentOnboardingIndicator(0);

        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });
        buttonOnboardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onboardingViewPager.getCurrentItem() + 1 < onboardingAdapter.getItemCount()){
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem()+1);
                }else{
                    startActivity(new Intent(getApplicationContext(),Home.class));
                    finish();
                }
            }
        });
    }



    private void setupOnboardingItems() {
        List<OnboardingItem> onboardingItems = new ArrayList<>();
        OnboardingItem itemPayOnline = new OnboardingItem();
        itemPayOnline.setTitle("Selamat Datang");
        itemPayOnline.setDescription("di Aplikasi Biodata Saya");
        itemPayOnline.setImage(R.drawable.logo1);

        OnboardingItem itemOntheWay = new OnboardingItem();
        itemOntheWay.setTitle("Memilih Menu");
        itemOntheWay.setDescription("Gunakan Navigation Bar untuk memilih menu sesuai yang diinginkan");
        itemOntheWay.setImage(R.drawable.navbarrr);

        OnboardingItem itemEatTogether = new OnboardingItem();
        itemEatTogether.setTitle("Enjoy the Apps!");
        itemEatTogether.setDescription("Selamat menikmati aplikasinya!");
        itemEatTogether.setImage(R.drawable.vectorr);

        onboardingItems.add(itemPayOnline);
        onboardingItems.add(itemOntheWay);
        onboardingItems.add(itemEatTogether);

        onboardingAdapter = new OnboardingAdapter(onboardingItems);

    }

    private void setupOnboardingIndicators(){
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0,8,0);
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicators.addView(indicators[i]);
        }
    }

    private void setCurrentOnboardingIndicator(int index){
        int childCount = layoutOnboardingIndicators.getChildCount();
                for (int i = 0; i < childCount; i++){
                    ImageView imageView = (ImageView)layoutOnboardingIndicators.getChildAt(i);
                    if(i == index){
                        imageView.setImageDrawable(
                                ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_active)
                        );
                    } else {
                        imageView.setImageDrawable(
                                ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_inactive)
                        );
                    }
                }
                if(index==onboardingAdapter.getItemCount()-1){
                    buttonOnboardingAction.setText("Gas!!!");
                }else {
                    buttonOnboardingAction.setText("Lanjut");
                }
    }
}
