package yj0;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lyj0/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "msg", "b", "url", "c", "img", "d", "nightImg", "e", "getJsBundleKey", "()Ljava/lang/String;", "jsBundleKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: yj0.c, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ECPromoteItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String msg;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String url;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String img;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String nightImg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String jsBundleKey;

    public ECPromoteItem() {
        this(null, null, null, null, null, 31, null);
    }

    public int hashCode() {
        String str = this.msg;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.img;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.nightImg;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.jsBundleKey;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "ECPromoteItem(msg=" + this.msg + ", url=" + this.url + ", img=" + this.img + ", nightImg=" + this.nightImg + ", jsBundleKey=" + this.jsBundleKey + ")";
    }

    public ECPromoteItem(String str, String str2, String str3, String str4, String str5) {
        this.msg = str;
        this.url = str2;
        this.img = str3;
        this.nightImg = str4;
        this.jsBundleKey = str5;
    }

    public /* synthetic */ ECPromoteItem(String str, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECPromoteItem)) {
            return false;
        }
        ECPromoteItem eCPromoteItem = (ECPromoteItem) other;
        return Intrinsics.areEqual(this.msg, eCPromoteItem.msg) && Intrinsics.areEqual(this.url, eCPromoteItem.url) && Intrinsics.areEqual(this.img, eCPromoteItem.img) && Intrinsics.areEqual(this.nightImg, eCPromoteItem.nightImg) && Intrinsics.areEqual(this.jsBundleKey, eCPromoteItem.jsBundleKey);
    }
}
