
package io.github.djunicode.salespersontracker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponseModel {

    @SerializedName("Token")
    @Expose
    private String token;
    @SerializedName("S_id")
    @Expose
    private String sId;
    @SerializedName("Flag")
    @Expose
    private Integer flag;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Photo")
    @Expose
    private String photo;
    @SerializedName("Lat")
    @Expose
    private Double lat;
    @SerializedName("Long")
    @Expose
    private Double _long;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSId() {
        return sId;
    }

    public void setSId(String sId) {
        this.sId = sId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLong() {
        return _long;
    }

    public void setLong(Double _long) {
        this._long = _long;
    }

}
