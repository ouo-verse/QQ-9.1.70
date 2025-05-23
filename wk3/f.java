package wk3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00128\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u00128\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u00128\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00128\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016R\u001a\u0010\u001f\u001a\u00020\u00128\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016R\u001a\u0010!\u001a\u00020\u00128\u0006X\u0087D\u00a2\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016R\u001a\u0010#\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001a\u0010%\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\u00a8\u0006)"}, d2 = {"Lwk3/f;", "", "", "actionId", "I", "a", "()I", "width", "j", "height", "getHeight", "", "useFilament", "Z", "getUseFilament", "()Z", "uploadCloud", "getUploadCloud", "", "maleDefaultPicUrl", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "femaleDefaultPicUrl", "b", "text1", "d", "text2", "e", "text3", "f", "text4", "g", "text5", tl.h.F, "uploadTarget", "getUploadTarget", "uploadScene", "i", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f {

    @SerializedName("uploadCloud")
    private final boolean uploadCloud;

    @SerializedName("useFilament")
    private final boolean useFilament;

    @SerializedName("actionId")
    private final int actionId = 6172;

    @SerializedName("width")
    private final int width = 126;

    @SerializedName("height")
    private final int height = 126;

    @SerializedName("maleDefaultPicUrl")
    @NotNull
    private final String maleDefaultPicUrl = "https://static-res.qq.com/static-res/zplan/aio/tab_icon/defaultMaleMemeIcon_emote_detail.png";

    @SerializedName("femaleDefaultPicUrl")
    @NotNull
    private final String femaleDefaultPicUrl = "https://static-res.qq.com/static-res/zplan/aio/tab_icon/defaultFemaleMemeIcon_emote_detail.png";

    @SerializedName("text1")
    @NotNull
    private final String text1 = "\u53d1\u9001\u6211\u7684\u8d85\u7ea7QQ\u79c0\u8868\u60c5";

    @SerializedName("text2")
    @NotNull
    private final String text2 = "\u53d1\u9001\u6211\u7684\u8d85\u7ea7QQ\u79c0\u8868\u60c5";

    @SerializedName("text3")
    @NotNull
    private final String text3 = "\u5b9a\u5236\u6211\u7684\u4e13\u5c5e\u8d85\u7ea7QQ\u79c0\u8868\u60c5";

    @SerializedName("text4")
    @NotNull
    private final String text4 = "\u53bb\u53d1\u9001";

    @SerializedName("text5")
    @NotNull
    private final String text5 = "\u53bb\u5b9a\u5236";

    @SerializedName("uploadTarget")
    private final int uploadTarget = 1;

    @SerializedName("uploadScene")
    private final int uploadScene = 2;

    /* renamed from: a, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getFemaleDefaultPicUrl() {
        return this.femaleDefaultPicUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getMaleDefaultPicUrl() {
        return this.maleDefaultPicUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getText1() {
        return this.text1;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getText2() {
        return this.text2;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getText3() {
        return this.text3;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getText4() {
        return this.text4;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getText5() {
        return this.text5;
    }

    /* renamed from: i, reason: from getter */
    public final int getUploadScene() {
        return this.uploadScene;
    }

    /* renamed from: j, reason: from getter */
    public final int getWidth() {
        return this.width;
    }
}
