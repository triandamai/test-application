package app.trian.tes.data.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Progress(
    @SerializedName("userUID")
    var userUID:String="",
    @SerializedName("testUID")
    var testUID:String="",
    @SerializedName("testName")
    var testName:String="",
    @SerializedName("percentage")
    var percentage:Int=0,
    @SerializedName("createdAt")
    var createdAt:Long=0,
    @SerializedName("updatedAt")
    var updatedAt:Long=0
)
