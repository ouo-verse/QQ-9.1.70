package rk;

import android.os.Bundle;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.PhotoInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R2\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lrk/g;", "Lrk/c;", "Landroid/os/Bundle;", "e", "Landroid/os/Bundle;", "j", "()Landroid/os/Bundle;", "l", "(Landroid/os/Bundle;)V", "bundle", "Lcooperation/qzone/QZoneHelper$UserInfo;", "f", "Lcooperation/qzone/QZoneHelper$UserInfo;", "getUserInfo", "()Lcooperation/qzone/QZoneHelper$UserInfo;", DomainData.DOMAIN_NAME, "(Lcooperation/qzone/QZoneHelper$UserInfo;)V", ITVKPlayerEventListener.KEY_USER_INFO, "Ljava/util/ArrayList;", "Lcooperation/qzone/model/PhotoInfo;", "Lkotlin/collections/ArrayList;", "g", "Ljava/util/ArrayList;", "k", "()Ljava/util/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/util/ArrayList;)V", "photoInfoList", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g extends c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Bundle bundle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneHelper.UserInfo userInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private ArrayList<PhotoInfo> photoInfoList = new ArrayList<>();

    /* renamed from: j, reason: from getter */
    public final Bundle getBundle() {
        return this.bundle;
    }

    public final ArrayList<PhotoInfo> k() {
        return this.photoInfoList;
    }

    public final void l(Bundle bundle) {
        this.bundle = bundle;
    }

    public final void m(ArrayList<PhotoInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.photoInfoList = arrayList;
    }

    public final void n(QZoneHelper.UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
