package zi0;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lzi0/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "screenOn", "<init>", "(Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: zi0.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ECScreenEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean screenOn;

    public ECScreenEvent(boolean z16) {
        this.screenOn = z16;
    }

    public int hashCode() {
        boolean z16 = this.screenOn;
        if (z16) {
            return 1;
        }
        return z16 ? 1 : 0;
    }

    public String toString() {
        return "ECScreenEvent(screenOn=" + this.screenOn + ")";
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ECScreenEvent) && this.screenOn == ((ECScreenEvent) other).screenOn;
        }
        return true;
    }
}
