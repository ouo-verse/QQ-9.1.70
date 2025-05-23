package x50;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c {

    @SerializedName(MobileQQ.PREF_WHITE_LIST_KEY)
    private List<a> whiteList;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a {

        @SerializedName("tabName")
        public String tabName;

        @SerializedName("tabType")
        public String tabType;
    }

    public List<a> a() {
        return this.whiteList;
    }
}
