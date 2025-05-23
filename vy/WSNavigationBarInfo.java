package vy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b0\u00101J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u001b\u0010\u0015R\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001e\u0010\u0018R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0015R(\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0004\b\u001e\u0010\n\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u0018R\"\u0010-\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010)\u001a\u0004\b \u0010*\"\u0004\b+\u0010,R$\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00078F@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b/\u0010)\u001a\u0004\b\u001d\u0010*\u00a8\u00062"}, d2 = {"Lvy/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "position", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "barId", "c", "getSelectedBarId", "i", "(Ljava/lang/String;)V", "selectedBarId", "setBarType", "(I)V", "barType", "e", "setBarName", "barName", "f", h.F, "redNum", "g", "getBarIcon", "setBarIcon", "barIcon", "getBarStyle", "setBarStyle", "getBarStyle$annotations", "()V", "barStyle", "Z", "()Z", "j", "(Z)V", "isShowRedDot", "<set-?>", "isSelected", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vy.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class WSNavigationBarInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int position;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String barId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String selectedBarId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int barType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private String barName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int redNum;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String barIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int barStyle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isShowRedDot;

    public WSNavigationBarInfo(int i3, String barId, String selectedBarId, int i16, String barName) {
        Intrinsics.checkNotNullParameter(barId, "barId");
        Intrinsics.checkNotNullParameter(selectedBarId, "selectedBarId");
        Intrinsics.checkNotNullParameter(barName, "barName");
        this.position = i3;
        this.barId = barId;
        this.selectedBarId = selectedBarId;
        this.barType = i16;
        this.barName = barName;
        this.barIcon = "";
        this.barStyle = 1;
    }

    /* renamed from: a, reason: from getter */
    public final String getBarId() {
        return this.barId;
    }

    /* renamed from: b, reason: from getter */
    public final String getBarName() {
        return this.barName;
    }

    /* renamed from: c, reason: from getter */
    public final int getBarType() {
        return this.barType;
    }

    /* renamed from: d, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* renamed from: e, reason: from getter */
    public final int getRedNum() {
        return this.redNum;
    }

    public final boolean f() {
        return Intrinsics.areEqual(this.barId, this.selectedBarId);
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsShowRedDot() {
        return this.isShowRedDot;
    }

    public final void h(int i3) {
        this.redNum = i3;
    }

    public int hashCode() {
        return (((((((this.position * 31) + this.barId.hashCode()) * 31) + this.selectedBarId.hashCode()) * 31) + this.barType) * 31) + this.barName.hashCode();
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectedBarId = str;
    }

    public final void j(boolean z16) {
        this.isShowRedDot = z16;
    }

    public String toString() {
        return "WSNavigationBarInfo(position=" + this.position + ", barId=" + this.barId + ", selectedBarId=" + this.selectedBarId + ", barType=" + this.barType + ", barName=" + this.barName + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WSNavigationBarInfo)) {
            return false;
        }
        WSNavigationBarInfo wSNavigationBarInfo = (WSNavigationBarInfo) other;
        return this.position == wSNavigationBarInfo.position && Intrinsics.areEqual(this.barId, wSNavigationBarInfo.barId) && Intrinsics.areEqual(this.selectedBarId, wSNavigationBarInfo.selectedBarId) && this.barType == wSNavigationBarInfo.barType && Intrinsics.areEqual(this.barName, wSNavigationBarInfo.barName);
    }
}
