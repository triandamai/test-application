package app.trian.tes.data.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Question(
    @SerializedName("testUID")
    var testUID:String="",
    @SerializedName("question")
    var question:String="",
    @SerializedName("answer")
    var answer:String="",
    @SerializedName("options")
    var options:Map<String,String> = mapOf()
)
