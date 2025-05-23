package y40;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.events.QFSLayerFloatShowEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchPageCloseEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.search.event.UpdateSearchShadingWordEvent;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StShadingWords;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p40.o;
import tl.h;
import ua0.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 X2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001YB\u0019\u0012\b\u00103\u001a\u0004\u0018\u00010,\u0012\u0006\u0010;\u001a\u000204\u00a2\u0006\u0004\bV\u0010WJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u0014\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\u001e\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J$\u0010\"\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 0\u001fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 `!H\u0016J\u0012\u0010$\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010'\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010*\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010+\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%H\u0016R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010L\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010ER\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010=\u00a8\u0006Z"}, d2 = {"Ly40/g;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "K9", "O9", "G9", "I9", "Lfeedcloud/FeedCloudMeta$StShadingWords;", "stShadingWords", "Q9", "P9", "F9", "", "Lfeedcloud/FeedCloudCommon$Entry;", "extInfoList", "", "E9", "", "isVisible", "S9", "M9", "getLogTag", "onInitView", "action", "", "args", "handleBroadcastMessage", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "simpleBaseEvent", "onReceiveEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "d", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "getInitBean", "()Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "setInitBean", "(Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;)V", "initBean", "", "e", "I", "getSearchSource", "()I", "setSearchSource", "(I)V", ForwardRecentActivity.KEY_SEARCH_SOURCE, "f", "Landroid/view/View;", "closeBtn", "Landroid/widget/FrameLayout;", h.F, "Landroid/widget/FrameLayout;", "searchBar", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "searchBtn", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "commonSearchBtn", BdhLogUtil.LogTag.Tag_Conn, "searchTextView", "Lfeedcloud/FeedCloudMeta$StFeed;", "D", "Lfeedcloud/FeedCloudMeta$StFeed;", "mFeed", "E", "Ljava/lang/String;", "refPageId", UserInfo.SEX_FEMALE, "smallWindow", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;I)V", "G", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class g extends u implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView searchTextView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed mFeed;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private String refPageId;

    /* renamed from: F, reason: from kotlin metadata */
    private View smallWindow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleInitBean initBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int searchSource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View closeBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout searchBar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView searchBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView commonSearchBtn;

    public g(@Nullable QCircleInitBean qCircleInitBean, int i3) {
        this.initBean = qCircleInitBean;
        this.searchSource = i3;
    }

    private final String E9(List<FeedCloudCommon$Entry> extInfoList) {
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : extInfoList) {
            if (Intrinsics.areEqual("transfer_info", feedCloudCommon$Entry.key.get())) {
                String str = feedCloudCommon$Entry.value.get();
                Intrinsics.checkNotNullExpressionValue(str, "entry.value.get()");
                return str;
            }
        }
        return "";
    }

    private final void F9(FeedCloudMeta$StShadingWords stShadingWords) {
        PageInfo pageInfo;
        Map mutableMapOf;
        TextView textView = this.searchTextView;
        if (textView != null && (pageInfo = VideoReport.getPageInfo(textView)) != null) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("xsj_query_text", stShadingWords.text.get()), TuplesKt.to("xsj_item_index", 0), TuplesKt.to("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_GREY_WORD));
            List<FeedCloudCommon$Entry> list = stShadingWords.ext_info.get();
            Intrinsics.checkNotNullExpressionValue(list, "stShadingWords.ext_info.get()");
            String E9 = E9(list);
            if (!TextUtils.isEmpty(E9)) {
                mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHADING_WORD_TRANSFER_INFO, E9);
            }
            String pageId = pageInfo.getPageId();
            if (pageId == null) {
                pageId = QCircleDaTongConstant.PageId.PG_XSJ_LAYER_PAGE;
            }
            mutableMapOf.put("xsj_custom_pgid", pageId);
            String str = this.refPageId;
            if (str != null) {
                mutableMapOf.put("dt_ref_pgid", str);
            }
            i.h(this.searchTextView, "ev_xsj_abnormal_imp", mutableMapOf);
        }
    }

    private final void G9(View rootView) {
        View findViewById = rootView.findViewById(R.id.va6);
        this.closeBtn = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: y40.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.H9(g.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (o.d(QCirclePluginUtil.getQCircleInitBean(this$0.getContext())) && uq3.o.g()) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSLayerFloatShowEvent(QFSLayerFloatShowEvent.EVENT_TYPE_TOP_CLOSE_TRIGGER));
        } else {
            this$0.getActivity().onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void I9(View rootView) {
        TextView textView;
        View findViewById = rootView.findViewById(R.id.vaa);
        if (findViewById instanceof ViewStub) {
            View inflate = ((ViewStub) findViewById).inflate();
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
            this.searchBar = (FrameLayout) inflate;
        } else if (findViewById instanceof FrameLayout) {
            this.searchBar = (FrameLayout) findViewById;
        }
        FrameLayout frameLayout = this.searchBar;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        final int t16 = p.t(this.initBean);
        FrameLayout frameLayout2 = this.searchBar;
        if (frameLayout2 != null) {
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: y40.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.J9(g.this, t16, view);
                }
            });
        }
        FrameLayout frameLayout3 = this.searchBar;
        TextView textView2 = null;
        if (frameLayout3 != null) {
            textView = (TextView) frameLayout3.findViewById(R.id.f108966ej);
        } else {
            textView = null;
        }
        this.searchBtn = textView;
        FrameLayout frameLayout4 = this.searchBar;
        if (frameLayout4 != null) {
            textView2 = (TextView) frameLayout4.findViewById(R.id.f108976ek);
        }
        this.searchTextView = textView2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(g this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSSearchBean qFSSearchBean = new QFSSearchBean();
        qFSSearchBean.setUserSource(i3);
        qFSSearchBean.setPageInteract(true);
        com.tencent.biz.qqcircle.launcher.c.y0(this$0.getContext(), qFSSearchBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void K9(View rootView) {
        int i3;
        View findViewById = rootView.findViewById(R.id.va_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_layer_page_small_window)");
        this.smallWindow = findViewById;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallWindow");
            findViewById = null;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: y40.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.L9(g.this, view);
            }
        });
        View view = this.smallWindow;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallWindow");
            view = null;
        }
        o.a(view, new e30.b(this.mFeed), this.initBean);
        View view2 = this.smallWindow;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallWindow");
            view2 = null;
        }
        if (o.f(QCirclePluginUtil.getQCircleInitBean(getContext()))) {
            QCircleInitBean qCircleInitBean = this.initBean;
            if (qCircleInitBean != null) {
                feedCloudMeta$StFeed = qCircleInitBean.getFeed();
            }
            if (o.e(feedCloudMeta$StFeed)) {
                i3 = 0;
                view2.setVisibility(i3);
            }
        }
        i3 = 8;
        view2.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view2 = this$0.smallWindow;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallWindow");
            view2 = null;
        }
        o.a(view2, new e30.b(this$0.mFeed), this$0.initBean);
        if (((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(MobileQQ.sMobileQQ)) {
            this$0.O9();
        } else {
            ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialog(this$0.getContext());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean M9() {
        if (this.searchSource == 17) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(g this$0, FeedCloudMeta$StShadingWords this_apply) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.Q9(this_apply);
    }

    private final void O9() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSLayerSearchResultPageTitlePart", 1, "[openFeedSmallWindow] current should not be null.");
            return;
        }
        Intrinsics.checkNotNull(feedCloudMeta$StFeed);
        QLog.d("QFSLayerSearchResultPageTitlePart", 1, "[openFeedSmallWindow] feed id: " + feedCloudMeta$StFeed.f398449id.get());
        SimpleEventBus.getInstance().dispatchEvent(new QFSLayerFloatShowEvent(QFSLayerFloatShowEvent.EVENT_TYPE_LAYER_TOP_FLOAT_TRIGGER));
    }

    private final void P9() {
        int i3;
        if (this.searchBar != null && this.searchTextView != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            FrameLayout frameLayout = this.searchBar;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
            int i16 = 0;
            if (feedCloudMeta$StFeed != null) {
                i3 = feedCloudMeta$StFeed.hashCode();
            } else {
                i3 = 0;
            }
            i.k(frameLayout, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_BOX, linkedHashMap, i3);
            TextView textView = this.searchTextView;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.mFeed;
            if (feedCloudMeta$StFeed2 != null) {
                i16 = feedCloudMeta$StFeed2.hashCode();
            }
            i.k(textView, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_GREY_WORD, linkedHashMap, i16);
        }
    }

    private final void Q9(FeedCloudMeta$StShadingWords stShadingWords) {
        boolean z16;
        boolean z17;
        String str;
        final String shadingWord = stShadingWords.text.get();
        TextView textView = this.searchTextView;
        if (textView != null) {
            if (shadingWord.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                str = "\u641c\u4f60\u60f3\u770b";
            } else {
                str = shadingWord;
            }
            textView.setText(str);
        }
        Intrinsics.checkNotNullExpressionValue(shadingWord, "shadingWord");
        if (shadingWord.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            TextView textView2 = this.searchBtn;
            if (textView2 != null) {
                textView2.setClickable(false);
                return;
            }
            return;
        }
        TextView textView3 = this.searchBtn;
        if (textView3 != null) {
            textView3.setClickable(true);
        }
        final int t16 = p.t(this.initBean);
        TextView textView4 = this.searchBtn;
        if (textView4 != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: y40.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.R9(g.this, t16, shadingWord, view);
                }
            });
        }
        F9(stShadingWords);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(g this$0, int i3, String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSSearchBean qFSSearchBean = new QFSSearchBean();
        qFSSearchBean.setUserSource(i3);
        qFSSearchBean.setQuerySource(this$0.searchSource);
        qFSSearchBean.setSearchKeyword(str);
        qFSSearchBean.setPageInteract(true);
        com.tencent.biz.qqcircle.launcher.c.A0(this$0.getContext(), qFSSearchBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void S9(final boolean isVisible) {
        getMainHandler().post(new Runnable() { // from class: y40.d
            @Override // java.lang.Runnable
            public final void run() {
                g.T9(isVisible, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(boolean z16, g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = null;
        if (z16) {
            View view2 = this$0.smallWindow;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("smallWindow");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            View view3 = this$0.closeBtn;
            if (view3 != null) {
                view3.setPadding(view3.getPaddingLeft(), view3.getPaddingTop(), cx.a(6.0f), view3.getPaddingBottom());
                return;
            }
            return;
        }
        View view4 = this$0.smallWindow;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smallWindow");
        } else {
            view = view4;
        }
        view.setVisibility(8);
        QLog.e("QFSLayerSearchResultPageTitlePart", 1, "[updateSmallWindow] gone.");
        View view5 = this$0.closeBtn;
        if (view5 != null) {
            view5.setPadding(view5.getPaddingLeft(), view5.getPaddingTop(), cx.a(14.0f), view5.getPaddingBottom());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(UpdateSearchShadingWordEvent.class);
        arrayList.add(QFSSearchPageCloseEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerSearchResultPageTitlePart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (!Intrinsics.areEqual("layer_notify_part_update_feed", action) || !(args instanceof e30.b)) {
            return;
        }
        FeedCloudMeta$StFeed g16 = ((e30.b) args).g();
        this.mFeed = g16;
        if (g16 != null) {
            List<Integer> list = g16.opMask2.get();
            boolean z16 = false;
            if (M9() && (list.isEmpty() || !list.contains(47))) {
                FrameLayout frameLayout = this.searchBar;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                ImageView imageView = this.commonSearchBtn;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                if (o.e(this.mFeed) && o.f(QCirclePluginUtil.getQCircleInitBean(getContext()))) {
                    z16 = true;
                }
                S9(z16);
                return;
            }
            P9();
            S9(false);
            FrameLayout frameLayout2 = this.searchBar;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            ImageView imageView2 = this.commonSearchBtn;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            FeedCloudMeta$StShadingWords feedCloudMeta$StShadingWords = g16.shading_words.get();
            Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StShadingWords, "this.shading_words.get()");
            Q9(feedCloudMeta$StShadingWords);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        String str;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        G9(rootView);
        I9(rootView);
        K9(rootView);
        this.commonSearchBtn = p.G(rootView, this.initBean);
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        if (pageInfo != null) {
            str = pageInfo.pageId;
        } else {
            str = null;
        }
        this.refPageId = str;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        FeedCloudMeta$StShadingWords feedCloudMeta$StShadingWords;
        FeedCloudMeta$StShadingWords feedCloudMeta$StShadingWords2;
        super.onPartResume(activity);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StShadingWords = feedCloudMeta$StFeed.shading_words) != null && (feedCloudMeta$StShadingWords2 = feedCloudMeta$StShadingWords.get()) != null) {
            Q9(feedCloudMeta$StShadingWords2);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        String str;
        PBStringField pBStringField;
        if (simpleBaseEvent instanceof UpdateSearchShadingWordEvent) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
            if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            final FeedCloudMeta$StShadingWords feedCloudMeta$StShadingWords = ((UpdateSearchShadingWordEvent) simpleBaseEvent).getShadingWordsMap().get(str);
            if (feedCloudMeta$StShadingWords != null) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: y40.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.N9(g.this, feedCloudMeta$StShadingWords);
                    }
                });
            }
        }
        if ((simpleBaseEvent instanceof QFSSearchPageCloseEvent) && !M9()) {
            getActivity().onBackPressed();
        }
    }
}
