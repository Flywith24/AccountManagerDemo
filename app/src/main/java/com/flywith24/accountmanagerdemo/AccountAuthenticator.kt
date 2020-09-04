package com.flywith24.accountmanagerdemo

import android.accounts.AbstractAccountAuthenticator
import android.accounts.Account
import android.accounts.AccountAuthenticatorResponse
import android.content.Context
import android.os.Bundle

/**
 * @author Flywith24
 * @date   2020/9/4
 * time   11:52
 * description
 */
class AccountAuthenticator(context: Context) : AbstractAccountAuthenticator(context) {

    override fun addAccount(
        response: AccountAuthenticatorResponse, accountType: String, authTokenType: String?,
        requiredFeatures: Array<out String>?, options: Bundle?
    ): Bundle? {
        return null
    }


    override fun confirmCredentials(
        response: AccountAuthenticatorResponse,
        account: Account,
        options: Bundle?
    ): Bundle? {
        return null
    }


    override fun editProperties(
        response: AccountAuthenticatorResponse?,
        accountType: String?
    ): Bundle? {
        return null
    }


    override fun getAuthToken(
        response: AccountAuthenticatorResponse,
        accountInput: Account,
        authTokenType: String,
        options: Bundle?
    ): Bundle? {
        return null
    }


    override fun getAuthTokenLabel(authTokenType: String): String? {
        return null
    }


    override fun hasFeatures(
        response: AccountAuthenticatorResponse,
        account: Account,
        features: Array<out String>
    )
            : Bundle? {
        return null
    }


    override fun updateCredentials(
        response: AccountAuthenticatorResponse,
        account: Account,
        authTokenType: String?,
        options: Bundle?
    ): Bundle? {
        return null
    }
}