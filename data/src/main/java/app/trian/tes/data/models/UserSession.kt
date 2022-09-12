package app.trian.tes.data.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class UserSession(
    @SerializedName("email")
    var email:String="",
    @SerializedName("name")
    var name:String="",
    @SerializedName("createdAt")
    var createdAt:Long=0,
    @SerializedName("updatedAt")
    var updatedAt:Long=0,
)
