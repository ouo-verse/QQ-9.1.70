package rs2;

import com.tencent.mobileqq.troop.data.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lrs2/a;", "Lcom/tencent/qqnt/base/mvi/a;", "<init>", "()V", "a", "Lrs2/a$a;", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class a implements com.tencent.qqnt.base.mvi.a {
    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0013\u001a\u00020\b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lrs2/a$a;", "Lrs2/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/mobileqq/troop/data/n;", "a", "Ljava/util/List;", "()Ljava/util/List;", "data", "b", "Z", "()Z", "isEnd", "<init>", "(Ljava/util/List;Z)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: rs2.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class FileListUpdate extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<n> data;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isEnd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FileListUpdate(List<n> data, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.isEnd = z16;
        }

        public final List<n> a() {
            return this.data;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsEnd() {
            return this.isEnd;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.data.hashCode() * 31;
            boolean z16 = this.isEnd;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        public String toString() {
            return "FileListUpdate(data=" + this.data + ", isEnd=" + this.isEnd + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileListUpdate)) {
                return false;
            }
            FileListUpdate fileListUpdate = (FileListUpdate) other;
            return Intrinsics.areEqual(this.data, fileListUpdate.data) && this.isEnd == fileListUpdate.isEnd;
        }
    }
}
