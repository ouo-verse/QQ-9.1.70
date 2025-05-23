package rh4;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import pl4.a;
import trpc.yes.common.YesUserRankingOuterClass$QueryUserRankingReq;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\b"}, d2 = {"Lrh4/a;", "Lpl4/a;", "", "b", "<init>", "()V", "d", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a extends pl4.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lrh4/a$a;", "", "", "roomId", "", "from", "pageSize", "Lmqq/app/NewIntent;", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: rh4.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NewIntent a(long roomId, int from, int pageSize) {
            YesUserRankingOuterClass$QueryUserRankingReq yesUserRankingOuterClass$QueryUserRankingReq = new YesUserRankingOuterClass$QueryUserRankingReq();
            yesUserRankingOuterClass$QueryUserRankingReq.RoomID.set(roomId);
            yesUserRankingOuterClass$QueryUserRankingReq.From.set(from);
            yesUserRankingOuterClass$QueryUserRankingReq.PageSize.set(pageSize);
            NewIntent a16 = a.C11028a.a(yesUserRankingOuterClass$QueryUserRankingReq, a.class);
            Intrinsics.checkNotNullExpressionValue(a16, "createRequestIntent(reqD\u2026nkingServlet::class.java)");
            return a16;
        }

        Companion() {
        }
    }

    @Override // pl4.a
    protected int b() {
        return 1301;
    }
}
