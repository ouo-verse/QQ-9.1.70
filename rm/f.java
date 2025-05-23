package rm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lrm/f;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lmqq/app/AppActivity;", "d", "Lmqq/app/AppActivity;", "C9", "()Lmqq/app/AppActivity;", "setMActivity", "(Lmqq/app/AppActivity;)V", "mActivity", "Lcom/tencent/mobileqq/app/QQAppInterface;", "e", "Lcom/tencent/mobileqq/app/QQAppInterface;", "D9", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "setMApp", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "mApp", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AppActivity mActivity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QQAppInterface mApp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"rm/f$a", "Lcom/tencent/mobileqq/widget/navbar/a;", "Landroid/view/View;", "v", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onItemSelect", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements com.tencent.mobileqq.widget.navbar.a {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View v3, int item) {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (item == 1) {
                AppActivity mActivity = f.this.getMActivity();
                if (mActivity != null) {
                    mActivity.onBackPressed();
                    return;
                }
                return;
            }
            if (item != 5) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(IPublicAccountUtil.NEED_FINISH, true);
            intent.putExtra("uin", AppConstants.VALUE.UIN_QZONE);
            intent.putExtra("uinname", HardCodeUtil.qqStr(R.string.hvk));
            intent.putExtra("uintype", 1008);
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).gotoProfileForResult(intent, f.this.getMApp(), f.this.getActivity(), AppConstants.VALUE.UIN_QZONE, -1, 2000, 1, false);
        }
    }

    /* renamed from: C9, reason: from getter */
    public final AppActivity getMActivity() {
        return this.mActivity;
    }

    /* renamed from: D9, reason: from getter */
    public final QQAppInterface getMApp() {
        return this.mApp;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Context context;
        super.onInitView(rootView);
        if (getActivity() instanceof AppActivity) {
            Activity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type mqq.app.AppActivity");
            AppActivity appActivity = (AppActivity) activity;
            this.mActivity = appActivity;
            Intrinsics.checkNotNull(appActivity);
            AppRuntime appRuntime = appActivity.getAppRuntime();
            Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            this.mApp = (QQAppInterface) appRuntime;
        }
        if (getPartHost() instanceof QIphoneTitleBarFragment) {
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.fragment.QIphoneTitleBarFragment");
            ((QIphoneTitleBarFragment) partHost).setTitle(HardCodeUtil.qqStr(R.string.hvk));
            Drawable drawable = null;
            View findViewById = rootView != null ? rootView.findViewById(R.id.rlCommenTitle) : null;
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.widget.navbar.NavBarCommon");
            NavBarCommon navBarCommon = (NavBarCommon) findViewById;
            if (rootView != null && (context = rootView.getContext()) != null) {
                drawable = context.getDrawable(R.drawable.qui_chat_settings);
            }
            navBarCommon.setRightImage(drawable);
            navBarCommon.setRightImageDesc(HardCodeUtil.qqStr(R.string.dym));
            navBarCommon.setOnItemSelectListener(new a());
        }
    }
}
