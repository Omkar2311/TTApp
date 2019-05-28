package demo.vega.com.ttdemo.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class HashtagSearchResults implements Parcelable {

    String hashTagName;
    String noOfViews;

    public HashtagSearchResults(String hashTagName, String noOfViews) {
        this.hashTagName = hashTagName;
        this.noOfViews = noOfViews;
    }

    protected HashtagSearchResults(Parcel in) {
        hashTagName = in.readString();
        noOfViews = in.readString();
    }

    public static final Creator<HashtagSearchResults> CREATOR = new Creator<HashtagSearchResults>() {
        @Override
        public HashtagSearchResults createFromParcel(Parcel in) {
            return new HashtagSearchResults(in);
        }

        @Override
        public HashtagSearchResults[] newArray(int size) {
            return new HashtagSearchResults[size];
        }
    };

    public String getHashTagName() {
        return hashTagName;
    }

    public void setHashTagName(String hashTagName) {
        this.hashTagName = hashTagName;
    }

    public String getNoOfViews() {
        return noOfViews;
    }

    public void setNoOfViews(String noOfViews) {
        this.noOfViews = noOfViews;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(hashTagName);
        dest.writeString(noOfViews);
    }
}
