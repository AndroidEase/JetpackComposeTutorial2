import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposetutorial2.ui.theme.JetpackComposeTutorial2Theme

@Composable
fun Home() {
    Box() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Home")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    JetpackComposeTutorial2Theme {
        Home()
    }
}