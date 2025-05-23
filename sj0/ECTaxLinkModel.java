package sj0;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\t\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lsj0/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "validCode", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "url", "<init>", "(ILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: sj0.d, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ECTaxLinkModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int validCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String url;

    public ECTaxLinkModel(int i3, String str) {
        this.validCode = i3;
        this.url = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i3 = this.validCode * 31;
        String str = this.url;
        return i3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ECTaxLinkModel(validCode=" + this.validCode + ", url=" + this.url + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECTaxLinkModel)) {
            return false;
        }
        ECTaxLinkModel eCTaxLinkModel = (ECTaxLinkModel) other;
        return this.validCode == eCTaxLinkModel.validCode && Intrinsics.areEqual(this.url, eCTaxLinkModel.url);
    }
}
