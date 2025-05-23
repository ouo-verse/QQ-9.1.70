package yg0;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lyg0/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getDomain", "()Ljava/lang/String;", "domain", "b", "value", "c", "Z", "isExpired", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: yg0.b, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ECPsKey {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String domain;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String value;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isExpired;

    public ECPsKey(@NotNull String str, @Nullable String str2, boolean z16) {
        this.domain = str;
        this.value = str2;
        this.isExpired = z16;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ECPsKey) {
                ECPsKey eCPsKey = (ECPsKey) other;
                if (!Intrinsics.areEqual(this.domain, eCPsKey.domain) || !Intrinsics.areEqual(this.value, eCPsKey.value) || this.isExpired != eCPsKey.isExpired) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        String str = this.domain;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        String str2 = this.value;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        int i18 = (i17 + i16) * 31;
        boolean z16 = this.isExpired;
        int i19 = z16;
        if (z16 != 0) {
            i19 = 1;
        }
        return i18 + i19;
    }

    @NotNull
    public String toString() {
        return "ECPsKey(domain=" + this.domain + ", value=" + this.value + ", isExpired=" + this.isExpired + ")";
    }
}
