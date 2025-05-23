package xb0;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0001'B\u0011\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\r\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\u000e\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\b\u0010\u0019\u001a\u00020\u0004H\u0014R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006("}, d2 = {"Lxb0/ae;", "Lcom/tencent/biz/qqcircle/share/QCircleBaseShareOperation;", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "d0", "X", ExifInterface.LATITUDE_SOUTH, "", "Lcom/tencent/widget/ActionMenuItem;", "W", "actionMenuArray", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "P", "Lcom/tencent/widget/ActionSheet$OnButtonClickListener;", "U", "", "subActionType", "T", "c0", "actionType", "b0", "", "y", "G", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "u", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "log", "Lcom/tencent/biz/qqcircle/widgets/b;", "v", "Lcom/tencent/biz/qqcircle/widgets/b;", "mSecondMenuActionSheet", "Lcom/tencent/biz/qqcircle/share/QCircleBaseShareOperation$a;", "builder", "<init>", "(Lcom/tencent/biz/qqcircle/share/QCircleBaseShareOperation$a;)V", "w", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class ae extends QCircleBaseShareOperation {

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi log;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private com.tencent.biz.qqcircle.widgets.b mSecondMenuActionSheet;

    public ae(@Nullable QCircleBaseShareOperation.a aVar) {
        super(aVar);
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.log = (IAegisLogApi) api;
    }

    private final void P(List<ActionMenuItem> actionMenuArray) {
        actionMenuArray.add(new ActionMenuItem(5, "\u51cf\u5c11\u76f4\u64ad", 5, 0));
    }

    private final void Q(List<ActionMenuItem> actionMenuArray) {
        actionMenuArray.add(new ActionMenuItem(3, "\u51cf\u5c11\u6b64\u7c7b\u578b", 3, 0));
    }

    private final void R(List<ActionMenuItem> actionMenuArray) {
        actionMenuArray.add(new ActionMenuItem(4, "\u4e0d\u770b\u8be5\u4e3b\u64ad", 4, 0));
    }

    private final void S() {
        wb0.a h16 = h();
        if (h16 != null) {
            h16.a(false);
        }
        Activity f16 = f();
        com.tencent.biz.qqcircle.widgets.b bVar = this.mSecondMenuActionSheet;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSecondMenuActionSheet");
            bVar = null;
        }
        ob0.a.b(f16, bVar);
    }

    private final void T(int subActionType) {
        if (t() != null && t().feed != null && f() != null) {
            FeedCloudMeta$StFeed feed = t().feed;
            SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(feed.f398449id.get(), 3));
            Intrinsics.checkNotNullExpressionValue(feed, "feed");
            c0(feed, subActionType);
        }
    }

    private final ActionSheet.OnButtonClickListener U() {
        return new ActionSheet.OnButtonClickListener() { // from class: xb0.ad
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                ae.V(ae.this, view, i3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(ae this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity f16 = this$0.f();
        com.tencent.biz.qqcircle.widgets.b bVar = this$0.mSecondMenuActionSheet;
        com.tencent.biz.qqcircle.widgets.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSecondMenuActionSheet");
            bVar = null;
        }
        ob0.a.b(f16, bVar);
        com.tencent.biz.qqcircle.widgets.b bVar3 = this$0.mSecondMenuActionSheet;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSecondMenuActionSheet");
        } else {
            bVar2 = bVar3;
        }
        ActionMenuItem actionMenuItem = bVar2.getActionMenuItem(i3);
        if (actionMenuItem == null) {
            return;
        }
        this$0.T(actionMenuItem.action);
        this$0.S();
        QCircleToast.i(QCircleToast.f91646f, R.string.f182873hn, 0);
    }

    private final List<ActionMenuItem> W() {
        QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
        try {
            qQCircleFeedBase$StFeedBusiReqData.mergeFrom(t().feed.busiData.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            this.log.e("QCircleLiveDisLikeOperation", "parse reqData failed " + e16.getMessage());
        }
        ArrayList arrayList = new ArrayList();
        List<Integer> list = qQCircleFeedBase$StFeedBusiReqData.uninterest_buttons.get();
        if (list.contains(37)) {
            Q(arrayList);
        }
        if (list.contains(38)) {
            R(arrayList);
        }
        if (list.contains(39)) {
            P(arrayList);
        }
        return arrayList;
    }

    private final void X() {
        com.tencent.biz.qqcircle.widgets.b bVar = this.mSecondMenuActionSheet;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSecondMenuActionSheet");
            bVar = null;
        }
        bVar.addCancelButton(R.string.cancel);
        bVar.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: xb0.aa
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ae.Y(ae.this, dialogInterface);
            }
        });
        bVar.setOnDismissListener(new ActionSheet.OnDismissListener() { // from class: xb0.ab
            @Override // com.tencent.widget.ActionSheet.OnDismissListener
            public final void onDismiss() {
                ae.Z(ae.this);
            }
        });
        bVar.setOnBottomCancelListener(new View.OnClickListener() { // from class: xb0.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ae.a0(ae.this, view);
            }
        });
        bVar.getRootView().setBackgroundColor(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(ae this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(ae this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(ae this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void b0(FeedCloudMeta$StFeed feed, int actionType, int subActionType) {
        int i3;
        int m3;
        QCircleExtraTypeInfo qCircleExtraTypeInfo;
        this.log.i("QCircleLiveDisLikeOperation", "reportDcShareToDislike, roomId " + o40.a.b(feed));
        QCircleShareInfo t16 = t();
        if (t16 != null && (qCircleExtraTypeInfo = t16.extraTypeInfo) != null) {
            i3 = qCircleExtraTypeInfo.mDataPosition;
        } else {
            i3 = -1;
        }
        QCircleLpReportDc05501.DataBuilder ext3 = ua0.c.a(feed).setToUin(t().feed.poster.f398463id.get()).setActionType(actionType).setSubActionType(subActionType).setIndex(i3).setExt3(feed.createTime.toString());
        if (C(57)) {
            m3 = n();
        } else {
            m3 = m();
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(ext3.setPageId(m3)));
    }

    private final void c0(FeedCloudMeta$StFeed feed, int subActionType) {
        b0(feed, 65, subActionType);
        d("hidden", null);
    }

    private final void d0(FeedCloudMeta$StFeed feed) {
        b0(feed, 65, 2);
        b0(feed, 79, 1);
        d(QCircleDaTongConstant.ElementParamValue.UNINTEREST, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (t() != null && t().feed != null && f() != null) {
            com.tencent.biz.qqcircle.widgets.b c16 = com.tencent.biz.qqcircle.widgets.c.c(f(), W(), U());
            if (c16 == null) {
                this.log.e("QCircleLiveDisLikeOperation", "create SecondMenuActionSheet failed");
                return;
            }
            this.mSecondMenuActionSheet = c16;
            X();
            com.tencent.biz.qqcircle.widgets.b bVar = this.mSecondMenuActionSheet;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSecondMenuActionSheet");
                bVar = null;
            }
            bVar.show();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = t().feed;
            Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StFeed, "shareInfo.feed");
            d0(feedCloudMeta$StFeed);
            return;
        }
        J("QCircleLiveDisLikeOperation");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
