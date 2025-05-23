package q0;

import com.epicgames.ue4.GameActivityNative;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\n\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\tR\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lq0/a;", "Lp0/a;", "", "result", "", "callback", "a", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", AdMetricTag.EVENT_NAME, "b", "getParams", "params", "", "c", "I", "getCallbackId", "()I", "callbackId", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "render_library_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class a implements p0.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String eventName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String params;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int callbackId;

    public a(@NotNull String eventName, @NotNull String params, int i3) {
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        Intrinsics.checkParameterIsNotNull(params, "params");
        this.eventName = eventName;
        this.params = params;
        this.callbackId = i3;
    }

    @Override // p0.a
    public void callback(@Nullable String result) {
        if (isASync()) {
            GameActivityNative.Callback(getCallbackId(), result);
            return;
        }
        b.INSTANCE.a().warn("callback error, invalid callbackId:" + getCallbackId() + ", eventName:" + getEventName() + ", result:" + result);
    }

    @Override // p0.a
    public int getCallbackId() {
        return this.callbackId;
    }

    @Override // p0.a
    @NotNull
    public String getEventName() {
        return this.eventName;
    }

    @Override // p0.a
    @NotNull
    public String getParams() {
        return this.params;
    }

    @Override // p0.a
    public boolean isASync() {
        return a.C10971a.a(this);
    }
}
