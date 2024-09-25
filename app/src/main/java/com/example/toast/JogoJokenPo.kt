package com.example.toast

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class JogoJokenPo : AppCompatActivity() {

    private lateinit var playerImageView: ImageView
    private lateinit var computerImageView: ImageView
    private lateinit var resultTextView: TextView
    private lateinit var playButton: Button

    private val choices = listOf("Pedra", "Papel", "Tesoura")
    var i=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_jogo_joken_po)

        playerImageView = findViewById(R.id.playerImageView)
        computerImageView = findViewById(R.id.computerImageView)
        resultTextView = findViewById(R.id.resultTextView)
        playButton = findViewById(R.id.playButton)

        playButton.setOnClickListener {
            playGame()
        }

        playerImageView.setOnClickListener{
            changeHand()
        }
    }

    private fun changeHand(){
        val currentHand = choices[i]
        i += 1
        
        if (i==3){
            i=0
        }

        // Exibe a escolha do computador
        when (currentHand) {
            "Pedra" -> playerImageView.setImageResource(R.drawable.hand_rock)
            "Papel" -> playerImageView.setImageResource(R.drawable.hand_paper)
            "Tesoura" -> playerImageView.setImageResource(R.drawable.hand_scissor)
        }
    }

    private fun playGame() {
        // Escolha aleatória do computador
        val computerChoice = choices[Random.nextInt(choices.size)]

        // Exibe a escolha do computador
        when (computerChoice) {
            "Pedra" -> computerImageView.setImageResource(R.drawable.hand_rock)
            "Papel" -> computerImageView.setImageResource(R.drawable.hand_paper)
            "Tesoura" -> computerImageView.setImageResource(R.drawable.hand_scissor)
        }

        // Define o resultado da partida
        val result = determineWinner(computerChoice)

        // Exibe o resultado
        resultTextView.text = result
    }

    private fun determineWinner(computerChoice: String): String {
        // Pega a escolha do jogador (implemente a escolha do jogador aqui)
        // Por exemplo, você pode usar um menu de seleção ou botões
        val playerChoice = "Pedra" // Substitua pela escolha do jogador

        // Verifica o resultado da partida
        when (playerChoice) {
            computerChoice -> return "Empate!"
            "Pedra" -> {
                if (computerChoice == "Tesoura") return "Você venceu!"
                else return "Você perdeu!"
            }
            "Papel" -> {
                if (computerChoice == "Pedra") return "Você venceu!"
                else return "Você perdeu!"
            }
            "Tesoura" -> {
                if (computerChoice == "Papel") return "Você venceu!"
                else return "Você perdeu!"
            }
        }
        return "Erro" // Caso o resultado seja inválido
    }

}