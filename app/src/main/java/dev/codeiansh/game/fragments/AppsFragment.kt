package dev.codeiansh.game.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import dev.codeiansh.game.R
import dev.codeiansh.game.rcv_adapters.AppsAdapter
import dev.codeiansh.game.rcv_model.AppsModel
import dev.codeiansh.game.vp_adapters.AppsAdapter_vp
import dev.codeiansh.game.vp_model.AppsModel_vp


class AppsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var rcvadapter: AppsAdapter
    private lateinit var rcvlist: List<AppsModel>
    private lateinit var viewPager: ViewPager2
    private lateinit var vpadapter: AppsAdapter_vp
    private lateinit var imageList: List<AppsModel_vp>
    private var currentPage = 0
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_apps, container, false)


        imageList = listOf(
            AppsModel_vp(R.drawable.ic_app),
            AppsModel_vp(R.drawable.ic_games),
            AppsModel_vp(R.drawable.ic_homes)
        )
        rcvlist = listOf(
            AppsModel("name1", R.drawable.ic_launcher_background),
            AppsModel("name2", R.drawable.ic_launcher_background),
            AppsModel("name3", R.drawable.ic_launcher_background),
            AppsModel("name4", R.drawable.ic_launcher_background),
        )

        viewPager = view.findViewById(R.id.apps_viewPager2)
        vpadapter = AppsAdapter_vp(imageList)
        viewPager.adapter = vpadapter

        recyclerView = view.findViewById(R.id.apps_recyclerView)
        rcvadapter = AppsAdapter(rcvlist)
        recyclerView.adapter = rcvadapter
        recyclerView.layoutManager = GridLayoutManager(context, 2);

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