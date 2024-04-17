package com.example.guardi.ui.activity

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.guardi.R
import com.example.guardi.databinding.ActivityMainBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        buttonConfig()
        actualLocationMapConfig()
        alterLanguageConfig()

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun actualLocationMapConfig() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
        val actualPosition = LatLng(-9.669746, -35.721186)

        mapFragment.getMapAsync {
            addMarker(it, actualPosition)

            it.setOnMapLoadedCallback {
                it.moveCamera(CameraUpdateFactory.newLatLngZoom(actualPosition, 15f))
            }
        }
    }

    private fun addMarker(googleMap: GoogleMap, latLng: LatLng) {
        val marker = googleMap.addMarker(
            MarkerOptions()
                .title("Localização Atual")
                .snippet("R. Melo Póvoas, 110 - Jaraguá, Maceió - AL, 57022-230")
                .position(latLng)
        )
    }

    private fun buttonConfig() {
        binding.askForHelpButton.setOnClickListener {
            val intent = Intent(this, HelpRequestInfoActivity::class.java)
            startActivity(intent)
        }

        binding.emergencyContactsButton.setOnClickListener {
            val intent = Intent(this, EmergencyContactsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun alterLanguageConfig() {
        val languageButton = binding.englishButton

        languageButton.setOnClickListener {

            val locale = Locale("en")
            Locale.setDefault(locale)

            val config = Configuration()
            config.setLocale(locale)
            this.resources.updateConfiguration(config, this.resources.displayMetrics)

            recreate()
        }
    }
}