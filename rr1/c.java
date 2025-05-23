package rr1;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.inbox.centerpanel.assistant.GuildAssistantFragment;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.InboxNoticeNodeRepository;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.q;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006#"}, d2 = {"Lrr1/c;", "Lgs1/a;", "", "event", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "k", "Landroid/view/ViewGroup;", "parentFrame", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Intent;", "data", DomainData.DOMAIN_NAME, "l", "onBeforeAccountChanged", "e", "Landroid/view/ViewGroup;", "mParentView", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/GuildAssistantFragment;", "f", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/GuildAssistantFragment;", "mGuildAssistantFragment", "Lrr1/a;", tl.h.F, "Lrr1/a;", "mGestureListener", "Lcom/tencent/mobileqq/guild/mainframe/i;", "mainViewContext", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/i;)V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends gs1.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup mParentView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildAssistantFragment mGuildAssistantFragment;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mGestureListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"rr1/c$b", "Lrr1/a;", "Lrr1/i;", "notifyData", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.mainframe.i f431999a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f432000b;

        b(com.tencent.mobileqq.guild.mainframe.i iVar, c cVar) {
            this.f431999a = iVar;
            this.f432000b = cVar;
        }

        @Override // rr1.a
        public void c(@NotNull i notifyData) {
            Intrinsics.checkNotNullParameter(notifyData, "notifyData");
            if (this.f431999a.Z0().t() != 7 || notifyData.f() != 3) {
                return;
            }
            if (notifyData.c() == 3) {
                this.f432000b.q("pgout");
                return;
            }
            if (notifyData.c() != 1) {
                return;
            }
            InboxNoticeNodeRepository.m(7);
            GuildAssistantFragment guildAssistantFragment = this.f432000b.mGuildAssistantFragment;
            if (guildAssistantFragment != null) {
                guildAssistantFragment.Uh();
            }
            this.f432000b.q("pgin");
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("clearNoticeRedPoint");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.GuildAssistantCenterPanelController", 1, (String) it.next(), null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull com.tencent.mobileqq.guild.mainframe.i mainViewContext) {
        super(mainViewContext);
        Intrinsics.checkNotNullParameter(mainViewContext, "mainViewContext");
        this.mGestureListener = new b(mainViewContext, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(String event) {
        View view;
        GuildAssistantFragment guildAssistantFragment = this.mGuildAssistantFragment;
        if (guildAssistantFragment != null) {
            View view2 = null;
            if (guildAssistantFragment != null) {
                view = guildAssistantFragment.getView();
            } else {
                view = null;
            }
            if (view != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
                hashMap.put("pgid", "pg_sgrp_channelassitant");
                GuildAssistantFragment guildAssistantFragment2 = this.mGuildAssistantFragment;
                if (guildAssistantFragment2 != null) {
                    view2 = guildAssistantFragment2.requireView();
                }
                VideoReport.reportEvent(event, view2, hashMap);
            }
        }
    }

    @Override // gs1.a
    public int k() {
        return 7;
    }

    @Override // gs1.a
    public void l() {
        GuildAssistantFragment guildAssistantFragment = this.mGuildAssistantFragment;
        if (guildAssistantFragment != null) {
            q.a(guildAssistantFragment);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.C2C.GuildAssistantCenterPanelController", 2, "hide mGuildAssistantFragment!");
            }
        }
        this.mGuildAssistantFragment = null;
    }

    @Override // gs1.a
    public void m(@Nullable ViewGroup parentFrame) {
        this.mParentView = parentFrame;
    }

    @Override // gs1.a
    public void n(@Nullable Intent data) {
        FragmentTransaction beginTransaction = j().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "fm.beginTransaction()");
        if (this.mGuildAssistantFragment == null) {
            GuildAssistantFragment.Companion companion = GuildAssistantFragment.INSTANCE;
            com.tencent.mobileqq.guild.mainframe.i mainViewContext = this.f227466d;
            Intrinsics.checkNotNullExpressionValue(mainViewContext, "mainViewContext");
            this.mGuildAssistantFragment = companion.a(mainViewContext);
            ViewGroup viewGroup = this.mParentView;
            Intrinsics.checkNotNull(viewGroup);
            int id5 = viewGroup.getId();
            GuildAssistantFragment guildAssistantFragment = this.mGuildAssistantFragment;
            Intrinsics.checkNotNull(guildAssistantFragment);
            beginTransaction.add(id5, guildAssistantFragment, "GuildAssistantCenterPanelController_GuildAssistantFragment");
        }
        GuildAssistantFragment guildAssistantFragment2 = this.mGuildAssistantFragment;
        Intrinsics.checkNotNull(guildAssistantFragment2);
        beginTransaction.show(guildAssistantFragment2).commitAllowingStateLoss();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.GuildAssistantCenterPanelController", 2, "show mGuildAssistantFragment!");
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onBeforeAccountChanged() {
        GuildAssistantFragment guildAssistantFragment = this.mGuildAssistantFragment;
        if (guildAssistantFragment != null) {
            q.b(guildAssistantFragment);
            this.mGuildAssistantFragment = null;
            if (this.f227466d.Z0().t() == 7) {
                com.tencent.mobileqq.guild.mainframe.i mainViewContext = this.f227466d;
                Intrinsics.checkNotNullExpressionValue(mainViewContext, "mainViewContext");
                GuildMainFrameUtils.d(mainViewContext);
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.C2C.GuildAssistantCenterPanelController", 2, "onBeforeAccountChanged");
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onCreate() {
        super.onCreate();
        this.f227466d.N().addGestureListener(this.mGestureListener);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.GuildAssistantCenterPanelController", 2, "onCreate");
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onDestroy() {
        GuildAssistantFragment guildAssistantFragment = this.mGuildAssistantFragment;
        if (guildAssistantFragment != null) {
            q.b(guildAssistantFragment);
            this.mGuildAssistantFragment = null;
        }
        this.f227466d.N().removeGestureListener(this.mGestureListener);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.GuildAssistantCenterPanelController", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }
}
