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
            "General",
            43.0,
            "PORTION",
            "5"
        )
        _snusState.value = SnusState.NONE
    }

    private fun addNewSnus(
        Name: String,
        Size: Double,
        Type: String,
        Description: String
    ) {
        var type: Snustype = Snustype.PORTION
        when(Type){
            Snustype.LOOSE.toString() -> type = Snustype.LOOSE
            Snustype.WHITEPORTION.toString() -> type = Snustype.WHITEPORTION
            Snustype.PORTION.toString() -> type = Snustype.PORTION
        }
        _snusList.value?.add(Snus(Name, Size, type, Description.toInt()))
    }

    fun onSnusSave(name: String, size: String, type: String, description: String) {
        var sizeToDouble: Double = 0.0
        try {
            sizeToDouble = size.toDouble()

        }
        catch (e: NumberFormatException){
            Timber.i("Invalid snus")
        }
        addNewSnus(name,sizeToDouble,type,description)

        _snusState.value = SnusState.SAVE
    }

    fun onSnusStateActionComplete() {

        _snusState.value = SnusState.NONE
    }


}
