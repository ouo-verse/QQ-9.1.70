package x6;

import NS_MOBILE_MAIN_PAGE.s_urge_publish_info;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\tB%\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lx6/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "f", "(Z)V", "showUrgePublish", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "buttonText", "d", "buttonClickToast", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: x6.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class QZoneUrgePublishInfo {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean showUrgePublish;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String buttonText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String buttonClickToast;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lx6/b$a;", "", "LNS_MOBILE_MAIN_PAGE/s_urge_publish_info;", "urgePublish", "Lx6/b;", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: x6.b$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final QZoneUrgePublishInfo a(s_urge_publish_info urgePublish) {
            QZoneUrgePublishInfo qZoneUrgePublishInfo = new QZoneUrgePublishInfo(false, null, null, 7, null);
            if (urgePublish != null) {
                qZoneUrgePublishInfo.f(urgePublish.show_urge_publish_button);
                String str = urgePublish.button_text;
                if (str == null) {
                    str = "";
                }
                qZoneUrgePublishInfo.e(str);
                String str2 = urgePublish.button_click_toast;
                qZoneUrgePublishInfo.d(str2 != null ? str2 : "");
            }
            return qZoneUrgePublishInfo;
        }

        Companion() {
        }
    }

    public QZoneUrgePublishInfo() {
        this(false, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getButtonClickToast() {
        return this.buttonClickToast;
    }

    /* renamed from: b, reason: from getter */
    public final String getButtonText() {
        return this.buttonText;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getShowUrgePublish() {
        return this.showUrgePublish;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.buttonClickToast = str;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.buttonText = str;
    }

    public final void f(boolean z16) {
        this.showUrgePublish = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.showUrgePublish;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.buttonText.hashCode()) * 31) + this.buttonClickToast.hashCode();
    }

    public String toString() {
        return "QZoneUrgePublishInfo(showUrgePublish=" + this.showUrgePublish + ", buttonText='" + this.buttonText + "', buttonClickToast='" + this.buttonClickToast + "')";
    }

    public QZoneUrgePublishInfo(boolean z16, String buttonText, String buttonClickToast) {
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(buttonClickToast, "buttonClickToast");
        this.showUrgePublish = z16;
        this.buttonText = buttonText;
        this.buttonClickToast = buttonClickToast;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZoneUrgePublishInfo)) {
            return false;
        }
        QZoneUrgePublishInfo qZoneUrgePublishInfo = (QZoneUrgePublishInfo) other;
        return this.showUrgePublish == qZoneUrgePublishInfo.showUrgePublish && Intrinsics.areEqual(this.buttonText, qZoneUrgePublishInfo.buttonText) && Intrinsics.areEqual(this.buttonClickToast, qZoneUrgePublishInfo.buttonClickToast);
    }

    public /* synthetic */ QZoneUrgePublishInfo(boolean z16, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2);
    }
}
