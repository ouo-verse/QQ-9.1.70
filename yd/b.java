package yd;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import tencent.gdt.qq_ad_get;
import tencent.gdt.qq_common;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0005\u001a\u00020\u0003*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0006\u001a\u00020\u0003*\u0004\u0018\u00010\u0000\u001a\f\u0010\b\u001a\u00020\u0007*\u0004\u0018\u00010\u0000\u001a\f\u0010\t\u001a\u00020\u0003*\u0004\u0018\u00010\u0000\u001a\f\u0010\n\u001a\u00020\u0003*\u0004\u0018\u00010\u0000\u001a\f\u0010\u000b\u001a\u00020\u0003*\u0004\u0018\u00010\u0000\u001a\f\u0010\f\u001a\u00020\u0003*\u0004\u0018\u00010\u0000\u001a\u0012\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u0004\u0018\u00010\u0000\u001a\u0014\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0012\u001a\u00020\u0003*\u0004\u0018\u00010\u0000\u00a8\u0006\u0013"}, d2 = {"Lyd/a;", "", h.F, "", "l", "g", "k", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicUrl;", "e", "c", "d", "a", "j", "", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$BasicInfo$CreativeElementStructureContent$Label;", "i", "Ltencent/gdt/qq_common$FloatingTip;", "b", "f", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {
    public static final CommonPicUrl e(a aVar) {
        String str;
        GdtAd gdtAd;
        GdtImageData imageData;
        GdtAd gdtAd2;
        GdtImageData imageData2;
        GdtAd gdtAd3;
        GdtImageData imageData3;
        CommonPicUrl commonPicUrl = new CommonPicUrl();
        if (aVar == null || (gdtAd3 = aVar.getGdtAd()) == null || (imageData3 = gdtAd3.getImageData()) == null || (str = imageData3.url) == null) {
            str = "";
        }
        commonPicUrl.setUrl(str);
        int i3 = 0;
        commonPicUrl.setWidth((aVar == null || (gdtAd2 = aVar.getGdtAd()) == null || (imageData2 = gdtAd2.getImageData()) == null) ? 0 : imageData2.width);
        if (aVar != null && (gdtAd = aVar.getGdtAd()) != null && (imageData = gdtAd.getImageData()) != null) {
            i3 = imageData.height;
        }
        commonPicUrl.setHeight(i3);
        return commonPicUrl;
    }

    public static final String a(a aVar) {
        GdtAd gdtAd;
        String text = (aVar == null || (gdtAd = aVar.getGdtAd()) == null) ? null : gdtAd.getText();
        return text == null ? "" : text;
    }

    public static final List<qq_common.FloatingTip> b(a aVar) {
        GdtAd gdtAd;
        if (aVar == null || (gdtAd = aVar.getGdtAd()) == null) {
            return null;
        }
        return gdtAd.getFloatingTips();
    }

    public static final String c(a aVar) {
        GdtAd gdtAd;
        String advertiser_corporate_logo = (aVar == null || (gdtAd = aVar.getGdtAd()) == null) ? null : gdtAd.getAdvertiser_corporate_logo();
        return advertiser_corporate_logo == null ? "" : advertiser_corporate_logo;
    }

    public static final String d(a aVar) {
        GdtAd gdtAd;
        String advertiser_corporate_image_name = (aVar == null || (gdtAd = aVar.getGdtAd()) == null) ? null : gdtAd.getAdvertiser_corporate_image_name();
        return advertiser_corporate_image_name == null ? "" : advertiser_corporate_image_name;
    }

    public static final String f(a aVar) {
        GdtAd gdtAd;
        String adSelectedUrl = (aVar == null || (gdtAd = aVar.getGdtAd()) == null) ? null : gdtAd.getAdSelectedUrl();
        return adSelectedUrl == null ? "" : adSelectedUrl;
    }

    public static final String g(a aVar) {
        Object obj;
        GdtAd gdtAd;
        if (aVar != null && (gdtAd = aVar.getGdtAd()) != null) {
            obj = Long.valueOf(gdtAd.getAId());
        } else {
            obj = Integer.MIN_VALUE;
        }
        return obj.toString();
    }

    public static final int h(a aVar) {
        GdtAd gdtAd;
        if (aVar == null || (gdtAd = aVar.getGdtAd()) == null) {
            return Integer.MIN_VALUE;
        }
        return gdtAd.getInnerShowType();
    }

    public static final List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label> i(a aVar) {
        GdtAd gdtAd;
        List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label> labelList = (aVar == null || (gdtAd = aVar.getGdtAd()) == null) ? null : gdtAd.getLabelList();
        return labelList == null ? new ArrayList() : labelList;
    }

    public static final String j(a aVar) {
        GdtAd gdtAd;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo basicInfo;
        PBStringField pBStringField;
        String str = (aVar == null || (gdtAd = aVar.getGdtAd()) == null || (adInfo = gdtAd.info) == null || (displayInfo = adInfo.display_info) == null || (basicInfo = displayInfo.basic_info) == null || (pBStringField = basicInfo.left_bottom_txt) == null) ? null : pBStringField.get();
        return str == null ? "" : str;
    }

    public static final String k(a aVar) {
        GdtAd gdtAd;
        String posId = (aVar == null || (gdtAd = aVar.getGdtAd()) == null) ? null : gdtAd.getPosId();
        return posId == null ? "" : posId;
    }

    public static final String l(a aVar) {
        GdtAd gdtAd;
        String traceId = (aVar == null || (gdtAd = aVar.getGdtAd()) == null) ? null : gdtAd.getTraceId();
        return traceId == null ? "" : traceId;
    }
}
