package android.example.snuscollectorapp.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber
import java.lang.NumberFormatException

enum class SnusState {
    NONE,
    SAVE

}

class SnusViewModel : ViewModel() {
    private var _snusList = MutableLiveData<MutableList<Snus>>()
    val snusList: LiveData<MutableList<Snus>>
        get() = _snusList

    private var _snusState = MutableLiveData<SnusState>()
    val snusState: LiveData<SnusState>
        get() = _snusState

    init {
        _snusList.value = mutableListOf()
        addNewSnus(
            "Göteborgs Rapé",
            43.0,
            "PORTION",
            "5"
        )
        _snusState.value = SnusState.NONE
    }

    private fun addNewSnus(
        Name: String,
        Size: Double,
        Company: String,
        Description: String
    ) {
        var company: Snustype = Snustype.PORTION
        when(Company){
            Snustype.LOOSE.toString() -> company = Snustype.LOOSE
            Snustype.WHITEPORTION.toString() -> company = Snustype.WHITEPORTION
            Snustype.PORTION.toString() -> company = Snustype.PORTION
        }
        _snusList.value?.add(Snus(Name, Size, company, Description.toInt()))
    }

    fun onSnusSave(name: String, size: String, company: String, description: String) {
        var sizeToDouble: Double = 0.0
        try {
            sizeToDouble = size.toDouble()

        }
        catch (e: NumberFormatException){
            Timber.i("Invalid size for snus")
        }
        addNewSnus(name,sizeToDouble,company,description)

        _snusState.value = SnusState.SAVE
    }

    fun onSnusStateActionComplete() {

        _snusState.value = SnusState.NONE
    }


}
