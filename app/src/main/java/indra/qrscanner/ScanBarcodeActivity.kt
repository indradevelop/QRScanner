package indra.qrscanner

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import indra.qrscanner.ui.theme.QRScannerTheme

class ScanBarcodeActivity : ComponentActivity() {
    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ScanBarcodeActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QRScannerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
                        BarcodeScannerScreen{ barcodeValue ->
                            val intent = ScanResultActivity.newIntent(this@ScanBarcodeActivity, barcodeValue)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
            }
        }
    }
}