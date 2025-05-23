package vc3;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.af;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lvc3/g;", "", "Landroid/content/Context;", "context", "", "page", "Landroid/widget/ImageView;", "imageView", "", "c", "", "Lvc3/a;", "b", "Ljava/util/Map;", "iconMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f441394a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, ZootopiaDynamicIconData> iconMap;

    static {
        Map<String, ZootopiaDynamicIconData> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("ZootopiaHomeDownload", new ZootopiaDynamicIconData("zootopia_download_list_entrance_apng.png", 24.0f, R.drawable.id5, null)), TuplesKt.to("ZootopiaDetailDownload", new ZootopiaDynamicIconData("zootopia_download_detail_entrance_apng.png", 24.0f, R.drawable.f159850id4, null)));
        iconMap = mutableMapOf;
    }

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Context context, String page, final ZootopiaDynamicIconData icon, final ImageView imageView) {
        Intrinsics.checkNotNullParameter(page, "$page");
        Intrinsics.checkNotNullParameter(icon, "$icon");
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        String a16 = context != null ? af.f373257a.a(context, icon.getFileName()) : null;
        if (a16 == null) {
            QLog.e("ZootopiaLoadLocalDrawableUtils", 1, page + " filePath is null");
            return;
        }
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setRequestWidth(ViewUtils.dpToPx(icon.getIconSize()));
        apngOptions.setRequestHeight(ViewUtils.dpToPx(icon.getIconSize()));
        apngOptions.setLoadingDrawable(context.getResources().getDrawable(icon.getLoadingDrawableId()));
        icon.e(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", apngOptions, a16));
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: vc3.f
            @Override // java.lang.Runnable
            public final void run() {
                g.e(imageView, icon);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ImageView imageView, ZootopiaDynamicIconData icon) {
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        Intrinsics.checkNotNullParameter(icon, "$icon");
        imageView.setImageDrawable(icon.getCacheUrlDrawable());
    }

    public final void c(final Context context, final String page, final ImageView imageView) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        final ZootopiaDynamicIconData zootopiaDynamicIconData = iconMap.get(page);
        if (zootopiaDynamicIconData == null) {
            return;
        }
        if (zootopiaDynamicIconData.getCacheUrlDrawable() != null) {
            imageView.setImageDrawable(zootopiaDynamicIconData.getCacheUrlDrawable());
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: vc3.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.d(context, page, zootopiaDynamicIconData, imageView);
                }
            }, 64, null, true);
        }
    }
}
