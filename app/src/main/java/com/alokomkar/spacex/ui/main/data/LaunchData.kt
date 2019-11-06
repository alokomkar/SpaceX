package com.alokomkar.spacex.ui.main.data


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

//Parameters required :
//mission name, launch date and mission id.

//On click - display rocket name and description

data class LaunchData(
    @SerializedName("details")
    var details: String? = "",
    @SerializedName("flight_number")
    var flightNumber: Int = 0,
    @SerializedName("is_tentative")
    var isTentative: Boolean = false,
    @SerializedName("last_date_update")
    var lastDateUpdate: String = "",
    @SerializedName("last_ll_launch_date")
    var lastLlLaunchDate: String? = "",
    @SerializedName("last_ll_update")
    var lastLlUpdate: String? = "",
    @SerializedName("last_wiki_launch_date")
    var lastWikiLaunchDate: String = "",
    @SerializedName("last_wiki_revision")
    var lastWikiRevision: String = "",
    @SerializedName("last_wiki_update")
    var lastWikiUpdate: String = "",
    @SerializedName("launch_date_local")
    var launchDateLocal: String = "",
    @SerializedName("launch_date_source")
    var launchDateSource: String = "",
    @SerializedName("launch_date_unix")
    var launchDateUnix: Int = 0,
    @SerializedName("launch_date_utc")
    var launchDateUtc: String = "",
    @SerializedName("launch_year")
    var launchYear: String = "",
    @SerializedName("links")
    var links: Links = Links(),
    @SerializedName("mission_id")
    var missionId: List<String> = listOf(),
    @SerializedName("mission_name")
    var missionName: String = "",
    @SerializedName("rocket")
    var rocket: Rocket = Rocket(),
    @SerializedName("tbd")
    var tbd: Boolean = false,
    @SerializedName("tentative_max_precision")
    var tentativeMaxPrecision: String = "",
    @SerializedName("upcoming")
    var upcoming: Boolean = false
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readParcelable(Links::class.java.classLoader) ?: Links(),
        parcel.createStringArrayList() ?: ArrayList(),
        parcel.readString() ?: "",
        parcel.readParcelable(Rocket::class.java.classLoader) ?: Rocket(),
        parcel.readByte() != 0.toByte(),
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(details)
        parcel.writeInt(flightNumber)
        parcel.writeByte(if (isTentative) 1 else 0)
        parcel.writeString(lastDateUpdate)
        parcel.writeString(lastLlLaunchDate)
        parcel.writeString(lastLlUpdate)
        parcel.writeString(lastWikiLaunchDate)
        parcel.writeString(lastWikiRevision)
        parcel.writeString(lastWikiUpdate)
        parcel.writeString(launchDateLocal)
        parcel.writeString(launchDateSource)
        parcel.writeInt(launchDateUnix)
        parcel.writeString(launchDateUtc)
        parcel.writeString(launchYear)
        parcel.writeParcelable(links, flags)
        parcel.writeStringList(missionId)
        parcel.writeString(missionName)
        parcel.writeParcelable(rocket, flags)
        parcel.writeByte(if (tbd) 1 else 0)
        parcel.writeString(tentativeMaxPrecision)
        parcel.writeByte(if (upcoming) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LaunchData> {
        override fun createFromParcel(parcel: Parcel): LaunchData {
            return LaunchData(parcel)
        }

        override fun newArray(size: Int): Array<LaunchData?> {
            return arrayOfNulls(size)
        }
    }
}