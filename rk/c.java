package rk;

import android.app.Activity;
import android.widget.ImageView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.model.PhotoParam;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\b\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR$\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0007\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lrk/c;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/widget/ImageView;", "b", "", "a", "I", "c", "()I", "g", "(I)V", "curPos", "Lcooperation/qzone/model/PhotoParam;", "Lcooperation/qzone/model/PhotoParam;", "d", "()Lcooperation/qzone/model/PhotoParam;", tl.h.F, "(Lcooperation/qzone/model/PhotoParam;)V", "photoParam", "e", "i", "requestCode", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "f", "(Landroid/widget/ImageView;)V", "clickView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int curPos;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private PhotoParam photoParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int requestCode = 1204;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView clickView;

    /* renamed from: a, reason: from getter */
    public final ImageView getClickView() {
        return this.clickView;
    }

    public final ImageView b(Activity activity) {
        com.qzone.reborn.util.k kVar = com.qzone.reborn.util.k.f59549a;
        if (kVar.e(activity) || kVar.d(activity)) {
            return null;
        }
        return this.clickView;
    }

    /* renamed from: c, reason: from getter */
    public final int getCurPos() {
        return this.curPos;
    }

    /* renamed from: d, reason: from getter */
    public final PhotoParam getPhotoParam() {
        return this.photoParam;
    }

    /* renamed from: e, reason: from getter */
    public final int getRequestCode() {
        return this.requestCode;
    }

    public final void f(ImageView imageView) {
        this.clickView = imageView;
    }

    public final void g(int i3) {
        this.curPos = i3;
    }

    public final void h(PhotoParam photoParam) {
        this.photoParam = photoParam;
    }

    public final void i(int i3) {
        this.requestCode = i3;
    }
}
