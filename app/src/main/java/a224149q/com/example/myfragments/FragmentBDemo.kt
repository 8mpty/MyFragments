package a224149q.com.example.myfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_b_demo.*

class FragmentBDemo : Fragment() {
    companion object {
        fun newInstance() = FragmentBDemo()
    }

    private var listener: FragmentBDemo.FragmentBButtonListener? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentBButtonListener){
            listener = context
        }else{
            throw RuntimeException(context.toString() + "must implement OnFragmentInteractionListener")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_b_demo, container, false)

        var fragmentBtn = v.findViewById<Button>(R.id.fragmentButton)

        fragmentBtn.setOnClickListener{
            var num = fragmentET.text.toString().toInt()

            listener?.onButtonClickListener(num)
        }
        return v
    }

    interface FragmentBButtonListener{
        fun onButtonClickListener(someNumber: Int);
    }
}