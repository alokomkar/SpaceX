package com.alokomkar.spacex.ui.main.data


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Rocket(
    @SerializedName("rocket_id")
    var rocketId: String = "",
    @SerializedName("rocket_name")
    var rocketName: String = "",
    @SerializedName("rocket_type")
    var rocketType: String = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(rocketId)
        parcel.writeString(rocketName)
        parcel.writeString(rocketType)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rocket

        if (rocketId != other.rocketId) return false
        if (rocketName != other.rocketName) return false
        if (rocketType != other.rocketType) return false

        return true
    }

    override fun hashCode(): Int {
        var result = rocketId.hashCode()
        result = 31 * result + rocketName.hashCode()
        result = 31 * result + rocketType.hashCode()
        return result
    }

    companion object CREATOR : Parcelable.Creator<Rocket> {
        override fun createFromParcel(parcel: Parcel): Rocket {
            return Rocket(parcel)
        }

        override fun newArray(size: Int): Array<Rocket?> {
            return arrayOfNulls(size)
        }
    }


}