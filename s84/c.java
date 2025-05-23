package s84;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sqshow.zootopia.data.ZootopiaDownloadBarType;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import t74.u;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\tR\u0014\u0010\u0015\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\tR\u0014\u0010\u0017\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\tR\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\tR\u0014\u0010\u001b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\tR0\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001cj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Ls84/c;", "", "Lcom/tencent/sqshow/zootopia/data/ZootopiaDownloadBarType;", "barType", "Ls84/a;", "a", "c", "b", "", "I", "BOTTOM_DRAWABLE", "LIST_DRAWABLE", "d", "BANNER_DRAWABLE", "", "e", UserInfo.SEX_FEMALE, "smallHomeTransitPageWidth", "f", "SMALL_HOME_TRANSIT_PAGE_DRAWABLE", "g", "VIDEO_STATUS_DRAWABLE", h.F, "PLAY_TOGETHER_DRAWABLE", "i", "RESERVE_BTN_DRAWABLE", "j", "CLOUD_MOD_BTN_DRAWABLE", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "k", "Ljava/util/HashMap;", "buttonStyleMap", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f433498a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int BOTTOM_DRAWABLE = R.drawable.gz7;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int LIST_DRAWABLE = R.drawable.gz6;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final int BANNER_DRAWABLE = R.drawable.hxh;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final float smallHomeTransitPageWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final int SMALL_HOME_TRANSIT_PAGE_DRAWABLE;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final int VIDEO_STATUS_DRAWABLE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final int PLAY_TOGETHER_DRAWABLE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final int RESERVE_BTN_DRAWABLE;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final int CLOUD_MOD_BTN_DRAWABLE;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<ZootopiaDownloadBarType, a> buttonStyleMap;

    static {
        HashMap<ZootopiaDownloadBarType, a> hashMapOf;
        float c16 = u.INSTANCE.c(BaseApplication.getContext()) - ViewUtils.dpToPx(32.0f);
        smallHomeTransitPageWidth = c16;
        SMALL_HOME_TRANSIT_PAGE_DRAWABLE = R.drawable.gz7;
        VIDEO_STATUS_DRAWABLE = R.drawable.gze;
        PLAY_TOGETHER_DRAWABLE = R.drawable.gzc;
        RESERVE_BTN_DRAWABLE = R.drawable.gzc;
        CLOUD_MOD_BTN_DRAWABLE = R.drawable.gzd;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(ZootopiaDownloadBarType.BOTTOM_DOWNLOAD_BAR, new a(12.0f, 80.0f, 25.0f, 12.5f, R.drawable.gz7, null, false, 0.0f, 0.0f, 0.0f, 992, null)), TuplesKt.to(ZootopiaDownloadBarType.LIST_DOWNLOAD_BAR, new a(14.0f, 102.0f, 41.5f, 24.25f, R.drawable.gz6, null, false, 0.0f, 0.0f, 0.0f, 992, null)), TuplesKt.to(ZootopiaDownloadBarType.BANNER_DOWNLOAD_BAR, new a(12.0f, 104.0f, 27.0f, 13.5f, R.drawable.hxh, null, false, 0.0f, 0.0f, 0.0f, 992, null)), TuplesKt.to(ZootopiaDownloadBarType.SMALL_HOME_TRANSIT_PAGE_BAR, new a(17.0f, c16, 45.0f, 4.0f, R.drawable.gz7, null, false, 0.0f, 0.0f, 0.0f, 992, null)), TuplesKt.to(ZootopiaDownloadBarType.VIDEO_DOWNLOAD_BAR, new a(12.0f, 82.0f, 27.0f, 14.0f, R.drawable.gze, null, false, 0.0f, 0.0f, 0.0f, 992, null)), TuplesKt.to(ZootopiaDownloadBarType.PLAY_TOGETHER_BAR, new a(13.0f, 54.0f, 27.0f, 13.0f, R.drawable.gzc, null, false, 0.0f, 0.0f, 0.0f, 992, null)), TuplesKt.to(ZootopiaDownloadBarType.CLOUD_MOD_BAR, new a(13.0f, 54.0f, 27.0f, 13.0f, R.drawable.gzd, null, false, 0.0f, 0.0f, 0.0f, 992, null)));
        buttonStyleMap = hashMapOf;
    }

    c() {
    }

    public final a a(ZootopiaDownloadBarType barType) {
        Intrinsics.checkNotNullParameter(barType, "barType");
        return buttonStyleMap.get(barType);
    }

    public final a b() {
        return new a(13.0f, 54.0f, 27.0f, 13.0f, RESERVE_BTN_DRAWABLE, "#FFB300", true, 0.0f, 0.0f, 0.0f, 896, null);
    }

    public final a c() {
        return new a(13.0f, 54.0f, 27.0f, 13.0f, RESERVE_BTN_DRAWABLE, null, false, 0.0f, 0.0f, 0.0f, 992, null);
    }
}
