package demo.vega.com.ttdemo.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class SoundSearchResult implements Parcelable {

    String imgUrl;
    String userName;
    String description;
    String noOfSounds;

    public SoundSearchResult(String imgUrl, String userName, String description, String noOfSounds) {
        this.imgUrl = imgUrl;
        this.userName = userName;
        this.description = description;
        this.noOfSounds = noOfSounds;
    }

    protected SoundSearchResult(Parcel in) {
        imgUrl = in.readString();
        userName = in.readString();
        description = in.readString();
        noOfSounds = in.readString();
    }

    public static final Creator<SoundSearchResult> CREATOR = new Creator<SoundSearchResult>() {
        @Override
        public SoundSearchResult createFromParcel(Parcel in) {
            return new SoundSearchResult(in);
        }

        @Override
        public SoundSearchResult[] newArray(int size) {
            return new SoundSearchResult[size];
        }
    };

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNoOfSounds() {
        return noOfSounds;
    }

    public void setNoOfSounds(String noOfSounds) {
        this.noOfSounds = noOfSounds;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imgUrl);
        dest.writeString(userName);
        dest.writeString(description);
        dest.writeString(noOfSounds);
    }
}
