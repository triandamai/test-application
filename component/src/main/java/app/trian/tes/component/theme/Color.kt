package app.trian.tes.component.theme

import androidx.compose.ui.graphics.Color


val Primary = Color(0xFFFF3378)
val Secondary = Color(0xFF33C9FF)
val Variant = Color(0xFF41E94B)

val Background = Color(0xFFFCFCFC)
val Surface = Color(0xFFFFFFFF)
val OnBackground = Color(0xFF1C202E)
val OnSurface = Color(0xFFAEB1B8)
val BackgroundDashboard = Color(0xFFFCFCFC)

val DisableColor = Color(0xFFDCDFE5)
val DisableContentColor = Color(0xFF8D8E8F)

val CircleIconCategory = Color(0xFFF7F7F7)

val ExpensesColor = Color(0xFFFF2525)

object HexToJetpackColor{
    fun getColor(colorString: String): Color {
        return Color(android.graphics.Color.parseColor("#$colorString"))
    }
}

val listGradient = listOf<GradientColor>(
    GradientColor("7562FF", "33C9FF"),
    GradientColor("FF8B62", "FF3378"),
    GradientColor("36F6E4", "19EA25"),
    GradientColor("F433DD", "F433DD"),
    GradientColor("FFA27F", "FFCD48"),
    GradientColor("00FAAB", "8F5DFF"),
    GradientColor("F274FF", "F61F6D"),
)

data class GradientColor(var first:String,var second:String)



val TextActive = Color(0xFF313E4C)
val TextInactive = Color(0xFFBABABE)



