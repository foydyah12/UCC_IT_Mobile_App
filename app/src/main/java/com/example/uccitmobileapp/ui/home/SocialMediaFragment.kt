package com.example.uccitmobileapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.uccitmobileapp.R
import com.example.uccitmobileapp.SocialMediaPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class SocialMediaFragment : Fragment(R.layout.fragment_social_media) {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabLayout = view.findViewById(R.id.tabLayout)
        viewPager = view.findViewById(R.id.viewPager)

        // Setup ViewPager with adapter
        val adapter = SocialMediaPagerAdapter(this)
        viewPager.adapter = adapter

        // Tab titles in order
        val tabTitles = listOf("Instagram", "Facebook", "TikTok", "Twitter")

        // Attach TabLayout with ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}
