package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"Lshark/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "getNameStringId", "()J", "nameStringId", "b", "I", "getType", "()I", "type", "shark-hprof"}, k = 1, mv = {1, 4, 1})
/* renamed from: shark.e, reason: from toString */
/* loaded from: classes29.dex */
public final /* data */ class FieldRecord {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long nameStringId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FieldRecord) {
                FieldRecord fieldRecord = (FieldRecord) other;
                if (this.nameStringId != fieldRecord.nameStringId || this.type != fieldRecord.type) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j3 = this.nameStringId;
        return (((int) (j3 ^ (j3 >>> 32))) * 31) + this.type;
    }

    @NotNull
    public String toString() {
        return "FieldRecord(nameStringId=" + this.nameStringId + ", type=" + this.type + ")";
    }
}
