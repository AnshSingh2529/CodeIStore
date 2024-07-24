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
import dev.codeiansh.game.rcv_adapters.GamesAdapter
import dev.codeiansh.game.rcv_model.GamesModel
import dev.codeiansh.game.vp_adapters.GamesAdapterVP
import dev.codeiansh.game.vp_model.GamesModel_vp


class GameFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var rcvadapter: GamesAdapter
    private lateinit var rcvlist: List<GamesModel>
    private lateinit var viewPager: RecyclerView
    private lateinit var vpadapter: GamesAdapterVP
    private lateinit var imageList: List<GamesModel_vp>
    private var currentPage = 0
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game, container, false)

        imageList = listOf(
            GamesModel_vp(
                "1",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
            GamesModel_vp(
                "2",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
            GamesModel_vp(
                "3",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
            GamesModel_vp(
                "4",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
            GamesModel_vp(
                "5",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
            GamesModel_vp(
                "6",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
            GamesModel_vp(
                "7",
                "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=800"
            ),
        )
        rcvlist = listOf(
            GamesModel("name1", R.drawable.ic_launcher_background),
            GamesModel("name2", R.drawable.ic_launcher_background),
            GamesModel("name3", R.drawable.ic_launcher_background),
            GamesModel("name4", R.drawable.ic_launcher_background),
        )

        viewPager = view.findViewById(R.id.games_viewPager2)
        vpadapter = GamesAdapterVP()
        viewPager.adapter = vpadapter
        vpadapter.submitList(imageList)

        recyclerView = view.findViewById(R.id.games_recyclerView)
        rcvadapter = GamesAdapter(rcvlist)
        recyclerView.adapter = rcvadapter
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
//        handler.postDelayed(runnable, 3000)
        return view
    }

//    private val runnable = object : Runnable {
//        override fun run() {
//            if (currentPage == vpadapter.itemCount) {
//                currentPage = 0
//            }
//            viewPager.setCurrentItem(currentPage++, true)
//            handler.postDelayed(this, 3000)
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        handler.removeCallbacks(runnable)
//    }

}