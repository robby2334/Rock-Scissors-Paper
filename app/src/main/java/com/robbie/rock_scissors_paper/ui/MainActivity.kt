package com.robbie.rock_scissors_paper.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.robbie.rock_scissors_paper.R
import com.robbie.rock_scissors_paper.databinding.ActivityMainBinding
import com.robbie.rock_scissors_paper.utils.Game

open class MainActivity : AppCompatActivity(), Game {
    private lateinit var binding: ActivityMainBinding
    private var player = 0
    private var computer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        playerElements()


    }

    @SuppressLint("SetTextI18n")
    fun playerElements() {
        binding.llRockPlayer.setOnClickListener {
            scaleIvPlayer(it)
            playGame()
            binding.tvScore.text = "Score Player : $player\nComputer :$computer"

        }
        binding.llScissorsPlayer.setOnClickListener {
            scaleIvPlayer(it)
            playGame()
            binding.tvScore.text = "Score Player : $player\nComputer :$computer"

        }
        binding.llPaperPlayer.setOnClickListener {
            scaleIvPlayer(it)
            playGame()
            binding.tvScore.text = "Score Player : $player\nComputer :$computer"


        }
        binding.ivReset.setOnClickListener {
            reset()
        }

    }


    private fun scaleIvPlayer(args: Any) {
        when {
            args === binding.llRockPlayer-> {
                binding.llRockPlayer.scaleX = "0.85".toFloat()
                binding.llRockPlayer.scaleY = "0.85".toFloat()

                // Button PAPER and ROCK scale reset
                binding.llPaperPlayer.scaleX = "1.2".toFloat()
                binding.llPaperPlayer.scaleY = "1.2".toFloat()
                binding.llScissorsPlayer.scaleX = "1.2".toFloat()
                binding.llScissorsPlayer.scaleY = "1.2".toFloat()

            }
            args === binding.llPaperPlayer -> {
                binding.llPaperPlayer.scaleX = "0.85".toFloat()
                binding.llPaperPlayer.scaleY = "0.85".toFloat()

                // Button ROCK and SCISSORS scale reset
                binding.llRockPlayer.scaleX = "1.2".toFloat()
                binding.llRockPlayer.scaleY = "1.2".toFloat()
                binding.llScissorsPlayer.scaleX = "1.2".toFloat()
                binding.llScissorsPlayer.scaleY = "1.2".toFloat()

            }
            args === binding.llScissorsPlayer -> {
                binding.llScissorsPlayer.scaleX = "0.85".toFloat()
                binding.llScissorsPlayer.scaleY = "0.85".toFloat()

                // Button ROCK and PAPER scale reset
                binding.llRockPlayer.scaleX = "1.2".toFloat()
                binding.llRockPlayer.scaleY = "1.2".toFloat()
                binding.llPaperPlayer.scaleX = "1.2".toFloat()
                binding.llPaperPlayer.scaleY = "1.2".toFloat()
            }
            else -> resetChoicePlayer()
        }
    }

    private fun resetChoicePlayer() {
        binding.llRockPlayer.scaleX = "1.2".toFloat()
        binding.llRockPlayer.scaleY = "1.2".toFloat()
        binding.llPaperPlayer.scaleX = "1.2".toFloat()
        binding.llPaperPlayer.scaleY = "1.2".toFloat()
        binding.llScissorsPlayer.scaleX = "1.2".toFloat()
        binding.llScissorsPlayer.scaleY = "1.2".toFloat()
    }

    private fun scaleIvCom(args: Any) {
        when {
            args === binding.llRockCom -> {
                binding.llRockCom.scaleX = "0.85".toFloat()
                binding.llRockCom.scaleY = "0.85".toFloat()

                // Button PAPER and ROCK scale reset
                binding.llPaperCom.scaleX = "1.2".toFloat()
                binding.llPaperCom.scaleY = "1.2".toFloat()
                binding.llScissorsCom.scaleX = "1.2".toFloat()
                binding.llScissorsCom.scaleY = "1.2".toFloat()

            }
            args === binding.llPaperCom -> {
                binding.llPaperCom.scaleX = "0.85".toFloat()
                binding.llPaperCom.scaleY = "0.85".toFloat()

                // Button ROCK and SCISSORS scale reset
                binding.llRockCom.scaleX = "1.2".toFloat()
                binding.llRockCom.scaleY = "1.2".toFloat()
                binding.llScissorsCom.scaleX = "1.2".toFloat()
                binding.llScissorsCom.scaleY = "1.2".toFloat()

            }
            args === binding.llScissorsCom -> {
                binding.llScissorsCom.scaleX = "0.85".toFloat()
                binding.llScissorsCom.scaleY = "0.85".toFloat()

                // Button ROCK and PAPER scale reset
                binding.llRockCom.scaleX = "1.2".toFloat()
                binding.llRockCom.scaleY = "1.2".toFloat()
                binding.llPaperCom.scaleX = "1.2".toFloat()
                binding.llPaperCom.scaleY = "1.2".toFloat()
            }
            else -> resetChoiceCom()
        }
    }

    private fun resetChoiceCom() {
        binding.llRockCom.scaleX = "1.2".toFloat()
        binding.llRockCom.scaleY = "1.2".toFloat()
        binding.llPaperCom.scaleX = "1.2".toFloat()
        binding.llPaperCom.scaleY = "1.2".toFloat()
        binding.llScissorsCom.scaleX = "1.2".toFloat()
        binding.llScissorsCom.scaleY = "1.2".toFloat()
    }

    override fun playGame() {

        val playerChoice = String()
        val machineCombos = listOf("ROCK", "SCISSORS", "PAPER")

        val machineChoseNum = (0..2).random() % 3
        when {
            (machineCombos[machineChoseNum]) === "ROCK" -> {
                scaleIvCom(binding.llRockCom)


            }
            (machineCombos[machineChoseNum]) === "SCISSORS" -> {
                scaleIvCom(binding.llScissorsCom)


            }
            (machineCombos[machineChoseNum]) === "PAPER" -> {
                scaleIvCom(binding.llPaperCom)


            }

        }


        when (machineCombos[machineChoseNum]) {
            "ROCK" -> {
                when (playerChoice) {
                    "ROCK" -> {
                        showResult(2)
                    }
                    "PAPER" -> {
                        showResult(0)
                    }
                    else -> {
                        showResult(1)

                    }
                }
            }
            "PAPER" -> {
                when (playerChoice) {
                    "ROCK" -> {
                        showResult(1)

                    }
                    "PAPER" -> {
                        showResult(2)
                    }
                    else -> {
                        showResult(0)
                    }
                }
            }
            else -> {
                when (playerChoice) {
                    "ROCK" -> {
                        showResult(0)
                    }
                    "PAPER" -> {
                        showResult(1)

                    }
                    else -> {
                        showResult(2)
                    }
                }
            }
        }
    }


    private fun showResult(result: Int) {
        when (result) {
            0 -> {
                binding.ivInfo.setImageResource(R.drawable.p1win)
                player++


            }
            1 -> {
                binding.ivInfo.setImageResource(R.drawable.draw)


            }
            2 -> {
                binding.ivInfo.setImageResource(R.drawable.com_win)
                computer++


            }


        }

    }

    @SuppressLint("SetTextI18n")
    private fun reset() {
        player = 0
        computer = 0
        binding.tvScore.text = "Score Player : $player\nComputer :$computer"
        binding.ivInfo.setImageResource(0)
        playerElements()
        resetChoicePlayer()
        resetChoiceCom()


    }


}






