package a224149q.com.example.myfragments

import android.graphics.Paint.Style
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class DialogShowFragment : DialogFragment() {
    var displayMsg : String ?= null
    companion object{
        fun newInstance(msg: String) : DialogShowFragment{
            val fragment = DialogShowFragment()

            fragment.setStyle(STYLE_NORMAL, R.style.DialogShowFragment)
            fragment?.displayMsg = msg

            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_dialog_show, container, false)
        var displayMsgTv = v.findViewById<TextView>(R.id.displayMsgTv)
        displayMsgTv.text = displayMsg?: "No msg to display"

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog?.setTitle("Number Added")
    }
}