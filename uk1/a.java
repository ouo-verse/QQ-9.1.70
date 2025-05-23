package uk1;

import android.content.Intent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.feed.fragment.GuildFeedNoticeFragment;
import com.tencent.mobileqq.guild.feed.performance.report.g;
import com.tencent.mobileqq.guild.mainframe.i;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.q;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqguild.directmessage.service.IFeedBoxSummaryService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006$"}, d2 = {"Luk1/a;", "Lgs1/a;", "", "p", "Landroid/view/ViewGroup;", "parentFrame", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "k", "Landroid/content/Intent;", "data", DomainData.DOMAIN_NAME, "l", "", "i", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBeforeAccountChanged", "onBackPressed", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "parentView", "Lcom/tencent/mobileqq/guild/feed/fragment/GuildFeedNoticeFragment;", "f", "Lcom/tencent/mobileqq/guild/feed/fragment/GuildFeedNoticeFragment;", "feedNoticeFragment", "Lrr1/a;", h.F, "Lrr1/a;", "mGestureListener", "Lcom/tencent/mobileqq/guild/mainframe/i;", "mainViewContext", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/i;)V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends gs1.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout parentView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildFeedNoticeFragment feedNoticeFragment;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final rr1.a mGestureListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"uk1/a$b", "Lrr1/a;", "Lrr1/i;", "notifyData", "", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends rr1.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f439107a;

        b(i iVar) {
            this.f439107a = iVar;
        }

        @Override // rr1.a
        public void c(@NotNull rr1.i notifyData) {
            Intrinsics.checkNotNullParameter(notifyData, "notifyData");
            if (this.f439107a.Z0().t() != 9 || notifyData.f() != 3 || notifyData.c() != 1) {
                return;
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("AbsGestureListener", 2, "clearNoticeRedPoint");
            }
            ((IFeedBoxSummaryService) ch.R0(IFeedBoxSummaryService.class)).markRead();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull i mainViewContext) {
        super(mainViewContext);
        Intrinsics.checkNotNullParameter(mainViewContext, "mainViewContext");
        this.mGestureListener = new b(mainViewContext);
    }

    private final void p() {
        q.b(this.feedNoticeFragment);
        this.feedNoticeFragment = null;
    }

    @Override // gs1.a
    public boolean i(@Nullable Intent data) {
        if (this.feedNoticeFragment == null) {
            return true;
        }
        return false;
    }

    @Override // gs1.a
    public int k() {
        return 9;
    }

    @Override // gs1.a
    public void l() {
        if (this.feedNoticeFragment != null) {
            p();
            QLog.d("Guild.C2C.GuildFeedNoticeCenterPanelController", 2, "hide noticeFragment !");
            g.j(this.feedNoticeFragment);
        }
    }

    @Override // gs1.a
    public void m(@Nullable ViewGroup parentFrame) {
        Intrinsics.checkNotNull(parentFrame, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.parentView = (FrameLayout) parentFrame;
    }

    @Override // gs1.a
    public void n(@Nullable Intent data) {
        if (this.feedNoticeFragment != null) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.C2C.GuildFeedNoticeCenterPanelController", 2, "remove noticeFragment !");
            }
            q.b(this.feedNoticeFragment);
            g.j(this.feedNoticeFragment);
        }
        if (data == null) {
            new Intent();
        }
        this.feedNoticeFragment = new GuildFeedNoticeFragment();
        FragmentTransaction beginTransaction = j().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "fm.beginTransaction()");
        FrameLayout frameLayout = this.parentView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentView");
            frameLayout = null;
        }
        int id5 = frameLayout.getId();
        GuildFeedNoticeFragment guildFeedNoticeFragment = this.feedNoticeFragment;
        Intrinsics.checkNotNull(guildFeedNoticeFragment);
        beginTransaction.add(id5, guildFeedNoticeFragment, "GuildChannelNoticeFrameController_QQGuildChannelNoticeFragment");
        beginTransaction.commitAllowingStateLoss();
        g.k(this.feedNoticeFragment);
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("Guild.C2C.GuildFeedNoticeCenterPanelController", 2, "show noticeFragment !");
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public boolean onBackPressed() {
        boolean z16;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            if (this.feedNoticeFragment == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            d16.d("Guild.C2C.GuildFeedNoticeCenterPanelController", 2, "onBackPressed noticeFragment is null ? " + z16);
        }
        if (this.f227466d.Z0().t() != 9) {
            return false;
        }
        g.j(this.feedNoticeFragment);
        if (this.f227466d.Z0().o()) {
            this.f227466d.Z0().z(1);
        } else if (this.f227466d.Z0().q()) {
            this.f227466d.Z0().z(2);
        } else if (this.f227466d.Z0().p()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onBeforeAccountChanged() {
        if (this.feedNoticeFragment != null) {
            p();
            if (this.f227466d.Z0().t() == 9) {
                i mainViewContext = this.f227466d;
                Intrinsics.checkNotNullExpressionValue(mainViewContext, "mainViewContext");
                GuildMainFrameUtils.d(mainViewContext);
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.C2C.GuildFeedNoticeCenterPanelController", 2, "onBeforeAccountChanged");
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onCreate() {
        super.onCreate();
        this.f227466d.N().addGestureListener(this.mGestureListener);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onDestroy() {
        if (this.feedNoticeFragment != null) {
            p();
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.C2C.GuildFeedNoticeCenterPanelController", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            }
        }
        this.f227466d.N().removeGestureListener(this.mGestureListener);
    }
}
