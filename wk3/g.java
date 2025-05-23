package wk3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\f\u00a8\u0006\u001d"}, d2 = {"Lwk3/g;", "", "", "toString", "", "enableEmoticonGrayTips", "Z", "c", "()Z", "highLightWord", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "tipWord", "f", "", "appearanceTimeThreshold", "I", "a", "()I", "", "requestInterval", "J", "e", "()J", "createRoleScheme", "b", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class g {

    @SerializedName("enableEmoticonGrayTips")
    private final boolean enableEmoticonGrayTips;

    @SerializedName("highLightWord")
    @NotNull
    private final String highLightWord = "\u70b9\u51fb\u53d1\u9001";

    @SerializedName("tipWord")
    @NotNull
    private final String tipWord = "\u7528\u8d85\u7ea7QQ\u79c0\u8868\u60c5\u56de\u5e94TA";

    @SerializedName("appearanceTimeThreshold")
    private final int appearanceTimeThreshold = 3;

    @SerializedName("requestInterval")
    private final long requestInterval = 86400000;

    @SerializedName("createRoleScheme")
    @NotNull
    private final String createRoleScheme = "mqqapi://zplan/openPage?src_type=app&version=1.0&subReferer=em_zplan_emote_xht_to_chuangjue&pageID=12";

    /* renamed from: a, reason: from getter */
    public final int getAppearanceTimeThreshold() {
        return this.appearanceTimeThreshold;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getCreateRoleScheme() {
        return this.createRoleScheme;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getEnableEmoticonGrayTips() {
        return this.enableEmoticonGrayTips;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getHighLightWord() {
        return this.highLightWord;
    }

    /* renamed from: e, reason: from getter */
    public final long getRequestInterval() {
        return this.requestInterval;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTipWord() {
        return this.tipWord;
    }

    @NotNull
    public String toString() {
        return "ZPlanEmoticonGrayTipsConfig, enableEmoticonGrayTips: " + this.enableEmoticonGrayTips + ", highLightWord: " + this.highLightWord + ", tipWord: " + this.tipWord + ", appearanceTimeThreshold: " + this.appearanceTimeThreshold + ", requestInterval: " + this.requestInterval + ", createRoleScheme: " + this.createRoleScheme;
    }
}
