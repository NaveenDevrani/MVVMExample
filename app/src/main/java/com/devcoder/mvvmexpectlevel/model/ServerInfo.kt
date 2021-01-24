package com.devcoder.mvvmexpectlevel.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ServerInfo() : Parcelable {
    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("Id")
    @Expose
    var id = ""

    @SerializedName("port")
    @Expose
    var port: String? = null

    @SerializedName("https_port")
    @Expose
    var httpsPort: String? = null

    @SerializedName("server_protocol")
    @Expose
    var serverProtocol: String? = null

    @SerializedName("rtmp_port")
    @Expose
    var rtmpPort: String? = null

    @SerializedName("timezone")
    @Expose
    var timezone: String? = null

    @SerializedName("timestamp_now")
    @Expose
    var timestampNow: Int? = null

    @SerializedName("time_now")
    @Expose
    var timeNow: String? = null

    @SerializedName("process")
    @Expose
    var process: Boolean? = null

    constructor(parcel: Parcel) : this() {
        url = parcel.readString()
        id = parcel.readString() ?: ""
        port = parcel.readString()
        httpsPort = parcel.readString()
        serverProtocol = parcel.readString()
        rtmpPort = parcel.readString()
        timezone = parcel.readString()
        timestampNow = parcel.readValue(Int::class.java.classLoader) as? Int
        timeNow = parcel.readString()
        process = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeString(id)
        parcel.writeString(port)
        parcel.writeString(httpsPort)
        parcel.writeString(serverProtocol)
        parcel.writeString(rtmpPort)
        parcel.writeString(timezone)
        parcel.writeValue(timestampNow)
        parcel.writeString(timeNow)
        parcel.writeValue(process)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ServerInfo> {
        override fun createFromParcel(parcel: Parcel): ServerInfo {
            return ServerInfo(parcel)
        }

        override fun newArray(size: Int): Array<ServerInfo?> {
            return arrayOfNulls(size)
        }
    }

}
