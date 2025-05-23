package r10;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.comment.WsCommentPresenter;
import com.tencent.biz.pubaccount.weishi.n;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import com.tencent.biz.pubaccount.weishi.view.WSXRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001]\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002,eB\u0019\u0012\u0006\u0010a\u001a\u00020`\u0012\b\u0010b\u001a\u0004\u0018\u00010@\u00a2\u0006\u0004\bc\u0010dJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J,\u0010\u000f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0014\u0010\u0018\u001a\u00020\u0004*\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007J\b\u0010#\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u000bH\u0014J\b\u0010%\u001a\u00020\u0004H\u0014J\b\u0010&\u001a\u00020\u0004H\u0016J\b\u0010'\u001a\u00020\u0004H\u0014J&\u0010,\u001a\u00020\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110(2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u0016J\n\u0010-\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u000bJ\u000e\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u000bJ\u0006\u00102\u001a\u00020\tJ\u000e\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u000203J\u0010\u00106\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u00107\u001a\u00020\u0004J\u0006\u00108\u001a\u00020\u0004J\u0006\u00109\u001a\u00020\u0004J\u000e\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u000bR\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010MR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00110O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010SR\u0016\u0010V\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010UR\u0016\u0010W\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010UR\u0016\u0010X\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010UR\u0016\u0010Y\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u00101R\u0016\u0010Z\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00101R\u0018\u0010\\\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010[R\u0014\u0010_\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010^\u00a8\u0006f"}, d2 = {"Lr10/i;", "Lcom/tencent/biz/pubaccount/weishi/baseui/b;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "Lt10/a;", "", "D", BdhLogUtil.LogTag.Tag_Req, "Landroid/view/View;", "view", "", "isVisible", "", "animDuration", "Landroid/view/animation/Animation$AnimationListener;", "animListener", "V", "B", "LUserGrowth/stSimpleMetaComment;", "comment", "G", ExifInterface.LATITUDE_SOUTH, "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "y", "K", "L", "E", "requestScrollComment", "P", "U", ViewStickEventHelper.IS_SHOW, "N", "parentView", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "g", "f", "", "listData", "isFirst", "isLoadFinished", "a", "getItemData", "position", "H", "currentPosition", "I", UserInfo.SEX_FEMALE, "Lr10/i$b;", "onElementListener", "O", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "T", "J", "M", "height", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lt10/b;", BdhLogUtil.LogTag.Tag_Conn, "Lt10/b;", "mPresenter", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;", "mHolder", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "fragment", "Landroid/view/View;", "mCommentContainer", "mFLRvContainer", "Lcom/tencent/biz/pubaccount/weishi/view/WSXRecyclerView;", "Lcom/tencent/biz/pubaccount/weishi/view/WSXRecyclerView;", "mWSXRecyclerView", "Landroid/support/v7/widget/LinearLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "mLayoutManager", "", "Ljava/util/List;", "commentsListPool", "Lr10/c;", "Lr10/c;", "mAdapter", "Z", "isShowScrollComment", "isCommentScrolling", "mIsLoadFinished", "showCommentCount", "scrollCommentContainerHeight", "Lr10/i$b;", "mOnElementListener", "r10/i$d", "Lr10/i$d;", "mHandler", "Landroid/content/Context;", "context", "holder", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;)V", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i extends com.tencent.biz.pubaccount.weishi.baseui.b<j> implements t10.a {

    /* renamed from: C, reason: from kotlin metadata */
    private final t10.b mPresenter;

    /* renamed from: D, reason: from kotlin metadata */
    private au mHolder;

    /* renamed from: E, reason: from kotlin metadata */
    private WSVerticalPageFragment fragment;

    /* renamed from: F, reason: from kotlin metadata */
    private View mCommentContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private View mFLRvContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private WSXRecyclerView mWSXRecyclerView;

    /* renamed from: I, reason: from kotlin metadata */
    private LinearLayoutManager mLayoutManager;

    /* renamed from: J, reason: from kotlin metadata */
    private final List<stSimpleMetaComment> commentsListPool;

    /* renamed from: K, reason: from kotlin metadata */
    private r10.c mAdapter;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isShowScrollComment;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isCommentScrolling;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mIsLoadFinished;

    /* renamed from: P, reason: from kotlin metadata */
    private int showCommentCount;

    /* renamed from: Q, reason: from kotlin metadata */
    private int scrollCommentContainerHeight;

    /* renamed from: R, reason: from kotlin metadata */
    private b mOnElementListener;

    /* renamed from: S, reason: from kotlin metadata */
    private final d mHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lr10/i$b;", "", "", "isShowScrollComment", "", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public interface b {
        void a(boolean isShowScrollComment);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"r10/i$d", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class d extends Handler {
        d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            super.handleMessage(msg2);
            i.this.y(this, msg2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, au auVar) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPresenter = new t10.b(this);
        this.mHolder = auVar;
        this.fragment = auVar != null ? auVar.f82128e : null;
        this.commentsListPool = new ArrayList();
        this.mHandler = new d(Looper.getMainLooper());
    }

    private final void B() {
        View view = this.mCommentContainer;
        WSXRecyclerView wSXRecyclerView = view != null ? (WSXRecyclerView) view.findViewById(R.id.p67) : null;
        if (wSXRecyclerView == null) {
            return;
        }
        this.mWSXRecyclerView = wSXRecyclerView;
        LoadingMoreHelper loadMoreLayoutHelper = wSXRecyclerView.getLoadMoreLayoutHelper();
        if (loadMoreLayoutHelper != null) {
            loadMoreLayoutHelper.setPreLoaderCount(8);
        }
        Context mContext = this.f80409d;
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        this.mLayoutManager = new g(mContext, 1, false);
        Context mContext2 = this.f80409d;
        Intrinsics.checkNotNullExpressionValue(mContext2, "mContext");
        this.mAdapter = new r10.c(mContext2, this.fragment, getItemData());
        wSXRecyclerView.setRefreshEnable(false);
        wSXRecyclerView.setIsAutoScrolling(true);
        RecyclerViewWithHeaderFooter recyclerView = wSXRecyclerView.getRecyclerView();
        if (recyclerView != null) {
            recyclerView.setAdapter(this.mAdapter);
        }
        if (recyclerView != null) {
            recyclerView.setLayoutManager(this.mLayoutManager);
        }
        if (recyclerView != null) {
            recyclerView.setItemAnimator(null);
        }
        if (recyclerView != null) {
            Context mContext3 = this.f80409d;
            Intrinsics.checkNotNullExpressionValue(mContext3, "mContext");
            recyclerView.addOnItemTouchListener(new r10.b(mContext3));
        }
        if (recyclerView != null) {
            recyclerView.addItemDecoration(new n());
        }
        if (this.scrollCommentContainerHeight > ba.f81740o) {
            if (recyclerView != null) {
                recyclerView.setFadingEdgeLength(ba.f81734i);
            }
            if (recyclerView != null) {
                recyclerView.setVerticalFadingEdgeEnabled(true);
            }
        } else if (recyclerView != null) {
            recyclerView.setVerticalFadingEdgeEnabled(false);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(200L);
        if (recyclerView != null) {
            recyclerView.setItemAnimator(defaultItemAnimator);
        }
        r10.c cVar = this.mAdapter;
        if (cVar != null) {
            cVar.setOnItemClickListener(new BaseAdapter.OnItemClickListener() { // from class: r10.h
                @Override // com.tencent.widget.pull2refresh.BaseAdapter.OnItemClickListener
                public final void onItemClick(View view2, int i3) {
                    i.C(i.this, view2, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(i this$0, View view, int i3) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.g presenter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        r10.c cVar = this$0.mAdapter;
        Map<String, String> map = null;
        this$0.G(cVar != null ? cVar.getItem(i3) : null);
        WSVerticalPageFragment wSVerticalPageFragment = this$0.fragment;
        String from = wSVerticalPageFragment != null ? wSVerticalPageFragment.getFrom() : null;
        WSVerticalPageFragment wSVerticalPageFragment2 = this$0.fragment;
        String playScene = wSVerticalPageFragment2 != null ? wSVerticalPageFragment2.getPlayScene() : null;
        j c16 = this$0.c();
        stSimpleMetaFeed e16 = c16 != null ? c16.e() : null;
        WSVerticalPageFragment wSVerticalPageFragment3 = this$0.fragment;
        if (wSVerticalPageFragment3 != null && (presenter = wSVerticalPageFragment3.getPresenter()) != null) {
            map = presenter.h0();
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.X(from, playScene, e16, 2, map);
    }

    private final void D() {
        if (this.mCommentContainer == null) {
            View p16 = p(R.id.f116786zo);
            Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type android.view.ViewStub");
            ViewStub viewStub = (ViewStub) p16;
            viewStub.setLayoutResource(R.layout.f167387d20);
            this.mCommentContainer = viewStub.inflate();
        }
        View view = this.mCommentContainer;
        if (view != null) {
            V(view, true, 300, null);
            this.mFLRvContainer = view.findViewById(R.id.p3z);
            R();
            B();
        }
    }

    private final boolean E() {
        return c() != null && c().j();
    }

    private final void G(stSimpleMetaComment comment) {
        WSVerticalPageFragment wSVerticalPageFragment = this.fragment;
        WsCommentPresenter wsCommentPresenter = wSVerticalPageFragment != null ? wSVerticalPageFragment.f81812c0 : null;
        if (wsCommentPresenter != null) {
            String l3 = com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(wSVerticalPageFragment != null ? wSVerticalPageFragment.getFrom() : null);
            WSVerticalPageFragment wSVerticalPageFragment2 = this.fragment;
            wsCommentPresenter.m0(l3, wSVerticalPageFragment2 != null ? wSVerticalPageFragment2.getPlayScene() : null);
            wsCommentPresenter.v0(d());
            wsCommentPresenter.t0(3);
            j itemData = getItemData();
            wsCommentPresenter.r0(itemData != null ? itemData.e() : null);
            wsCommentPresenter.p0(comment != null ? comment.f25128id : null);
            wsCommentPresenter.o0(true);
            wsCommentPresenter.w0();
        }
    }

    private final void K() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.g presenter;
        if (this.showCommentCount <= 0) {
            return;
        }
        WSVerticalPageFragment wSVerticalPageFragment = this.fragment;
        Map<String, String> map = null;
        String from = wSVerticalPageFragment != null ? wSVerticalPageFragment.getFrom() : null;
        WSVerticalPageFragment wSVerticalPageFragment2 = this.fragment;
        String playScene = wSVerticalPageFragment2 != null ? wSVerticalPageFragment2.getPlayScene() : null;
        j c16 = c();
        stSimpleMetaFeed e16 = c16 != null ? c16.e() : null;
        int i3 = this.showCommentCount;
        WSVerticalPageFragment wSVerticalPageFragment3 = this.fragment;
        if (wSVerticalPageFragment3 != null && (presenter = wSVerticalPageFragment3.getPresenter()) != null) {
            map = presenter.h0();
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.a0(from, playScene, e16, i3, map);
    }

    private final void N(boolean isShow) {
        com.tencent.biz.pubaccount.weishi.baseui.c<T> cVar;
        au auVar = this.mHolder;
        if (auVar == null || (cVar = auVar.f82127d) == 0) {
            return;
        }
        cVar.e(isShow ? 4 : 5);
    }

    private final void P(boolean requestScrollComment) {
        if (c() == null) {
            return;
        }
        c().q(requestScrollComment);
    }

    private final void R() {
        View view;
        x.b("WSVerticalItemScrollCommentController", "[scrollCommentContainerHeight]:" + this.scrollCommentContainerHeight);
        if (this.scrollCommentContainerHeight == 0 || (view = this.mFLRvContainer) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.getLayoutParams().height = this.scrollCommentContainerHeight;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(Handler handler, Message message) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.g presenter;
        RecyclerViewWithHeaderFooter recyclerView;
        if (message.what == 1001) {
            if (this.commentsListPool.size() > 0) {
                this.showCommentCount++;
                r10.c cVar = this.mAdapter;
                if (cVar != null) {
                    cVar.p(this.commentsListPool.remove(0));
                }
                r10.c cVar2 = this.mAdapter;
                if (cVar2 != null) {
                    int itemCount = cVar2.getItemCount() - 1;
                    WSXRecyclerView wSXRecyclerView = this.mWSXRecyclerView;
                    if (wSXRecyclerView != null && (recyclerView = wSXRecyclerView.getRecyclerView()) != null) {
                        recyclerView.smoothScrollToPosition(itemCount);
                    }
                }
                x.i("WSVerticalItemScrollCommentController", "commentsListPool \u5269\u4f59\u4e2a\u6570\uff1a" + this.commentsListPool.size());
                handler.sendEmptyMessageDelayed(1001, a.f430463a.a());
                if (this.commentsListPool.size() == 5) {
                    this.mPresenter.b(false, false);
                    return;
                }
                return;
            }
            this.isCommentScrolling = false;
            if (this.mIsLoadFinished) {
                z(new c());
                K();
                WSVerticalPageFragment wSVerticalPageFragment = this.fragment;
                Map<String, String> map = null;
                String from = wSVerticalPageFragment != null ? wSVerticalPageFragment.getFrom() : null;
                WSVerticalPageFragment wSVerticalPageFragment2 = this.fragment;
                String playScene = wSVerticalPageFragment2 != null ? wSVerticalPageFragment2.getPlayScene() : null;
                j c16 = c();
                stSimpleMetaFeed e16 = c16 != null ? c16.e() : null;
                WSVerticalPageFragment wSVerticalPageFragment3 = this.fragment;
                if (wSVerticalPageFragment3 != null && (presenter = wSVerticalPageFragment3.getPresenter()) != null) {
                    map = presenter.h0();
                }
                com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.Z(from, playScene, e16, map);
            }
        }
    }

    public final void A(View parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        this.f80410e = parentView;
    }

    /* renamed from: F, reason: from getter */
    public final boolean getIsShowScrollComment() {
        return this.isShowScrollComment;
    }

    public final void H(int position) {
        L();
    }

    public final void I(int currentPosition) {
        K();
    }

    public final void J() {
        if (this.isShowScrollComment && this.isCommentScrolling) {
            this.isCommentScrolling = false;
            this.mHandler.removeMessages(1001);
        }
    }

    public final void M() {
        if (!this.isShowScrollComment || this.isCommentScrolling) {
            return;
        }
        this.isCommentScrolling = true;
        this.mHandler.sendEmptyMessage(1001);
    }

    public final void O(b onElementListener) {
        Intrinsics.checkNotNullParameter(onElementListener, "onElementListener");
        this.mOnElementListener = onElementListener;
    }

    public final void Q(int height) {
        this.scrollCommentContainerHeight = height;
    }

    public final void T() {
        if (E()) {
            M();
        } else {
            U();
        }
    }

    @Override // t10.a
    public void a(List<stSimpleMetaComment> listData, boolean isFirst, boolean isLoadFinished) {
        Intrinsics.checkNotNullParameter(listData, "listData");
        this.mIsLoadFinished = isLoadFinished;
        this.commentsListPool.addAll(listData);
        if (isFirst) {
            D();
            S();
        } else {
            if (this.isCommentScrolling) {
                return;
            }
            M();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.commentsListPool.clear();
        this.showCommentCount = 0;
        x.b("WSVerticalItemScrollCommentController", "onRecycle");
    }

    @Override // t10.a
    public j getItemData() {
        return c();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return 0;
    }

    public final void z(Animation.AnimationListener animListener) {
        V(this.mCommentContainer, false, 300, animListener);
        this.isShowScrollComment = false;
        this.isCommentScrolling = false;
        N(false);
        this.mHandler.removeMessages(1001);
    }

    private final void L() {
        this.showCommentCount = 0;
        this.commentsListPool.clear();
        P(false);
        z(null);
        this.mIsLoadFinished = false;
        View view = this.mCommentContainer;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    private final void S() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.g presenter;
        this.isShowScrollComment = true;
        this.isCommentScrolling = true;
        N(true);
        b bVar = this.mOnElementListener;
        if (bVar != null) {
            bVar.a(this.isShowScrollComment);
        }
        this.mHandler.sendEmptyMessage(1001);
        WSVerticalPageFragment wSVerticalPageFragment = this.fragment;
        Map<String, String> map = null;
        String from = wSVerticalPageFragment != null ? wSVerticalPageFragment.getFrom() : null;
        WSVerticalPageFragment wSVerticalPageFragment2 = this.fragment;
        String playScene = wSVerticalPageFragment2 != null ? wSVerticalPageFragment2.getPlayScene() : null;
        j c16 = c();
        stSimpleMetaFeed e16 = c16 != null ? c16.e() : null;
        WSVerticalPageFragment wSVerticalPageFragment3 = this.fragment;
        if (wSVerticalPageFragment3 != null && (presenter = wSVerticalPageFragment3.getPresenter()) != null) {
            map = presenter.h0();
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.Y(from, playScene, e16, map);
    }

    private final void U() {
        P(true);
        this.mPresenter.b(true, true);
    }

    private final void V(View view, boolean isVisible, int animDuration, Animation.AnimationListener animListener) {
        if (view == null) {
            return;
        }
        view.clearAnimation();
        AnimationSet animationSet = new AnimationSet(true);
        if (isVisible) {
            view.setVisibility(0);
            animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet.addAnimation(new TranslateAnimation(0.0f, 0.0f, view.getHeight(), 0.0f));
        } else {
            view.setVisibility(8);
            animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
            animationSet.addAnimation(new TranslateAnimation(0.0f, 0.0f, 0.0f, -view.getHeight()));
        }
        animationSet.setDuration(animDuration);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(animListener);
        view.startAnimation(animationSet);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    public void g() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    public void h() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"r10/i$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b bVar = i.this.mOnElementListener;
            if (bVar != null) {
                bVar.a(i.this.isShowScrollComment);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
