package a224149q.com.example.myfragments

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), FragmentBDemo.FragmentBButtonListener {
    var sum = 0
    override fun onButtonClickListener(someNumber: Int) {
        var oldSum = sum
        sum += someNumber
        var msg = "Adding $someNumber to $oldSum gives u $sum"
//        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()

        DialogShowFragment.newInstance(msg).show(supportFragmentManager, "DialogDisplayMsg")
    }
    var fragmentManager: FragmentManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        setContentView(R.layout.alternate_fragment)
        fragmentManager = supportFragmentManager
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.quitMenuItem){
            AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Close Session")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes", object: DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        finish()
                    }
                })
                .setNegativeButton("Cancel", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        dialog?.cancel()
                    }
                }).show()
        }
        return super.onOptionsItemSelected(item)
    }
    fun runFragmentA(v: View){
        // Creates a new fragment
        var fragment = FragmentADemo.newInstance()

        // Make use of the fragment within fragmentmanager
        var frag_transaction = fragmentManager?.beginTransaction()

        //Replace existing (if any) fragment that is within fragment_container and give it a tag "frag_A"
        frag_transaction?.replace(R.id.fragment_container, fragment, "frag_A")

        //Add transaction to backstack
        frag_transaction?.addToBackStack(null)

        //Commit transaction
        frag_transaction?.commit()
    }
    fun runFragmentB(v: View){
        var frag_transaction = fragmentManager?.beginTransaction()
        var fragment = FragmentBDemo.newInstance()
        frag_transaction?.replace(R.id.fragment_container, fragment, "frag_B")
        frag_transaction?.addToBackStack(null)
        frag_transaction?.commit()
    }
    fun runToggle(v: View){
//        var fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        var fragment = supportFragmentManager.findFragmentByTag("frag_A")

        if(fragment != null && fragment is FragmentADemo){
            (fragment as FragmentADemo).toggleSumDisplayVisibility()
        }else{
            if(fragment != null){
                Toast.makeText(this,"Fragment is null", Toast.LENGTH_LONG).show()
            }else if(!(fragment is FragmentADemo)){
                Toast.makeText(this, "Fragment is not Fragment A !", Toast.LENGTH_LONG).show()
            }
        }
    }
}