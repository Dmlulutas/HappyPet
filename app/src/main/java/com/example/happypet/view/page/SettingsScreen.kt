import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.happypet.R
import com.example.happypet.factory.GreenNotification
import com.example.happypet.factory.NotificationFactory
import com.example.happypet.view.page.BaseScreen
import com.example.happypet.view.theme.springGreen
import com.example.happypet.viewModel.SettingsViewModel

class SettingsPage(
    override var backstack: String?,
    override var navController: NavHostController,
) : BaseScreen() {

    init {
        //Factory Sample
        val redNotif =
            NotificationFactory.createFactory<GreenNotification>("1", "Dog food supply", 1, true)
        val notif = redNotif.makeNotif()
        Log.d("created notif", notif.toString())
    }

    @Composable
    override fun GetUI(viewModel: ViewModel, owner: LifecycleOwner) {
        val homeViewModel = viewModel as SettingsViewModel
        Box(modifier = Modifier.fillMaxSize()) {
            ClickableText(
                text = AnnotatedString(LocalContext.current.getString(R.string.settings)),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp),
                onClick = { onClick(homeViewModel) },
                style = TextStyle(
                    fontSize = 24.sp,
                    color = springGreen
                )
            )
        }
        Text(
            text = homeViewModel.params,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(45.dp),
            style = MaterialTheme.typography.h5
        )

    }


    fun onClick(model: ViewModel) {
        val setViewModel: SettingsViewModel = model as SettingsViewModel
        setViewModel.changeParams("test")
    }


    @Composable
    fun TextContent(name: String) {
        Column(modifier = Modifier.padding(16.dp)) {

            if (name.isNotEmpty()) {
                Text(
                    text = "Hello, $name!",
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.h5
                )
            }

        }
    }
}