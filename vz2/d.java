package vz2;

import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lvz2/d;", "", "", "a", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f443778a = new d();

    d() {
    }

    @NotNull
    public final String a() {
        String clientMode = GdtDeviceInfoHelper.getClientMode();
        Intrinsics.checkNotNullExpressionValue(clientMode, "getClientMode()");
        return clientMode;
    }
}
