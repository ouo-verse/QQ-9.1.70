package xv0;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\r\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lxv0/a;", "", "", "a", "J", "c", "()J", "giftSubId", "b", "giftNum", "", "Ljava/lang/String;", "()Ljava/lang/String;", "giftDesc", "<init>", "(JJLjava/lang/String;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long giftSubId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long giftNum;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String giftDesc;

    public a(long j3, long j16, @NotNull String giftDesc) {
        Intrinsics.checkNotNullParameter(giftDesc, "giftDesc");
        this.giftSubId = j3;
        this.giftNum = j16;
        this.giftDesc = giftDesc;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGiftDesc() {
        return this.giftDesc;
    }

    /* renamed from: b, reason: from getter */
    public final long getGiftNum() {
        return this.giftNum;
    }

    /* renamed from: c, reason: from getter */
    public final long getGiftSubId() {
        return this.giftSubId;
    }
}
