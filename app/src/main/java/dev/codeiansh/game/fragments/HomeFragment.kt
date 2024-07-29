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
import dev.codeiansh.game.rcv_adapters.HomeAdapter
import dev.codeiansh.game.rcv_adapters.HomeViewPagerAdapter
import dev.codeiansh.game.rcv_model.HomeModel
import dev.codeiansh.game.recommended.adapters.VpHomesAdapter
import dev.codeiansh.game.recommended.models.RecommendedHomesData
import dev.codeiansh.game.vp_adapters.HomeAdapterVP
import dev.codeiansh.game.vp_model.HomeModel_vp


class HomeFragment : Fragment() {

    private lateinit var recommendedViewPager: ViewPager2
    private lateinit var rcv_viewPager: ViewPager2
    private lateinit var rcvlist: List<HomeModel>
    private lateinit var viewPager: ViewPager2
    private lateinit var vpadapter: HomeAdapterVP
    private lateinit var imageList: List<HomeModel_vp>
    private lateinit var recommendedList: List<RecommendedHomesData>
    private var currentPage = 0
    private val handler = Handler(Looper.getMainLooper())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        imageList = listOf(
            HomeModel_vp(
                "1",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
            HomeModel_vp(
                "2",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
            HomeModel_vp(
                "3",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
            HomeModel_vp(
                "4",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
            HomeModel_vp(
                "5",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
            HomeModel_vp(
                "6",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
            HomeModel_vp(
                "7",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
        )
        rcvlist = listOf(
            HomeModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            HomeModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            HomeModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            HomeModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            HomeModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            HomeModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            HomeModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            HomeModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            HomeModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            HomeModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            HomeModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            HomeModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            HomeModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            HomeModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            HomeModel("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),

        )

         recommendedList = listOf(
            RecommendedHomesData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedHomesData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedHomesData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedHomesData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedHomesData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedHomesData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedHomesData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedHomesData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedHomesData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedHomesData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedHomesData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedHomesData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),
            RecommendedHomesData("name1", R.drawable.ic_launcher_background,"type1","rating1","size1"),

        )
        val pageSize = 3
//        for recommended Page
        val recPage = recommendedList.chunked(pageSize)
        recommendedViewPager = view.findViewById(R.id.recommended_viewPager2)
        val recAdapter = VpHomesAdapter(recPage)
        recommendedViewPager.adapter = recAdapter



        val page = rcvlist.chunked(pageSize)
        rcv_viewPager = view.findViewById(R.id.rcv_viewPager2)
        val adapter = HomeViewPagerAdapter(page)
        rcv_viewPager.adapter = adapter


        viewPager = view.findViewById(R.id.home_viewPager2)
        vpadapter = HomeAdapterVP()
        viewPager.adapter = vpadapter
        vpadapter.submitList(imageList)


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