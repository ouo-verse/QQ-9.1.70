package xa4;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.immersive.utils.bp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqforward.api.RecentContactListener;
import com.tencent.mobileqq.qqforward.api.RecentUserBean;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pu4.g;
import pu4.i;
import pu4.j;
import pu4.l;
import pu4.n;
import tl.h;
import xa4.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u0003\u001e\"&B\u0017\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020!\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u001e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J.\u0010\u001a\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0018H\u0002J.\u0010\u001b\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0018H\u0002J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00060"}, d2 = {"Lxa4/f;", "", "", h.F, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "Lxa4/f$b;", "userList", "Landroid/view/View;", "g", "view", "i", "Landroid/widget/LinearLayout;", "parentContainer", "k", "Lxa4/f$c;", "viewHolder", "data", "l", "", "", "f", AdMetricTag.EVENT_NAME, "", "reportMap", DomainData.DOMAIN_NAME, "o", "p", "Lpu4/n;", "a", "Lpu4/n;", QCircleScheme.AttrDetail.FEED_INFO, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "b", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "Landroid/widget/PopupWindow;", "c", "Landroid/widget/PopupWindow;", "popWindow", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "d", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "dtViewReporter", "<init>", "(Lpu4/n;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "e", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final n feedInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private PopupWindow popWindow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZplanViewReportHelper dtViewReporter;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lxa4/f$a;", "", "Lpu4/n;", QCircleScheme.AttrDetail.FEED_INFO, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "", "a", "", "AUTO_HIDE_DELAY", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xa4.f$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(n feedInfo, Activity activity, ZootopiaSource sourceCurrent) {
            Intrinsics.checkNotNullParameter(feedInfo, "feedInfo");
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
            new f(feedInfo, sourceCurrent).p(activity);
        }

        Companion() {
        }
    }

    public f(n feedInfo, ZootopiaSource sourceCurrent) {
        Intrinsics.checkNotNullParameter(feedInfo, "feedInfo");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.feedInfo = feedInfo;
        this.sourceCurrent = sourceCurrent;
        this.dtViewReporter = new ZplanViewReportHelper();
    }

    private final void h() {
        QLog.i("ZPlanFeedsPublishSuccessView", 1, "hide");
        PopupWindow popupWindow = this.popWindow;
        boolean z16 = false;
        if (popupWindow != null && popupWindow.isShowing()) {
            z16 = true;
        }
        if (z16) {
            try {
                PopupWindow popupWindow2 = this.popWindow;
                if (popupWindow2 != null) {
                    popupWindow2.dismiss();
                }
                this.popWindow = null;
            } catch (Exception e16) {
                QLog.e("ZPlanFeedsPublishSuccessView", 1, "hide exception", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(f this$0, View view, Map reportParams, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
        this$0.n(view, "em_zplan_publish_win_close", reportParams);
        this$0.h();
    }

    private final void k(LinearLayout parentContainer, List<RecentUserInfo> userList) {
        QLog.i("ZPlanFeedsPublishSuccessView", 1, "renderRecentUserList, costTime = " + (System.currentTimeMillis() - System.currentTimeMillis()) + "ms, ret = " + userList);
        if (userList.isEmpty()) {
            parentContainer.setVisibility(8);
            return;
        }
        parentContainer.setVisibility(0);
        Context context = parentContainer.getContext();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.f12738_);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.f127289);
        int size = userList.size();
        int childCount = parentContainer.getChildCount();
        int min = Math.min(size, childCount);
        for (int i3 = 0; i3 < min; i3++) {
            Object tag = parentContainer.getChildAt(i3).getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.publish.view.ZPlanFeedsPublishSuccessView.RecentUserItemViewHolder");
            l((RecentUserItemViewHolder) tag, userList.get(i3));
        }
        if (size <= childCount) {
            if (size < childCount) {
                while (size < childCount) {
                    parentContainer.getChildAt(size).setVisibility(8);
                    size++;
                }
                return;
            }
            return;
        }
        LayoutInflater from = LayoutInflater.from(context);
        while (childCount < size) {
            View itemView = from.inflate(R.layout.dfo, (ViewGroup) parentContainer, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.r8k);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView");
            RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById;
            roundCornerImageView.setRadius(context.getResources().getDimensionPixelSize(R.dimen.f12738_) / 2.0f);
            View findViewById2 = itemView.findViewById(R.id.r8l);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            RecentUserItemViewHolder recentUserItemViewHolder = new RecentUserItemViewHolder(itemView, roundCornerImageView, (TextView) findViewById2);
            itemView.setTag(recentUserItemViewHolder);
            l(recentUserItemViewHolder, userList.get(childCount));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -2);
            layoutParams.leftMargin = dimensionPixelSize2;
            layoutParams.rightMargin = childCount == size + (-1) ? dimensionPixelSize2 : 0;
            parentContainer.addView(itemView, layoutParams);
            childCount++;
        }
    }

    private final void l(RecentUserItemViewHolder viewHolder, final RecentUserInfo data) {
        Drawable q16;
        viewHolder.getContentView().setVisibility(0);
        viewHolder.getNickTxt().setText(data.getDisplayName());
        if (TextUtils.isEmpty(data.getUin())) {
            q16 = com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.ik_);
        } else {
            q16 = QCirclePluginGlobalInfo.q(data.getUin(), data.getType() == 1 ? 4 : 1);
        }
        viewHolder.getAvatarView().setImageDrawable(q16);
        final Map<String, String> f16 = f();
        aa.d(viewHolder.getContentView(), new View.OnClickListener() { // from class: xa4.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.m(f.RecentUserInfo.this, this, f16, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m(RecentUserInfo data, f this$0, Map reportParams, View view) {
        g gVar;
        String str;
        String str2;
        g[] gVarArr;
        Object firstOrNull;
        g[] gVarArr2;
        Object firstOrNull2;
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
        QLog.i("ZPlanFeedsPublishSuccessView", 1, "click share - " + data.getUin() + "_" + data.getType() + "_" + data.getTroopUin() + "_" + data.getDisplayName());
        this$0.n(view, "em_zplan_publish_win_friend", reportParams);
        com.tencent.mobileqq.zootopia.e eVar = com.tencent.mobileqq.zootopia.e.f328302a;
        l lVar = this$0.feedInfo.f427499b;
        if (lVar == null || (gVarArr2 = lVar.f427479d) == null) {
            gVar = null;
        } else {
            firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(gVarArr2);
            gVar = (g) firstOrNull2;
        }
        boolean a16 = eVar.a(gVar);
        l lVar2 = this$0.feedInfo.f427499b;
        if (lVar2 != null && (gVarArr = lVar2.f427479d) != null) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(gVarArr);
            g gVar2 = (g) firstOrNull;
            if (gVar2 != null) {
                str = gVar2.f427434a;
                String str3 = str != null ? "" : str;
                zb4.a aVar = zb4.a.f452297a;
                n nVar = this$0.feedInfo;
                l lVar3 = nVar.f427499b;
                str2 = lVar3 == null ? lVar3.f427476a : null;
                if (str2 == null) {
                    str2 = "";
                }
                j jVar = nVar.f427498a;
                String str4 = jVar != null ? jVar.f427463b : null;
                String str5 = str4 != null ? "" : str4;
                String uin = data.getUin();
                int type = data.getType();
                n nVar2 = this$0.feedInfo;
                i iVar = nVar2.f427502e;
                l lVar4 = nVar2.f427499b;
                aVar.a(str2, str5, uin, type, str3, a16, iVar, lVar4 == null ? lVar4.f427491p : -1, this$0.sourceCurrent);
            }
        }
        str = null;
        if (str != null) {
        }
        zb4.a aVar2 = zb4.a.f452297a;
        n nVar3 = this$0.feedInfo;
        l lVar32 = nVar3.f427499b;
        if (lVar32 == null) {
        }
        if (str2 == null) {
        }
        j jVar2 = nVar3.f427498a;
        if (jVar2 != null) {
        }
        if (str4 != null) {
        }
        String uin2 = data.getUin();
        int type2 = data.getType();
        n nVar22 = this$0.feedInfo;
        i iVar2 = nVar22.f427502e;
        l lVar42 = nVar22.f427499b;
        aVar2.a(str2, str5, uin2, type2, str3, a16, iVar2, lVar42 == null ? lVar42.f427491p : -1, this$0.sourceCurrent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(final f this$0, final Activity activity, final List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: xa4.b
            @Override // java.lang.Runnable
            public final void run() {
                f.r(list, this$0, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(List list, final f this$0, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                RecentUserBean recentUserBean = (RecentUserBean) it.next();
                if (recentUserBean.getType() == 0 || recentUserBean.getType() == 1) {
                    String uin = recentUserBean.getUin();
                    String str = "";
                    if (uin == null) {
                        uin = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(uin, "it.uin ?: \"\"");
                    }
                    String displayName = recentUserBean.getDisplayName();
                    if (displayName == null) {
                        displayName = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(displayName, "it.displayName ?: \"\"");
                    }
                    int type = recentUserBean.getType();
                    String str2 = recentUserBean.getmTroopUin();
                    if (str2 != null) {
                        Intrinsics.checkNotNullExpressionValue(str2, "it.getmTroopUin() ?: \"\"");
                        str = str2;
                    }
                    arrayList.add(new RecentUserInfo(uin, displayName, type, str));
                }
            }
        }
        QLog.i("ZPlanFeedsPublishSuccessView", 1, "show userList.size=" + arrayList.size());
        if (arrayList.isEmpty()) {
            QQToast.makeText(BaseApplication.getContext(), 2, R.string.xo_, 1).show();
            return;
        }
        PopupWindow popupWindow = new PopupWindow(this$0.g(activity, arrayList), -1, -2);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setAnimationStyle(R.style.f173290zz);
        this$0.popWindow = popupWindow;
        try {
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(activity);
            PopupWindow popupWindow2 = this$0.popWindow;
            if (popupWindow2 != null) {
                popupWindow2.showAtLocation(activity.getWindow().getDecorView(), 48, 0, statusBarHeight);
            }
        } catch (Exception e16) {
            QLog.e("ZPlanFeedsPublishSuccessView", 1, "show exception", e16);
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: xa4.c
            @Override // java.lang.Runnable
            public final void run() {
                f.s(f.this);
            }
        }, 7000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
    }

    public final void p(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        j jVar = this.feedInfo.f427498a;
        QLog.i("ZPlanFeedsPublishSuccessView", 1, "show - feedId=" + (jVar != null ? jVar.f427463b : null) + ", activity=" + activity);
        bp.f90195c.c(new RecentContactListener() { // from class: xa4.a
            @Override // com.tencent.mobileqq.qqforward.api.RecentContactListener
            public final void onResult(List list) {
                f.q(f.this, activity, list);
            }
        });
    }

    private final Map<String, String> f() {
        Map<String, String> mutableMapOf;
        String num;
        Pair[] pairArr = new Pair[4];
        l lVar = this.feedInfo.f427499b;
        String str = lVar != null ? lVar.f427476a : null;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("zplan_content_id", str);
        l lVar2 = this.feedInfo.f427499b;
        if (lVar2 != null && (num = Integer.valueOf(lVar2.f427491p).toString()) != null) {
            str2 = num;
        }
        pairArr[1] = TuplesKt.to("zplan_content_type", str2);
        pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(this.sourceCurrent));
        pairArr[3] = TuplesKt.to("dt_pgid", "pg_zplan_outfit_community");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lxa4/f$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "uin", "b", CommonConstant.KEY_DISPLAY_NAME, "c", "I", "()I", "type", "troopUin", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xa4.f$b, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class RecentUserInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String displayName;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String troopUin;

        public RecentUserInfo(String uin, String displayName, int i3, String troopUin) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(displayName, "displayName");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.uin = uin;
            this.displayName = displayName;
            this.type = i3;
            this.troopUin = troopUin;
        }

        /* renamed from: a, reason: from getter */
        public final String getDisplayName() {
            return this.displayName;
        }

        /* renamed from: b, reason: from getter */
        public final String getTroopUin() {
            return this.troopUin;
        }

        /* renamed from: c, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* renamed from: d, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        public int hashCode() {
            return (((((this.uin.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.type) * 31) + this.troopUin.hashCode();
        }

        public String toString() {
            return "RecentUserInfo(uin=" + this.uin + ", displayName=" + this.displayName + ", type=" + this.type + ", troopUin=" + this.troopUin + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecentUserInfo)) {
                return false;
            }
            RecentUserInfo recentUserInfo = (RecentUserInfo) other;
            return Intrinsics.areEqual(this.uin, recentUserInfo.uin) && Intrinsics.areEqual(this.displayName, recentUserInfo.displayName) && this.type == recentUserInfo.type && Intrinsics.areEqual(this.troopUin, recentUserInfo.troopUin);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lxa4/f$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/view/View;", "a", "Landroid/view/View;", "b", "()Landroid/view/View;", "contentView", "Lcom/tencent/sqshow/zootopia/utils/ui/RoundCornerImageView;", "Lcom/tencent/sqshow/zootopia/utils/ui/RoundCornerImageView;", "()Lcom/tencent/sqshow/zootopia/utils/ui/RoundCornerImageView;", "avatarView", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "nickTxt", "<init>", "(Landroid/view/View;Lcom/tencent/sqshow/zootopia/utils/ui/RoundCornerImageView;Landroid/widget/TextView;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xa4.f$c, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class RecentUserItemViewHolder {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final View contentView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final RoundCornerImageView avatarView;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final TextView nickTxt;

        public RecentUserItemViewHolder(View contentView, RoundCornerImageView avatarView, TextView nickTxt) {
            Intrinsics.checkNotNullParameter(contentView, "contentView");
            Intrinsics.checkNotNullParameter(avatarView, "avatarView");
            Intrinsics.checkNotNullParameter(nickTxt, "nickTxt");
            this.contentView = contentView;
            this.avatarView = avatarView;
            this.nickTxt = nickTxt;
        }

        /* renamed from: a, reason: from getter */
        public final RoundCornerImageView getAvatarView() {
            return this.avatarView;
        }

        /* renamed from: b, reason: from getter */
        public final View getContentView() {
            return this.contentView;
        }

        /* renamed from: c, reason: from getter */
        public final TextView getNickTxt() {
            return this.nickTxt;
        }

        public int hashCode() {
            return (((this.contentView.hashCode() * 31) + this.avatarView.hashCode()) * 31) + this.nickTxt.hashCode();
        }

        public String toString() {
            return "RecentUserItemViewHolder(contentView=" + this.contentView + ", avatarView=" + this.avatarView + ", nickTxt=" + this.nickTxt + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecentUserItemViewHolder)) {
                return false;
            }
            RecentUserItemViewHolder recentUserItemViewHolder = (RecentUserItemViewHolder) other;
            return Intrinsics.areEqual(this.contentView, recentUserItemViewHolder.contentView) && Intrinsics.areEqual(this.avatarView, recentUserItemViewHolder.avatarView) && Intrinsics.areEqual(this.nickTxt, recentUserItemViewHolder.nickTxt);
        }
    }

    private final void i(View view, List<RecentUserInfo> userList) {
        final View findViewById = view.findViewById(R.id.r4n);
        View findViewById2 = view.findViewById(R.id.r4q);
        final Map<String, String> f16 = f();
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: xa4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                f.j(f.this, findViewById, f16, view2);
            }
        });
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) findViewById2;
        k(linearLayout, userList);
        o(findViewById, "em_zplan_publish_win_close", f16);
        if (linearLayout.getVisibility() == 0) {
            o(findViewById2, "em_zplan_publish_win_friend", f16);
        }
    }

    private final void n(View view, String eventName, Map<String, String> reportMap) {
        if (view == null) {
            return;
        }
        this.dtViewReporter.e(view, eventName, reportMap);
    }

    private final void o(View view, String eventName, Map<String, String> reportMap) {
        if (view == null) {
            return;
        }
        this.dtViewReporter.g(view, eventName, (r16 & 4) != 0 ? null : reportMap, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    private final View g(Activity activity, List<RecentUserInfo> userList) {
        View view = View.inflate(activity, R.layout.dfp, null);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        i(view, userList);
        return view;
    }
}
