package app.trian.tes.component.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.trian.tes.component.*
import app.trian.tes.component.R
import app.trian.tes.component.theme.TestTheme
import compose.icons.Octicons
import compose.icons.octicons.ArrowLeft24

/**
 *
 * author Trian Damai
 * created_at 10/03/22 - 13.25
 * site https://trian.app
 */
data class DetailTestUIState(
    var loading:Boolean = false,
    var error:Boolean = false,
    var errorMessage:String = ""

)
@Composable
fun ScreenDetailTest(
    modifier: Modifier = Modifier,
    state:DetailTestUIState=DetailTestUIState(),
    onBackPressed:()->Unit={},
    onStartTest:(String)->Unit = {}
) {
    Scaffold(
        topBar = {
            AppbarBasic(
                title = stringResource(R.string.txt_title_screen_detail_test),
                navigationIcon = {
                    IconToggleButton(
                        checked = false,
                        onCheckedChange = {
                            onBackPressed()
                        }
                    ) {
                        Icon(
                            imageVector = Octicons.ArrowLeft24,
                            contentDescription = "",
                            tint = MaterialTheme.colors.onBackground
                        )
                    }
                },
            )
        }
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(
                    vertical = 30.dp,
                    horizontal = 30.dp
                )
        ) {
            Column(
                modifier = modifier
                    .align(Alignment.TopCenter)

            ) {
                Column {
                    Text(
                        text = stringResource(R.string.txt_label_detail_officer_name),
                        style = MaterialTheme.typography.caption.copy(
                            color = MaterialTheme.colors.onSurface
                        )
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    Text(
                        text = "Lorem ipsum",
                        style = MaterialTheme.typography.body1
                    )
                }
                Spacer(modifier = modifier.height(30.dp))
                Column {
                    Text(
                        text = stringResource(R.string.txt_label_detail_officer_nip),
                        style = MaterialTheme.typography.caption.copy(
                            color = MaterialTheme.colors.onSurface
                        )
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    Text(
                        text = "Lorem ipsum",
                        style = MaterialTheme.typography.body1
                    )
                }
                Spacer(modifier = modifier.height(30.dp))
                Column {
                    Text(
                        text = stringResource(R.string.txt_label_detail_officer_opd),
                        style = MaterialTheme.typography.caption.copy(
                            color = MaterialTheme.colors.onSurface
                        )
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    Text(
                        text = "Lorem ipsum",
                        style = MaterialTheme.typography.body1
                    )
                }
                Spacer(modifier = modifier.height(30.dp))
                Row (
                    modifier= modifier
                        .height(IntrinsicSize.Min)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Column {
                        Text(
                            text = stringResource(R.string.txt_label_detail_officer_level),
                            style = MaterialTheme.typography.caption.copy(
                                color = MaterialTheme.colors.onSurface
                            )
                        )
                        Spacer(modifier = modifier.height(10.dp))
                        Text(
                            text = "Lorem ipsum",
                            style = MaterialTheme.typography.body1
                        )
                    }
                    Column(
                        modifier = modifier
                            .padding(vertical = 4.dp)
                            .fillMaxHeight()
                            .width(1.dp)
                            .background(
                                color = MaterialTheme.colors.onSurface
                            )
                    ) {

                    }
                    Column {
                        Text(
                            text = stringResource(R.string.txt_label_detail_officer_created_at),
                            style = MaterialTheme.typography.caption.copy(
                                color = MaterialTheme.colors.onSurface
                            )
                        )
                        Spacer(modifier = modifier.height(10.dp))
                        Text(
                            text = "2 Sept 2022",
                            style = MaterialTheme.typography.body1
                        )
                    }
                }
                Spacer(modifier = modifier
                    .height(30.dp))
                DottedLine(
                    color = MaterialTheme.colors.onSurface
                )
                Spacer(modifier = modifier
                    .height(30.dp))
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = stringResource(R.string.txt_label_detail_officer_assignment),
                            style = MaterialTheme.typography.caption.copy(
                                color = MaterialTheme.colors.onSurface
                            )
                        )
                        Spacer(modifier = modifier.height(10.dp))
                        Text(
                            text = "Lorem ipsum",
                            style = MaterialTheme.typography.body1
                        )
                    }
                }

                Spacer(modifier = modifier
                    .height(24.dp)
                )
                ButtonSecondary(
                    text = stringResource(R.string.txt_btn_start),
                    color = MaterialTheme.colors.primary,
                    onClick = {
                       onStartTest("SGas")
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewScreenDetailTest() {
    TestTheme {
        ScreenDetailTest(
            state = DetailTestUIState(
                loading = false,
                error = false,
            )
        )
    }
}