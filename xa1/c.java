package xa1;

import com.tencent.state.square.feeds.SquareQZoneFeedsManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00072\u00020\u0001:\u0001\u0004B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lxa1/c;", "", "", "toString", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "homePageUrl", "", "b", "I", "()I", "e", "(I)V", "privacyDialogShowLimitDay", "c", "f", "qZoneBubbleText", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String homePageUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int privacyDialogShowLimitDay;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String qZoneBubbleText;

    public c(@NotNull String homePageUrl, int i3, @NotNull String qZoneBubbleText) {
        Intrinsics.checkNotNullParameter(homePageUrl, "homePageUrl");
        Intrinsics.checkNotNullParameter(qZoneBubbleText, "qZoneBubbleText");
        this.homePageUrl = homePageUrl;
        this.privacyDialogShowLimitDay = i3;
        this.qZoneBubbleText = qZoneBubbleText;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getHomePageUrl() {
        return this.homePageUrl;
    }

    /* renamed from: b, reason: from getter */
    public final int getPrivacyDialogShowLimitDay() {
        return this.privacyDialogShowLimitDay;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getQZoneBubbleText() {
        return this.qZoneBubbleText;
    }

    public final void d(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.homePageUrl = str;
    }

    public final void e(int i3) {
        this.privacyDialogShowLimitDay = i3;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qZoneBubbleText = str;
    }

    @NotNull
    public String toString() {
        String str = "VasZPlanQZoneFeedsConfig:\nhomePageUrl: " + this.homePageUrl + "\nprivacyDialogShowLimitDay: " + this.privacyDialogShowLimitDay + "\nqZoneBubbleText" + this.qZoneBubbleText;
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder()\n        \u2026)\n            .toString()");
        return str;
    }

    public /* synthetic */ c(String str, int i3, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? SquareQZoneFeedsManager.DEFAULT_QZONE_HOME_PAGE_URL : str, (i16 & 2) != 0 ? 7 : i3, (i16 & 4) != 0 ? "\u6211\u66f4\u65b0\u4e86\u8bf4\u8bf4" : str2);
    }
}
