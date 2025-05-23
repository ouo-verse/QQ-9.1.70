package xd;

import android.text.TextUtils;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicSpecUrlEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0000\u001a\u001e\u0010\n\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\t\u001a\u00060\u0007j\u0002`\b\u001a\u001c\u0010\u000b\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\t\u001a\u00060\u0007j\u0002`\b\u001a\u001c\u0010\f\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\t\u001a\u00060\u0007j\u0002`\b\u001a\u001c\u0010\r\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\t\u001a\u00060\u0007j\u0002`\b\u001a\n\u0010\u000f\u001a\u00020\u000e*\u00020\u0000\u001a\u0006\u0010\u0010\u001a\u00020\u0007\u001a\u0006\u0010\u0011\u001a\u00020\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonImage;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicUrl;", "e", "", "g", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicSpecUrlEntry;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/PhotoSpec;", "spec", "f", "c", h.F, "d", "", "i", "b", "a", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {
    public static final int a() {
        return (ImmersiveUtils.getScreenWidth() * 4) / 3;
    }

    public static final int b() {
        return ImmersiveUtils.getScreenWidth();
    }

    public static final String c(List<CommonPicSpecUrlEntry> list, int i3) {
        String url;
        Intrinsics.checkNotNullParameter(list, "<this>");
        for (CommonPicSpecUrlEntry commonPicSpecUrlEntry : list) {
            Integer spec = commonPicSpecUrlEntry.getSpec();
            if (spec != null && spec.intValue() == i3) {
                CommonPicUrl url2 = commonPicSpecUrlEntry.getUrl();
                if (!TextUtils.isEmpty(url2 != null ? url2.getUrl() : null)) {
                    CommonPicUrl url3 = commonPicSpecUrlEntry.getUrl();
                    return (url3 == null || (url = url3.getUrl()) == null) ? "" : url;
                }
            }
        }
        return "";
    }

    public static final int d(List<CommonPicSpecUrlEntry> list, int i3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        for (CommonPicSpecUrlEntry commonPicSpecUrlEntry : list) {
            Integer spec = commonPicSpecUrlEntry.getSpec();
            if (spec != null && spec.intValue() == i3) {
                CommonPicUrl url = commonPicSpecUrlEntry.getUrl();
                if (!TextUtils.isEmpty(url != null ? url.getUrl() : null)) {
                    CommonPicUrl url2 = commonPicSpecUrlEntry.getUrl();
                    if (url2 != null) {
                        return url2.getHeight();
                    }
                    return 0;
                }
            }
        }
        return 0;
    }

    public static final CommonPicUrl e(CommonImage commonImage) {
        List listOf;
        Object obj;
        Intrinsics.checkNotNullParameter(commonImage, "<this>");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{5, 1, 6, 0, 3});
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            CommonPicUrl f16 = f(commonImage.getPhotoUrl(), ((Number) it.next()).intValue());
            if (f16 != null) {
                return f16;
            }
        }
        Iterator<T> it5 = commonImage.getPhotoUrl().iterator();
        while (true) {
            if (!it5.hasNext()) {
                obj = null;
                break;
            }
            obj = it5.next();
            if (!TextUtils.isEmpty(((CommonPicSpecUrlEntry) obj).getUrl() != null ? r4.getUrl() : null)) {
                break;
            }
        }
        CommonPicSpecUrlEntry commonPicSpecUrlEntry = (CommonPicSpecUrlEntry) obj;
        CommonPicUrl url = commonPicSpecUrlEntry != null ? commonPicSpecUrlEntry.getUrl() : null;
        return url == null ? commonImage.getDefaultUrl() : url;
    }

    public static final CommonPicUrl f(List<CommonPicSpecUrlEntry> list, int i3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                return null;
            }
            CommonPicSpecUrlEntry commonPicSpecUrlEntry = (CommonPicSpecUrlEntry) it.next();
            Integer spec = commonPicSpecUrlEntry.getSpec();
            if (spec != null && spec.intValue() == i3) {
                CommonPicUrl url = commonPicSpecUrlEntry.getUrl();
                if (!TextUtils.isEmpty(url != null ? url.getUrl() : null)) {
                    return commonPicSpecUrlEntry.getUrl();
                }
            }
        }
    }

    public static final String g(CommonImage commonImage) {
        List listOf;
        Object obj;
        Intrinsics.checkNotNullParameter(commonImage, "<this>");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{5, 1, 6, 0, 3});
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            CommonPicUrl f16 = f(commonImage.getPhotoUrl(), ((Number) it.next()).intValue());
            if (f16 != null) {
                return f16.getUrl();
            }
        }
        Iterator<T> it5 = commonImage.getPhotoUrl().iterator();
        while (true) {
            if (!it5.hasNext()) {
                obj = null;
                break;
            }
            obj = it5.next();
            if (!TextUtils.isEmpty(((CommonPicSpecUrlEntry) obj).getUrl() != null ? r4.getUrl() : null)) {
                break;
            }
        }
        CommonPicSpecUrlEntry commonPicSpecUrlEntry = (CommonPicSpecUrlEntry) obj;
        CommonPicUrl url = commonPicSpecUrlEntry != null ? commonPicSpecUrlEntry.getUrl() : null;
        if (url == null) {
            url = commonImage.getDefaultUrl();
        }
        if (url != null) {
            return url.getUrl();
        }
        return null;
    }

    public static final int h(List<CommonPicSpecUrlEntry> list, int i3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        for (CommonPicSpecUrlEntry commonPicSpecUrlEntry : list) {
            Integer spec = commonPicSpecUrlEntry.getSpec();
            if (spec != null && spec.intValue() == i3) {
                CommonPicUrl url = commonPicSpecUrlEntry.getUrl();
                if (!TextUtils.isEmpty(url != null ? url.getUrl() : null)) {
                    CommonPicUrl url2 = commonPicSpecUrlEntry.getUrl();
                    if (url2 != null) {
                        return url2.getWidth();
                    }
                    return 0;
                }
            }
        }
        return 0;
    }

    public static final boolean i(CommonImage commonImage) {
        Intrinsics.checkNotNullParameter(commonImage, "<this>");
        CommonPicUrl f16 = f(commonImage.getPhotoUrl(), 1);
        if (f16 == null || TextUtils.isEmpty(f16.getUrl())) {
            return false;
        }
        return ((float) f16.getWidth()) >= ((float) ImmersiveUtils.getScreenWidth()) * 1.2f || ((float) f16.getHeight()) >= ((float) ImmersiveUtils.getScreenHeight()) * 1.2f;
    }
}
