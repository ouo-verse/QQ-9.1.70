package vb;

import a9.f;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.albumx.qzone.local.g;
import com.qzone.reborn.albumx.qzonex.bean.QZAlbumxDescDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumMemberInitBean;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAnswerCheckPageInitBean;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxEditTextInitBean;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxInvitePageInitBean;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxMainPageInitBean;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxTaskDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadSelectAlbumInitBean;
import com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxAlbumDetailFragment;
import com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxAlbumMemberFragment;
import com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxAnswerCheckFragment;
import com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxDescDetailFragment;
import com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxEditAlbumFragment;
import com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxEditTextFragment;
import com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxInviteFragment;
import com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxMainFragment;
import com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxSelectCoverFragment;
import com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxTaskDetailFragment;
import com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxUploadAlbumFragment;
import com.qzone.reborn.albumx.qzonex.fragment.QZAlbumxUploadSelectAlbumFragment;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb.d;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b&\u0010'J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\fJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000eJ&\u0010\u0013\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u001e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018J\u001e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u001bJ\u0016\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u001dJ\u001e\u0010 \u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u001fJ\u001e\u0010!\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u000eJ\u0016\u0010#\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\"J\u001e\u0010%\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020$\u00a8\u0006("}, d2 = {"Lvb/b;", "Lho/a;", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxMainPageInitBean;", "initBean", "Landroid/os/Bundle;", "bundle", "", "i", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxInvitePageInitBean;", h.F, "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxTaskDetailInitBean;", "k", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "g", "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadAlbumInitBean;", "Landroid/content/Intent;", "intent", "l", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumEditInitBean;", "editAlbumInitBean", "f", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxEditTextInitBean;", "e", "Lcom/qzone/reborn/albumx/qzonex/bean/QZAlbumxDescDetailInitBean;", "a", "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadSelectAlbumInitBean;", DomainData.DOMAIN_NAME, "c", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumMemberInitBean;", "b", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAnswerCheckPageInitBean;", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements ho.a {
    public final void a(Activity activity, QZAlbumxDescDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        i.d(activity, "/qzone/holder_page").withString("public_fragment_class", QZAlbumxDescDetailFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void b(Activity activity, QZAlbumxAlbumMemberInitBean initBean) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        i.d(activity, "/qzone/holder_page").withString("public_fragment_class", QZAlbumxAlbumMemberFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void c(Activity activity, int requestCode, QZAlbumxAlbumDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Navigator.withRequestCode$default(i.d(activity, "/qzone/holder_page").withString("public_fragment_class", QZAlbumxSelectCoverFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean), activity, requestCode, (Bundle) null, 4, (Object) null).request();
    }

    public final void d(Activity activity, int requestCode, QZAlbumxAnswerCheckPageInitBean initBean) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Navigator.withRequestCode$default(i.d(activity, "/qzone/holder_page").withString("public_fragment_class", QZAlbumxAnswerCheckFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean), activity, requestCode, (Bundle) null, 4, (Object) null).request();
    }

    public final void e(Activity activity, int requestCode, QZAlbumxEditTextInitBean initBean) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Navigator.withRequestCode$default(i.d(activity, "/qzone/holder_page").withString("public_fragment_class", QZAlbumxEditTextFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean), activity, requestCode, (Bundle) null, 4, (Object) null).request();
    }

    public final void f(Activity activity, int requestCode, CommonAlbumEditInitBean editAlbumInitBean) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(editAlbumInitBean, "editAlbumInitBean");
        Navigator.withRequestCode$default(i.d(activity, "/qzone/holder_page").withString("public_fragment_class", QZAlbumxEditAlbumFragment.class.getName()), activity, requestCode, (Bundle) null, 4, (Object) null).withParcelable("key_bundle_common_init_bean", editAlbumInitBean).request();
    }

    public final void g(Context context, QZAlbumxAlbumDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        initBean.setLaunchTime(System.currentTimeMillis());
        PreLoader.remove("qzone_albumx_detail_album_list_data_preload_id");
        PreLoader.preLoad("qzone_albumx_detail_album_list_data_preload_id", new d(initBean));
        f.f25725a.g();
        kc.b.INSTANCE.a().p(LoginData.getInstance().getUinString(), null);
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZAlbumxAlbumDetailFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void h(Context context, QZAlbumxInvitePageInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZAlbumxInviteFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void i(Context context, QZAlbumxMainPageInitBean initBean, Bundle bundle) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        if (bundle == null) {
            bundle = new Bundle();
        }
        initBean.setLaunchTime(System.currentTimeMillis());
        PreLoader.remove("qzone_albumx_album_list_data_preload_id");
        PreLoader.preLoad("qzone_albumx_album_list_data_preload_id", new tb.b(initBean));
        f.f25725a.g();
        g.f52662a.d();
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZAlbumxMainFragment.class.getName()).withAll(bundle).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void k(Context context, QZAlbumxTaskDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZAlbumxTaskDetailFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void n(Activity activity, int requestCode, QZAlbumxUploadSelectAlbumInitBean initBean) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Navigator.withRequestCode$default(i.d(activity, "/qzone/holder_page").withString("public_fragment_class", QZAlbumxUploadSelectAlbumFragment.class.getName()), activity, requestCode, (Bundle) null, 4, (Object) null).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public static /* synthetic */ void j(b bVar, Context context, QZAlbumxMainPageInitBean qZAlbumxMainPageInitBean, Bundle bundle, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            bundle = new Bundle();
        }
        bVar.i(context, qZAlbumxMainPageInitBean, bundle);
    }

    public static /* synthetic */ void m(b bVar, Context context, QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean, Intent intent, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            intent = new Intent();
        }
        bVar.l(context, qZAlbumxUploadAlbumInitBean, intent);
    }

    public final void l(Context context, QZAlbumxUploadAlbumInitBean initBean, Intent intent) {
        if (context == null || initBean == null) {
            return;
        }
        eo.c.f396879a.b();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras == null) {
            extras = new Bundle();
        }
        initBean.setLaunchTime(System.currentTimeMillis());
        lc.a.f414334a.i(extras, initBean);
        Navigator withParcelable = i.d(context, "/qzone/common_upload_page").withAll(extras).withFlags(intent != null ? intent.getFlags() : 0).withString("public_fragment_class", QZAlbumxUploadAlbumFragment.class.getName()).withParcelable("key_bundle_common_init_bean", initBean);
        if (initBean.getRequestCode() != -1 && (context instanceof Activity)) {
            Navigator.withRequestCode$default(withParcelable, (Activity) context, initBean.getRequestCode(), (Bundle) null, 4, (Object) null).requestWithReturn();
        } else {
            withParcelable.request();
        }
    }
}
