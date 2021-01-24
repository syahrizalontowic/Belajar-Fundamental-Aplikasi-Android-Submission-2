package com.syahrizal.submissiondua.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.syahrizal.submissiondua.ui.fragment.FollowerFragment
import com.syahrizal.submissiondua.ui.fragment.FollowingFragment
import com.syahrizal.submissiondua.ui.fragment.RepositoryFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return RepositoryFragment()
            1 -> return FollowerFragment()
            2 -> return FollowingFragment()
        }
        return RepositoryFragment()
    }

}