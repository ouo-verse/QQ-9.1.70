package u20;

import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001\tBY\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0016\u0010\fR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\fR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u001b\u0010\fR\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b \u0010\f\u00a8\u0006%"}, d2 = {"Lu20/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "authTitle", "authDesc", "c", "d", "helpTitle", "helpDesc", "e", "g", "settingTitle", "f", "settingDesc", "i", "(Ljava/lang/String;)V", "permissionFeedGuideTip", tl.h.F, "getFunctionFeedGuideTip", "functionFeedGuideTip", "videoFrameGuideTip", "j", "getMiniFeedBannerTip", "miniFeedBannerTip", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "k", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u20.k, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSTextConfig {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String authTitle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String authDesc;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String helpTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String helpDesc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String settingTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String settingDesc;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String permissionFeedGuideTip;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String functionFeedGuideTip;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String videoFrameGuideTip;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String miniFeedBannerTip;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lu20/k$a;", "", "Lorg/json/JSONObject;", "Lu20/k;", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u20.k$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QFSTextConfig a(@NotNull JSONObject jSONObject) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            boolean z27;
            boolean z28;
            boolean z29;
            boolean z36;
            boolean z37;
            Intrinsics.checkNotNullParameter(jSONObject, "<this>");
            String optString = jSONObject.optString("auth_title");
            if (optString.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                optString = com.tencent.biz.qqcircle.utils.h.a(R.string.f170497z80);
            }
            String str = optString;
            Intrinsics.checkNotNullExpressionValue(str, "optString(\"auth_title\").\u2026tr(R.string.auth_title) }");
            String optString2 = jSONObject.optString("auth_desc");
            if (optString2.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                optString2 = com.tencent.biz.qqcircle.utils.h.a(R.string.z7z);
            }
            String str2 = optString2;
            Intrinsics.checkNotNullExpressionValue(str2, "optString(\"auth_desc\").i\u2026Str(R.string.auth_desc) }");
            String optString3 = jSONObject.optString("input_recom_title");
            if (optString3.length() == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                optString3 = com.tencent.biz.qqcircle.utils.h.a(R.string.f160831w3);
            }
            String str3 = optString3;
            Intrinsics.checkNotNullExpressionValue(str3, "optString(\"input_recom_t\u2026ring.input_recom_title) }");
            String optString4 = jSONObject.optString("input_recom_desc");
            if (optString4.length() == 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                optString4 = com.tencent.biz.qqcircle.utils.h.a(R.string.f160821w2);
            }
            String str4 = optString4;
            Intrinsics.checkNotNullExpressionValue(str4, "optString(\"input_recom_d\u2026tring.input_recom_desc) }");
            String optString5 = jSONObject.optString("setting_title");
            if (optString5.length() == 0) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (z26) {
                optString5 = com.tencent.biz.qqcircle.utils.h.a(R.string.f225816mn);
            }
            String str5 = optString5;
            Intrinsics.checkNotNullExpressionValue(str5, "optString(\"setting_title\u2026R.string.setting_title) }");
            String optString6 = jSONObject.optString("setting_desc");
            if (optString6.length() == 0) {
                z27 = true;
            } else {
                z27 = false;
            }
            if (z27) {
                optString6 = com.tencent.biz.qqcircle.utils.h.a(R.string.f225636m6);
            }
            String str6 = optString6;
            Intrinsics.checkNotNullExpressionValue(str6, "optString(\"setting_desc\"\u2026(R.string.setting_desc) }");
            String str7 = null;
            String optString7 = jSONObject.optString("function_guide_desc");
            if (optString7.length() == 0) {
                z28 = true;
            } else {
                z28 = false;
            }
            if (z28) {
                optString7 = com.tencent.biz.qqcircle.utils.h.a(R.string.f181903f1);
            }
            String str8 = optString7;
            Intrinsics.checkNotNullExpressionValue(str8, "optString(\"function_guid\u2026ment_rec_pic_hint_text) }");
            String optString8 = jSONObject.optString("video_frame_guide_desc");
            if (optString8.length() == 0) {
                z29 = true;
            } else {
                z29 = false;
            }
            if (z29) {
                optString8 = com.tencent.biz.qqcircle.utils.h.a(R.string.f238157j0);
            }
            String str9 = optString8;
            Intrinsics.checkNotNullExpressionValue(str9, "optString(\"video_frame_g\u2026o_frame_feed_guide_tip) }");
            String optString9 = jSONObject.optString("mini_feed_banner_tip");
            if (optString9.length() == 0) {
                z36 = true;
            } else {
                z36 = false;
            }
            if (z36) {
                optString9 = com.tencent.biz.qqcircle.utils.h.a(R.string.zxx);
            }
            String str10 = optString9;
            Intrinsics.checkNotNullExpressionValue(str10, "optString(\"mini_feed_ban\u2026d_rec_pic_entrance_tip) }");
            QFSTextConfig qFSTextConfig = new QFSTextConfig(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, 64, null);
            String optString10 = jSONObject.optString("permission_guide_desc");
            if (optString10.length() == 0) {
                z37 = true;
            } else {
                z37 = false;
            }
            if (z37) {
                optString10 = QCircleApplication.APP.getResources().getString(R.string.zxq, qFSTextConfig.getHelpTitle());
            }
            Intrinsics.checkNotNullExpressionValue(optString10, "optString(\"permission_gu\u2026ottom_guide, helpTitle) }");
            qFSTextConfig.i(optString10);
            return qFSTextConfig;
        }

        Companion() {
        }
    }

    public QFSTextConfig(@NotNull String authTitle, @NotNull String authDesc, @NotNull String helpTitle, @NotNull String helpDesc, @NotNull String settingTitle, @NotNull String settingDesc, @NotNull String permissionFeedGuideTip, @NotNull String functionFeedGuideTip, @NotNull String videoFrameGuideTip, @NotNull String miniFeedBannerTip) {
        Intrinsics.checkNotNullParameter(authTitle, "authTitle");
        Intrinsics.checkNotNullParameter(authDesc, "authDesc");
        Intrinsics.checkNotNullParameter(helpTitle, "helpTitle");
        Intrinsics.checkNotNullParameter(helpDesc, "helpDesc");
        Intrinsics.checkNotNullParameter(settingTitle, "settingTitle");
        Intrinsics.checkNotNullParameter(settingDesc, "settingDesc");
        Intrinsics.checkNotNullParameter(permissionFeedGuideTip, "permissionFeedGuideTip");
        Intrinsics.checkNotNullParameter(functionFeedGuideTip, "functionFeedGuideTip");
        Intrinsics.checkNotNullParameter(videoFrameGuideTip, "videoFrameGuideTip");
        Intrinsics.checkNotNullParameter(miniFeedBannerTip, "miniFeedBannerTip");
        this.authTitle = authTitle;
        this.authDesc = authDesc;
        this.helpTitle = helpTitle;
        this.helpDesc = helpDesc;
        this.settingTitle = settingTitle;
        this.settingDesc = settingDesc;
        this.permissionFeedGuideTip = permissionFeedGuideTip;
        this.functionFeedGuideTip = functionFeedGuideTip;
        this.videoFrameGuideTip = videoFrameGuideTip;
        this.miniFeedBannerTip = miniFeedBannerTip;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAuthDesc() {
        return this.authDesc;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAuthTitle() {
        return this.authTitle;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getHelpDesc() {
        return this.helpDesc;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getHelpTitle() {
        return this.helpTitle;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getPermissionFeedGuideTip() {
        return this.permissionFeedGuideTip;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSTextConfig)) {
            return false;
        }
        QFSTextConfig qFSTextConfig = (QFSTextConfig) other;
        if (Intrinsics.areEqual(this.authTitle, qFSTextConfig.authTitle) && Intrinsics.areEqual(this.authDesc, qFSTextConfig.authDesc) && Intrinsics.areEqual(this.helpTitle, qFSTextConfig.helpTitle) && Intrinsics.areEqual(this.helpDesc, qFSTextConfig.helpDesc) && Intrinsics.areEqual(this.settingTitle, qFSTextConfig.settingTitle) && Intrinsics.areEqual(this.settingDesc, qFSTextConfig.settingDesc) && Intrinsics.areEqual(this.permissionFeedGuideTip, qFSTextConfig.permissionFeedGuideTip) && Intrinsics.areEqual(this.functionFeedGuideTip, qFSTextConfig.functionFeedGuideTip) && Intrinsics.areEqual(this.videoFrameGuideTip, qFSTextConfig.videoFrameGuideTip) && Intrinsics.areEqual(this.miniFeedBannerTip, qFSTextConfig.miniFeedBannerTip)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getSettingDesc() {
        return this.settingDesc;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getSettingTitle() {
        return this.settingTitle;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getVideoFrameGuideTip() {
        return this.videoFrameGuideTip;
    }

    public int hashCode() {
        return (((((((((((((((((this.authTitle.hashCode() * 31) + this.authDesc.hashCode()) * 31) + this.helpTitle.hashCode()) * 31) + this.helpDesc.hashCode()) * 31) + this.settingTitle.hashCode()) * 31) + this.settingDesc.hashCode()) * 31) + this.permissionFeedGuideTip.hashCode()) * 31) + this.functionFeedGuideTip.hashCode()) * 31) + this.videoFrameGuideTip.hashCode()) * 31) + this.miniFeedBannerTip.hashCode();
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.permissionFeedGuideTip = str;
    }

    @NotNull
    public String toString() {
        return "QFSTextConfig(authTitle=" + this.authTitle + ", authDesc=" + this.authDesc + ", helpTitle=" + this.helpTitle + ", helpDesc=" + this.helpDesc + ", settingTitle=" + this.settingTitle + ", settingDesc=" + this.settingDesc + ", permissionFeedGuideTip=" + this.permissionFeedGuideTip + ", functionFeedGuideTip=" + this.functionFeedGuideTip + ", videoFrameGuideTip=" + this.videoFrameGuideTip + ", miniFeedBannerTip=" + this.miniFeedBannerTip + ")";
    }

    public /* synthetic */ QFSTextConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, (i3 & 64) != 0 ? "" : str7, str8, str9, str10);
    }
}
