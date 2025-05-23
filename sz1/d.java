package sz1;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.base.repository.RepositoryCallbackConfig;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberChange;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.data.fc;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001!\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0007J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0012\u0010\u0016\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0002J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\bH\u0016R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\"R\u0014\u0010&\u001a\u00020$8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010%R\u0014\u0010*\u001a\u00020'8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8VX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lsz1/d;", "Lcom/tencent/mobileqq/guild/base/repository/b;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "Lcom/tencent/mobileqq/guild/api/IGuildSpeakThresholdApi$a;", "listener", "", "e", "p", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGuildSpeakableThresholdPermission;", "f", "", "j", "channelId", "k", "l", "", "type", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "tinyId", DomainData.DOMAIN_NAME, "o", "account", "onAccountChanged", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "serviceHolder", "Ljava/util/concurrent/CopyOnWriteArrayList;", h.F, "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "sz1/d$a", "Lsz1/d$a;", "speakingThresholdUpdateObserver", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "service", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "g", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "igProGlobalService", "Lcom/tencent/mobileqq/guild/base/repository/c;", "a", "()Lcom/tencent/mobileqq/guild/base/repository/c;", "repositoryCallbackConfig", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d implements com.tencent.mobileqq.guild.base.repository.b, com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final d f435022e;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ServiceCache$LazyHolder serviceHolder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<IGuildSpeakThresholdApi.a> listeners;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a speakingThresholdUpdateObserver;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.guild.base.repository.d f435026d = new com.tencent.mobileqq.guild.base.repository.d("Guild.sr.SpeakThresholdRepository");

    /* compiled from: P */
    @Metadata(d1 = {"\u0000W\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0014J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004H\u0014J\u001a\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0014J2\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0014J\u001a\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J\"\u0010\u0018\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016H\u0014J8\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J&\u0010\"\u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0004H\u0014J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000fH\u0014\u00a8\u0006&"}, d2 = {"sz1/d$a", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProRoleMemberChange;", "changeList", "", "onChangeRoleMember", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "roleList", "onDeleteRole", "tinyId", "onMemberTopRoleChanged", "channelId", "", "changeType", "tinyIdList", "onChannelAdminChange", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "onGuildPermissionChanged", "Ljava/util/HashSet;", "channelIds", "onChannelPermissionChanged", "result", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "info", "onUserProfileInfoUpdate", "onGuildInfoUpdated", "guildIds", "Lcom/tencent/mobileqq/qqguildsdk/data/fc;", "thresholds", "onSpeakableThresholdUpdate", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "sourceType", "onAddGuildWithInfo", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@NotNull IGProGuildInfo info, int sourceType) {
            Intrinsics.checkNotNullParameter(info, "info");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sr.SpeakThresholdRepository", 2, "onAddGuildWithInfo guildId" + info.getGuildID());
            }
            for (IGuildSpeakThresholdApi.a aVar : d.listeners) {
                String guildID = info.getGuildID();
                Intrinsics.checkNotNullExpressionValue(guildID, "info.guildID");
                aVar.M(guildID);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChangeRoleMember(@NotNull String guildId, @Nullable List<IGProRoleMemberChange> changeList) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sr.SpeakThresholdRepository", 2, "onChangeRoleMember guildId" + guildId);
            }
            Iterator it = d.listeners.iterator();
            while (it.hasNext()) {
                ((IGuildSpeakThresholdApi.a) it.next()).M(guildId);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChannelAdminChange(@NotNull String guildId, @Nullable String channelId, int changeType, @Nullable List<String> tinyIdList) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sr.SpeakThresholdRepository", 2, "onChannelAdminChange guildId" + guildId);
            }
            Iterator it = d.listeners.iterator();
            while (it.hasNext()) {
                ((IGuildSpeakThresholdApi.a) it.next()).M(guildId);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelPermissionChanged(@Nullable String guildId, @Nullable HashSet<String> channelIds) {
            boolean z16;
            boolean z17 = false;
            if (guildId != null && guildId.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (channelIds == null || channelIds.isEmpty()) {
                    z17 = true;
                }
                if (!z17) {
                    Iterator it = d.listeners.iterator();
                    while (it.hasNext()) {
                        ((IGuildSpeakThresholdApi.a) it.next()).E(guildId, channelIds);
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onDeleteRole(@NotNull String guildId, @Nullable List<IGProGuildRoleInfo> roleList) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sr.SpeakThresholdRepository", 2, "onDeleteRole guildId" + guildId);
            }
            Iterator it = d.listeners.iterator();
            while (it.hasNext()) {
                ((IGuildSpeakThresholdApi.a) it.next()).M(guildId);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sr.SpeakThresholdRepository", 2, "onGuildInfoUpdated guildId" + guildId);
            }
            Iterator it = d.listeners.iterator();
            while (it.hasNext()) {
                ((IGuildSpeakThresholdApi.a) it.next()).M(guildId);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildPermissionChanged(@NotNull String guildId, @Nullable dx permission) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sr.SpeakThresholdRepository", 2, "onGuildPermissionChanged guildId" + guildId);
            }
            Iterator it = d.listeners.iterator();
            while (it.hasNext()) {
                ((IGuildSpeakThresholdApi.a) it.next()).M(guildId);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onMemberTopRoleChanged(@NotNull String guildId, @Nullable String tinyId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (d.f435022e.n(tinyId)) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.sr.SpeakThresholdRepository", 2, "onMemberTopRoleChanged guildId" + guildId + ", tinyId:" + tinyId);
                }
                Iterator it = d.listeners.iterator();
                while (it.hasNext()) {
                    ((IGuildSpeakThresholdApi.a) it.next()).M(guildId);
                }
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onSpeakableThresholdUpdate(@NotNull List<String> guildIds, @Nullable List<fc> thresholds) {
            Intrinsics.checkNotNullParameter(guildIds, "guildIds");
            Logger.f235387a.d().d("Guild.sr.SpeakThresholdRepository", 1, "onSpeakableThresholdUpdate guildIds" + guildIds);
            Iterator it = d.listeners.iterator();
            while (it.hasNext()) {
                ((IGuildSpeakThresholdApi.a) it.next()).G(guildIds);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0069, code lost:
        
            if (r2 == null) goto L18;
         */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onUserProfileInfoUpdate(int result, @Nullable String errMsg, @Nullable String guildId, @Nullable String tinyId, @Nullable ev info) {
            String str;
            List<String> arrayList;
            int collectionSizeOrDefault;
            if (result == 0) {
                d dVar = d.f435022e;
                if (dVar.n(tinyId)) {
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("Guild.sr.SpeakThresholdRepository", 2, "onUserProfileInfoUpdate guildId" + guildId);
                    }
                    if (TextUtils.equals(guildId, "0")) {
                        ArrayList<Long> sortedGuildIdsFromCache = dVar.h().getSortedGuildIdsFromCache();
                        if (sortedGuildIdsFromCache != null) {
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(sortedGuildIdsFromCache, 10);
                            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                            Iterator<T> it = sortedGuildIdsFromCache.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(String.valueOf((Long) it.next()));
                            }
                            arrayList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
                        }
                        arrayList = new ArrayList<>();
                        Iterator it5 = d.listeners.iterator();
                        while (it5.hasNext()) {
                            ((IGuildSpeakThresholdApi.a) it5.next()).G(arrayList);
                        }
                        return;
                    }
                    for (IGuildSpeakThresholdApi.a aVar : d.listeners) {
                        if (guildId == null) {
                            str = "0";
                        } else {
                            str = guildId;
                        }
                        aVar.M(str);
                    }
                }
            }
        }
    }

    static {
        d dVar = new d();
        f435022e = dVar;
        serviceHolder = new ServiceCache$LazyHolder("Guild.sr.SpeakThresholdRepository");
        listeners = new CopyOnWriteArrayList<>();
        a aVar = new a();
        speakingThresholdUpdateObserver = aVar;
        AccountChangedNotifier.f214789d.a(dVar);
        dVar.g().addObserver(aVar);
    }

    d() {
    }

    @JvmStatic
    public static final void e(@NotNull IGuildSpeakThresholdApi.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.addIfAbsent(listener);
    }

    @JvmStatic
    @NotNull
    public static final IGuildSpeakableThresholdPermission f(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        IGuildSpeakableThresholdPermission permission = f435022e.h().getGuildSpeakableThresholdPermission(guildId);
        Intrinsics.checkNotNullExpressionValue(permission, "permission");
        return permission;
    }

    private final IGProGlobalService g() {
        return serviceHolder.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGPSService h() {
        return serviceHolder.b();
    }

    private final boolean i(String channelId) {
        IGProChannelInfo channelInfo = h().getChannelInfo(channelId);
        if (channelInfo != null) {
            return channelInfo.isChannelOrCategoryAdmin();
        }
        return false;
    }

    @JvmStatic
    public static final boolean j(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return f435022e.m(f(guildId).getGuildLimitType());
    }

    @JvmStatic
    public static final boolean k(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        d dVar = f435022e;
        if (dVar.m(f(guildId).getGuildLimitType()) && !dVar.i(channelId)) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean l(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return f435022e.m(f(guildId).getDirectMsgLimitType());
    }

    private final boolean m(int type) {
        if (type != 2 && type != 4) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n(String tinyId) {
        return TextUtils.equals(h().getSelfTinyId(), tinyId);
    }

    @JvmStatic
    public static final void p(@NotNull IGuildSpeakThresholdApi.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    @Override // com.tencent.mobileqq.guild.base.repository.b
    @NotNull
    /* renamed from: a */
    public RepositoryCallbackConfig getRepositoryCallbackConfig() {
        return this.f435026d.getRepositoryCallbackConfig();
    }

    public final void o(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((IGuildSpeakThresholdApi.a) it.next()).M(guildId);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        IGProGlobalService g16 = g();
        a aVar = speakingThresholdUpdateObserver;
        g16.deleteObserver(aVar);
        serviceHolder = new ServiceCache$LazyHolder("Guild.sr.SpeakThresholdRepository");
        g().addObserver(aVar);
    }
}
