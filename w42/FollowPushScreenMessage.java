package w42;

import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lw42/c;", "Lw42/f;", "", "toString", "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "d", "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "b", "()Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "followPushMessage", "Lw42/i;", "e", "Lw42/i;", "msgHeader", "<init>", "(Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;)V", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: w42.c, reason: from toString */
/* loaded from: classes15.dex */
public final class FollowPushScreenMessage implements f {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final FollowPushMessage followPushMessage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i msgHeader;

    public FollowPushScreenMessage(@NotNull FollowPushMessage followPushMessage) {
        Intrinsics.checkNotNullParameter(followPushMessage, "followPushMessage");
        this.followPushMessage = followPushMessage;
        this.msgHeader = new i();
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final FollowPushMessage getFollowPushMessage() {
        return this.followPushMessage;
    }

    @NotNull
    public String toString() {
        return "FollowPushScreenMessage(followPushMessage=" + this.followPushMessage + ')';
    }
}
