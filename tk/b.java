package tk;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.request.Option;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {
    public static RFWLayerPicInfo a(VideoInfo videoInfo, BusinessFeedData businessFeedData) {
        String str;
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setCurrentPicInfo(new RFWLayerPicInfo.RFWPicInfo());
        if (videoInfo == null) {
            return rFWLayerPicInfo;
        }
        PictureUrl pictureUrl = videoInfo.coverUrl;
        if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
            str = videoInfo.coverUrl.url;
        } else {
            str = "";
        }
        PictureUrl pictureUrl2 = videoInfo.currentUrl;
        if (pictureUrl2 != null && !TextUtils.isEmpty(pictureUrl2.url)) {
            str = videoInfo.currentUrl.url;
        }
        PictureUrl pictureUrl3 = videoInfo.bigUrl;
        if (pictureUrl3 != null && !TextUtils.isEmpty(pictureUrl3.url)) {
            str = videoInfo.bigUrl.url;
        }
        PictureUrl pictureUrl4 = videoInfo.originUrl;
        if (pictureUrl4 != null && !TextUtils.isEmpty(pictureUrl4.url)) {
            str = videoInfo.originUrl.url;
        }
        if (TextUtils.isEmpty(str)) {
            if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
                RFWLog.e("QZoneFeedxDataConvertor", RFWLog.USR, "all url is empty, exception, feed id is " + businessFeedData.getFeedCommInfo().feedsid + " feedsKey is " + businessFeedData.getFeedCommInfo().feedskey);
            }
            RFWLog.e("QZoneFeedxDataConvertor", RFWLog.USR, "all url is empty, exception");
        }
        rFWLayerPicInfo.getCurrentPicInfo().setUrl(str);
        rFWLayerPicInfo.getCurrentPicInfo().setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(str)));
        return rFWLayerPicInfo;
    }
}
