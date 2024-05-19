import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import resourcesdemo.composeapp.generated.resources.*

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme(colors = if (isSystemInDarkTheme()) darkColors() else lightColors()) {
        Surface(Modifier.fillMaxSize()) {
            var bytes by remember { mutableStateOf(byteArrayOf()) }

            Column(
                modifier = Modifier.fillMaxWidth().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val jetbrainsMono = FontFamily(Font(Res.font.JetBrainsMono_Regular))
                Text(
                    stringResource(Res.string.app_name),
                    fontFamily = jetbrainsMono,
                    style = MaterialTheme.typography.h3
                )

                Spacer(Modifier.height(48.dp))

                Res.drawable.screen

                Text(stringResource(Res.string.greeting), style = MaterialTheme.typography.h5)

                Spacer(Modifier.weight(1f))

                Image(painterResource(Res.drawable.logo), null, modifier = Modifier.size(400.dp))
            }

            LaunchedEffect(Unit) {
                bytes = Res.readBytes("files/hello_world.txt")
            }
        }
    }
}
