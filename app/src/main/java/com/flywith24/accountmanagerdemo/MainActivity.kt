package com.flywith24.accountmanagerdemo

import android.accounts.Account
import android.accounts.AccountManager
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author Flywith24
 * @date   2020/9/4
 * time   11:59
 * description
 */
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val manager: AccountManager by lazy { AccountManager.get(this) }

    fun login(view: View) {
        if (username.text.toString().isNotBlank()) {
            Account(username.text.toString(), "mdm").also { account ->
                manager.addAccountExplicitly(account, "", null)
                manager.setAuthToken(account, "primary", token.text.toString())
            }
        } else {
            Toast.makeText(this, "用户名不许为空！", Toast.LENGTH_SHORT).show()
        }
    }

    fun logout(view: View) {
        val account = manager.getAccountsByType("mdm")
        account.forEach {
            manager.removeAccountExplicitly(it)
        }
        username.setText("")
    }
}