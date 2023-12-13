package a224149q.com.example.myfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

var sumDisplay : TextView?= null
class FragmentADemo : Fragment() {
    companion object {
        fun newInstance() = FragmentADemo()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_a_demo, container, false)
        sumDisplay = v.findViewById<TextView>(R.id.sumDisplayTv)
        sumDisplay?.visibility = View.INVISIBLE
        var sum = (activity as MainActivity).sum
        sumDisplay?.text = "Current Sum is $sum"

        return v
    }

    fun toggleSumDisplayVisibility(){
        if(sumDisplay?.visibility == View.VISIBLE){
            sumDisplay?.visibility = View.VISIBLE
        }else{
            sumDisplay?.visibility = View.VISIBLE
        }
    }
}