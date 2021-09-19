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
            scaleIv(it)
            playGame()
            binding.tvScore.text = "Score Player : $player\nComputer :$computer"

        }
        binding.llScissorsPlayer.setOnClickListener {
            scaleIv(it)
            playGame()
            binding.tvScore.text = "Score Player : $player\nComputer :$computer"

        }
        binding.llPaperPlayer.setOnClickListener {
            scaleIv(it)
            playGame()
            binding.tvScore.text = "Score Player : $player\nComputer :$computer"

        }

        binding.ivReset.setOnClickListener {
            finish()
            startActivity((intent))
        }


    }

    private fun scaleIv(args: Any) {
        when {
            args === binding.llRockPlayer -> {
                binding.llRockPlayer.scaleX = "0.85".toFloat()
                binding.llRockPlayer.scaleY = "0.85".toFloat()

                // Button PAPER and ROCK scale reset
                binding.llPaperPlayer.scaleX = "1".toFloat()
                binding.llPaperPlayer.scaleY = "1".toFloat()
                binding.llScissorsPlayer.scaleX = "1".toFloat()
                binding.llScissorsPlayer.scaleY = "1".toFloat()

            }
            args === binding.llPaperPlayer -> {
                binding.llPaperPlayer.scaleX = "0.85".toFloat()
                binding.llPaperPlayer.scaleY = "0.85".toFloat()

                // Button ROCK and SCISSORS scale reset
                binding.llRockPlayer.scaleX = "1".toFloat()
                binding.llRockPlayer.scaleY = "1".toFloat()
                binding.llScissorsPlayer.scaleX = "1".toFloat()
                binding.llScissorsPlayer.scaleY = "1".toFloat()

            }
            args === binding.llScissorsPlayer -> {
                binding.llScissorsPlayer.scaleX = "0.85".toFloat()
                binding.llScissorsPlayer.scaleY = "0.85".toFloat()

                // Button ROCK and PAPER scale reset
                binding.llRockPlayer.scaleX = "1".toFloat()
                binding.llRockPlayer.scaleY = "1".toFloat()
                binding.llPaperPlayer.scaleX = "1".toFloat()
                binding.llPaperPlayer.scaleY = "1".toFloat()
            }
            else -> resetChoice()
        }
    }

    private fun resetChoice() {
        binding.llRockPlayer.scaleX = "1".toFloat()
        binding.llRockPlayer.scaleY = "1".toFloat()
        binding.llPaperPlayer.scaleX = "1".toFloat()
        binding.llPaperPlayer.scaleY = "1".toFloat()
        binding.llScissorsPlayer.scaleX = "1".toFloat()
        binding.llScissorsPlayer.scaleY = "1".toFloat()
    }

    override fun playGame() {
        val playerChoice = String()
        val machineCombos = listOf("ROCK", "SCISSORS", "PAPER")
        val machineChoseNum = (0..2).random() % 3
        when {
            (machineCombos[machineChoseNum]) === "ROCK" -> {
                binding.ivComChoice.setImageResource(R.drawable.rock)


            }
            (machineCombos[machineChoseNum]) === "SCISSORS" -> {
                binding.ivComChoice.setImageResource(R.drawable.scissors)

            }
            (machineCombos[machineChoseNum]) === "PAPER" -> {
                binding.ivComChoice.setImageResource(R.drawable.paper)

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
                        player++
                    }
                    else -> {
                        showResult(1)
                        computer++

                    }
                }
            }
            "PAPER" -> {
                when (playerChoice) {
                    "ROCK" -> {
                        showResult(1)
                        computer++

                    }
                    "PAPER" -> {
                        showResult(2)
                    }
                    else -> {
                        showResult(0)
                        player++
                    }
                }
            }
            else -> {
                when (playerChoice) {
                    "ROCK" -> {
                        showResult(0)
                        player++
                    }
                    "PAPER" -> {
                        showResult(1)
                        computer++

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


            }
            1 -> {
                binding.ivInfo.setImageResource(R.drawable.com_win)


            }
            2 -> {
                binding.ivInfo.setImageResource(R.drawable.draw)


            }


        }

    }

}






