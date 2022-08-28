package app.trian.tes.component.screen.question

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.trian.tes.component.theme.TestTheme

/**
 *
 * author Trian Damai
 * created_at 03/04/22 - 14.19
 * site https://trian.app
 */
@Composable
fun BaseStepQuestion(
    modifier: Modifier =Modifier,
    inputContent:@Composable ()->Unit={},
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(
                vertical = 30.dp,
                horizontal = 30.dp
            ),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            inputContent.invoke()
        }
    }
}

@Preview
@Composable
fun PreviewBaseStepQuestion() {
    TestTheme {
        Column(modifier=Modifier.background(MaterialTheme.colors.background)) {
            BaseStepQuestion()
        }
    }
}