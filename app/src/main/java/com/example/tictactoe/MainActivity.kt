package com.example.tictactoe

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {


    var PLAYER = false
    var TURN_COUNT = 0
    var counter = 0

    var boardStatus = Array(3){IntArray(3)}
    lateinit var board: Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.BLACK))


        val resetbtn = findViewById<Button>(R.id.resetbtn)
        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)

        board = arrayOf(arrayOf(button,button2,button3), arrayOf(button4,button5,button6), arrayOf(button7,button8,button9))

        initialBoardStatus()

        for(i in board){
            for(button in i){
                button.setOnClickListener(this)

            }
        }

        resetbtn.setOnClickListener {
            PLAYER = true
            TURN_COUNT = 0
            initialBoardStatus()
            updateDisplay("Player Turn: X")

        }

    }


    private fun initialBoardStatus() {
        for(i in 0..2){
            for(j in 0..2){
                boardStatus[i][j] = -1
            }
        }

        for(i in board){
            for(b in i){
                b.isEnabled = true
                b.text = ""
            }
        }
    }


    override fun onClick(view: View) {
        val turn = findViewById<TextView>(R.id.displayTextView)
        when(view.id){
            R.id.button->{
                counter++
                updateValues(row=0,col=0,player = PLAYER)
            }
            R.id.button2->{
                counter++
                updateValues(row=0,col=1,player = PLAYER)
            }
            R.id.button3->{
                counter++
                updateValues(row=0,col=2,player = PLAYER)
            }
            R.id.button4->{
                counter++
                updateValues(row=1,col=0,player = PLAYER)
            }
            R.id.button5->{
                counter++
                updateValues(row=1,col=1,player = PLAYER)
            }
            R.id.button6->{
                counter++
                updateValues(row=1,col=2,player = PLAYER)
            }
            R.id.button7->{
                counter++
                updateValues(row=2,col=0,player = PLAYER)
            }
            R.id.button8->{
                counter++
                updateValues(row=2,col=1,player = PLAYER)
            }
            R.id.button9->{
                counter++
                updateValues(row=2,col=2,player = PLAYER)
            }
        }
        TURN_COUNT++

        PLAYER = !PLAYER
        if(TURN_COUNT==9){
            updateDisplay("Game Draw")
        }
        else if(PLAYER){
            updateDisplay("Player Turn: X")
        }else{
            updateDisplay("Player Turn: O")
        }
        checkWinner()
    }

    private fun updateDisplay(s: String) {
        val turn = findViewById<TextView>(R.id.displayTextView)
        turn.text = s
        if(s.contains("Winner")){
            disablebutton()
        }
    }

    private fun disablebutton() {
        for(i in board){
            for(button in i){
                button.isEnabled = false
            }
        }
    }

    private fun checkWinner() {
        val Winner = findViewById<TextView>(R.id.displayTextView)
        for(i in 0..2){
            if((boardStatus[i][0]==boardStatus[i][1]) && (boardStatus[i][0]==boardStatus[i][2])){
                if(boardStatus[i][0]==1){
                    updateDisplay("Player X: Winner")
                    break
                }
                else if(boardStatus[i][0]==0) {
                    updateDisplay("Player O: Winner")
                    break
                }
            }

        }

       for(i in 0..2){
           if((boardStatus[0][i]==boardStatus[1][i]) && (boardStatus[0][i]==boardStatus[2][i])){
               if(boardStatus[0][i]==1){
                   updateDisplay("Player X: Winner")
                   break
               }
               else if(boardStatus[0][i]==0) {
                   updateDisplay("Player O: Winner")
                   break
               }
           }

       }

       if((boardStatus[0][0]==boardStatus[1][1]) && (boardStatus[0][0]==boardStatus[2][2])){
           if(boardStatus[0][0]==1){
               updateDisplay("Player X: Winner")

           }
           else if(boardStatus[0][0]==0) {
               updateDisplay("Player O: Winner")

           }
       }

       if((boardStatus[0][2]==boardStatus[1][1]) && (boardStatus[0][2]==boardStatus[2][0])){
           if(boardStatus[0][2]==1){
               updateDisplay("Player X: Winner")

           }
           else if(boardStatus[0][2]==0) {
               updateDisplay("Player O: Winner")

           }
       }
    }


    private fun updateValues(row: Int, col: Int, player: Boolean){
        var t = ""
        t = if(player){
            "X"
        }else{
            "0"
        }
        val value = if(player) 1 else 0
        board[row][col].apply {
            isEnabled = false
            text = t
        }
        println("Value: "+value)
        boardStatus[row][col] = value
        println("Board status:- ${boardStatus[row][col]} ")
      //  checkWinner()
    }
}






