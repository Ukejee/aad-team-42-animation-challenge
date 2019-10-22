package com.aad_team_42.travelmanticsrebranded.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aad_team_42.travelmanticsrebranded.R
import com.aad_team_42.travelmanticsrebranded.adapters.OnboardingAdapter
import com.aad_team_42.travelmanticsrebranded.view.OnboardingPage
import com.aad_team_42.travelmanticsrebranded.view.OnboardingPageView
import kotlinx.android.synthetic.main.onboarding.*

class OnboardingActivity : BaseActivity(){

    private val adapter = OnboardingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding)

        val data = OnboardingPage
                .values()
                .map { onboardingPageData ->
                    val pageView = OnboardingPageView(this)
                    pageView.setPageData(onboardingPageData)

                    pageView
                }

        adapter.setData(data)
        onboardingView.setAdapter(adapter)
    }
}