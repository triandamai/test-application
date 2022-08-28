package app.trian.tes.component.screen

import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.trian.tes.component.AppbarBasic
import app.trian.tes.component.ButtonSecondary
import app.trian.tes.component.ItemRadioSelection
import app.trian.tes.component.R
import app.trian.tes.component.form.FormInput
import app.trian.tes.component.screen.question.BaseStepQuestion
import app.trian.tes.component.theme.BackgroundDashboard
import app.trian.tes.component.theme.TestTheme
import app.trian.tes.component.utils.from
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import compose.icons.Octicons
import compose.icons.octicons.ArrowLeft24
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *
 * author Trian Damai
 * created_at 10/03/22 - 17.14
 * site https://trian.app
 */


@Composable
fun ScreenQuestion(
    modifier: Modifier = Modifier,
    currentPage:Int=0,
    totalPage:Int=0,
    onBackPressed: () -> Unit = {},
    onPrev:()->Unit={},
    onNext:()->Unit={},
) {
    val ctx = LocalContext.current
    val scope = rememberCoroutineScope()

    var animated by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = Unit, block = {
        animated = true
    })

    fun nextPage() {
        scope.launch {
            onNext()
            if(currentPage<totalPage) {
                animated = false
                delay(500)
                animated = true
            }
        }

    }

    fun prevPage() {
        scope.launch {
            onPrev()
            animated = false
            delay(500)
            animated = true
        }

    }


    //handle system back pressed
    BackHandler {
        prevPage()
    }
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
                }
            )
        },
        bottomBar={
                  Row(
                      modifier = modifier
                          .fillMaxWidth()
                          .background(MaterialTheme.colors.background)
                          .padding(
                              horizontal = 16.dp.from(ctx),
                              vertical = 8.dp.from(ctx)
                          ),
                      horizontalArrangement = Arrangement.SpaceBetween,
                      verticalAlignment = Alignment.CenterVertically
                  ) {
                      ButtonSecondary(
                          modifier = modifier.width(85.dp.from(ctx)),
                          text = "Prev",
                          enabled = (currentPage > 1) ,
                          color = MaterialTheme.colors.primary,
                          onClick = {
                              prevPage()
                          }
                      )
                      Text(text = "$currentPage dari $totalPage")
                      ButtonSecondary(
                          modifier = modifier.width(85.dp.from(ctx)),
                          text = if(currentPage < totalPage) "Next" else "Simpan",
                          enabled = true,
                          color = MaterialTheme.colors.primary,
                          onClick = {
                              nextPage()
                          }
                      )
                  }
        },
        backgroundColor = BackgroundDashboard
    ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                AnimatedVisibility(
                    visible = animated,
                    enter = fadeIn(
                        animationSpec = tween(
                            durationMillis = 300,
                            easing = LinearEasing
                        )
                    ),
                    exit = fadeOut (
                        animationSpec = tween(
                            durationMillis = 300,
                            easing = LinearEasing
                        )
                    )
                    ) {
                            BaseStepQuestion(
                                inputContent = {
                                    LazyColumn(content = {
                                        item {
                                            Text(
                                                text = "Ini pertanyaan",
                                                style = MaterialTheme.typography.body1.copy(
                                                    color = MaterialTheme.colors.onBackground,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            )
                                        }
                                        item {
                                            Spacer(modifier = modifier.height(16.dp))
                                        }
                                        items(listOf("A","B","C")){
                                            ItemRadioSelection(
                                                name = "$it Jawabannya adalah lorem",
                                                selected = false
                                            ) {


                                            }
                                        }
                                    })


                                }
                            )
                }
            }
    }
}

@Preview
@Composable
fun PreviewScreenQuestion() {
    TestTheme {
        ScreenQuestion()
    }
}