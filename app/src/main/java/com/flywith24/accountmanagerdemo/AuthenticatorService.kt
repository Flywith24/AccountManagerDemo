package com.flywith24.accountmanagerdemo

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * @author Flywith24
 * @date   2020/9/4
 * time   11:51
 * description
 */
class AuthenticatorService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        val authenticator = AccountAuthenticator(this)
        return authenticator.iBinder
    }
}