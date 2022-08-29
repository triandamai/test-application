package app.trian.tes.data.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class UserAnswer(
    @SerializedName("questionUID")
    var questionUID:String,
    @SerializedName("answer")
    var answer:String,
    @SerializedName("isCorrect")
    var isCorrect:Boolean
)
