package yv2;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g;
import com.tencent.qqlive.ona.protocol.jce.AdActionItem;
import com.tencent.qqlive.ona.protocol.jce.AdDownloadItem;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    @Nullable
    public static a a(Context context, wv2.a aVar, b.a aVar2, d dVar, g gVar) {
        AdActionItem adActionItem;
        AdDownloadItem adDownloadItem;
        if (aVar == null || (adActionItem = aVar.f446565a) == null || (adDownloadItem = adActionItem.adDownload) == null) {
            return null;
        }
        if (adDownloadItem.downloadType != 3) {
            n.e("DownloadTypeHandlerFactory", "newMarketDownloadHandler: into a wrong case or H5, current downloadType=" + aVar.f446565a.adDownload.downloadType);
            return null;
        }
        return new c(context, aVar, adDownloadItem, dVar, gVar, aVar2);
    }
}
