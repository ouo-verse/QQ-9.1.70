package xg4;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u000e\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u0003\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\b\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lxg4/a;", "", "", "a", "J", "c", "()J", "type", "b", "getScene", "scene", "", "I", "()I", "hintIconResId", "", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "hintIconUrl", "<init>", "(JJILjava/lang/String;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long scene;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int hintIconResId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String hintIconUrl;

    public a() {
        this(0L, 0L, 0, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getHintIconResId() {
        return this.hintIconResId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getHintIconUrl() {
        return this.hintIconUrl;
    }

    /* renamed from: c, reason: from getter */
    public final long getType() {
        return this.type;
    }

    public a(long j3, long j16, int i3, @NotNull String hintIconUrl) {
        Intrinsics.checkNotNullParameter(hintIconUrl, "hintIconUrl");
        this.type = j3;
        this.scene = j16;
        this.hintIconResId = i3;
        this.hintIconUrl = hintIconUrl;
    }

    public /* synthetic */ a(long j3, long j16, int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 99L : j3, (i16 & 2) != 0 ? 1L : j16, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? "" : str);
    }
}
