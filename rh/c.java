package rh;

import android.content.Context;
import android.view.ViewGroup;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.util.ar;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J$\u0010\u0012\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\"\u0010\u0017\u001a\u00020\u00102\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a8\u0006\u001b"}, d2 = {"Lrh/c;", "", "Landroid/content/Context;", "context", "Lcom/qzone/proxy/feedcomponent/model/PictureUrl;", "picInfo", "Lkotlin/Pair;", "", "e", "Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", QCircleScheme.AttrDetail.VIDEO_INFO, "f", "g", "Landroid/view/ViewGroup$LayoutParams;", "params", "pictureUrl", "", "a", "b", "Ljava/util/ArrayList;", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", "Lkotlin/collections/ArrayList;", s4.c.PICS, "c", "d", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f431447a = new c();

    c() {
    }

    private final Pair<Integer, Integer> e(Context context, PictureUrl picInfo) {
        int i3;
        int i16;
        int i17;
        float f16;
        int g16 = g(context);
        if (picInfo != null && (i3 = picInfo.width) > 0 && (i16 = picInfo.height) > 0) {
            float f17 = (i16 * 1.0f) / i3;
            if (f17 > 1.3559322f) {
                f16 = g16 * 1.3559322f;
            } else {
                if (f17 >= 0.76836157f) {
                    i17 = (int) (g16 * f17);
                    return new Pair<>(Integer.valueOf(g16), Integer.valueOf(i17));
                }
                f16 = g16 * 0.76836157f;
            }
            i17 = (int) f16;
            return new Pair<>(Integer.valueOf(g16), Integer.valueOf(i17));
        }
        QLog.i("QZoneEventTagWHRateUtils", 1, "fetchCoverWidthAndHeight  videoInfo " + picInfo);
        return new Pair<>(Integer.valueOf(g16), Integer.valueOf((int) (g16 * 0.76836157f)));
    }

    private final Pair<Integer, Integer> f(Context context, VideoInfo videoInfo) {
        int i3;
        int i16;
        int i17;
        float f16;
        int g16 = g(context);
        if (videoInfo != null && (i3 = videoInfo.width) > 0 && (i16 = videoInfo.height) > 0) {
            float f17 = (i16 * 1.0f) / i3;
            if (f17 > 1.3559322f) {
                f16 = g16 * 1.3559322f;
            } else {
                if (f17 >= 0.76836157f) {
                    i17 = (int) (g16 * f17);
                    return new Pair<>(Integer.valueOf(g16), Integer.valueOf(i17));
                }
                f16 = g16 * 0.76836157f;
            }
            i17 = (int) f16;
            return new Pair<>(Integer.valueOf(g16), Integer.valueOf(i17));
        }
        QLog.e("QZoneEventTagWHRateUtils", 1, "fetchVideoWidthAndHeight videoInfo " + videoInfo);
        return new Pair<>(Integer.valueOf(g16), Integer.valueOf((int) (g16 * 0.76836157f)));
    }

    public final int g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (pl.a.f426446a.o(context) - (ar.e(7.0f) * 3)) / 2;
    }

    public final void c(ArrayList<PictureItem> pics) {
        if (pics != null && pics.size() == 1) {
            PictureItem pictureItem = pics.get(0);
            Intrinsics.checkNotNullExpressionValue(pictureItem, "pics[0]");
            PictureItem pictureItem2 = pictureItem;
            PictureUrl pictureUrl = pictureItem2.bigUrl;
            if (pictureUrl == null || pictureUrl == null) {
                return;
            }
            PictureUrl pictureUrl2 = pictureItem2.currentUrl;
            if (pictureUrl2.width == pictureUrl.width || pictureUrl2.height == pictureUrl.height) {
                return;
            }
            pictureItem2.currentUrl = pictureUrl;
            return;
        }
        QLog.i("QZoneEventTagWHRateUtils", 1, "[convertSinglePictureUrl] is not single pic");
    }

    public final VideoInfo d(VideoInfo videoInfo) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        if (videoInfo == null) {
            return null;
        }
        if (videoInfo.width > 0 && videoInfo.height > 0) {
            return videoInfo;
        }
        PictureUrl pictureUrl = videoInfo.coverUrl;
        if (pictureUrl != null && (i27 = pictureUrl.width) > 0 && (i28 = pictureUrl.height) > 0) {
            videoInfo.width = i27;
            videoInfo.height = i28;
        } else {
            PictureUrl pictureUrl2 = videoInfo.currentUrl;
            if (pictureUrl2 != null && (i19 = pictureUrl2.width) > 0 && (i26 = pictureUrl2.height) > 0) {
                videoInfo.width = i19;
                videoInfo.height = i26;
            } else {
                PictureUrl pictureUrl3 = videoInfo.bigUrl;
                if (pictureUrl3 != null && (i17 = pictureUrl3.width) > 0 && (i18 = pictureUrl3.height) > 0) {
                    videoInfo.width = i17;
                    videoInfo.height = i18;
                } else {
                    PictureUrl pictureUrl4 = videoInfo.originUrl;
                    if (pictureUrl4 != null && (i3 = pictureUrl4.width) > 0 && (i16 = pictureUrl4.height) > 0) {
                        videoInfo.width = i3;
                        videoInfo.height = i16;
                    }
                }
            }
        }
        return videoInfo;
    }

    public final void a(Context context, ViewGroup.LayoutParams params, PictureUrl pictureUrl) {
        if (context != null && params != null && pictureUrl != null) {
            Pair<Integer, Integer> e16 = e(context, pictureUrl);
            params.width = e16.getFirst().intValue();
            params.height = e16.getSecond().intValue();
        } else {
            QLog.e("QZoneEventTagWHRateUtils", 1, "calculateCoverWHRate context " + context + " pictureUrl " + pictureUrl);
        }
    }

    public final void b(Context context, ViewGroup.LayoutParams params, VideoInfo videoInfo) {
        if (context != null && params != null && videoInfo != null) {
            Pair<Integer, Integer> f16 = f(context, videoInfo);
            params.width = f16.getFirst().intValue();
            params.height = f16.getSecond().intValue();
        } else {
            QLog.e("QZoneEventTagWHRateUtils", 1, "calculateSingleVideo context " + context + " pictureUrl " + videoInfo);
        }
    }
}
