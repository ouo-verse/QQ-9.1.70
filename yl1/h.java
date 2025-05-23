package yl1;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailTopUpdateEvent;
import com.tencent.mobileqq.guild.feed.nativedetail.fragment.FeedNativeDetailFragment;
import com.tencent.mobileqq.guild.feed.report.c;
import com.tencent.mobileqq.guild.homev2.fragments.GuildHomeV2Fragment;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopFeedActionReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopFeedActionRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProTopFeedActionCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u00a8\u0006\u0015"}, d2 = {"Lyl1/h;", "", "", "isFeedTop", "isSuccess", "", "errMsg", "", "k", "guildId", "channelId", "feedId", "", MiniChatConstants.MINI_APP_TOP_TYPE, "e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProTopFeedActionReq;", "req", "reSet", tl.h.F, "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h {

    /* renamed from: a */
    @NotNull
    public static final h f450607a = new h();

    h() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x002d, code lost:
    
        r6 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void f(String guildId, int i3, String channelId, String feedId, DialogInterface dialogInterface, int i16) {
        Long longOrNull;
        long j3;
        Long longOrNull2;
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        Intrinsics.checkNotNullParameter(feedId, "$feedId");
        h hVar = f450607a;
        GProTopFeedActionReq gProTopFeedActionReq = new GProTopFeedActionReq();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(guildId);
        long j16 = 0;
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        gProTopFeedActionReq.guildId = j3;
        if (i3 != 1 && longOrNull2 != null) {
            j16 = longOrNull2.longValue();
        }
        gProTopFeedActionReq.channelId = j16;
        gProTopFeedActionReq.feedId = feedId;
        gProTopFeedActionReq.userId = ch.f();
        gProTopFeedActionReq.topType = i3;
        Unit unit = Unit.INSTANCE;
        hVar.h(false, gProTopFeedActionReq, true);
    }

    public static final void g(String guildId, String channelId, String feedId, int i3, DialogInterface dialogInterface, int i16) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        Intrinsics.checkNotNullParameter(feedId, "$feedId");
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        GuildFeedDetailTopUpdateEvent guildFeedDetailTopUpdateEvent = new GuildFeedDetailTopUpdateEvent();
        guildFeedDetailTopUpdateEvent.setGuildId(guildId);
        guildFeedDetailTopUpdateEvent.setChannelId(channelId);
        guildFeedDetailTopUpdateEvent.setFeedId(feedId);
        guildFeedDetailTopUpdateEvent.setTopType(i3);
        simpleEventBus.dispatchEvent(guildFeedDetailTopUpdateEvent);
    }

    public static /* synthetic */ void i(h hVar, boolean z16, GProTopFeedActionReq gProTopFeedActionReq, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        hVar.h(z16, gProTopFeedActionReq, z17);
    }

    public static final void j(IPerformanceReportTask reportTask, GProTopFeedActionReq req, boolean z16, boolean z17, int i3, String errMsg, GProTopFeedActionRsp gProTopFeedActionRsp) {
        boolean z18;
        Intrinsics.checkNotNullParameter(reportTask, "$reportTask");
        Intrinsics.checkNotNullParameter(req, "$req");
        com.tencent.mobileqq.guild.feed.report.c.E(com.tencent.mobileqq.guild.feed.report.c.f223280a, reportTask, i3, errMsg, false, 8, null);
        boolean z19 = false;
        if (i3 == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18) {
            QLog.e("FeedTopActionHelper", 1, "topFeedAction|result=" + i3 + ", err=" + errMsg + ", req=" + req);
            if (z16) {
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                GuildFeedDetailTopUpdateEvent guildFeedDetailTopUpdateEvent = new GuildFeedDetailTopUpdateEvent();
                guildFeedDetailTopUpdateEvent.setGuildId(String.valueOf(req.guildId));
                guildFeedDetailTopUpdateEvent.setChannelId(String.valueOf(req.channelId));
                guildFeedDetailTopUpdateEvent.setTopType(req.topType);
                simpleEventBus.dispatchEvent(guildFeedDetailTopUpdateEvent);
            }
        } else {
            SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
            GuildFeedDetailTopUpdateEvent guildFeedDetailTopUpdateEvent2 = new GuildFeedDetailTopUpdateEvent();
            if (req.action == 1) {
                z19 = true;
            }
            guildFeedDetailTopUpdateEvent2.setIsFeedSetTop(z19);
            guildFeedDetailTopUpdateEvent2.setGuildId(String.valueOf(req.guildId));
            guildFeedDetailTopUpdateEvent2.setChannelId(String.valueOf(req.channelId));
            guildFeedDetailTopUpdateEvent2.setFeedId(req.feedId);
            guildFeedDetailTopUpdateEvent2.setTopType(req.topType);
            simpleEventBus2.dispatchEvent(guildFeedDetailTopUpdateEvent2);
        }
        h hVar = f450607a;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        hVar.k(z17, z18, errMsg);
    }

    private final void k(final boolean isFeedTop, final boolean isSuccess, final String errMsg) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: yl1.g
            @Override // java.lang.Runnable
            public final void run() {
                h.l(isSuccess, isFeedTop, errMsg);
            }
        });
    }

    public static final void l(boolean z16, boolean z17, String errMsg) {
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(errMsg, "$errMsg");
        BaseApplication context = BaseApplication.getContext();
        if (z16) {
            if (z17) {
                i16 = R.string.f145580rv;
            } else {
                i16 = R.string.f145570ru;
            }
            errMsg = context.getString(i16) + context.getString(R.string.f145650s2);
        }
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        QQToast.makeText(context, i3, errMsg, 0).show();
    }

    public final void e(@NotNull final String guildId, @NotNull final String channelId, @NotNull final String feedId, final int r132) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = ch.i();
        }
        Context context2 = context;
        if (!(context2 instanceof QPublicFragmentActivity)) {
            return;
        }
        QPublicFragmentActivity qPublicFragmentActivity = (QPublicFragmentActivity) context2;
        if (!(qPublicFragmentActivity.getFragment() instanceof GuildHomeV2Fragment) && !(qPublicFragmentActivity.getFragment() instanceof FeedNativeDetailFragment)) {
            return;
        }
        DialogUtil.createCustomDialog(context2, 230, (String) null, qPublicFragmentActivity.getString(R.string.f145120qm), qPublicFragmentActivity.getString(R.string.cancel), qPublicFragmentActivity.getString(R.string.f145130qn), new DialogInterface.OnClickListener() { // from class: yl1.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                h.f(guildId, r132, channelId, feedId, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: yl1.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                h.g(guildId, channelId, feedId, r132, dialogInterface, i3);
            }
        }).show();
    }

    public final void h(final boolean z16, @NotNull final GProTopFeedActionReq req, final boolean z17) {
        boolean z18;
        Intrinsics.checkNotNullParameter(req, "req");
        int i3 = 2;
        if (!z16) {
            req.labelId = 2;
            i3 = 1;
        }
        req.action = i3;
        com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
        if (i3 == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        String str = req.feedId;
        Intrinsics.checkNotNullExpressionValue(str, "req.feedId");
        final IPerformanceReportTask k3 = cVar.k(z18, new c.FeedReportData(str, String.valueOf(req.guildId), String.valueOf(req.channelId)));
        if (req.topType == 0) {
            req.topType = 1;
        }
        com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
        if (c16 != null) {
            c16.topFeedAction(req, new IGProTopFeedActionCallback() { // from class: yl1.f
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProTopFeedActionCallback
                public final void onResult(int i16, String str2, GProTopFeedActionRsp gProTopFeedActionRsp) {
                    h.j(IPerformanceReportTask.this, req, z17, z16, i16, str2, gProTopFeedActionRsp);
                }
            });
        }
    }
}
