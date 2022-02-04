package android.example.snuscollectorapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Snus(
    var name: String, private var cost: Double, private var type: Snustype, private var strength: Int
) : Parcelable {

    fun getType(): String {
        return type.toString()
    }
    fun setType(input:String){
        when(input){
            Snustype.LOOSE.toString() -> type = Snustype.LOOSE
            Snustype.WHITEPORTION.toString() -> type = Snustype.WHITEPORTION
            Snustype.PORTION.toString() -> type = Snustype.PORTION
        }
    }



    fun getCost(): String {
        return cost.toString()
    }
    fun setCost(input:String){
        cost = input.toDouble()
    }
    fun getStrength(): String {
        return strength.toString()
    }
    fun setStrength(input:String){
        strength = input.toInt()
    }


}