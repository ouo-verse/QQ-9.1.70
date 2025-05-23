package qi4;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.strategy.IPlayerStrategy;
import com.tencent.timi.game.liveroom.impl.room.gameinfo.LiveBannerContainerContainer;
import com.tencent.timi.game.liveroom.impl.room.playtogether.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mm4.b;
import nf4.c;
import nf4.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pf4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\bH\u0016R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lqi4/a;", "Lnf4/h;", "", "b", "", "bizScene", "Lof4/b;", "g", "Lkf4/a;", "guildInfo", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lnf4/c;", "e", "Lpf4/d;", "f", "", "isSelfAnchor", "guildIdInfo", "liveGameId", "a", "Lkf4/b;", "anchorGuildInfo", "d", "c", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/x;", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/x;", "mPlayTogetherService", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a implements h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f428963a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final x mPlayTogetherService;

    static {
        a aVar = new a();
        f428963a = aVar;
        mPlayTogetherService = new x();
        aVar.b();
    }

    a() {
    }

    @Override // nf4.h
    public void a(boolean isSelfAnchor, @NotNull kf4.a guildIdInfo, int liveGameId) {
        Intrinsics.checkNotNullParameter(guildIdInfo, "guildIdInfo");
        ((ni4.a) b.b(ni4.a.class)).l2().a(isSelfAnchor, guildIdInfo, liveGameId);
    }

    public final void b() {
        try {
            ((IPlayerStrategy) QRoute.api(IPlayerStrategy.class)).init();
        } catch (Exception e16) {
            QLog.e("TimiLiveApiImpl", 1, "initPlayerStrategy fail!", e16);
        }
    }

    @Override // nf4.h
    public void c(@NotNull kf4.a guildIdInfo) {
        Intrinsics.checkNotNullParameter(guildIdInfo, "guildIdInfo");
        ((ni4.a) b.b(ni4.a.class)).l2().c(guildIdInfo);
    }

    @Override // nf4.h
    public void d(@Nullable kf4.b anchorGuildInfo) {
        ((ni4.a) b.b(ni4.a.class)).l2().d(anchorGuildInfo);
    }

    @Override // nf4.h
    @Nullable
    public c e(@Nullable kf4.a guildInfo, @Nullable Activity activity) {
        if (activity == null) {
            return null;
        }
        LiveBannerContainerContainer liveBannerContainerContainer = new LiveBannerContainerContainer(activity, null, 2, null);
        liveBannerContainerContainer.setGuildInfo(guildInfo);
        return liveBannerContainerContainer;
    }

    @Override // nf4.h
    @NotNull
    public d f() {
        return mPlayTogetherService;
    }

    @Override // nf4.h
    @NotNull
    public of4.b g(int bizScene) {
        return new ri4.a(bizScene);
    }
}
