package buu.informatics.s59160586.newcarpark


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login_page.*

/**
 * A simple [Fragment] subclass.
 */
class login_page : Fragment() {
    var username = "admin"
    var password = "password"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login_button.setOnClickListener {
            val getUsername = username_text.text.toString()
            val getPassword = password_text.text.toString()

            if (checkLogin(getUsername, getPassword)) {
                findNavController().navigate(R.id.action_login_page_to_park_page)
            }
        }
    }

    fun checkLogin (username:String, password:String) : Boolean {
        if (username == "" || password == "") {
            Toast.makeText(getActivity(), "Please fill all field" , Toast.LENGTH_LONG).show()
            return false
        } else if (username != "admin" || password!= "password") {
            Toast.makeText(getActivity(), "Username or Password incorrect" , Toast.LENGTH_LONG).show()
            return false
        } else {
            return true
        }
    }




}
