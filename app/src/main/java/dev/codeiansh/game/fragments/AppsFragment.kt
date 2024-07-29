package dev.codeiansh.game.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import dev.codeiansh.game.R
import dev.codeiansh.game.rcv_adapters.AppsViewPagerAdapter
import dev.codeiansh.game.rcv_model.AppsModel
import dev.codeiansh.game.recommended.adapters.VpAppsAdapter
import dev.codeiansh.game.recommended.models.RecommendedAppsData
import dev.codeiansh.game.vp_adapters.AppsAdapterVP
import dev.codeiansh.game.vp_model.AppsModel_vp

class AppsFragment : Fragment() {
    private lateinit var recommendedViewPager: ViewPager2
    private lateinit var rcv_viewPager: ViewPager2
    private lateinit var rcvlist: List<AppsModel>
    private lateinit var viewPager: ViewPager2
    private lateinit var vpadapter: AppsAdapterVP
    private lateinit var imageList: List<AppsModel_vp>
    private lateinit var recommendedList: List<RecommendedAppsData>
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
            AppsModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            AppsModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            AppsModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            AppsModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            AppsModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            AppsModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            AppsModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            AppsModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            AppsModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            AppsModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            AppsModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            AppsModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),

        )

         recommendedList = listOf(
            RecommendedAppsData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedAppsData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedAppsData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedAppsData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedAppsData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedAppsData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedAppsData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedAppsData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedAppsData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedAppsData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedAppsData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),

        )

//        For Recommendation Page
        val recPage = 3
        val recPages = recommendedList.chunked(recPage)

        recommendedViewPager = view.findViewById(R.id.recommended_viewPager2)
        val recAdapter = VpAppsAdapter(recPages)
        recommendedViewPager.adapter = recAdapter

//        For Suggested Page
        val pageSize = 3
        val pages = rcvlist.chunked(pageSize)

        rcv_viewPager = view.findViewById(R.id.rcv_viewPager2)
        val adapter = AppsViewPagerAdapter(pages)
        rcv_viewPager.adapter = adapter


        // Set up ViewPager2
        viewPager = view.findViewById(R.id.apps_viewPager2)
        vpadapter = AppsAdapterVP()
        viewPager.adapter = vpadapter
        vpadapter.submitList(imageList)

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
