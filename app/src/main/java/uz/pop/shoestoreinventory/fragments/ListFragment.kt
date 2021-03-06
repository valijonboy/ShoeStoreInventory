package uz.pop.shoestoreinventory.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import uz.pop.shoestoreinventory.R
import uz.pop.shoestoreinventory.ShoeViewModel
import uz.pop.shoestoreinventory.databinding.FragmentListBinding
import uz.pop.shoestoreinventory.databinding.ShoeItemBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel by activityViewModels<ShoeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list,
            container, false
        )

        binding.lifecycleOwner = this

        viewModel.shoesList.observe(viewLifecycleOwner, { newShoe ->

            newShoe.forEach { shoe ->
                val shoeItems: ShoeItemBinding = DataBindingUtil.inflate(
                    inflater, R.layout.shoe_item,
                    container, false
                )
                shoeItems.tvName.text = shoe.name
                shoeItems.tvCompany.text = shoe.company
                shoeItems.tvSize.text = shoe.size
                shoeItems.tvDescription.text = shoe.description

                shoeItems.executePendingBindings()

                binding.shoeInventory.addView(shoeItems.root)
            }

        })
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            findNavController().navigate(ListFragmentDirections.actionToDetailsFragment())

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout_menu ->
                findNavController().navigate(ListFragmentDirections.actionListFragmentToLoginFragment())
        }
        return super.onOptionsItemSelected(item)
    }
}