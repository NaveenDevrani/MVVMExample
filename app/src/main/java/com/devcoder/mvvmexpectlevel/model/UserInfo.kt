package com.devcoder.mvvmexpectlevel.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class UserInfo() : Parcelable {
    @SerializedName("username")
    @Expose
    var username: String? = null

    @SerializedName("id")
    @Expose
    var id = ""

    @SerializedName("password")
    @Expose
    var password: String? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("auth")
    @Expose
    var auth: Int? = null

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("exp_date")
    @Expose
    var expDate: String? = null

    @SerializedName("is_trial")
    @Expose
    var isTrial: String? = null

    @SerializedName("active_cons")
    @Expose
    var activeCons: String? = null

    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null

    @SerializedName("max_connections")
    @Expose
    var maxConnections: String? = null

    @SerializedName("allowed_output_formats")
    @Expose
    var allowedOutputFormats: List<String>? = null

    constructor(parcel: Parcel) : this() {
        username = parcel.readString()
        id = parcel.readString() ?: ""
        password = parcel.readString()
        message = parcel.readString()
        auth = parcel.readValue(Int::class.java.classLoader) as? Int
        status = parcel.readString()
        expDate = parcel.readString()
        isTrial = parcel.readString()
        activeCons = parcel.readString()
        createdAt = parcel.readString()
        maxConnections = parcel.readString()
        allowedOutputFormats = parcel.createStringArrayList()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeString(id)
        parcel.writeString(password)
        parcel.writeString(message)
        parcel.writeValue(auth)
        parcel.writeString(status)
        parcel.writeString(expDate)
        parcel.writeString(isTrial)
        parcel.writeString(activeCons)
        parcel.writeString(createdAt)
        parcel.writeString(maxConnections)
        parcel.writeStringList(allowedOutputFormats)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserInfo> {
        override fun createFromParcel(parcel: Parcel): UserInfo {
            return UserInfo(parcel)
        }

        override fun newArray(size: Int): Array<UserInfo?> {
            return arrayOfNulls(size)
        }
    }

}
