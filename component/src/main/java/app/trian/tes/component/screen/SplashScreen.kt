package app.trian.tes.component.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.trian.tes.component.R
import app.trian.tes.component.theme.TestTheme
import app.trian.tes.component.utils.getAppVersion


@Composable
fun ScreenSplashScreen(
    modifier:Modifier=Modifier
) {
    val ctx = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
            .padding(
                vertical = 20.dp,
                horizontal = 20.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Column {

        }
        Column {
            Image(
                painter = painterResource(id = R.drawable.logo_amikom),
                contentDescription = "Logo Amikom",
                modifier= modifier
                    .fillMaxWidth(
                        fraction = 0.5f
                    )
                    .fillMaxHeight(
                        fraction = 0.5f
                    )
            )
        }
        Column(
            modifier=modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.txt_app_label),
                style = MaterialTheme.typography.subtitle2.copy(
                    color = MaterialTheme.colors.surface
                )
            )
            Spacer(modifier = modifier.height(10.dp))
            Text(
                text = "version ${ctx.getAppVersion()}",
                style = MaterialTheme.typography.caption.copy(
                    color = MaterialTheme.colors.surface
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewSplashScreen() {
     TestTheme {
        ScreenSplashScreen()
    }
}