package yj0;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lyj0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "name", "b", "I", WadlProxyConsts.CHANNEL, "c", "getAdId", "()Ljava/lang/String;", "adId", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: yj0.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ECAdvertiseItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int channel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String adId;

    public ECAdvertiseItem() {
        this(null, 0, null, 7, null);
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.channel) * 31;
        String str2 = this.adId;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ECAdvertiseItem(name=" + this.name + ", channel=" + this.channel + ", adId=" + this.adId + ")";
    }

    public ECAdvertiseItem(String str, int i3, String str2) {
        this.name = str;
        this.channel = i3;
        this.adId = str2;
    }

    public /* synthetic */ ECAdvertiseItem(String str, int i3, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? "" : str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECAdvertiseItem)) {
            return false;
        }
        ECAdvertiseItem eCAdvertiseItem = (ECAdvertiseItem) other;
        return Intrinsics.areEqual(this.name, eCAdvertiseItem.name) && this.channel == eCAdvertiseItem.channel && Intrinsics.areEqual(this.adId, eCAdvertiseItem.adId);
    }
}
