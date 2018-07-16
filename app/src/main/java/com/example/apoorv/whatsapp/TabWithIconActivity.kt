package com.example.apoorv.whatsapp

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import com.example.apoorv.whatsapp.Fragments.FilesFragment
import com.example.apoorv.whatsapp.Fragments.StatusFragment
import com.example.apoorv.whatsapp.Fragments.SavedFragment
import com.example.apoorv.whatsapp.R
import com.example.apoorv.whatsapp.ViewPagerAdapter


class TabWithIconActivity : AppCompatActivity() {

    //This is our tablayout
    private var tabLayout: TabLayout? = null

    //This is our viewPager
    private var viewPager: ViewPager? = null

    var adapter: ViewPagerAdapter? = null

    //Fragments

    var filesFragment: FilesFragment? = null
    var statusFragment: StatusFragment? = null
    var savedFragment: SavedFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_with_icon)
        //Initializing viewPager
        viewPager = findViewById(R.id.main_viewpager) as ViewPager
        viewPager!!.offscreenPageLimit = 3
        setupViewPager(viewPager!!)

        //Initializing the tablayout
        tabLayout = findViewById(R.id.main_tablayout) as TabLayout

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.setCurrentItem(tab.position, false)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        viewPager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                tabLayout!!.getTabAt(position)!!.select()

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_all, menu)
        // Associate searchable configuration with the SearchView
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.itemId) {
            R.id.action_about -> {
                Toast.makeText(this, "About Click", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_rate -> {
                Toast.makeText(this, "Rate us Click", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_exit -> {
                Toast.makeText(this, "Exit Click", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        statusFragment = StatusFragment()
        filesFragment = FilesFragment()
        savedFragment = SavedFragment()
        adapter.addFragment(statusFragment!!, "STATUS")
        adapter.addFragment(savedFragment!!, "SAVED")
        adapter.addFragment(filesFragment!!, "FILES")
        viewPager.adapter = adapter
    }

}