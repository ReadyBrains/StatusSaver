package com.example.apoorv.whatsapp.Fragments

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.*
import com.example.apoorv.whatsapp.R
import com.example.apoorv.whatsapp.ViewPagerAdapter
import com.example.apoorv.whatsapp.CustomViewPager


class StatusFragment : Fragment() {

    var videoFragment: StatusVideoFragment ?=null
    var imageFragment: StatusImageFragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_status, container, false)
        // Setting ViewPager for each Tabs
        val viewPager = view.findViewById(R.id.status_viewpager) as CustomViewPager
        viewPager!!.offscreenPageLimit = 2
        setupViewPager(viewPager!!)
        // Set Tabs inside Toolbar
        val tabLayout = view.findViewById(R.id.status_tablayout) as TabLayout
        tabLayout.setTabTextColors(
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorTextPrimary)
        )
        tabLayout.setupWithViewPager(viewPager)
        viewPager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                tabLayout!!.getTabAt(position)!!.select()

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
        return view

    }


    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        videoFragment = StatusVideoFragment()
        imageFragment= StatusImageFragment()
        adapter.addFragment(imageFragment!!,"Image")
        adapter.addFragment(videoFragment!!, "Video")
        viewPager.adapter = adapter
    }


}