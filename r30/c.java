package r30;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleHalfScreenInitBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.d;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.half.webview.QFSHalfScreenBrowserFragment;
import com.tencent.biz.qqcircle.immersive.tab.QFSKuiklyFragment;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.HalfScreenBrowserActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.mobileqq.winkpublish.publishconst.WinkHostConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006J7\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0015\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\nJ-\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0019\u001a\u00020\rJ\u0010\u0010\u001a\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u001d\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a8\u0006 "}, d2 = {"Lr30/c;", "", "Landroid/content/Context;", "context", "Lcom/tencent/biz/qqcircle/beans/QCircleHalfScreenInitBean;", "initBean", "Landroid/content/Intent;", "c", "intent", "b", "", ZPlanPublishSource.FROM_SCHEME, "feedId", "", "isAutoOpen", "", "i", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "h5Url", "f", "kuiklyUrl", "e", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/String;", "j", "d", h.F, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "g", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f430661a = new c();

    c() {
    }

    @Nullable
    public final String a(@Nullable String scheme, @Nullable String feedId, @Nullable Boolean isAutoOpen) {
        if (scheme != null) {
            Uri.Builder buildUpon = Uri.parse(scheme).buildUpon();
            if (!TextUtils.isEmpty(feedId)) {
                buildUpon.appendQueryParameter("feedid", feedId);
            }
            if (isAutoOpen != null) {
                if (isAutoOpen.booleanValue()) {
                    buildUpon.appendQueryParameter("qfs_autoshowpannel", "1");
                } else {
                    buildUpon.appendQueryParameter("qfs_autoshowpannel", "0");
                }
            }
            return buildUpon.build().toString();
        }
        return scheme;
    }

    @NotNull
    public final Intent b(@NotNull QCircleHalfScreenInitBean initBean, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle bundle = new Bundle();
        bundle.putInt("webViewFullHeight", -1);
        bundle.putInt("backgroundColorId", R.color.f156932fm);
        bundle.putFloat("webViewHeightRatio", initBean.getHeightRatio());
        bundle.putString("entranceFeedId", initBean.getFeedId());
        intent.putExtras(bundle);
        return intent;
    }

    @NotNull
    public final Intent c(@NotNull Context context, @NotNull QCircleHalfScreenInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        if (!(context instanceof Activity)) {
            context = BaseApplication.getContext();
        }
        Intent intent = new Intent(context, (Class<?>) HalfScreenBrowserActivity.class);
        intent.putExtra("halfFragmentClass", QFSHalfScreenBrowserFragment.class);
        intent.putExtra("url", initBean.getH5Url());
        intent.setData(Uri.parse(initBean.getH5Url()));
        return b(initBean, intent);
    }

    public final boolean d() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_half_screen_web", true);
    }

    public final boolean e(@Nullable String kuiklyUrl) {
        if (WinkHostConstants.AppSetting.isPublicVersion()) {
            return false;
        }
        HashMap<String, String> c16 = d.c(kuiklyUrl);
        if (c16.containsKey(QCircleSchemeAttr.WebView.KEY_BUSINESS_ID)) {
            return false;
        }
        QCircleToast.m(QCircleToast.f91645e, "\u7f3a\u5c11qqcir_business_id\u53c2\u6570", 0, true, false, 500L, 0);
        QLog.e("QFSHalfScreenPanelUtil", 1, "[interceptHalfKuiklyJump] url not contain business_id, url:" + c16);
        return true;
    }

    public final boolean f(@Nullable String h5Url) {
        if (WinkHostConstants.AppSetting.isPublicVersion() || d.c(h5Url).containsKey(QCircleSchemeAttr.WebView.KEY_TASK_ID)) {
            return false;
        }
        QCircleToast.m(QCircleToast.f91645e, "\u7f3a\u5c11qfs_taskid\u53c2\u6570", 0, true, false, 500L, 0);
        QLog.e("QFSHalfScreenPanelUtil", 1, "[interceptHalfWebViewJump] url not contain task_id, url:" + h5Url);
        return true;
    }

    public final boolean g(@Nullable Activity activity) {
        Serializable serializable;
        Intent intent;
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra("halfFragmentClass");
        } else {
            serializable = null;
        }
        if ((serializable instanceof Class) && Intrinsics.areEqual(serializable, QFSHalfScreenBrowserFragment.class)) {
            return true;
        }
        return false;
    }

    public final boolean h(@Nullable String scheme) {
        if (scheme != null) {
            return !TextUtils.isEmpty(QFSKuiklyFragment.ri(scheme));
        }
        return false;
    }

    public final void i(@Nullable Context context, @Nullable String scheme, @Nullable String feedId, @Nullable Boolean isAutoOpen) {
        QCircleHalfScreenInitBean qCircleHalfScreenInitBean;
        String a16 = a(scheme, feedId, isAutoOpen);
        QCircleInitBean a17 = QCircleSchemeLauncher.a(context, a16);
        if (a17 instanceof QCircleHalfScreenInitBean) {
            qCircleHalfScreenInitBean = (QCircleHalfScreenInitBean) a17;
        } else {
            qCircleHalfScreenInitBean = null;
        }
        if (qCircleHalfScreenInitBean != null) {
            if (qCircleHalfScreenInitBean.isWebViewHalf()) {
                if (f430661a.f(qCircleHalfScreenInitBean.getH5Url())) {
                    return;
                } else {
                    SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(28, a17.getFeedId(), true));
                }
            } else if (qCircleHalfScreenInitBean.isKuiklyHalf()) {
                if (f430661a.e(qCircleHalfScreenInitBean.getH5Url())) {
                    return;
                } else {
                    SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(39, a17.getFeedId(), true));
                }
            }
        }
        com.tencent.biz.qqcircle.launcher.c.g(context, a16);
    }

    @Nullable
    public final String j(@Nullable Context context, @Nullable String scheme) {
        QCircleHalfScreenInitBean qCircleHalfScreenInitBean;
        QCircleInitBean a16 = QCircleSchemeLauncher.a(context, scheme);
        if (a16 instanceof QCircleHalfScreenInitBean) {
            qCircleHalfScreenInitBean = (QCircleHalfScreenInitBean) a16;
        } else {
            qCircleHalfScreenInitBean = null;
        }
        if (qCircleHalfScreenInitBean == null) {
            return null;
        }
        if (!TextUtils.isEmpty(qCircleHalfScreenInitBean.getH5Url()) && !f430661a.h(qCircleHalfScreenInitBean.getH5Url())) {
            ((IQQWinkLaucher) QRoute.api(IQQWinkLaucher.class)).preloadWebView(qCircleHalfScreenInitBean.getH5Url(), false);
        }
        return qCircleHalfScreenInitBean.getH5Url();
    }
}
