package buu.informatics.s59160586.newcarpark

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_park_page.*






class park_page : Fragment() {
    var parking = listOf<ParkData>(ParkData() , ParkData() , ParkData())
    var pickSlot = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_park_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()

//        mainArea.setOnClickListener {
//            hideSoftKeyboard()
//        }
    }

    fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager!!.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
    }

    fun setListener () {
        var slotClick = listOf<TextView>(park1_button , park2_button , park3_button)
        for (i in slotClick) {
            i.setOnClickListener{
                fectInfo(i)
            }
        }
        update_button.setOnClickListener {
            setInfo()
        }

        delete_button.setOnClickListener {
            deleteInfo()
        }

    }

    fun fectInfo(view: TextView){

        pickSlot = view.id.toString()
        //Toast.makeText(this , pickSlot , Toast.LENGTH_SHORT).show()
        checkSlot()
        when(view.id){
            R.id.park1_button -> {
                carNum_text.requestFocus()
                carNum_text.setText(parking.get(0).carId)
                name_text.setText(parking.get(0).ownerName)
                brand_text.setText(parking.get(0).carBrand)
            }
            R.id.park2_button -> {
                carNum_text.requestFocus()
                carNum_text.setText(parking.get(1).carId)
                name_text.setText(parking.get(1).ownerName)
                brand_text.setText(parking.get(1).carBrand)
            }
            R.id.park3_button -> {
                carNum_text.requestFocus()
                carNum_text.setText(parking.get(2).carId)
                name_text.setText(parking.get(2).ownerName)
                brand_text.setText(parking.get(2).carBrand)
            }
        }
    }

    fun setInfo () {
        if(selected()){
            if(checkInput()){
                when (pickSlot){
                    R.id.park1_button.toString() -> {
                        parking[0].carId = carNum_text.text.toString()
                        parking[0].ownerName = name_text.text.toString()
                        parking[0].carBrand = brand_text.text.toString()
                    }
                    R.id.park2_button.toString() -> {
                        parking[1].carId = carNum_text.text.toString()
                        parking[1].ownerName = name_text.text.toString()
                        parking[1].carBrand = brand_text.text.toString()
                    }
                    R.id.park3_button.toString() -> {
                        parking[2].carId = carNum_text.text.toString()
                        parking[2].ownerName = name_text.text.toString()
                        parking[2].carBrand = brand_text.text.toString()
                    }
                }
                clearTextInput()
                Toast.makeText(getActivity(), "This is my Toast message!", Toast.LENGTH_LONG).show()
                checkSlot()
                pickSlot = ""
            }else{
                Toast.makeText(getActivity() , "Please fill all in put text. " , Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(getActivity() , "Please select parking slot." , Toast.LENGTH_SHORT).show()
        }
    }

    fun selected() : Boolean {
        if(pickSlot == ""){
            return false
        }else{
            return true
        }
    }

    fun clearTextInput() {
        var input = listOf<TextView>(carNum_text , name_text , brand_text)
        for (i in input){
            i.text = ""
        }
    }

    fun checkSlot() {
        for ( i in 0..parking.size-1){
            if(parking[i].ownerName != ""){
                if(i == 0){
                    park1_button.setText("Full")
                }else if(i == 1) {
                    park2_button.setText("Full")
                }else{
                    park3_button.setText("Full")
                }
            }else{
                if(i == 0){
                    park1_button.setText("Empty")
                }else if(i == 1) {
                    park2_button.setText("Empty")
                }else{
                    park3_button.setText("Empty")
                }
            }
        }
    }

    fun checkInput() : Boolean {
        var slotClick = listOf<TextView>(carNum_text , name_text , brand_text)
        var flag = true
        for (i in slotClick){
            if(i.text.toString() == ""){
                flag = false
                break
            }
        }

        return flag
    }

    fun deleteInfo() {
        when(pickSlot){

            R.id.park1_button.toString() ->{
                parking[0].carId = ""
                parking[0].ownerName = ""
                parking[0].carBrand = ""
            }
            R.id.park2_button.toString() ->{
                parking[1].carId = ""
                parking[1].ownerName = ""
                parking[1].carBrand = ""
            }
            R.id.park3_button.toString() ->{
                parking[2].carId = ""
                parking[2].ownerName = ""
                parking[2].carBrand = ""
            }

        }
        checkSlot()
        clearTextInput()
    }

}
