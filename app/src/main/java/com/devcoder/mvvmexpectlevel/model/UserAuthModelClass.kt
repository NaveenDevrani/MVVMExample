package com.devcoder.mvvmexpectlevel.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserAuthModelClass() : Parcelable {
    @SerializedName("user_info")
    @Expose
    var userInfo: UserInfo? = null

    @SerializedName("server_info")
    @Expose
    var serverInfo: ServerInfo? = null

    constructor(parcel: Parcel) : this() {
        userInfo = parcel.readParcelable(UserInfo::class.java.classLoader)
        serverInfo = parcel.readParcelable(ServerInfo::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(userInfo, flags)
        parcel.writeParcelable(serverInfo, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserAuthModelClass> {
        override fun createFromParcel(parcel: Parcel): UserAuthModelClass {
            return UserAuthModelClass(parcel)
        }

        override fun newArray(size: Int): Array<UserAuthModelClass?> {
            return arrayOfNulls(size)
        }
    }
}