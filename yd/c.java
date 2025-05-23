package yd;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellAdv;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonVideo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0016\u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u001a\u0010\u001b\u001a\u00020\u00178\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR#\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000e0\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lyd/c;", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonImage;", "c", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "e", "Lcom/tencent/gdtad/aditem/GdtImageData;", "imageData", "d", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "Lyd/a;", "f", "", "g", "adFeedData", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellMedia;", "a", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonVideo;", "b", "", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "", "Ljava/util/Map;", "getAdDataMap", "()Ljava/util/Map;", "adDataMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f450161a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String TAG = "QZoneAdDataManager";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, a> adDataMap = new HashMap();

    c() {
    }

    private final CommonImage d(GdtImageData imageData) {
        CommonImage commonImage = new CommonImage();
        CommonPicUrl commonPicUrl = new CommonPicUrl();
        commonPicUrl.setUrl(imageData != null ? imageData.url : null);
        commonPicUrl.setWidth(imageData != null ? imageData.width : 0);
        commonPicUrl.setHeight(imageData != null ? imageData.height : 0);
        commonImage.setDefaultUrl(commonPicUrl);
        return commonImage;
    }

    private final List<CommonMedia> e(GdtAd ad5) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MutiPicTextInfo mutiPicTextInfo;
        PBRepeatField<String> pBRepeatField;
        ArrayList arrayList = new ArrayList();
        int size = (ad5 == null || (adInfo = ad5.info) == null || (displayInfo = adInfo.display_info) == null || (mutiPicTextInfo = displayInfo.muti_pic_text_info) == null || (pBRepeatField = mutiPicTextInfo.image) == null) ? 0 : pBRepeatField.size();
        if (size <= 0) {
            return arrayList;
        }
        for (int i3 = 0; i3 < size; i3++) {
            CommonMedia commonMedia = new CommonMedia();
            commonMedia.setImage(d(ad5 != null ? ad5.getImageData(i3) : null));
            arrayList.add(commonMedia);
        }
        return arrayList;
    }

    public final CommonVideo b(GdtAd ad5) {
        CommonVideo commonVideo = new CommonVideo();
        commonVideo.setUrl(ad5 != null ? ad5.getVideoUrl() : null);
        commonVideo.setVideoTime((ad5 != null ? ad5.getVideoDuration() : 0L) * 1000);
        commonVideo.setWidth(ad5 != null ? ad5.getVideoWidth() : 0);
        commonVideo.setHeight(ad5 != null ? ad5.getVideoHeight() : 0);
        commonVideo.setCover(c(ad5));
        return commonVideo;
    }

    public final a f(CommonFeed commonFeed) {
        String advFeedId;
        Intrinsics.checkNotNullParameter(commonFeed, "commonFeed");
        CommonCellAdv cellAdv = commonFeed.getCellAdv();
        if (cellAdv == null || (advFeedId = cellAdv.getAdvFeedId()) == null) {
            return null;
        }
        Map<String, a> map = adDataMap;
        if (!map.containsKey(advFeedId)) {
            g(commonFeed);
        }
        return map.get(advFeedId);
    }

    public final void g(CommonFeed commonFeed) {
        CommonCellAdv cellAdv;
        c45.a advFeed;
        Intrinsics.checkNotNullParameter(commonFeed, "commonFeed");
        if (!CommonFeedExtKt.isAdFeed(commonFeed) || (cellAdv = commonFeed.getCellAdv()) == null || (advFeed = cellAdv.getAdvFeed()) == null) {
            return;
        }
        try {
            access.AdGetRsp mergeFrom = new access.AdGetRsp().mergeFrom(advFeed.f30291a);
            a aVar = new a();
            aVar.g(new GdtAd(mergeFrom.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.get(0)));
            List<access.ExpInfo> list = mergeFrom.ext.get();
            Intrinsics.checkNotNullExpressionValue(list, "adGetRsp.ext.get()");
            aVar.f(list);
            commonFeed.setCellMedia(f450161a.a(aVar));
            adDataMap.put(CommonFeedExtKt.getFeedUniqueKey(commonFeed), aVar);
        } catch (Exception unused) {
            QLog.e(TAG, 2, "parseAndCacheAdData error");
            Unit unit = Unit.INSTANCE;
        }
    }

    private final CommonImage c(GdtAd ad5) {
        return d(ad5 != null ? ad5.getImageData() : null);
    }

    public final CommonCellMedia a(a adFeedData) {
        GdtAd gdtAd = adFeedData != null ? adFeedData.getGdtAd() : null;
        int h16 = b.h(adFeedData);
        ArrayList arrayList = new ArrayList();
        qe.b bVar = qe.b.f428879a;
        if (bVar.g(h16)) {
            CommonMedia commonMedia = new CommonMedia();
            commonMedia.setVideo(b(gdtAd));
            arrayList.add(commonMedia);
        } else if (bVar.e(h16)) {
            CommonMedia commonMedia2 = new CommonMedia();
            commonMedia2.setImage(c(gdtAd));
            arrayList.add(commonMedia2);
        } else if (bVar.d(h16)) {
            arrayList.addAll(e(gdtAd));
        }
        CommonCellMedia commonCellMedia = new CommonCellMedia();
        commonCellMedia.setMediaItems(arrayList);
        commonCellMedia.setUploadNum(arrayList.size());
        return commonCellMedia;
    }
}
