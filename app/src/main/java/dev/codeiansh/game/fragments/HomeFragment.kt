package dev.codeiansh.game.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import dev.codeiansh.game.R
import dev.codeiansh.game.rcv_adapters.HomeAdapter
import dev.codeiansh.game.rcv_model.HomeModel
import dev.codeiansh.game.vp_adapters.HomeAdapter_vp
import dev.codeiansh.game.vp_model.HomeModel_vp


class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var rcvadapter: HomeAdapter
    private lateinit var rcvlist: List<HomeModel>
    private lateinit var viewPager: ViewPager2
    private lateinit var vpadapter: HomeAdapter_vp
    private lateinit var imageList: List<HomeModel_vp>
    private var currentPage = 0
    private val handler = Handler(Looper.getMainLooper())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        imageList = listOf(
            HomeModel_vp(R.drawable.ic_app),
            HomeModel_vp(R.drawable.ic_games),
            HomeModel_vp(R.drawable.ic_homes)
        )
        rcvlist = listOf(
            HomeModel("name1", R.drawable.ic_launcher_background),
            HomeModel("name2", R.drawable.ic_launcher_background),
            HomeModel("name3", R.drawable.ic_launcher_background),
            HomeModel("name4", R.drawable.ic_launcher_background),
        )

        viewPager = view.findViewById(R.id.home_viewPager2)
        vpadapter = HomeAdapter_vp(imageList)
        viewPager.adapter = vpadapter

        recyclerView = view.findViewById(R.id.home_recyclerView)
        rcvadapter = HomeAdapter(rcvlist)
        recyclerView.adapter = rcvadapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);

        handler.postDelayed(runnable, 3000)
        return view
    }

    private val runnable = object : Runnable {
        override fun run() {
            if (currentPage == vpadapter.itemCount) {
                currentPage = 0
            }
            viewPager.setCurrentItem(currentPage++, true)
            handler.postDelayed(this, 3000)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(runnable)
    }
}