package xq1;

import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.base.repository.RepositoryCallbackConfig;
import com.tencent.mobileqq.guild.base.repository.ResultDispatcher;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBannerBizId;
import com.tencent.mobileqq.qqguildsdk.data.genc.cb;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wh2.dd;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u00019B\t\b\u0002\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0007J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0012H\u0007J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0012H\u0007J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016R\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010!R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0014\u00100\u001a\u00020-8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00103\u001a\u0002018BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u00102R\u0014\u00107\u001a\u0002048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088VX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b9\u0010:\u00a8\u0006>"}, d2 = {"Lxq1/c;", "Lcom/tencent/mobileqq/guild/base/repository/b;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "guildId", "Lxq1/a;", "j", "", "isVisitor", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/base/repository/h;", "callback", "", h.F, "Lxq1/f;", "listener", "f", "Lxq1/e;", "g", ReportConstant.COSTREPORT_PREFIX, "t", "r", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGlobalBanner;", "guildBanner", "p", "o", "account", "onAccountChanged", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "serviceHolder", "Lxq1/c$a;", "Lxq1/c$a;", "announceUpdateObserver", "Ljava/util/concurrent/ConcurrentHashMap;", "i", "Ljava/util/concurrent/ConcurrentHashMap;", "announcements", "Ljava/util/concurrent/CopyOnWriteArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", BdhLogUtil.LogTag.Tag_Conn, "channelListeners", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "l", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "gproGlobalService", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gproService", "Lcom/tencent/mobileqq/guild/api/IGuildAdapterService;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/guild/api/IGuildAdapterService;", "guildAdapterService", "Lcom/tencent/mobileqq/guild/base/repository/c;", "a", "()Lcom/tencent/mobileqq/guild/base/repository/c;", "repositoryCallbackConfig", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c implements com.tencent.mobileqq.guild.base.repository.b, com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<f> channelListeners;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final c f448387e;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ServiceCache$LazyHolder serviceHolder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a announceUpdateObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Announcement> announcements;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<e> listeners;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.guild.base.repository.d f448392d = new com.tencent.mobileqq.guild.base.repository.d("Guild.ann.GlobalAnnounceRepository");

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014J,\u0010\u000e\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0014J\"\u0010\u0011\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0014J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0014\u00a8\u0006\u0016"}, d2 = {"Lxq1/c$a;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGlobalBanner;", "newGuildBanner", "", "onGlobalBannerUpdated", "removedGuildBanner", "onGlobalBannerRemoved", "", "guildId", "channelId", "", "oldVisibleType", "newVisibleType", "onChannelVisibleChanged", "", "channelIds", "onPushChannelDestroy", "channelUin", "onChannelInfoUpdated", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private static final class a extends GPServiceObserver {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            super.onChannelInfoUpdated(channelUin);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.ann.GlobalAnnounceRepository", 2, "onChannelInfoUpdated(" + channelUin + ")");
            }
            Iterator it = c.channelListeners.iterator();
            while (it.hasNext()) {
                ((f) it.next()).c(channelUin);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelVisibleChanged(@Nullable String guildId, @Nullable String channelId, int oldVisibleType, int newVisibleType) {
            super.onChannelVisibleChanged(guildId, channelId, oldVisibleType, newVisibleType);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.ann.GlobalAnnounceRepository", 2, "onChannelVisibleChanged(" + guildId + ")(" + channelId + ")(" + oldVisibleType + ")(" + newVisibleType + ")");
            }
            Iterator it = c.channelListeners.iterator();
            while (it.hasNext()) {
                ((f) it.next()).b(guildId, channelId, oldVisibleType, newVisibleType);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onGlobalBannerRemoved(@Nullable IGProGlobalBanner removedGuildBanner) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.ann.GlobalAnnounceRepository", 2, "onGlobalBannerRemoved(" + removedGuildBanner + ")");
            }
            if (removedGuildBanner != null) {
                c.f448387e.o(removedGuildBanner);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onGlobalBannerUpdated(@Nullable IGProGlobalBanner newGuildBanner) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.ann.GlobalAnnounceRepository", 2, "onGlobalBannerUpdated(" + newGuildBanner + ")");
            }
            if (newGuildBanner != null) {
                c.f448387e.p(newGuildBanner);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onPushChannelDestroy(@Nullable String guildId, @Nullable List<String> channelIds) {
            super.onPushChannelDestroy(guildId, channelIds);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.ann.GlobalAnnounceRepository", 2, "onPushChannelDestroy(" + channelIds + ")");
            }
            Iterator it = c.channelListeners.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(channelIds);
            }
        }
    }

    static {
        c cVar = new c();
        f448387e = cVar;
        serviceHolder = new ServiceCache$LazyHolder("Guild.ann.GlobalAnnounceRepository");
        a aVar = new a();
        announceUpdateObserver = aVar;
        announcements = new ConcurrentHashMap<>();
        listeners = new CopyOnWriteArrayList<>();
        channelListeners = new CopyOnWriteArrayList<>();
        AccountChangedNotifier.f214789d.a(cVar);
        cVar.l().addObserver(aVar);
    }

    c() {
    }

    @JvmStatic
    public static final void f(@NotNull f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        channelListeners.addIfAbsent(listener);
    }

    @JvmStatic
    public static final void g(@NotNull e listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.addIfAbsent(listener);
    }

    @JvmStatic
    public static final void h(@NotNull String guildId, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        int i3;
        long j3;
        IGProGuildBannerBizId bizId;
        IGProGuildBannerBizId bizId2;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        c cVar = f448387e;
        final ResultDispatcher resultDispatcher = new ResultDispatcher("clearAnnouncement " + guildId, callback, cVar.getRepositoryCallbackConfig().getInlineDispatcher());
        if (!NetworkUtil.isNetworkAvailable()) {
            ri1.a b16 = ri1.a.b(-93, "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
            Intrinsics.checkNotNullExpressionValue(b16, "error(GProStateCode.ERRO\u2026R_NETWORK_NOTSUPPORT_MSG)");
            resultDispatcher.b(b16);
            return;
        }
        Announcement j16 = j(guildId);
        cb cbVar = new cb();
        cbVar.i(MiscKt.l(guildId));
        cbVar.h(MiscKt.l(j16.b()));
        cbVar.f(j16.a());
        IGProGlobalBanner globalBanner = j16.getGlobalBanner();
        if (globalBanner != null && (bizId2 = globalBanner.getBizId()) != null) {
            i3 = bizId2.getBannerType();
        } else {
            i3 = 0;
        }
        cbVar.g(i3);
        IGProGlobalBanner globalBanner2 = j16.getGlobalBanner();
        if (globalBanner2 != null && (bizId = globalBanner2.getBizId()) != null) {
            j3 = bizId.getMsgSeq();
        } else {
            j3 = 0;
        }
        cbVar.j(j3);
        cVar.m().deleteGuildGlobalBanner(cbVar, new dd() { // from class: xq1.b
            @Override // wh2.dd
            public final void a(int i16, String str, IGProGlobalBanner iGProGlobalBanner) {
                c.i(ResultDispatcher.this, i16, str, iGProGlobalBanner);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ResultDispatcher this_networkGuard, int i3, String str, IGProGlobalBanner iGProGlobalBanner) {
        Intrinsics.checkNotNullParameter(this_networkGuard, "$this_networkGuard");
        ri1.a error = ri1.a.b(i3, str);
        Logger.f235387a.d().d("Guild.ann.GlobalAnnounceRepository", 1, "clearAnnouncement result: " + i3 + ", msg: " + str);
        if (!error.d()) {
            Intrinsics.checkNotNullExpressionValue(error, "error");
            this_networkGuard.b(error);
        } else {
            this_networkGuard.c(Boolean.TRUE);
        }
    }

    @JvmStatic
    @NotNull
    public static final Announcement j(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return k(guildId, true);
    }

    @JvmStatic
    @NotNull
    public static final Announcement k(@NotNull String guildId, boolean isVisitor) {
        Announcement announcement;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (isVisitor) {
            announcement = f448387e.r(guildId, true);
        } else {
            announcement = announcements.get(guildId);
            if (announcement == null) {
                announcement = f448387e.r(guildId, false);
            }
            Intrinsics.checkNotNullExpressionValue(announcement, "{\n            announceme\u2026guildId, false)\n        }");
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.ann.GlobalAnnounceRepository", 2, "fetchAnnouncement(" + guildId + ") = " + announcement);
        }
        return announcement;
    }

    private final IGProGlobalService l() {
        return serviceHolder.a();
    }

    private final IGPSService m() {
        return serviceHolder.b();
    }

    private final IGuildAdapterService n() {
        return serviceHolder.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(IGProGlobalBanner guildBanner) {
        String guildId = guildBanner.getGuildId();
        Announcement announcement = announcements.get(guildId);
        if (announcement == null) {
            Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
            announcement = new Announcement(guildId, guildBanner);
        }
        Iterator<e> it = listeners.iterator();
        while (it.hasNext()) {
            it.next().b(announcement);
        }
        announcements.remove(guildId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(IGProGlobalBanner guildBanner) {
        String guildId = guildBanner.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        Announcement announcement = new Announcement(guildId, guildBanner);
        announcements.put(guildId, announcement);
        Iterator<e> it = listeners.iterator();
        while (it.hasNext()) {
            it.next().a(announcement);
        }
    }

    @JvmStatic
    public static final boolean q(@NotNull String guildId) {
        String bannerId;
        boolean z16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        IGProGlobalBanner guildGlobalBanner = f448387e.m().getGuildGlobalBanner(guildId);
        if (guildGlobalBanner == null || (bannerId = guildGlobalBanner.getBannerId()) == null) {
            return false;
        }
        if (bannerId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    private final Announcement r(String guildId, boolean isVisitor) {
        return new Announcement(guildId, n().getGuildBanner(guildId, !isVisitor ? 1 : 0));
    }

    @JvmStatic
    public static final void s(@NotNull f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        channelListeners.remove(listener);
    }

    @JvmStatic
    public static final void t(@NotNull e listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    @Override // com.tencent.mobileqq.guild.base.repository.b
    @NotNull
    /* renamed from: a */
    public RepositoryCallbackConfig getRepositoryCallbackConfig() {
        return this.f448392d.getRepositoryCallbackConfig();
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        announcements.clear();
        IGProGlobalService l3 = l();
        a aVar = announceUpdateObserver;
        l3.deleteObserver(aVar);
        serviceHolder = new ServiceCache$LazyHolder("Guild.ann.GlobalAnnounceRepository");
        l().addObserver(aVar);
    }
}
