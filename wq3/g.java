package wq3;

import android.graphics.Outline;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleFollowApi;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qcircle.ntchat.QFSAioTopTipMsgIntent$OnGetFollowState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudWrite$StDoFollowRsp;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wq3.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0006\u001a\u00020\u0005H\u0002J$\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u001c\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J$\u0010\u0014\u001a\u00020\u00052\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0007H\u0016R\u0014\u0010\u001c\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001bR\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lwq3/g;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/e;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "Landroid/view/View$OnClickListener;", "", "k1", "Landroid/view/View;", "view", "", "eid", "followState", "h1", "j1", "f1", "l1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "mUIModel", "afterCreateVM", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "v", NodeProps.ON_CLICK, "d", "Ljava/lang/String;", "TAG", "Lwq3/h;", "e", "Lwq3/h;", "mVM", "", "f", "J", "mPeerUin", tl.h.F, "mPeerNick", "", "i", "I", "mPeerFollowState", "<init>", "()V", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class g extends com.tencent.aio.base.mvvm.a<at.e, TopTipViewState> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "QFSAioTopTipVB";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h mVM = new h();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mPeerUin = -1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mPeerNick = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mPeerFollowState = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"wq3/g$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(g this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.k1();
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof QFSAioTopTipMsgIntent$OnGetFollowState) {
                g.this.mPeerFollowState = ((QFSAioTopTipMsgIntent$OnGetFollowState) i3).getFollowState();
                Handler mMainHandler = g.this.mVM.getMMainHandler();
                final g gVar = g.this;
                mMainHandler.post(new Runnable() { // from class: wq3.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.a.b(g.this);
                    }
                });
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"wq3/g$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), com.tencent.qqnt.base.utils.c.f353052a.b(4));
        }
    }

    private final void f1() {
        final FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        feedCloudMeta$StUser.f398463id.set(String.valueOf(this.mPeerUin));
        feedCloudMeta$StUser.nick.set(this.mPeerNick);
        final int i3 = 1;
        VSNetworkHelper.getInstance().sendRequest(((IQCircleFollowApi) QRoute.api(IQCircleFollowApi.class)).getQCircleFollowRequest(feedCloudMeta$StUser, 1, null), new VSDispatchObserver.OnVSRspCallBack() { // from class: wq3.e
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                g.g1(i3, feedCloudMeta$StUser, this, baseRequest, z16, j3, str, (FeedCloudWrite$StDoFollowRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(int i3, FeedCloudMeta$StUser user, g this$0, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoFollowRsp feedCloudWrite$StDoFollowRsp) {
        Intrinsics.checkNotNullParameter(user, "$user");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && j3 == 0) {
            SimpleEventBus.getInstance().dispatchEvent(new QCircleFollowUpdateEvent(i3, user.f398463id.get()));
            ((IQCircleFollowApi) QRoute.api(IQCircleFollowApi.class)).setUinFollowed(user.f398463id.get(), i3);
            ((IQCircleFollowApi) QRoute.api(IQCircleFollowApi.class)).updateFollowUser(user.f398463id.get(), user.nick.get(), true);
            QQToast.makeText(this$0.getMContext(), R.string.f183353iy, 0).show();
            return;
        }
        QQToast.makeText(this$0.getMContext(), str, 0).show();
    }

    private final void h1(View view, String eid, String followState) {
        VideoReport.setElementId(view, eid);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("xsj_target_qq", Long.valueOf(this.mPeerUin));
        if (followState != null) {
            linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, followState);
        }
        VideoReport.setElementParams(view, linkedHashMap);
        VideoReport.reportEvent("dt_imp", view, linkedHashMap);
    }

    static /* synthetic */ void i1(g gVar, View view, String str, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        gVar.h1(view, str, str2);
    }

    private final void j1() {
        int i3 = this.mPeerFollowState;
        if (i3 != 0 && i3 != 2) {
            if (i3 == 3 || i3 == 1) {
                QCircleHostLauncher.startAddFriend(getMContext(), 2, String.valueOf(this.mPeerUin), this.mPeerNick, true, false);
                return;
            }
            return;
        }
        f1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1() {
        if (!i.f446087a.c(this.mPeerUin, this.mPeerFollowState)) {
            QLog.d(this.TAG, 1, "[handleShowFollowOrAddFriendTips] return mPeerUin = " + this.mPeerUin + ", mPeerNick = " + this.mPeerNick + ", mPeerFollowState = " + this.mPeerFollowState);
            return;
        }
        getHostView().setVisibility(0);
        TextView textView = (TextView) getHostView().findViewById(R.id.kbr);
        TextView tvOperation = (TextView) getHostView().findViewById(R.id.f109786gr);
        View ivClose = (ImageView) getHostView().findViewById(R.id.dum);
        tvOperation.setOutlineProvider(new b());
        tvOperation.setClipToOutline(true);
        tvOperation.setOnClickListener(this);
        ivClose.setOnClickListener(this);
        int i3 = this.mPeerFollowState;
        if (i3 == 0) {
            textView.setText(HardCodeUtil.qqStr(R.string.f188203w2));
            tvOperation.setText(HardCodeUtil.qqStr(R.string.f19049429));
            Intrinsics.checkNotNullExpressionValue(tvOperation, "tvOperation");
            h1(tvOperation, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON, "follow");
            Intrinsics.checkNotNullExpressionValue(ivClose, "ivClose");
            h1(ivClose, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_GUIDE_CLOSE_BUTTON, "follow");
            return;
        }
        if (i3 == 2) {
            textView.setText(HardCodeUtil.qqStr(R.string.f188093vr));
            tvOperation.setText(HardCodeUtil.qqStr(R.string.f184753mq));
            Intrinsics.checkNotNullExpressionValue(tvOperation, "tvOperation");
            h1(tvOperation, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON, QCircleDaTongConstant.ElementParamValue.FOLLOWBACK);
            Intrinsics.checkNotNullExpressionValue(ivClose, "ivClose");
            h1(ivClose, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_GUIDE_CLOSE_BUTTON, QCircleDaTongConstant.ElementParamValue.FOLLOWBACK);
            return;
        }
        if (i3 == 3 || i3 == 1) {
            textView.setText(HardCodeUtil.qqStr(R.string.f188183w0));
            tvOperation.setText(HardCodeUtil.qqStr(R.string.f188083vq));
            Intrinsics.checkNotNullExpressionValue(tvOperation, "tvOperation");
            i1(this, tvOperation, QCircleDaTongConstant.ElementId.EM_XSJ_PRIVATE_MSG_ADD_FRIEND_BUTTON, null, 4, null);
            Intrinsics.checkNotNullExpressionValue(ivClose, "ivClose");
            i1(this, ivClose, QCircleDaTongConstant.ElementId.EM_XSJ_ADD_FRIEND_CLOSE_BUTTON, null, 4, null);
        }
    }

    private final void l1() {
        i.f446087a.d(this.mPeerUin, this.mPeerFollowState);
        getHostView().setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.a, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void afterCreateVM(@Nullable BaseVM<at.e, TopTipViewState, com.tencent.aio.api.runtime.a> mUIModel) {
        super.afterCreateVM(mUIModel);
        this.mPeerUin = ((com.tencent.aio.api.runtime.a) this.mVM.getMContext()).g().l().getLong("key_peerUin", 0L);
        this.mPeerNick = ((com.tencent.aio.api.runtime.a) this.mVM.getMContext()).g().r().c().g();
        QLog.d(this.TAG, 1, "[attachVM] mPeerUin = " + this.mPeerUin + ", mPeerNick = " + this.mPeerNick);
        a aVar = new a();
        j e16 = ((com.tencent.aio.api.runtime.a) this.mVM.getMContext()).e();
        String canonicalName = QFSAioTopTipMsgIntent$OnGetFollowState.class.getCanonicalName();
        LifecycleOwner d16 = ((com.tencent.aio.api.runtime.a) this.mVM.getMContext()).d();
        Intrinsics.checkNotNullExpressionValue(d16, "mVM.mContext.lifecycleOwner");
        e16.c(canonicalName, aVar, d16);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<at.e, TopTipViewState, com.tencent.aio.api.runtime.a> createVM() {
        return this.mVM;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.dum) {
            l1();
        } else if (v3.getId() == R.id.f109786gr) {
            l1();
            j1();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View inflate = LayoutInflater.from(getMContext()).inflate(R.layout.g7u, createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026ViewParams.parent, false)");
        return inflate;
    }
}
