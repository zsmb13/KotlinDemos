import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.sp
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            val lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle
            val state: Lifecycle.State by lifecycle.currentStateFlow.collectAsState()

            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("This app is currently", fontSize = 40.sp)
                Text("$state", fontSize = 40.sp)
            }

            LaunchedEffect(lifecycle) {
                lifecycle.addObserver(LoggingLifecycleObserver)
                lifecycle.currentStateFlow.collect { state: Lifecycle.State ->
                    println("Lifecycle state: $state")
                }
            }
        }
    }
}

object LoggingLifecycleObserver : DefaultLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) {
        println("Lifecycle event: onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        println("Lifecycle event: onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        println("Lifecycle event: onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        println("Lifecycle event: onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        println("Lifecycle event: onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        println("Lifecycle event: onStop")
    }
}
