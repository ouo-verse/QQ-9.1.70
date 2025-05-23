package q82;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.mobileqq.matchfriend.reborn.media.QQStrangerWinkOutputRouter;
import com.tencent.mobileqq.matchfriend.reborn.media.gallery.QQStrangerLayerFragment;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.wink.QQWinkConfig;
import com.tencent.mobileqq.wink.QQWinkPage;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.QCircleInitBean;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJH\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\f\u0010\u0012\u001a\u00020\u000f*\u00020\u0011H\u0002J\f\u0010\u0013\u001a\u00020\u000f*\u00020\u0011H\u0002J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002JL\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016\u00a8\u0006\u001f"}, d2 = {"Lq82/a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "picInfo", "Landroid/widget/ImageView;", "imageView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/compat/CompatPublicFragment;", "fragmentClass", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "feed", "", "isFromFeedDetailPage", "", "f", "Landroid/os/Bundle;", "b", "c", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", h.F, "", "url", "d", "g", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a */
    public static final a f428711a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"q82/a$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: q82.a$a */
    /* loaded from: classes36.dex */
    public static final class C11063a extends QQPermission.BasePermissionsListener {

        /* renamed from: a */
        final /* synthetic */ Activity f428712a;

        /* renamed from: b */
        final /* synthetic */ int f428713b;

        C11063a(Activity activity, int i3) {
            this.f428712a = activity;
            this.f428713b = i3;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            a.f428711a.h(this.f428712a, this.f428713b);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> r36) {
            QLog.e("QQStrangerMediaLauncher", 1, "launchQQWinkHomeForResult permission denied.");
        }
    }

    a() {
    }

    private final void b(Bundle bundle) {
        bundle.putString("app_key", "0AND05J90ZOPH3DU");
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "qqstranger");
        bundle.putString("wink_output_route", QQStrangerWinkOutputRouter.ROUTE_PATH);
        bundle.putLong("wink_output_point", 3L);
    }

    private final void c(Bundle bundle) {
        bundle.putInt(QQWinkConstants.EDITOR_DEFAULT_EDIT_MODE, 1);
        bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, false);
        bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_MUSIC, false);
        bundle.putString(QQWinkConstants.EDITOR_NEXT_BUTTON_TEXT, "\u5b8c\u6210");
    }

    public final void h(Activity activity, int i3) {
        List listOf;
        Bundle bundle = new Bundle();
        a aVar = f428711a;
        aVar.b(bundle);
        aVar.c(bundle);
        bundle.putString(QQWinkConstants.CAPTURE_ABILITY, "photo");
        bundle.putBoolean(QQWinkConstants.EDITOR_NEED_DRAFT, false);
        bundle.putBoolean(QQWinkConstants.EDITOR_DISABLE_SAVE_PUBLISH_DRAFT, true);
        bundle.putInt(QQWinkConstants.ACTIVITY_REQUEST_CODE, i3);
        Config.a aVar2 = new Config.a();
        aVar2.i(TabType.ONLY_IMAGE);
        aVar2.e(i3);
        aVar2.j(1);
        aVar2.l(false);
        QQWinkPage qQWinkPage = QQWinkPage.MediaPicker;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new QQWinkPage[]{QQWinkPage.Capture, qQWinkPage});
        QCircleInitBean qCircleInitBean = new QCircleInitBean(false, false, null, 7, null);
        qCircleInitBean.setShowVideoTemplateButton(false);
        Unit unit = Unit.INSTANCE;
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkIndex(activity, new QQWinkConfig(listOf, qQWinkPage, qCircleInitBean, aVar2.a()), bundle);
    }

    public final void d(Context context, String url, ImageView imageView, Class<? extends CompatPublicFragment> fragmentClass, FeedPB$Feed feed, boolean isFromFeedDetailPage) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        if (context != null) {
            if (url.length() == 0) {
                return;
            }
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
            if (startsWith$default) {
                rFWPicInfo.setUrl(url);
            } else {
                rFWPicInfo.setUrl(url);
                rFWPicInfo.setLocalPath(url);
            }
            f(context, rFWPicInfo, imageView, fragmentClass, feed, isFromFeedDetailPage);
        }
    }

    public final void g(Activity r65, int requestCode) {
        Intrinsics.checkNotNullParameter(r65, "activity");
        if (r65.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && r65.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            h(r65, requestCode);
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(r65, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_STRANGER, QQPermissionConstants.Business.SCENE.QQ_STRANGER_PUBLISH));
        if (qQPermission != null) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new C11063a(r65, requestCode));
        }
    }

    private final void f(Context context, RFWLayerPicInfo.RFWPicInfo picInfo, ImageView imageView, Class<? extends CompatPublicFragment> fragmentClass, FeedPB$Feed feed, boolean isFromFeedDetailPage) {
        List listOf;
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setBigPicInfo(picInfo);
        rFWLayerPicInfo.setOriginPicInfo(picInfo);
        rFWLayerPicInfo.setCurrentPicInfo(picInfo);
        rFWLayerPicInfo.setSmallPicInfo(picInfo);
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(rFWLayerItemMediaInfo);
        Bundle bundle = new Bundle();
        if (feed != null) {
            bundle.putByteArray("qqstranger_square_feed", feed.toByteArray());
            bundle.putBoolean("qqstranger_is_from_detail_page", isFromFeedDetailPage);
        }
        if (QQTheme.isVasTheme() && !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("stranger_9095_qq_gallery_profile", false)) {
            bundle.putBoolean("enableQUIProfile", true);
        }
        RFWLayerLaunchUtil.jumpToGallery$default(context, imageView, listOf, 0, QQGalleryActivity.class, fragmentClass, bundle, 0, 128, null);
    }

    public static /* synthetic */ void e(a aVar, Context context, String str, ImageView imageView, Class cls, FeedPB$Feed feedPB$Feed, boolean z16, int i3, Object obj) {
        aVar.d(context, str, (i3 & 4) != 0 ? null : imageView, (i3 & 8) != 0 ? QQStrangerLayerFragment.class : cls, (i3 & 16) != 0 ? null : feedPB$Feed, (i3 & 32) != 0 ? false : z16);
    }
}
