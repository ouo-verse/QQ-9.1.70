package zk0;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2 = {"Lzk0/b;", "Ltk0/b;", "<init>", "()V", "a", "b", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public class b implements tk0.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lzk0/b$a;", "Lzk0/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "()J", "uin", "<init>", "(J)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: zk0.b$a, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class OnClickCreateMiniXW extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long uin;

        public OnClickCreateMiniXW(long j3) {
            this.uin = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getUin() {
            return this.uin;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (!(other instanceof OnClickCreateMiniXW) || this.uin != ((OnClickCreateMiniXW) other).uin) {
                    return false;
                }
                return true;
            }
            return true;
        }

        public int hashCode() {
            long j3 = this.uin;
            return (int) (j3 ^ (j3 >>> 32));
        }

        @NotNull
        public String toString() {
            return "OnClickCreateMiniXW(uin=" + this.uin + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lzk0/b$b;", "Lzk0/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "()J", "uin", "<init>", "(J)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: zk0.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class OnClickGift extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long uin;

        public OnClickGift(long j3) {
            this.uin = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getUin() {
            return this.uin;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (!(other instanceof OnClickGift) || this.uin != ((OnClickGift) other).uin) {
                    return false;
                }
                return true;
            }
            return true;
        }

        public int hashCode() {
            long j3 = this.uin;
            return (int) (j3 ^ (j3 >>> 32));
        }

        @NotNull
        public String toString() {
            return "OnClickGift(uin=" + this.uin + ")";
        }
    }
}
