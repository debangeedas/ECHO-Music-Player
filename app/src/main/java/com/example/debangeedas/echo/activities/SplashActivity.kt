package com.example.debangeedas.echo.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Handler
import android.support.v4.app.ActivityCompat
import android.widget.Toast
import com.example.debangeedas.echo.R

/*The SplashActivity file inherits the AppCompatActivity. The AppCompatActivity is the base activity
    * on which every android application's activity is made upon. When developing Android applications
    * that support multiple android devices running on different versions (Oreo, Nougat, Marshmallow, Lollipop, Kitkat, etc.),
    * we want a standard way to provide newer features on earlier versions of Android
    * or gracefully fall back to equivalent functionality. This AppCompatActivity is a version of such support library
    * which provides us with that.*/

class SplashActivity : AppCompatActivity() {

    var permissionsString = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, /*This allows the application to read from external storage.
                                                                                 We need this to read the songs on your device*/
            Manifest.permission.MODIFY_AUDIO_SETTINGS, /*Allows an application to modify the global audio settings. This helps  us in turning the
                                                         volume up or down when music is playing*/
            Manifest.permission.READ_PHONE_STATE, /*This gives the application access to get the cellular network information, phone state
                                                    including the phone number, the status of any ongoing calls, and a list of any
                                                    phone accounts registered on the device. This checks whether the phone is active or in flight mode.*/
            Manifest.permission.PROCESS_OUTGOING_CALLS, /*Allows the application to see the number dialed during an outgoing call and gives it
                                                          an option to redirect or abort the call. Helps us in checking when a call is made
                                                          so that we can pause the media player*/
            Manifest.permission.RECORD_AUDIO) /*This only allows the application to record the audio. This helps the visualizer to sync with the music*/

    override fun onCreate(savedInstanceState: Bundle?) {

        /*Mandatory method of Android activity life-cycle.
       * The saved instance state parameter is used to save the state of the activity when the
       * activity is launched for the second time and onwards.*/
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if(!hasPermissions(this@SplashActivity, *permissionsString)) {

            ActivityCompat.requestPermissions(this@SplashActivity, permissionsString, 131)/*We request the user for permissions by
                                                                                                            passing the array of permissions.
                                                                                                            The request code is the unique number,
                                                                                                            with which the Android OS will identify
                                                                                                            which request was fired. We used 131,
                                                                                                            you can use any other distinct number*/

        } else {
            Handler().postDelayed({
                val startAct = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(startAct)
                this.finish()
            }, 1000)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            131 -> {/*Now remember that number specified here should match the request code sent when the permission was requested. In our case
                      it was 131*/
                if (grantResults.isNotEmpty() /*Check whether the results which came are not empty*/
                        /*The remaining lines check whether all the 5 permissions are granted or not. The && is the logical AND operator which
                        * returns true only if all the statements inside the if block return true. The complete condition becomes false if
                        * any of the condition return false*/
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED
                        && grantResults[2] == PackageManager.PERMISSION_GRANTED
                        && grantResults[3] == PackageManager.PERMISSION_GRANTED
                        && grantResults[4] == PackageManager.PERMISSION_GRANTED
                ) {
                    /*This is the same as above. As all permissions were granted we launch the next activity*/
                    Handler().postDelayed({
                        val startAct = Intent(this@SplashActivity, MainActivity::class.java)
                        startActivity(startAct)
                        this.finish()
                    }, 1000)
        } else {
                    Toast.makeText(this@SplashActivity, "Please grant all the permissions to continue.", Toast.LENGTH_SHORT).show()
                    this.finish()
                }
                return
            } else -> {

            Toast.makeText(this@SplashActivity, "Something went wrong", Toast.LENGTH_SHORT).show()
            this.finish()
            return
        }
    }}

    fun hasPermissions(context: Context, vararg permissions: String): Boolean { /*This functions takes two params namely the context of the
                                                                                 application and the array of permissions */
        var hasAllPermissions = true /*This variable is used as a flag for checking the status of permissions*/
        for (permission in permissions) { /*for loop to check for every single permission*/
            val res = context.checkCallingOrSelfPermission(permission) /*The method is used to determine whether the user is granted
                                                                         a permission or not*/
            if (res != PackageManager.PERMISSION_GRANTED) {
                hasAllPermissions = false /*If the permission has not been granted we change the value of hasAllPermission to false
                                            else it remains true*/
            }
        }
        return hasAllPermissions /*The return statement returns the status of all the permissions*/
    }
}
