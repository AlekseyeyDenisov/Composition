package ru.dw.composition.presentation.binding_adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import ru.dw.composition.R
import ru.dw.composition.domain.entity.GameResult

@BindingAdapter("requiredAnswer")
fun bindRequiredAnswers(textView: TextView,count:Int){
    textView.text = String.format(
        textView.context.getString(R.string.required_score),
        count
    )
}
@BindingAdapter("score")
fun bindScore(textView: TextView,score:Int){
    textView.text = String.format(
        textView.context.getString(R.string.score_answers),
        score
    )
}
@BindingAdapter("requiredPercentage")
fun bindRequiredPercentage(textView: TextView,count:Int){
    textView.text = String.format(
        textView.context.getString(R.string.required_percentage),
        count
    )
}
@BindingAdapter("scorePercentage")
fun bindScorePercentage(textView: TextView,gameResult: GameResult){

    textView.text = String.format(
        textView.context.getString(R.string.score_percentage),
        getPercentOfRightAnswers(gameResult)
    )
}
private fun getPercentOfRightAnswers(gameResult: GameResult) = with(gameResult) {
    if (countOfQuestions == 0) {
        0
    } else {
        ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
    }
}
@BindingAdapter("resultEmoji")
fun bindResultEmoji(imageView: ImageView,winner:Boolean){

    imageView.setImageResource(getSmileResId(winner))

}

private fun getSmileResId(winner:Boolean): Int {
    return if (winner) {
        R.drawable.ic_smile
    } else {
        R.drawable.ic_sad
    }
}