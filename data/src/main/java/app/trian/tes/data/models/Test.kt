package app.trian.tes.data.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Test(
    var testUID:String="",
    @SerializedName("title")
    var title:String="",
    @SerializedName("description")
    var description:String="",
    @SerializedName("category")
    var category:String="",
    @SerializedName("creator")
    var creator:String="",
    @SerializedName("createdAt")
    var createdAt:Long=0,
    @SerializedName("updatedAt")
    var updatedAt:Long=0
)
