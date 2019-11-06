package com.alokomkar.spacex.ui.main.data
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("article_link")
    var articleLink: String? = String(),
    @SerializedName("flickr_images")
    var flickrImages: List<String> = listOf(),
    @SerializedName("mission_patch")
    var missionPatch: String? = String(),
    @SerializedName("mission_patch_small")
    var missionPatchSmall: String? = String(),
    @SerializedName("presskit")
    var presskit: String? = String(),
    @SerializedName("reddit_launch")
    var redditLaunch: String? = String(),
    @SerializedName("reddit_media")
    var redditMedia: String? = String(),
    @SerializedName("reddit_recovery")
    var redditRecovery: String? = String(),
    @SerializedName("video_link")
    var videoLink: String? = String(),
    @SerializedName("wikipedia")
    var wikipedia: String? = String(),
    @SerializedName("youtube_id")
    var youtubeId: String? = String()
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.createStringArrayList() ?: ArrayList(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(articleLink)
        parcel.writeStringList(flickrImages)
        parcel.writeString(missionPatch)
        parcel.writeString(missionPatchSmall)
        parcel.writeString(presskit)
        parcel.writeString(redditLaunch)
        parcel.writeString(redditMedia)
        parcel.writeString(redditRecovery)
        parcel.writeString(videoLink)
        parcel.writeString(wikipedia)
        parcel.writeString(youtubeId)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Links

        if (articleLink != other.articleLink) return false
        if (flickrImages != other.flickrImages) return false
        if (missionPatch != other.missionPatch) return false
        if (missionPatchSmall != other.missionPatchSmall) return false
        if (presskit != other.presskit) return false
        if (redditLaunch != other.redditLaunch) return false
        if (redditMedia != other.redditMedia) return false
        if (redditRecovery != other.redditRecovery) return false
        if (videoLink != other.videoLink) return false
        if (wikipedia != other.wikipedia) return false
        if (youtubeId != other.youtubeId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = articleLink?.hashCode() ?: 0
        result = 31 * result + flickrImages.hashCode()
        result = 31 * result + (missionPatch?.hashCode() ?: 0)
        result = 31 * result + (missionPatchSmall?.hashCode() ?: 0)
        result = 31 * result + (presskit?.hashCode() ?: 0)
        result = 31 * result + (redditLaunch?.hashCode() ?: 0)
        result = 31 * result + (redditMedia?.hashCode() ?: 0)
        result = 31 * result + (redditRecovery?.hashCode() ?: 0)
        result = 31 * result + (videoLink?.hashCode() ?: 0)
        result = 31 * result + (wikipedia?.hashCode() ?: 0)
        result = 31 * result + (youtubeId?.hashCode() ?: 0)
        return result
    }

    companion object CREATOR : Parcelable.Creator<Links> {
        override fun createFromParcel(parcel: Parcel): Links {
            return Links(parcel)
        }

        override fun newArray(size: Int): Array<Links?> {
            return arrayOfNulls(size)
        }
    }


}