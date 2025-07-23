package indra.qrscanner

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import indra.qrscanner.ui.theme.QRScannerTheme // Adjust to your theme

class ScanResultActivity : ComponentActivity() {

    // Companion object to provide an easy way to create an Intent for this activity
    companion object {
        const val EXTRA_SCAN_RESULT = "indra.qrscanner.extra.SCAN_RESULT"
        fun newIntent(context: Context, scanResult: String): Intent {
            return Intent(context, ScanResultActivity::class.java).apply {
                putExtra(EXTRA_SCAN_RESULT, scanResult)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val scannedData = intent.getStringExtra(EXTRA_SCAN_RESULT) ?: "No data found"

        setContent {
            QRScannerTheme { // Use your app's theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ScanResultScreen(
                        scannedData = scannedData,
                        onBackPressed = {
                            finish()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ScanResultScreen(scannedData: String, onBackPressed: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Scanned QR Code:", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = scannedData, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onBackPressed) {
            Text("Back to Main")
        }
    }
}
