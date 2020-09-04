package com.flywith24.app2

import android.accounts.AccountManager
import android.accounts.AccountManagerCallback
import android.accounts.AccountManagerFuture
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onResume() {
        super.onResume()
        val accountManager = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager
        val account = accountManager.getAccountsByType("mdm")
        if (account.isNotEmpty()) {

            username.text = getString(R.string.username, account.first().name)
            accountManager.getAuthToken(
                account.first(), "primary",
                null,
                this,
                { result ->
                    val tokenResult = result.result.getString(AccountManager.KEY_AUTHTOKEN)
                    Log.i("yyz11", "$tokenResult")
                    token.text =
                        getString(
                            R.string.token,
                            tokenResult
                        )
                },
                null
            )

        } else {
            username.text = "账号为空"
            token.text = "token为空"
        }
    }
}
