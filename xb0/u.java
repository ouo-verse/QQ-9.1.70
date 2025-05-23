package xb0;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.requests.QCircleDeleteFeedRequest;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.utils.bm;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.qcircle.api.event.QFSDeleteQZoneVideoAlbumEvent;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.ActionSheet;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$RightInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StRight;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudWrite$StDelFeedRsp;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class u extends QCircleBaseShareOperation {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                u.this.U();
                u.this.e0("ev_xsj_abnormal_clck", QCircleDaTongConstant.ElementId.EM_XSJ_OLD_VER_DELETE_PRODUCT_POPUP, 3);
            } else {
                u.this.e0("ev_xsj_abnormal_clck", QCircleDaTongConstant.ElementId.EM_XSJ_OLD_VER_DELETE_PRODUCT_POPUP, 4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDelFeedRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f447730a;

        b(String str) {
            this.f447730a = str;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDelFeedRsp feedCloudWrite$StDelFeedRsp) {
            if (z16 && j3 == 0) {
                QLog.d("QFSSharePart", 1, "deleteFeed  success");
                SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(this.f447730a, 3));
                SimpleEventBus.getInstance().dispatchEvent(new QFSDeleteQZoneVideoAlbumEvent(false, this.f447730a), true);
                return;
            }
            QLog.e("QFSSharePart", 1, "deleteFeed  error");
        }
    }

    public u(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    private void T() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        int i3;
        String str = "";
        if (!C(57) && !uq3.c.g6()) {
            if (t().extraTypeInfo != null) {
                feedCloudMeta$StFeed = t().extraTypeInfo.mFeed;
            } else {
                feedCloudMeta$StFeed = null;
            }
            QCircleLpReportDc05501.DataBuilder subActionType = ua0.c.a(feedCloudMeta$StFeed).setActionType(22).setSubActionType(2);
            if (t().extraTypeInfo != null && t().extraTypeInfo.mFeed != null) {
                str = t().extraTypeInfo.mFeed.poster.f398463id.get();
            }
            QCircleLpReportDc05501.DataBuilder toUin = subActionType.setToUin(str);
            if (t().extraTypeInfo != null) {
                i3 = t().extraTypeInfo.mDataPosition;
            } else {
                i3 = -1;
            }
            QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(toUin.setIndex(i3).setPageId(m())));
            return;
        }
        H(22, 2, t().extraTypeInfo, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        g0(d0());
    }

    private VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDelFeedRsp> V(String str) {
        return new b(str);
    }

    private DialogInterface.OnClickListener W() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(int i3, String str, String str2) {
        String str3;
        FeedCloudMeta$StFeed d06 = d0();
        if (d06 == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", d06.f398449id.get());
        FeedCloudMeta$StUser feedCloudMeta$StUser = d06.poster;
        String str4 = "";
        if (feedCloudMeta$StUser == null) {
            str3 = "";
        } else {
            str3 = feedCloudMeta$StUser.f398463id.get();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str3);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRODUCT_PERMISSION, Integer.valueOf(cq.f92752a.h(d06)));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTIONSHEET_OPTION, Integer.valueOf(i3));
        if (q() != null) {
            str4 = q().getDtPageId();
        }
        buildElementParams.put("xsj_custom_pgid", str4);
        buildElementParams.put("xsj_eid", str);
        VideoReport.reportEvent(str2, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(boolean z16, boolean z17, FeedCloudMeta$StFeed feedCloudMeta$StFeed, com.tencent.biz.qqcircle.widgets.am amVar, View view, int i3) {
        QLog.d("QFSSharePart", 1, "showDeleteActionSheet qzone feed, click which : " + i3 + " hasFriendItem : " + z16 + " hasOnlySelfItem : " + z17);
        if (i3 != 0) {
            if (i3 == 1) {
                U();
                e0("ev_xsj_abnormal_clck", QCircleDaTongConstant.ElementId.EM_XSJ_DELETE_PRODUCT_POPUP, 3);
            }
        } else if (z16) {
            f0(feedCloudMeta$StFeed, true, 4);
            e0("ev_xsj_abnormal_clck", QCircleDaTongConstant.ElementId.EM_XSJ_DELETE_PRODUCT_POPUP, 2);
        } else if (z17) {
            f0(feedCloudMeta$StFeed, true, 64);
            e0("ev_xsj_abnormal_clck", QCircleDaTongConstant.ElementId.EM_XSJ_DELETE_PRODUCT_POPUP, 1);
        } else {
            U();
            e0("ev_xsj_abnormal_clck", QCircleDaTongConstant.ElementId.EM_XSJ_DELETE_PRODUCT_POPUP, 3);
        }
        amVar.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(boolean z16, com.tencent.biz.qqcircle.widgets.am amVar, View view, int i3) {
        QLog.d("QFSSharePart", 1, "showDeleteActionSheet not qzone feed, click which : " + i3 + " isNotPrivate : " + z16);
        if (i3 == 0) {
            U();
            e0("ev_xsj_abnormal_clck", QCircleDaTongConstant.ElementId.EM_XSJ_DELETE_PRODUCT_POPUP, 3);
        }
        amVar.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0() {
        e0("ev_xsj_abnormal_clck", QCircleDaTongConstant.ElementId.EM_XSJ_DELETE_PRODUCT_POPUP, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0() {
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(17, o(), false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(DialogInterface dialogInterface) {
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(17, o(), false));
    }

    private FeedCloudMeta$StFeed d0() {
        if (t().feed.isRecomFd.get()) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
            feedCloudMeta$StFeed.f398449id.set(t().feed.recomForward.f398458id.get());
            feedCloudMeta$StFeed.poster.set(t().feed.recomForward.poster.get());
            return feedCloudMeta$StFeed;
        }
        return t().feed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(final String str, final String str2, final int i3) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: xb0.t
            @Override // java.lang.Runnable
            public final void run() {
                u.this.X(i3, str2, str);
            }
        });
    }

    private void f0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16, int i3) {
        boolean z17 = true;
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSSharePart", 1, "requestSetFeedRight feed is null, isQZoneFeed : " + z16);
            return;
        }
        QLog.d("QFSSharePart", 1, "requestSetFeedRight isQZoneFeed : " + z16 + " rightFlag : " + i3 + " feedid : " + feedCloudMeta$StFeed.f398449id.get());
        if (z16) {
            bm.j(feedCloudMeta$StFeed, i3);
            return;
        }
        if (i3 != 1) {
            z17 = false;
        }
        bm.k(feedCloudMeta$StFeed, z17);
    }

    private void g0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSSharePart", 1, "sendDeleteFeedRequest feed is null");
            return;
        }
        QLog.d("QFSSharePart", 1, "sendDeleteFeedRequest feedid : " + feedCloudMeta$StFeed.f398449id.get());
        VSNetworkHelper.getInstance().sendRequest(new QCircleDeleteFeedRequest(feedCloudMeta$StFeed), V(feedCloudMeta$StFeed.f398449id.get()));
    }

    private void h0() {
        long j3;
        final boolean z16;
        FeedCloudMeta$RightInfo feedCloudMeta$RightInfo;
        PBEnumField pBEnumField;
        Window window;
        boolean z17;
        boolean z18;
        final FeedCloudMeta$StFeed d06 = d0();
        cq cqVar = cq.f92752a;
        boolean s16 = cqVar.s(d06);
        final com.tencent.biz.qqcircle.widgets.am e16 = com.tencent.biz.qqcircle.widgets.c.e(f());
        e16.setMainTitle(bm.d(s16));
        if (s16) {
            int i3 = cqVar.i(d06);
            QLog.d("QFSSharePart", 1, "showDeleteActionSheet qzoneRight feed, right : " + i3);
            if (i3 == 1) {
                e16.addRadioButton((CharSequence) com.tencent.biz.qqcircle.utils.h.a(R.string.f209835gh), false);
                z18 = false;
                z17 = true;
            } else if (i3 != 2 && i3 != 3 && i3 != 6) {
                z17 = false;
                z18 = false;
            } else {
                e16.addRadioButton((CharSequence) com.tencent.biz.qqcircle.utils.h.a(R.string.f195334eb), false);
                z17 = false;
                z18 = true;
            }
            e16.addRadioButton((CharSequence) com.tencent.biz.qqcircle.utils.h.a(R.string.f183823k8), false);
            final boolean z19 = z17;
            final boolean z26 = z18;
            e16.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: xb0.o
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i16) {
                    u.this.Y(z19, z26, d06, e16, view, i16);
                }
            });
        } else {
            FeedCloudMeta$StRight feedCloudMeta$StRight = d06.right;
            if (feedCloudMeta$StRight != null && (feedCloudMeta$RightInfo = feedCloudMeta$StRight.ugcRight) != null && (pBEnumField = feedCloudMeta$RightInfo.rightFlag) != null) {
                j3 = pBEnumField.get();
            } else {
                j3 = 0;
            }
            QLog.d("QFSSharePart", 1, "showDeleteActionSheet not qzone feed, right : " + j3);
            if (j3 != 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            e16.addRadioButton((CharSequence) com.tencent.biz.qqcircle.utils.h.a(R.string.f183823k8), false);
            e16.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: xb0.p
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i16) {
                    u.this.Z(z16, e16, view, i16);
                }
            });
        }
        e16.addCancelButton(com.tencent.biz.qqcircle.utils.h.a(R.string.cancel));
        e16.setOnDismissListener(new ActionSheet.OnDismissListener() { // from class: xb0.q
            @Override // com.tencent.widget.ActionSheet.OnDismissListener
            public final void onDismiss() {
                u.this.a0();
            }
        });
        e16.registerWatchDisMissActionListener(new ActionSheet.WatchDismissActions() { // from class: xb0.r
            @Override // com.tencent.widget.ActionSheet.WatchDismissActions
            public final void onDismissOperations() {
                u.this.b0();
            }
        });
        e16.show();
        Activity f16 = f();
        if (f16 != null) {
            window = f16.getWindow();
        } else {
            window = null;
        }
        if (window != null && RFWImmersiveUtils.isNavigationBarExist(window)) {
            RFWImmersiveUtils.setNavigationBarIconColor(e16.getWindow(), !QQTheme.isNowThemeIsNight());
            RFWImmersiveUtils.setNavigationBarColor(e16.getWindow(), ie0.a.f().g(f(), R.color.qui_common_bg_nav_secondary, 1000));
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(17, o(), true));
        e0("ev_xsj_abnormal_imp", QCircleDaTongConstant.ElementId.EM_XSJ_DELETE_PRODUCT_POPUP, 0);
    }

    private void i0(DialogInterface.OnClickListener onClickListener) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String a16;
        if (onClickListener != null && f() != null && !f().isFinishing()) {
            if (t() != null) {
                feedCloudMeta$StFeed = t().feed;
            } else {
                feedCloudMeta$StFeed = null;
            }
            if (cq.f92752a.s(feedCloudMeta$StFeed)) {
                a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f194434bw);
            } else {
                a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f183173ig);
            }
            QCircleCustomDialog P = QCircleCustomDialog.P(f(), null, a16, R.string.cancel, R.string.f170648xe, onClickListener, onClickListener);
            P.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: xb0.s
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    u.this.c0(dialogInterface);
                }
            });
            P.show();
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(17, o(), true));
            e0("ev_xsj_abnormal_imp", QCircleDaTongConstant.ElementId.EM_XSJ_OLD_VER_DELETE_PRODUCT_POPUP, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (t() != null && t().feed != null && f() != null) {
            if (bm.h()) {
                h0();
            } else {
                i0(W());
            }
            T();
            return;
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
