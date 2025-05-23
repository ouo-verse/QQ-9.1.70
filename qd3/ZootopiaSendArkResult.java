package qd3;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\f\u001a\u0004\b\u0005\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lqd3/a;", "", "", "toString", "", "a", "I", "b", "()I", "setResult", "(I)V", "result", "Ljava/lang/String;", "()Ljava/lang/String;", "setErr", "(Ljava/lang/String;)V", NotificationCompat.CATEGORY_ERROR, "<init>", "(ILjava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qd3.a, reason: from toString */
/* loaded from: classes21.dex */
public final class ZootopiaSendArkResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String err;

    public ZootopiaSendArkResult(int i3, @NotNull String err) {
        Intrinsics.checkNotNullParameter(err, "err");
        this.result = i3;
        this.err = err;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getErr() {
        return this.err;
    }

    /* renamed from: b, reason: from getter */
    public final int getResult() {
        return this.result;
    }

    @NotNull
    public String toString() {
        return "ZootopiaSendArkResult(result=" + this.result + ", err=" + this.err + ')';
    }
}
