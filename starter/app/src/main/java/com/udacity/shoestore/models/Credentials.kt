package com.udacity.shoestore.models

import android.provider.ContactsContract

data class Credentials (var email: ContactsContract.CommonDataKinds.Email, var password: String ="")

