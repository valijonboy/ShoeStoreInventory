package uz.pop.shoestoreinventory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.pop.shoestoreinventory.model.Shoe

class ShoeViewModel : ViewModel() {

    private val shoesDetails = ArrayList<Shoe>()

    private val _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList

    init {
        _shoesList.value = ArrayList()
    }

    fun saveData(shoe: Shoe) {
        shoesDetails.add(shoe)
        _shoesList.value = shoesDetails
    }
}