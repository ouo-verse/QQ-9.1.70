package sf4;

import com.google.gson.annotations.SerializedName;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    @SerializedName("slow_download_enable")
    public boolean slowDownloadEnable = false;

    @SerializedName("slow_download_check_duration")
    public int slowDownloadCheckDuration = 5000;

    @SerializedName("slow_download_switch_enable")
    public boolean slowDownloadSwitchEnable = true;

    @SerializedName("slow_download_switch_duration")
    public int slowDownloadSwitchDuration = 60000;

    @SerializedName("slow_download_bitrate_sd")
    public int slowDownloadBitrateSD = 140;

    @SerializedName("slow_download_preload_sd")
    public boolean slowDownloadPreloadSD = false;

    @SerializedName("slow_download_bitrate_hd")
    public int slowDownloadBitrateHD = 200;

    @SerializedName("slow_download_preload_hd")
    public boolean slowDownloadPreloadHD = false;

    @SerializedName("slow_download_bitrate_shd")
    public int slowDownloadBitrateSHD = 400;

    @SerializedName("slow_download_preload_shd")
    public boolean slowDownloadPreloadSHD = true;

    @SerializedName("test_speed_enable")
    public boolean testSpeedEnable = false;

    @SerializedName("test_speed_url")
    public String testSpeedUrl = "https://dlied5v6.qq.com/now/qq-live/player-strategy/test.flv";

    @SerializedName("test_speed_duration")
    public int testSpeedDuration = 60000;

    public String toString() {
        return "PlayerStrategyConfig{slowDownloadEnable=" + this.slowDownloadEnable + ", slowDownloadCheckDuration=" + this.slowDownloadCheckDuration + ", slowDownloadSwitchEnable=" + this.slowDownloadSwitchEnable + ", slowDownloadSwitchDuration=" + this.slowDownloadSwitchDuration + ", slowDownloadBitrateSD=" + this.slowDownloadBitrateSD + ", slowDownloadPreloadSD=" + this.slowDownloadPreloadSD + ", slowDownloadBitrateHD=" + this.slowDownloadBitrateHD + ", slowDownloadPreloadHD=" + this.slowDownloadPreloadHD + ", slowDownloadBitrateSHD=" + this.slowDownloadBitrateSHD + ", slowDownloadPreloadSHD=" + this.slowDownloadPreloadSHD + ", testSpeedEnable=" + this.testSpeedEnable + ", testSpeedUrl='" + this.testSpeedUrl + "', testSpeedDuration=" + this.testSpeedDuration + '}';
    }
}
