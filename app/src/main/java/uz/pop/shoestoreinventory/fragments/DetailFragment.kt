package uz.pop.shoestoreinventory.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import uz.pop.shoestoreinventory.R
import uz.pop.shoestoreinventory.ShoeViewModel
import uz.pop.shoestoreinventory.databinding.FragmentDetailsBinding
import uz.pop.shoestoreinventory.model.Shoe

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
      binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        binding.shoe = Shoe()

        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
       val shoes = binding.shoe!!

        binding.buttonSave.setOnClickListener {
            if (shoes.name.isEmpty() || shoes.company.isEmpty() ||
                    shoes.size.isEmpty() || shoes.description.isEmpty()){
                view?.let { it1 -> Snackbar.make(it1, "Please, enter all fields!", Snackbar.LENGTH_SHORT).show() }
            }else{
                viewModel.saveData(shoes)
                findNavController().navigate(R.id.action_detailsFragment_to_listFragment)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       binding.buttonCansel.setOnClickListener  {
            findNavController().navigate(R.id.action_detailsFragment_to_listFragment)
        }
    }
}