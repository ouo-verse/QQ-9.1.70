package sj0;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lsj0/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "text", "b", "value", "c", "I", "()I", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: sj0.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ECFilterOptionItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String text;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String value;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    public ECFilterOptionItem(String str, String str2, int i3) {
        this.text = str;
        this.value = str2;
        this.type = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.text;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.type;
    }

    public String toString() {
        return "ECFilterOptionItem(text=" + this.text + ", value=" + this.value + ", type=" + this.type + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECFilterOptionItem)) {
            return false;
        }
        ECFilterOptionItem eCFilterOptionItem = (ECFilterOptionItem) other;
        return Intrinsics.areEqual(this.text, eCFilterOptionItem.text) && Intrinsics.areEqual(this.value, eCFilterOptionItem.value) && this.type == eCFilterOptionItem.type;
    }
}
