package yb0;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.util.Consumer;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.immersive.feed.bk;
import com.tencent.biz.qqcircle.immersive.utils.au;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.utils.af;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.share.api.ShareActionSheetClickListener;
import com.tencent.mobileqq.share.api.ShareConfig;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import vb0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002JG\u0010 \u001a\u00020\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\f2+\u0010\u001f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001aj\u0004\u0018\u0001`\u001eJ\u0016\u0010$\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R;\u0010-\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001aj\u0004\u0018\u0001`\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00105\u00a8\u00069"}, d2 = {"Lyb0/g;", "", "Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "shareInfo", "Lcom/tencent/mobileqq/share/api/ShareConfig;", "o", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/share/api/ShareActionSheetClickListener;", tl.h.F, "Landroid/content/Context;", "context", "", "titleStr", "titleIconUrl", "Lj92/d;", "k", "Lwb0/a;", "l", "Landroid/content/DialogInterface$OnDismissListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/DialogInterface$OnCancelListener;", "i", "", "r", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "p", "", "isSuccess", "feedId", "g", "b", "Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "Lyb0/j;", "c", "Lyb0/j;", "shareManager", "d", "Lkotlin/jvm/functions/Function1;", "kuiklyCallback", "e", "Z", "isNeedHideActionBtn", "f", "Ljava/lang/String;", "shareFeedId", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "removeCallbackRunnable", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static QCircleShareInfo shareInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static j shareManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Function1<Object, Unit> kuiklyCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean isNeedHideActionBtn;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f449962a = new g();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String shareFeedId = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Runnable removeCallbackRunnable = new Runnable() { // from class: yb0.d
        @Override // java.lang.Runnable
        public final void run() {
            g.q();
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"yb0/g$a", "Lj92/d;", "Landroid/view/View;", OperateCustomButton.OPERATE_CREATE, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class a implements j92.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f449969a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f449970b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f449971c;

        a(Context context, String str, String str2) {
            this.f449969a = context;
            this.f449970b = str;
            this.f449971c = str2;
        }

        @Override // j92.d
        @NotNull
        public View create() {
            LinearLayout linearLayout = new LinearLayout(this.f449969a);
            linearLayout.setOrientation(0);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            linearLayout.setGravity(17);
            TextView textView = new TextView(this.f449969a);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textView.setTextSize(1, 14.0f);
            textView.setTextColor(this.f449969a.getResources().getColor(R.color.qui_common_text_primary, null));
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setText(this.f449970b);
            linearLayout.addView(textView);
            if (!TextUtils.isEmpty(this.f449971c)) {
                ImageView imageView = new ImageView(this.f449969a);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(cx.a(30.0f), cx.a(30.0f));
                layoutParams.leftMargin = cx.a(5.0f);
                imageView.setLayoutParams(layoutParams);
                Option targetView = Option.obtain().setUrl(this.f449971c).setTargetView(imageView);
                targetView.setSupportRecycler(false);
                QCircleFeedPicLoader.g().loadImage(targetView);
                linearLayout.addView(imageView);
            }
            return linearLayout;
        }
    }

    g() {
    }

    private final ShareActionSheetClickListener h(Activity activity, QCircleShareInfo shareInfo2) {
        vb0.a k3 = new a.h().u(shareInfo2).l(activity).m(shareInfo2.feed).t(shareInfo2.mReportBean).k();
        Intrinsics.checkNotNullExpressionValue(k3, "Builder()\n              \u2026\n                .build()");
        return k3;
    }

    private final DialogInterface.OnCancelListener i() {
        return new DialogInterface.OnCancelListener() { // from class: yb0.f
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                g.j(dialogInterface);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(DialogInterface dialogInterface) {
        f449962a.r();
    }

    private final j92.d k(Context context, String titleStr, String titleIconUrl) {
        if (TextUtils.isEmpty(titleStr)) {
            com.tencent.xaction.log.b.a("QFSKuiklyMultiShareHelper", 1, "[createCustomTitle] titleStr is empty.");
            return null;
        }
        return new a(context, titleStr, titleIconUrl);
    }

    private final wb0.a l() {
        return new b();
    }

    private final DialogInterface.OnDismissListener m() {
        return new DialogInterface.OnDismissListener() { // from class: yb0.e
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                g.n(dialogInterface);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(DialogInterface dialogInterface) {
        f449962a.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShareConfig o(QCircleShareInfo shareInfo2) {
        boolean z16;
        ShareConfig shareConfig = new ShareConfig();
        shareConfig.isShowShareToFriend = shareInfo2.isShowShareToFriend;
        shareConfig.isShowShareToQZone = shareInfo2.isShowShareToQZone;
        shareConfig.isShowShareToWechat = shareInfo2.isShowShareToWechat;
        shareConfig.isShowShareToWechatCircle = shareInfo2.isShowShareToWechatCircle;
        shareConfig.isShowShareToChannel = shareInfo2.isShowShareToChannel;
        boolean z17 = true;
        shareConfig.isShowShareToChannelAtLast = true;
        shareConfig.isForceNightTheme = false;
        if (isNeedHideActionBtn) {
            shareConfig.isShowCollect = false;
            shareConfig.isShowUnCollect = false;
            shareConfig.isShowCopyShortLink = false;
        } else {
            if (!bk.o1() && shareInfo2.isShowCollect) {
                z16 = true;
            } else {
                z16 = false;
            }
            shareConfig.isShowCollect = z16;
            if (bk.o1() || !shareInfo2.isShowUnCollect) {
                z17 = false;
            }
            shareConfig.isShowUnCollect = z17;
        }
        return shareConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q() {
        kuiklyCallback = null;
        com.tencent.xaction.log.b.a("QFSKuiklyMultiShareHelper", 1, "removeCallbackRunnable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x001d, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(((com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager.class)).loadAsString("qqcircle_enable_kuikly_multi_share_clear_callback", "5000"));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void r() {
        Long longOrNull;
        shareInfo = null;
        shareManager = null;
        isNeedHideActionBtn = false;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_kuikly_multi_share_clear_callback", true) && longOrNull != null) {
            RFWThreadManager.getUIHandler().postDelayed(removeCallbackRunnable, longOrNull.longValue());
            com.tencent.xaction.log.b.a("QFSKuiklyMultiShareHelper", 1, "remove delay.");
        }
        com.tencent.xaction.log.b.a("QFSKuiklyMultiShareHelper", 1, "reset.");
    }

    public final void g(boolean isSuccess, @NotNull String feedId) {
        Map mapOf;
        Map mapOf2;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        if (kuiklyCallback == null) {
            return;
        }
        if (!TextUtils.equals(shareFeedId, feedId)) {
            kuiklyCallback = null;
            shareFeedId = "";
            return;
        }
        if (isSuccess) {
            Function1<Object, Unit> function1 = kuiklyCallback;
            if (function1 != null) {
                mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("success", 1));
                function1.invoke(mapOf2);
            }
        } else {
            Function1<Object, Unit> function12 = kuiklyCallback;
            if (function12 != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("success", 0));
                function12.invoke(mapOf);
            }
        }
        shareFeedId = "";
        kuiklyCallback = null;
        com.tencent.xaction.log.b.a("QFSKuiklyMultiShareHelper", 1, "[callbackShareResult] isSuccess: " + isSuccess);
    }

    public final void p(@Nullable Activity activity, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        boolean z16;
        Map mapOf;
        boolean z17;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z18;
        String str5;
        String str6;
        boolean z19;
        j jVar = shareManager;
        if (jVar != null && jVar.z()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            j jVar2 = shareManager;
            if (jVar2 != null) {
                jVar2.m();
            }
            com.tencent.xaction.log.b.a("QFSKuiklyMultiShareHelper", 1, "[openMultiSharePanel] panel is showing, dismiss.");
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_kuikly_multi_share_clear_callback", true)) {
            RFWThreadManager.getUIHandler().removeCallbacks(removeCallbackRunnable);
        }
        kuiklyCallback = callback;
        if (activity != null) {
            if (params != null && params.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                JSONObject k06 = KRCSSViewExtensionKt.k0(params);
                String optString = k06.optString("feedID");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObj.optString(PARAM_KEY_FEED_ID)");
                shareFeedId = optString;
                String optString2 = k06.optString("uin");
                long optLong = k06.optLong(WadlProxyConsts.CREATE_TIME);
                JSONObject optJSONObject = k06.optJSONObject("shareInfo");
                if (optJSONObject != null) {
                    optJSONObject.optString("coverUrl");
                }
                if (optJSONObject != null) {
                    str = optJSONObject.optString("additionalMsg");
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                if (optJSONObject != null) {
                    str2 = optJSONObject.optString("panelTitle");
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (optJSONObject != null) {
                    str3 = optJSONObject.optString("panelTitleIconUrl");
                } else {
                    str3 = null;
                }
                if (str3 == null) {
                    str3 = "";
                }
                if (optJSONObject != null) {
                    str4 = optJSONObject.optString("toastHit");
                } else {
                    str4 = null;
                }
                if (str4 == null) {
                    str4 = "";
                }
                if (optJSONObject != null) {
                    z18 = optJSONObject.optBoolean(UIJsPlugin.EVENT_SHOW_TOAST);
                } else {
                    z18 = false;
                }
                if (optJSONObject != null) {
                    str5 = optJSONObject.optString(ISchemeApi.KEY_PAGE_ID);
                } else {
                    str5 = null;
                }
                if (str5 == null) {
                    str5 = "";
                }
                if (optJSONObject != null) {
                    str6 = optJSONObject.optString("shareFrom");
                } else {
                    str6 = null;
                }
                if (str6 == null) {
                    str6 = "";
                }
                if (optJSONObject != null) {
                    z19 = optJSONObject.optBoolean("hideActionBtn");
                } else {
                    z19 = false;
                }
                isNeedHideActionBtn = z19;
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
                feedCloudMeta$StFeed.f398449id.set(shareFeedId);
                feedCloudMeta$StFeed.createTime.set(optLong);
                FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
                feedCloudMeta$StUser.f398463id.set(optString2);
                feedCloudMeta$StFeed.poster.set(feedCloudMeta$StUser);
                QCircleShareInfo shareInfo2 = au.c(feedCloudMeta$StFeed);
                shareInfo2.feedBlockData = new e30.b(feedCloudMeta$StFeed);
                shareInfo2.type = 14;
                shareInfo2.shareStyleType = 15;
                shareInfo2.source = 15;
                shareInfo2.shareFrom = str6;
                shareInfo2.mDirectShowMsg = str;
                shareInfo2.isNeedShowShareSuccessToast = z18;
                if (z18 && !Intrinsics.areEqual(str4, "")) {
                    shareInfo2.customShareSuccessToast = str4;
                }
                QCircleReportBean qCircleReportBean = new QCircleReportBean();
                qCircleReportBean.setFeedId(shareFeedId);
                qCircleReportBean.setAuthUin(optString2);
                if (Intrinsics.areEqual(str5, "")) {
                    str5 = "pg_xsj_kuikly_page";
                }
                qCircleReportBean.setDtPageId(str5);
                shareInfo2.mReportBean = qCircleReportBean;
                Intrinsics.checkNotNullExpressionValue(shareInfo2, "shareInfo");
                j jVar3 = new j(o(shareInfo2), shareInfo2);
                shareManager = jVar3;
                jVar3.H(m());
                j jVar4 = shareManager;
                if (jVar4 != null) {
                    jVar4.G(i());
                }
                j jVar5 = shareManager;
                if (jVar5 != null) {
                    jVar5.j();
                }
                j jVar6 = shareManager;
                if (jVar6 != null) {
                    jVar6.E(k(activity, str2, str3));
                }
                j jVar7 = shareManager;
                if (jVar7 != null) {
                    jVar7.K(h(activity, shareInfo2));
                }
                if (r.h().r(shareInfo2)) {
                    r.h().b(af.a(shareInfo2.feed.f398449id.get()), new c(activity, shareInfo2));
                    r.h().t(shareInfo2, l(), null);
                } else {
                    j jVar8 = shareManager;
                    if (jVar8 != null) {
                        Intent s16 = QCircleBaseShareOperation.s(activity, shareInfo2.feed);
                        Intrinsics.checkNotNullExpressionValue(s16, "getShareArkIntent(activity, shareInfo.feed)");
                        jVar8.F(s16);
                    }
                    j jVar9 = shareManager;
                    if (jVar9 != null) {
                        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = shareInfo2.feed;
                        Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StFeed2, "shareInfo.feed");
                        jVar9.k(activity, feedCloudMeta$StFeed2);
                    }
                }
                shareInfo = shareInfo2;
                j jVar10 = shareManager;
                if (jVar10 != null) {
                    jVar10.L(activity);
                }
                com.tencent.xaction.log.b.a("QFSKuiklyMultiShareHelper", 1, "[openMultiSharePanel] feedId: " + shareFeedId);
                return;
            }
        }
        Function1<Object, Unit> function1 = kuiklyCallback;
        if (function1 != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("success", 0));
            function1.invoke(mapOf);
        }
        kuiklyCallback = null;
        com.tencent.xaction.log.b.a("QFSKuiklyMultiShareHelper", 1, "[openMultiSharePanel] params is empty.");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016\u00a8\u0006\u0014"}, d2 = {"yb0/g$b", "Lwb0/a;", "", "isKeepDim", "", "a", "report", "f", "isCollect", "b", "d", "c", "Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "shareInfo", "e", "saveQrcode", "Landroidx/core/util/Consumer;", "", "consumer", "g", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b implements wb0.a {
        b() {
        }

        @Override // wb0.a
        public void b(boolean isCollect) {
            QCircleShareInfo qCircleShareInfo;
            QCircleShareInfo qCircleShareInfo2 = g.shareInfo;
            boolean z16 = false;
            if (qCircleShareInfo2 != null && qCircleShareInfo2.isShowUnCollect == isCollect) {
                z16 = true;
            }
            if (!z16 && (qCircleShareInfo = g.shareInfo) != null) {
                qCircleShareInfo.isShowCollect = !isCollect;
                qCircleShareInfo.isShowUnCollect = isCollect;
                j jVar = g.shareManager;
                if (jVar != null) {
                    jVar.M(g.f449962a.o(qCircleShareInfo));
                }
            }
        }

        @Override // wb0.a
        public void c() {
        }

        @Override // wb0.a
        public void d() {
        }

        @Override // wb0.a
        public void f() {
        }

        @Override // wb0.a
        public void report() {
        }

        @Override // wb0.a
        public void saveQrcode() {
        }

        @Override // wb0.a
        public void a(boolean isKeepDim) {
        }

        @Override // wb0.a
        public void e(@Nullable QCircleShareInfo shareInfo) {
        }

        @Override // wb0.a
        public void g(@Nullable Consumer<String> consumer) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"yb0/g$c", "Lwb0/c;", "", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class c implements wb0.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f449972a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QCircleShareInfo f449973b;

        c(Activity activity, QCircleShareInfo qCircleShareInfo) {
            this.f449972a = activity;
            this.f449973b = qCircleShareInfo;
        }

        @Override // wb0.c
        public void a() {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed;
            j jVar = g.shareManager;
            if (jVar != null) {
                Activity activity = this.f449972a;
                QCircleShareInfo qCircleShareInfo = this.f449973b;
                if (qCircleShareInfo != null) {
                    feedCloudMeta$StFeed = qCircleShareInfo.feed;
                } else {
                    feedCloudMeta$StFeed = null;
                }
                Intent s16 = QCircleBaseShareOperation.s(activity, feedCloudMeta$StFeed);
                Intrinsics.checkNotNullExpressionValue(s16, "getShareArkIntent(activity, shareInfo?.feed)");
                jVar.F(s16);
            }
            j jVar2 = g.shareManager;
            if (jVar2 != null) {
                Activity activity2 = this.f449972a;
                FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.f449973b.feed;
                Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StFeed2, "shareInfo.feed");
                jVar2.k(activity2, feedCloudMeta$StFeed2);
            }
        }

        @Override // wb0.c
        public void b() {
        }
    }
}
