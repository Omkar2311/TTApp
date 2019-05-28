package demo.vega.com.ttdemo.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class UsersSearchResult implements Parcelable {

    String imgUrl;
    String userName;
    String description;

    public UsersSearchResult(String imgUrl, String userName, String description) {
        this.imgUrl = imgUrl;
        this.userName = userName;
        this.description = description;
    }

    protected UsersSearchResult(Parcel in) {
        imgUrl = in.readString();
        userName = in.readString();
        description = in.readString();
    }

    public static final Creator<UsersSearchResult> CREATOR = new Creator<UsersSearchResult>() {
        @Override
        public UsersSearchResult createFromParcel(Parcel in) {
            return new UsersSearchResult(in);
        }

        @Override
        public UsersSearchResult[] newArray(int size) {
            return new UsersSearchResult[size];
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imgUrl);
        dest.writeString(userName);
        dest.writeString(description);
    }
}
