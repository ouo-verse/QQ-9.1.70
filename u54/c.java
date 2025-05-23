package u54;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w64.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lu54/c;", "Lw64/j;", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "peerUid", "", "b", "I", "getChatType", "()I", "chatType", "<init>", "(Ljava/lang/String;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class c implements j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int chatType;

    public c(@NotNull String peerUid, int i3) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        this.peerUid = peerUid;
        this.chatType = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getPeerUid() {
        return this.peerUid;
    }
}
