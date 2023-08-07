package com.minseo.callbank.view.map

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.fragment.app.Fragment
import com.minseo.callbank.R
import com.minseo.callbank.databinding.ActivityMapBinding
import com.minseo.callbank.view_model.GpsUtils
import com.minseo.callbank.view_model.LocationViewModel

class MapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMapBinding
    private var isGPSEnabled = false
    private val locationViewModel: LocationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_map)

        selectTab(2)

        binding.tabItem1.setOnClickListener {
            selectTab(1)
        }

        binding.tabItem2.setOnClickListener {
            selectTab(2)
        }

        GpsUtils(this).turnGPSOn(object : GpsUtils.OnGpsListener {
            override fun gpsStatus(isGPSEnable: Boolean) {
                this@MapActivity.isGPSEnabled = isGPSEnable
            }
        })
        invokeLocationAction()
    }

    private fun selectTab(tabNumber: Int) {
        val selectedView: Button
        val nonSelectedView: Button
        val selectedFragment: Fragment

        if (tabNumber == 1) {
            selectedView = binding.tabItem1
            nonSelectedView = binding.tabItem2
            selectedFragment = Map1Fragment()
        } else {
            selectedView = binding.tabItem2
            nonSelectedView = binding.tabItem1
            selectedFragment = Map2Fragment()
        }

        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentContainer, selectedFragment, null)
            .commit()
    }

    private fun invokeLocationAction() {
        when {
            !isGPSEnabled -> binding.latLong.text = getString(R.string.enable_gps)

            isPermissionsGranted() -> startLocationUpdate()

            shouldShowRequestPermissionRationale() -> binding.latLong.text =
                getString(R.string.permission_request)

            else -> ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                LOCATION_REQUEST
            )
        }
    }

    private fun startLocationUpdate() {
        locationViewModel.getLocationData().observe(this, Observer {
            binding.latLong.text = getString(R.string.latLong, it.longitude, it.latitude)
            Log.v("longitude", it.longitude.toString())
            Log.v("latitude", it.latitude.toString())
        })
    }

    private fun isPermissionsGranted() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED

    private fun shouldShowRequestPermissionRationale() =
        ActivityCompat.shouldShowRequestPermissionRationale(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) && ActivityCompat.shouldShowRequestPermissionRationale(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_REQUEST -> {
                invokeLocationAction()
            }
        }
    }
}

const val LOCATION_REQUEST = 100