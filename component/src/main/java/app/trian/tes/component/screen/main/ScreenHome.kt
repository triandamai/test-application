package app.trian.tes.component.screen.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.trian.tes.component.AppbarHome
import app.trian.tes.component.ItemMenuDrawer
import app.trian.tes.component.ItemStat
import app.trian.tes.component.theme.TestTheme
import app.trian.tes.component.utils.from
import app.trian.tes.component.utils.gridItems
import compose.icons.Octicons
import compose.icons.octicons.DiffRenamed16
import compose.icons.octicons.Quote24
import kotlinx.coroutines.launch

/**
 *
 * author Trian Damai
 * created_at 09/03/22 - 21.21
 * site https://trian.app
 */
data class MonitoringUIState(
    var loading:Boolean =true,
    var error:Boolean=false,
    var errorMessage:String="n/a",

    var odp:String="n/a",
    var odpOnMonitoring:String="n/a",
    var odpFinish:String="n/a",

    var pdp:String="n/a",
    var pdpLabNegative:String="n/a",
    var pdpWaiting:String="n/a",
    var pdpDied:String="n/a",

    var positive:String="n/a",
    var positiveOnTreated:String="n/a",
    var positiveCured:String="n/a",
    var positiveDied:String="n/a"
)

@Composable
fun ScreenHome(
    modifier: Modifier = Modifier,
    router: NavHostController,
    menus:List<ItemMenuDrawer> = listOf(),
    monitoring:MonitoringUIState= MonitoringUIState(),
    userName:String="",
    onFabClicked:()->Unit={},
    onDetailTest:(String)->Unit={},
    onRestartActivity:()->Unit={}
) {

    val ctx = LocalContext.current
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    BaseMainScreen(
        drawerState=drawerState,
        router = router,
        onRestartActivity=onRestartActivity,
        onFabClicked = onFabClicked,
        menus = menus,
        userName = userName,
        topAppbar = {
            AppbarHome(
                title = "Home",
                navigationIcon = {
                    IconToggleButton(
                        checked = false,
                        onCheckedChange = {
                            scope.launch {
                                drawerState.open()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Octicons.Quote24,
                            contentDescription = "",
                            tint = MaterialTheme.colors.onBackground
                        )
                    }
                },
                content = {

                }
            )
        },
        content = {
            LazyColumn (
                modifier = modifier.padding(
                    vertical = 10.dp,
                    horizontal = 4.dp
                ),
                contentPadding = PaddingValues(
                    horizontal = 16.dp
                )
            ){
                gridItems(
                    data = listOf<String>("TOEFL","TOEP"),
                    columnCount = 2,
                    horizontalArrangement = Arrangement.Center
                ){
                    ItemStat(
                        name = it,
                        icon=Octicons.DiffRenamed16,
                        value = monitoring.odpFinish,
                        iconColor = MaterialTheme.colors.primary
                    ){
                        onDetailTest(it)
                    }
                }
                item {
                    Spacer(modifier = modifier.height(40.dp.from(ctx)))
                }
            }
        }
    )
}


@Preview
@Composable
fun PreviewScreenHome() {
    TestTheme {
        ScreenHome(router = rememberNavController())
    }
}