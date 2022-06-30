package ru.dw.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.dw.composition.R
import ru.dw.composition.databinding.FragmentChooseLevelBinding
import ru.dw.composition.domain.entity.Level


class ChooseLevelFragment : Fragment() {
    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding == null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        choseGame()
    }

    private fun choseGame() {
        with(binding) {
            buttonLevelTest.setOnClickListener {
                launchGameLevelFragment(Level.TEST)
            }
            buttonLevelEasy.setOnClickListener {
                launchGameLevelFragment(Level.EASY)
            }
            buttonLevelNormal.setOnClickListener {
                launchGameLevelFragment(Level.NORMAL)
            }
            buttonLevelHard.setOnClickListener {
                launchGameLevelFragment(Level.HARD)
            }
        }
    }

    private fun launchGameLevelFragment(level: Level) {
        val args = Bundle().apply {
            putParcelable(GameFragment.KEY_LEVEL, level)
        }
        findNavController().navigate(R.id.action_chooseLevelFragment2_to_gameFragment,args)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val NAME = "ChooseLevelFragment"
        fun newInstance(): ChooseLevelFragment {
            return ChooseLevelFragment()
        }
    }
}
