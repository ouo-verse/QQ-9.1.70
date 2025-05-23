package uu1;

import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.base.repository.RepositoryCallbackConfig;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTaskInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wh2.aa;
import wh2.cf;
import wh2.em;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b?\u0010@J>\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aJ\u0016\u0010 \u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0003H\u0016R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010&R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010)R&\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u000b0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00100-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00106\u001a\u0002048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u00105R\u0014\u0010:\u001a\u0002078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8VX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b<\u0010=\u00a8\u0006A"}, d2 = {"Luu1/e;", "Lcom/tencent/mobileqq/guild/base/repository/b;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "guildId", "", "skipStatus", "", "isAllFinished", "finishedNum", "totalNum", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProTaskInfo;", "taskList", "", "l", "Luu1/f;", "listener", "e", "r", "Luu1/b;", "f", "o", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "appId", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAppInfo;", "g", "Lwh2/em;", "callBack", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, h.F, "account", "onAccountChanged", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "serviceHolder", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "missions", "i", "appInfos", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "missionUpdateObserver", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "globalService", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "k", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "service", "Lcom/tencent/mobileqq/guild/base/repository/c;", "a", "()Lcom/tencent/mobileqq/guild/base/repository/c;", "repositoryCallbackConfig", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e implements com.tencent.mobileqq.guild.base.repository.b, com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private static final GPServiceObserver missionUpdateObserver;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final e f440046e;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ServiceCache$LazyHolder serviceHolder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, MissionModel> missions;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, List<IGProAppInfo>> appInfos;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<f> listeners;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.guild.base.repository.d f440051d = new com.tencent.mobileqq.guild.base.repository.d("MissionRepository");

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014\u00a8\u0006\u000f"}, d2 = {"uu1/e$a", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "skipStatus", "", "isAllFinished", "finishedNum", "totalNum", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProTaskInfo;", "taskList", "", "onGuildCreatorGuideTaskChange", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends GPServiceObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onGuildCreatorGuideTaskChange(@NotNull String guildId, int skipStatus, boolean isAllFinished, int finishedNum, int totalNum, @NotNull List<IGProTaskInfo> taskList) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(taskList, "taskList");
            if (QLog.isColorLevel()) {
                Logger.f235387a.d().d("Guild.mission.MissionRepository", 1, "onGuildCreatorGuideTaskChange(guildId:" + guildId + ",skipStatus:" + skipStatus + ",isAllFinished:" + isAllFinished + ",finishedNum" + finishedNum + ",totalNum" + totalNum + ",taskList:" + taskList + ")");
            }
            e.f440046e.l(guildId, skipStatus, isAllFinished, finishedNum, totalNum, taskList);
        }
    }

    static {
        e eVar = new e();
        f440046e = eVar;
        serviceHolder = new ServiceCache$LazyHolder("Guild.mission.MissionRepository");
        missions = new ConcurrentHashMap<>();
        appInfos = new ConcurrentHashMap<>();
        listeners = new CopyOnWriteArrayList<>();
        a aVar = new a();
        missionUpdateObserver = aVar;
        AccountChangedNotifier.f214789d.a(eVar);
        eVar.i().addObserver(aVar);
    }

    e() {
    }

    @JvmStatic
    public static final void e(@NotNull f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.addIfAbsent(listener);
    }

    @JvmStatic
    @Nullable
    public static final MissionModel f(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        f440046e.o(guildId);
        return missions.get(guildId);
    }

    private final IGProGlobalService i() {
        return serviceHolder.a();
    }

    @JvmStatic
    @Nullable
    public static final IGProGuildInfo j(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return f440046e.k().getGuildInfo(guildId);
    }

    private final IGPSService k() {
        return serviceHolder.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(String guildId, int skipStatus, boolean isAllFinished, int finishedNum, int totalNum, List<IGProTaskInfo> taskList) {
        MissionModel missionModel = new MissionModel(guildId, skipStatus, isAllFinished, finishedNum, totalNum, Mission.INSTANCE.a(taskList, guildId));
        missions.put(guildId, missionModel);
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((f) it.next()).a(missionModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String guildId, int i3, String str, List list) {
        List<IGProAppInfo> mutableList;
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        if (i3 == 0 && list != null) {
            ConcurrentHashMap<String, List<IGProAppInfo>> concurrentHashMap = appInfos;
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
            concurrentHashMap.put(guildId, mutableList);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str2 = "fetchAppInfoList error,result" + i3 + ", errMsg" + str;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.mission.MissionRepository", 1, (String) it.next(), null);
        }
    }

    private final void o(final String guildId) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.mission.MissionRepository", 2, "loadMission guildId" + guildId);
        }
        k().getGuildCreatorTasks(guildId, false, new cf() { // from class: uu1.c
            @Override // wh2.cf
            public final void onResult(int i3, String str, int i16, boolean z16, int i17, int i18, ArrayList arrayList) {
                e.p(guildId, i3, str, i16, z16, i17, i18, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(String guildId, int i3, String str, int i16, boolean z16, int i17, int i18, ArrayList tasks) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "loadMission error, result:" + i3 + ", errorMsg:" + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.mission.MissionRepository", 1, (String) it.next(), null);
            }
            return;
        }
        e eVar = f440046e;
        Intrinsics.checkNotNullExpressionValue(tasks, "tasks");
        eVar.l(guildId, i16, z16, i17, i18, tasks);
    }

    @JvmStatic
    public static final void r(@NotNull f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    @Override // com.tencent.mobileqq.guild.base.repository.b
    @NotNull
    /* renamed from: a */
    public RepositoryCallbackConfig getRepositoryCallbackConfig() {
        return this.f440051d.getRepositoryCallbackConfig();
    }

    @Nullable
    public final IGProAppInfo g(@NotNull String guildId, long appId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        List<IGProAppInfo> list = appInfos.get(guildId);
        if (list != null) {
            for (IGProAppInfo iGProAppInfo : list) {
                if (iGProAppInfo.getAppId() == appId) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return iGProAppInfo;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        return null;
    }

    public final long h(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        List<cy> channelListForSelector = k().getChannelListForSelector(guildId, false);
        if (channelListForSelector == null) {
            return 0L;
        }
        if (channelListForSelector.size() > 1) {
            return channelListForSelector.get(1).getCategoryId();
        }
        return channelListForSelector.get(0).getCategoryId();
    }

    public final void m(@NotNull final String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        k().fetchAppInfos(guildId, new aa() { // from class: uu1.d
            @Override // wh2.aa
            public final void onResult(int i3, String str, ArrayList arrayList) {
                e.n(guildId, i3, str, arrayList);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        missions.clear();
        appInfos.clear();
        IGProGlobalService i3 = i();
        GPServiceObserver gPServiceObserver = missionUpdateObserver;
        i3.deleteObserver(gPServiceObserver);
        serviceHolder = new ServiceCache$LazyHolder("Guild.mission.MissionRepository");
        i().addObserver(gPServiceObserver);
    }

    public final void q(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        k().refreshPollingData(guildId, 5);
    }

    public final void s(@NotNull String guildId, @NotNull em callBack) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        k().setGuildCreatorTaskSkipStatus(guildId, callBack);
    }
}
