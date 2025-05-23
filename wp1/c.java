package wp1;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.base.repository.RepositoryCallbackConfig;
import com.tencent.mobileqq.guild.base.repository.ResultDispatcher;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vh2.cd;
import vh2.r;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\bF\u0010\u001fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003J\b\u0010\u0007\u001a\u00020\u0005H\u0007J\u001e\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007J\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007J\b\u0010\u000e\u001a\u00020\nH\u0007J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u001c\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u0012\u0004\b\u001e\u0010\u001fR*\u0010$\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00038\u0006@BX\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001d\u0012\u0004\b#\u0010\u001f\u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\"\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001507068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010A\u001a\u00020?8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010@R\u0014\u0010E\u001a\u00020B8VX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bC\u0010D\u00a8\u0006G"}, d2 = {"Lwp1/c;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "Lcom/tencent/mobileqq/guild/base/repository/b;", "", "switchStatus", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "status", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "callback", "t", ReportConstant.COSTREPORT_PREFIX, "p", "u", h.F, "Loo1/a;", "j", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "i", "Lwp1/a;", "aware", "g", "r", "", "account", "onAccountChanged", "f", "I", "getSwitchStatus$annotations", "()V", "<set-?>", "o", "()I", "getNotifyStatus$annotations", "notifyStatus", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isFetching", "Lcom/tencent/common/app/AppInterface;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/common/app/AppInterface;", "appInterface", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "serviceHolder", "D", "Loo1/a;", "guildObserver", "E", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpsServiceObserver", "", "Lmqq/util/WeakReference;", UserInfo.SEX_FEMALE, "Ljava/util/List;", "switchStatusListeners", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gproService", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "gproGlobalService", "Lcom/tencent/mobileqq/guild/base/repository/c;", "a", "()Lcom/tencent/mobileqq/guild/base/repository/c;", "repositoryCallbackConfig", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements com.tencent.mobileqq.guild.base.repository.a, com.tencent.mobileqq.guild.base.repository.b {

    /* renamed from: C, reason: from kotlin metadata */
    private static ServiceCache$LazyHolder serviceHolder;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private static final oo1.a guildObserver;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private static final GPServiceObserver gpsServiceObserver;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private static List<? extends WeakReference<wp1.a>> switchStatusListeners;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final c f446014e;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int switchStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static int notifyStatus;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static AtomicBoolean isFetching;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static AppInterface appInterface;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.guild.base.repository.d f446019d = new com.tencent.mobileqq.guild.base.repository.d("GuildInboxNotificationRepository");

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"wp1/c$a", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "switchStatus", "", "onPushDirectMsgSwitchUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onPushDirectMsgSwitchUpdate(int switchStatus) {
            boolean z16;
            super.onPushDirectMsgSwitchUpdate(switchStatus);
            int i3 = 2;
            if (switchStatus == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            Logger.f235387a.d().d("Guild.C2C.GuildInboxNotificationRepository", 1, "onDirectMsgSwitchChanged open: " + z16);
            if (!z16) {
                i3 = 3;
            }
            c.q(i3);
            BusinessHandler businessHandler = ch.l().getBusinessHandler(QQGuildHandler.class.getName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler");
            ((QQGuildHandler) businessHandler).c3(z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"wp1/c$b", "Loo1/a;", "", "open", "", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends oo1.a {
        b() {
        }

        @Override // oo1.a
        public void f(boolean open) {
            int i3;
            super.f(open);
            Logger.f235387a.d().d("Guild.C2C.GuildInboxNotificationRepository", 1, "onDirectMsgSwitchChanged open: " + open);
            if (open) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            c.q(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"wp1/c$c", "Lvh2/cd;", "", "code", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "security", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: wp1.c$c, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C11500c implements cd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResultDispatcher<Boolean> f446020a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f446021b;

        C11500c(ResultDispatcher<Boolean> resultDispatcher, int i3) {
            this.f446020a = resultDispatcher;
            this.f446021b = i3;
        }

        @Override // vh2.cd
        public void a(int code, @Nullable String errMsg, @Nullable IGProSecurityResult security) {
            ri1.a result = ri1.a.e(code, errMsg, security);
            if (!result.d()) {
                ResultDispatcher<Boolean> resultDispatcher = this.f446020a;
                Intrinsics.checkNotNullExpressionValue(result, "result");
                resultDispatcher.b(result);
            } else {
                this.f446020a.c(Boolean.TRUE);
                c.notifyStatus = this.f446021b;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"wp1/c$d", "Lvh2/cd;", "", "code", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "security", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements cd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResultDispatcher<Boolean> f446022a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f446023b;

        d(ResultDispatcher<Boolean> resultDispatcher, int i3) {
            this.f446022a = resultDispatcher;
            this.f446023b = i3;
        }

        @Override // vh2.cd
        public void a(int code, @Nullable String errMsg, @Nullable IGProSecurityResult security) {
            boolean z16;
            ri1.a result = ri1.a.e(code, errMsg, security);
            if (!result.d()) {
                ResultDispatcher<Boolean> resultDispatcher = this.f446022a;
                Intrinsics.checkNotNullExpressionValue(result, "result");
                resultDispatcher.b(result);
                return;
            }
            this.f446022a.c(Boolean.TRUE);
            BusinessHandler businessHandler = ch.l().getBusinessHandler(QQGuildHandler.class.getName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler");
            QQGuildHandler qQGuildHandler = (QQGuildHandler) businessHandler;
            if (this.f446023b == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            qQGuildHandler.c3(z16);
            c.switchStatus = this.f446023b;
        }
    }

    static {
        List<? extends WeakReference<wp1.a>> emptyList;
        c cVar = new c();
        f446014e = cVar;
        isFetching = new AtomicBoolean(false);
        guildObserver = cVar.j();
        gpsServiceObserver = cVar.i();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        switchStatusListeners = emptyList;
        AccountChangedNotifier.f214789d.a(cVar);
        cVar.u();
    }

    c() {
    }

    private final void h() {
        AppInterface appInterface2 = appInterface;
        if (appInterface2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appInterface");
            appInterface2 = null;
        }
        appInterface2.removeObserver(guildObserver);
        m().deleteObserver(gpsServiceObserver);
    }

    private final GPServiceObserver i() {
        return new a();
    }

    private final oo1.a j() {
        return new b();
    }

    @JvmStatic
    public static final void k() {
        if (!isFetching.compareAndSet(false, true)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("fetchDirectMsgStatus error, isFetching");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.GuildInboxNotificationRepository", 1, (String) it.next(), null);
            }
            return;
        }
        f446014e.n().fetchDirectMsgStatus(new r() { // from class: wp1.b
            @Override // vh2.r
            public final void a(int i3, String str, int i16, int i17, int i18) {
                c.l(i3, str, i16, i17, i18);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(int i3, String str, int i16, int i17, int i18) {
        isFetching.set(false);
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "fetchDirectMsgStatus error, result: " + i3 + " errMsg:" + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.GuildInboxNotificationRepository", 1, (String) it.next(), null);
            }
            return;
        }
        Logger.f235387a.d().d("Guild.C2C.GuildInboxNotificationRepository", 1, "fetchDirectMsgStatus success, switchStatus:" + i16 + " notifyStatus:" + i17 + " userTestGroup:" + i18);
        q(i16);
        notifyStatus = i17;
    }

    private final IGProGlobalService m() {
        ServiceCache$LazyHolder serviceCache$LazyHolder = serviceHolder;
        if (serviceCache$LazyHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
            serviceCache$LazyHolder = null;
        }
        return serviceCache$LazyHolder.a();
    }

    private final IGPSService n() {
        ServiceCache$LazyHolder serviceCache$LazyHolder = serviceHolder;
        if (serviceCache$LazyHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
            serviceCache$LazyHolder = null;
        }
        return serviceCache$LazyHolder.b();
    }

    public static final int o() {
        return notifyStatus;
    }

    @JvmStatic
    public static final boolean p() {
        int i3 = switchStatus;
        if (i3 != 2 && i3 != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final void q(int switchStatus2) {
        if (switchStatus != switchStatus2) {
            Logger.f235387a.d().i("Guild.C2C.GuildInboxNotificationRepository", 1, "notifySwitchStatusChange:" + switchStatus + " -> " + switchStatus2);
            switchStatus = switchStatus2;
            Iterator<T> it = switchStatusListeners.iterator();
            while (it.hasNext()) {
                wp1.a aVar = (wp1.a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.X7(switchStatus2);
                }
            }
        }
    }

    @JvmStatic
    public static final void s(int status, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        c cVar = f446014e;
        ResultDispatcher resultDispatcher = new ResultDispatcher("setMsgNotifyStatus", callback, cVar.getRepositoryCallbackConfig().getInlineDispatcher());
        if (!NetworkUtil.isNetworkAvailable()) {
            ri1.a b16 = ri1.a.b(-93, "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
            Intrinsics.checkNotNullExpressionValue(b16, "error(GProStateCode.ERRO\u2026R_NETWORK_NOTSUPPORT_MSG)");
            resultDispatcher.b(b16);
        } else {
            cVar.n().setDirectMsgStatus(0, status, new C11500c(resultDispatcher, status));
        }
    }

    @JvmStatic
    public static final void t(int status, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        c cVar = f446014e;
        ResultDispatcher resultDispatcher = new ResultDispatcher("setMsgSwitchStatus", callback, cVar.getRepositoryCallbackConfig().getInlineDispatcher());
        if (!NetworkUtil.isNetworkAvailable()) {
            ri1.a b16 = ri1.a.b(-93, "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
            Intrinsics.checkNotNullExpressionValue(b16, "error(GProStateCode.ERRO\u2026R_NETWORK_NOTSUPPORT_MSG)");
            resultDispatcher.b(b16);
        } else {
            cVar.n().setDirectMsgStatus(status, 0, new d(resultDispatcher, status));
        }
    }

    private final void u() {
        AppInterface l3 = ch.l();
        Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
        appInterface = l3;
        serviceHolder = new ServiceCache$LazyHolder("Guild.C2C.GuildInboxNotificationRepository");
        AppInterface appInterface2 = appInterface;
        if (appInterface2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appInterface");
            appInterface2 = null;
        }
        appInterface2.addObserver(guildObserver);
        m().addObserver(gpsServiceObserver);
        k();
    }

    @Override // com.tencent.mobileqq.guild.base.repository.b
    @NotNull
    /* renamed from: a */
    public RepositoryCallbackConfig getRepositoryCallbackConfig() {
        return this.f446019d.getRepositoryCallbackConfig();
    }

    public final synchronized void g(@NotNull wp1.a aware) {
        boolean z16;
        boolean z17;
        List<? extends WeakReference<wp1.a>> plus;
        boolean z18;
        Intrinsics.checkNotNullParameter(aware, "aware");
        List<? extends WeakReference<wp1.a>> list = switchStatusListeners;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() == aware) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = false;
                    break;
                }
            }
        }
        z17 = true;
        if (z17) {
            List<? extends WeakReference<wp1.a>> list2 = switchStatusListeners;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                if (((WeakReference) obj).get() != 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    arrayList.add(obj);
                }
            }
            plus = CollectionsKt___CollectionsKt.plus((Collection<? extends WeakReference>) ((Collection<? extends Object>) arrayList), new WeakReference(aware));
            switchStatusListeners = plus;
        }
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        h();
        u();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0014 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void r(@NotNull wp1.a aware) {
        boolean z16;
        Intrinsics.checkNotNullParameter(aware, "aware");
        List<? extends WeakReference<wp1.a>> list = switchStatusListeners;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            WeakReference weakReference = (WeakReference) obj;
            if (weakReference.get() != aware && weakReference.get() != 0) {
                z16 = false;
                if (z16) {
                    arrayList.add(obj);
                }
            }
            z16 = true;
            if (z16) {
            }
        }
        switchStatusListeners = arrayList;
    }
}
