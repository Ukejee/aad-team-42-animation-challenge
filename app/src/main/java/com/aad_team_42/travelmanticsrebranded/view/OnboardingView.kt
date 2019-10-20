package com.aad_team_42.travelmanticsrebranded.view

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.aad_team_42.travelmanticsrebranded.R
import com.aad_team_42.travelmanticsrebranded.views.activities.MainActivity
import kotlinx.android.synthetic.main.onboarding_view.view.*

class OnboardingView:FrameLayout,ViewPager.OnPageChangeListener {
    private val numberOfPages by lazy { OnboardingPage.values().size }
    constructor(context: Context) : super(context)
    {initializeUi(context)}
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)   {
        initializeUi(context)}
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)   {initializeUi(context)}

    private fun initializeUi(context: Context?) {
        LayoutInflater.from(context).inflate(R.layout.onboarding_view, this, true)

        setupListeners()
    }
    private fun setupListeners() {
        pagesList.addOnPageChangeListener(this)
        pageIndicator.setViewPager(pagesList)

//        previousButton.setOnClickListener { pagesList.setCurrentItem(pagesList.currentItem - 1, true) }
//        nextButton.setOnClickListener { pagesList.setCurrentItem(pagesList.currentItem + 1, true) }
        getting_started.setOnClickListener {
           context.startActivity(Intent(context,MainActivity::class.java));
        }
    }
    fun setAdapter(adapter: PagerAdapter) {
        pagesList.adapter = adapter
    }

    override fun onPageScrollStateChanged(state: Int)=Unit

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        if (numberOfPages > 1) {
            val newProgress = (position + positionOffset) / (numberOfPages - 1)

            onboardingRoot.progress = newProgress
        }
    }

    override fun onPageSelected(position: Int)=Unit
}