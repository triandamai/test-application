package app.trian.tes.data.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Test(
    @SerializedName("title")
    var title:String,
    @SerializedName("description")
    var description:String,
    @SerializedName("version")
    var currentVersion:Int,
    @SerializedName("createdAt")
    var createdAt:Long,
    @SerializedName("updatedAt")
    var updatedAt:Long
)
