package com.example.uccitmobileapp

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.uccitmobileapp.ui.home.FacebookFragment
import com.example.uccitmobileapp.ui.home.InstagramFragment
import com.example.uccitmobileapp.ui.home.TikTokFragment
import com.example.uccitmobileapp.ui.home.TwitterFragment

class SocialMediaPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> InstagramFragment()
            1 -> FacebookFragment()
            2 -> TikTokFragment()
            3 -> TwitterFragment()
            else -> InstagramFragment()
        }
    }
}
