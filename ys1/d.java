package ys1;

import at1.GuildGameCreateBean;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.f;
import com.tencent.mobileqq.guild.media.core.g;
import com.tencent.mobileqq.guild.media.core.notify.aj;
import com.tencent.mobileqq.guild.media.core.notify.al;
import com.tencent.mobileqq.guild.media.core.notify.i;
import com.tencent.mobileqq.guild.media.core.notify.k;
import com.tencent.mobileqq.guild.media.core.notify.l;
import com.tencent.mobileqq.guild.media.core.notify.r;
import com.tencent.mobileqq.guild.media.core.notify.s;
import com.tencent.mobileqq.guild.performance.report.aa;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProVoiceSmobaGameRoomManageSysMsg;
import com.tencent.mobileqq.qqguildsdk.data.ew;
import com.tencent.mobileqq.qqguildsdk.data.ex;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001$B\u000f\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J6\u0010\u0012\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J \u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0014J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0014R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lys1/d;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProVoiceSmobaGameRoomManageSysMsg;", "teamChangePush", "", "onVoiceSmobaGameRooManageUpdate", "Lcom/tencent/mobileqq/qqguildsdk/data/ex;", "userActionPush", "onVoiceSmobaGameUserActionUpdate", "", "guildId", "channelId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "userList", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelUserNum;", "channelUserNumInfo", "onSmobaGameUserChangeNotifyForAll", "admint", "", "bAdmin", "onAdminChanged", "E0", "u", "p", "h0", "tinyId", "onUserDisplayNameUpdate", "Lcom/tencent/mobileqq/guild/media/core/f;", "d", "Lcom/tencent/mobileqq/guild/media/core/f;", "core", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d extends GPServiceObserver implements g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f core;

    public d(@NotNull f core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        IRuntimeService runtimeService = this.core.getQQAppInterface().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        ((IGPSService) runtimeService).addObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onAdminChanged(@NotNull String guildId, @NotNull String admint, boolean bAdmin) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(admint, "admint");
        super.onAdminChanged(guildId, admint, bAdmin);
        if (this.core.getSelfUserInfo().f228093a.equals(admint)) {
            this.core.getEventBus().i(new al());
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onSmobaGameUserChangeNotifyForAll(@Nullable String guildId, @Nullable String channelId, @Nullable ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
        if (userList == null) {
            return;
        }
        if (!Intrinsics.areEqual(channelId, this.core.E())) {
            QLog.d("QMGame.MediaGameGProObserverHelper", 1, "onSmobaGameUserChangeNotifyForAll not sameRoom ");
            return;
        }
        p.o(userList, this.core.D0().f228125a);
        p.n(userList, this.core.getSelfUserInfo());
        this.core.getEventBus().i(new l());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onUserDisplayNameUpdate(@Nullable String tinyId) {
        Long l3;
        if (this.core.o0().a()) {
            if (!Intrinsics.areEqual(tinyId, String.valueOf(this.core.o0().n().getNewCaptainId()))) {
                IGProVoiceSmobaGameRoomStateInfo roomInfo = this.core.o0().n().getRoomInfo();
                if (roomInfo != null) {
                    l3 = Long.valueOf(roomInfo.getCaptainTinyId());
                } else {
                    l3 = null;
                }
                if (!Intrinsics.areEqual(tinyId, String.valueOf(l3))) {
                    return;
                }
            }
            this.core.getEventBus().i(new k());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onVoiceSmobaGameRooManageUpdate(@NotNull IGProVoiceSmobaGameRoomManageSysMsg teamChangePush) {
        Intrinsics.checkNotNullParameter(teamChangePush, "teamChangePush");
        super.onVoiceSmobaGameRooManageUpdate(teamChangePush);
        QLog.d("QMGame.MediaGameGProObserverHelper", 4, "create team push " + teamChangePush.getOperType());
        aa.f230980i.w(teamChangePush.getOperType());
        if (Intrinsics.areEqual(String.valueOf(teamChangePush.getRoomInfo().getChannelId()), this.core.o0().getSelfUserInfo().Q)) {
            this.core.o0().j0(new GuildGameCreateBean(teamChangePush.getOperType(), teamChangePush.getStateInfo(), 0L, 0L, 0, null, 60, null));
            if (teamChangePush.getOperType() == 1) {
                this.core.o0().n().b().add(Long.valueOf(teamChangePush.getStateInfo().getCaptainTinyId()));
            }
            this.core.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.f(this.core.o0().n()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onVoiceSmobaGameUserActionUpdate(@NotNull ex userActionPush) {
        Intrinsics.checkNotNullParameter(userActionPush, "userActionPush");
        super.onVoiceSmobaGameUserActionUpdate(userActionPush);
        QLog.d("QMGame.MediaGameGProObserverHelper", 1, "user enter or quit push " + userActionPush.getRoomId());
        if (!this.core.o0().a()) {
            QLog.d("QMGame.MediaGameGProObserverHelper", 1, "onVoiceSmobaGameUserActionUpdate gameCreateRoomInfo is not init ");
            return;
        }
        long roomId = userActionPush.getRoomId();
        IGProVoiceSmobaGameRoomStateInfo roomInfo = this.core.o0().n().getRoomInfo();
        Intrinsics.checkNotNull(roomInfo);
        if (roomId != roomInfo.getRoomId()) {
            QLog.d("QMGame.MediaGameGProObserverHelper", 1, "onVoiceSmobaGameUserActionUpdate not sameRoom ");
            return;
        }
        if (userActionPush.a() != 0) {
            this.core.o0().n().h(userActionPush.a());
        }
        this.core.o0().n().i(userActionPush.getCurrentMemberNum());
        ArrayList<ew> b16 = userActionPush.b();
        Intrinsics.checkNotNullExpressionValue(b16, "userActionPush.userAction");
        for (ew ewVar : b16) {
            if (ewVar.a() == 10 && !this.core.o0().n().b().contains(Long.valueOf(ewVar.getTinyId()))) {
                QLog.d("QMGame.MediaGameGProObserverHelper", 1, "user enter " + ewVar.getTinyId());
                this.core.o0().n().b().add(Long.valueOf(ewVar.getTinyId()));
                this.core.getEventBus().i(new s(ewVar.getTinyId()));
            } else if ((ewVar.a() == 20 || ewVar.a() == 21) && this.core.o0().n().b().contains(Long.valueOf(ewVar.getTinyId()))) {
                QLog.d("QMGame.MediaGameGProObserverHelper", 1, "user quit " + ewVar.getTinyId());
                this.core.o0().n().b().remove(Long.valueOf(ewVar.getTinyId()));
                this.core.getEventBus().i(new aj(ewVar.getTinyId()));
                if (ewVar.a() == 21) {
                    this.core.getEventBus().i(new i(ewVar.getTinyId()));
                }
            }
            this.core.o0().n().k(ewVar.a());
        }
        this.core.getEventBus().i(new r(this.core.o0().n()));
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void u() {
        if (this.core.o0().a()) {
            this.core.o0().n().a();
        }
        IRuntimeService runtimeService = this.core.getQQAppInterface().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        ((IGPSService) runtimeService).deleteObserver(this);
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void h0() {
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void p() {
    }
}
