package app.trian.tes.component.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.trian.tes.component.AppbarAuth
import app.trian.tes.component.theme.fontFamily
import app.trian.tes.component.R
import app.trian.tes.component.form.FormInput
import app.trian.tes.component.form.FormInputWithButton
import app.trian.tes.component.theme.TestTheme

@Composable
fun ScreenRegister(
    modifier: Modifier=Modifier,
    onRegister:(email:String, password:String, name:String)->Unit={ _, _, _-> },
    onLogin:()->Unit={}
) {
    val ctx = LocalContext.current
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var name by remember {
        mutableStateOf("")
    }

    //annotation for text forget password
    val annotationStringLogin = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.onBackground,
                fontFamily = fontFamily
            )
        ){
            append(ctx.getString(R.string.login))
        }
        append(" ")
        pushStringAnnotation(
            tag = "login_here",
            annotation = "login_here"
        )
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.primary,
                fontFamily = fontFamily
            )
        ){
            append(ctx.getString(R.string.login_here))
        }
        pop()
    }

    Scaffold(
        topBar = {
            AppbarAuth(navigationText = stringResource(R.string.txt_btn_help)){

            }
        }
    ) {
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.bg_onboard_2),
                    contentDescription = stringResource(R.string.content_description_imaeg_page_login),
                    modifier = modifier.fillMaxWidth(fraction = 0.5f)
                )
            }
            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = stringResource(R.string.login_to_your_account),
                    style = MaterialTheme.typography.body1
                )
                FormInput(
                    initialValue = name,
                    onChange = {
                        name=it
                    },
                    placeholder = stringResource(R.string.placeholder_name),
                    label = stringResource(R.string.label_input_name),
                    singleLine = true,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
                FormInput(
                    initialValue = email,
                    onChange = {
                        email=it
                    },
                    placeholder = stringResource(R.string.placeholder_email),
                    label = stringResource(R.string.label_input_email),
                    singleLine = true,
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
                FormInputWithButton(
                    initialValue = password,
                    onChange = {
                        password = it
                    },
                    placeholder = stringResource(R.string.placeholder_password),
                    label = stringResource(R.string.label_input_password),
                    showPasswordObsecure = true,
                    singleLine = true,
                    onSubmit = {
                        onRegister(
                            email,
                            password,
                            name
                        )
                    },
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Send,
                    buttonEnabled = email.isNotBlank() && password.isNotBlank()
                )
            }

            Spacer(modifier = modifier.height(20.dp))
            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                ClickableText(
                    text = annotationStringLogin,
                    onClick = {
                            offset->
                        annotationStringLogin.getStringAnnotations(
                            tag = "login_here",
                            start = offset,
                            end = offset
                        ).firstOrNull()?.let { _ ->
                            onLogin()
                        }
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewScreenRegister(){
    TestTheme {
        ScreenRegister()
    }
}