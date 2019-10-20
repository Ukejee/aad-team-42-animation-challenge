package com.aad_team_42.travelmanticsrebranded.adapters

import android.view.View
import android.view.ViewGroup
import com.aad_team_42.travelmanticsrebranded.view.OnboardingPageView
import androidx.viewpager.widget.PagerAdapter as PagerAdapter

class OnboardingAdapter: PagerAdapter() {
    private val items = mutableListOf<OnboardingPageView>()
    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view==`object`
    }

    override fun getCount(): Int = items.size

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val item = items[position]
        container.addView(item)
        return item
    }

    fun setData(pages: List<OnboardingPageView>) {
        this.items.clear()
        this.items.addAll(pages)
        notifyDataSetChanged()
    }
}