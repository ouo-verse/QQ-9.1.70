package uq1;

import android.support.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.qzone.widget.u;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;

/* compiled from: P */
@Keep
/* loaded from: classes14.dex */
public class d {

    @SerializedName("program_id")
    public String programId = "";

    @SerializedName("live_cover")
    public String liveCover = "";

    @SerializedName("live_name")
    public String liveName = "";

    @SerializedName(u.COLUMN_TAB_ID)
    public String tabId = "";

    @SerializedName("logo")
    public String logo = "";

    @SerializedName("stream_url")
    public String streamUrl = "";

    @SerializedName(AudienceReportConst.ANCHOR_NAME)
    public String anchorName = "";
}
