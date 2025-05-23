package q12;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetChannelActivityRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.bh;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import wh2.bv;
import wh2.em;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005R\u0011\u0010\u0012\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lq12/g;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetChannelActivityRsp;", "", "i", "", "guildId", "requestTag", "", "channelType", "Lq12/i;", "callback", "", "f", "d", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", tl.h.F, "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gpsService", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f428207a = new g();

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(long j3, int i3, String str) {
        Logger.f235387a.d().i("Guild.comm.GuildOperationBannerViewRepo", 1, "closeBanner: guildId=" + j3 + ", result=" + i3 + " msg=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(i callback, String requestTag, int i3, String str, IGProGetChannelActivityRsp iGProGetChannelActivityRsp) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(requestTag, "$requestTag");
        String str2 = null;
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str3 = "fetchBannerData error, result:" + i3 + " msg:" + str;
            if (str3 instanceof String) {
                bVar.a().add(str3);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.comm.GuildOperationBannerViewRepo", 1, (String) it.next(), null);
            }
            return;
        }
        Logger.a d16 = Logger.f235387a.d();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("fetchBannerData: ");
        if (iGProGetChannelActivityRsp != null) {
            str2 = f428207a.i(iGProGetChannelActivityRsp);
        }
        sb5.append(str2);
        d16.i("Guild.comm.GuildOperationBannerViewRepo", 1, sb5.toString());
        callback.a(requestTag, iGProGetChannelActivityRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i(IGProGetChannelActivityRsp iGProGetChannelActivityRsp) {
        return "guildId=" + iGProGetChannelActivityRsp.getGuildId() + ", size=" + iGProGetChannelActivityRsp.getChannelActivities().size() + ", isShow=" + iGProGetChannelActivityRsp.getIsShow() + ", closeOption=" + iGProGetChannelActivityRsp.getCloseOption();
    }

    public final void d(final long guildId) {
        h().closeChannelActivitySwitch(guildId, new em() { // from class: q12.e
            @Override // wh2.em
            public final void onResult(int i3, String str) {
                g.e(guildId, i3, str);
            }
        });
    }

    public final void f(long guildId, @NotNull final String requestTag, int channelType, @NotNull final i callback) {
        Intrinsics.checkNotNullParameter(requestTag, "requestTag");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IGPSService h16 = h();
        bh bhVar = new bh();
        bhVar.d(guildId);
        bhVar.c(channelType);
        h16.getChannelActivity(bhVar, new bv() { // from class: q12.f
            @Override // wh2.bv
            public final void a(int i3, String str, IGProGetChannelActivityRsp iGProGetChannelActivityRsp) {
                g.g(i.this, requestTag, i3, str, iGProGetChannelActivityRsp);
            }
        });
    }

    @NotNull
    public final IGPSService h() {
        IRuntimeService b16 = bz.b(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(b16, "runtimeService(IGPSService::class.java)");
        return (IGPSService) b16;
    }
}
