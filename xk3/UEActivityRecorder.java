package xk3;

import com.tencent.mobileqq.zplan.utils.stack.lifecycle.ProcessName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lxk3/c;", "", "other", "", "equals", "", "toString", "", "hashCode", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "key", "b", "process", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: xk3.c, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class UEActivityRecorder {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String key;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String process;

    public UEActivityRecorder(String key, @ProcessName String process) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(process, "process");
        this.key = key;
        this.process = process;
    }

    /* renamed from: a, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: b, reason: from getter */
    public final String getProcess() {
        return this.process;
    }

    public boolean equals(Object other) {
        if (!(other instanceof UEActivityRecorder)) {
            return false;
        }
        UEActivityRecorder uEActivityRecorder = (UEActivityRecorder) other;
        return Intrinsics.areEqual(uEActivityRecorder.key, this.key) && Intrinsics.areEqual(uEActivityRecorder.process, this.process);
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + this.process.hashCode();
    }

    public String toString() {
        return "UEActivityRecorder(key=" + this.key + ", process=" + this.process + ")";
    }
}
