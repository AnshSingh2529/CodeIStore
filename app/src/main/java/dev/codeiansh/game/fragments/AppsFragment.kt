package dev.codeiansh.game.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import dev.codeiansh.game.R
import dev.codeiansh.game.rcv_adapters.AppsAdapter
import dev.codeiansh.game.rcv_model.AppsModel
import dev.codeiansh.game.vp_adapters.AppsAdapterVP
import dev.codeiansh.game.vp_model.AppsModel_vp

class AppsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var rcvadapter: AppsAdapter
    private lateinit var rcvlist: List<AppsModel>
    private lateinit var viewPager: ViewPager2
    private lateinit var vpadapter: AppsAdapterVP
    private lateinit var imageList: List<AppsModel_vp>
    private var currentPage = 0
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_apps, container, false)

        // Initialize image list for ViewPager2
        imageList = listOf(
            AppsModel_vp(
                "1",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
            AppsModel_vp(
                "2",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
            AppsModel_vp(
                "3",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
            AppsModel_vp(
                "4",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
            AppsModel_vp(
                "5",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
            AppsModel_vp(
                "6",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            )
        )

        // Initialize recycler view list
        rcvlist = listOf(
            AppsModel("name1", R.drawable.ic_launcher_background),
            AppsModel("name2", R.drawable.ic_launcher_background),
            AppsModel("name3", R.drawable.ic_launcher_background),
            AppsModel("name4", R.drawable.ic_launcher_background),
            AppsModel("name5", R.drawable.ic_launcher_background),
            AppsModel("name6", R.drawable.ic_launcher_background),
            AppsModel("name7", R.drawable.ic_launcher_background),
            AppsModel("name8", R.drawable.ic_launcher_background),
            AppsModel("name9", R.drawable.ic_launcher_background)
        )

        // Set up ViewPager2
        viewPager = view.findViewById(R.id.apps_viewPager2)
        vpadapter = AppsAdapterVP()
        viewPager.adapter = vpadapter
        vpadapter.submitList(imageList)

        // Set up RecyclerView
        recyclerView = view.findViewById(R.id.apps_recyclerView)
        rcvadapter = AppsAdapter(rcvlist)
        recyclerView.adapter = rcvadapter
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        // Auto-scroll ViewPager2
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
