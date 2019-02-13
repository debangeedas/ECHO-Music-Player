package com.example.debangeedas.echo

import android.os.Parcel
import android.os.Parcelable

class Songs(var songID: Long, var songTitle: String, var artist: String, var songData: String, var dateAdded: Long) : Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readLong()) {
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        if (p0 != null) {
            p0.writeLong(songID)
        }
        if (p0 != null) {
            p0.writeString(songTitle)
        }
        if (p0 != null) {
            p0.writeString(artist)
        }
        if (p0 != null) {
            p0.writeString(songData)
        }
        if (p0 != null) {
            p0.writeLong(dateAdded)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Songs> {
        override fun createFromParcel(parcel: Parcel): Songs {
            return Songs(parcel)
        }

        override fun newArray(size: Int): Array<Songs?> {
            return arrayOfNulls(size)
        }
    }

}