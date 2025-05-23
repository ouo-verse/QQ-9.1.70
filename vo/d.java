package vo;

import NS_MOBILE_FEEDS.mobile_feeds_rsp;
import NS_MOBILE_FEEDS.single_feed;
import com.qzone.common.account.LoginData;
import com.qzone.feed.business.protocol.QZoneGetFriendFeedsRequest;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private static d f442094b;

    /* renamed from: a, reason: collision with root package name */
    private Map<Long, String> f442095a = new HashMap();

    public static d b() {
        if (f442094b == null) {
            synchronized (d.class) {
                if (f442094b == null) {
                    f442094b = new d();
                }
            }
        }
        return f442094b;
    }

    public String a(long j3) {
        return QzoneConfig.getInstance().getConfig("H5Url", QzoneCoverConst.SECONDARY_FAMOUS_SPACE_COVER_BG_IMAGE_URL, QzoneCoverConst.SECONDARY_FAMOUS_SPACE_COVER_BG_IMAGE_URL_DEFAULT).replace("{uin}", String.valueOf(j3)).replace("{timestamp}", new SimpleDateFormat("yyyyMMddHH").format(new Date()));
    }

    public String c(long j3) {
        String str;
        Map<Long, String> map = this.f442095a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            str = this.f442095a.get(Long.valueOf(j3));
        }
        return str;
    }

    public boolean d(long j3) {
        return c(j3) != null;
    }

    public void g(long j3, String str) {
        Map<Long, String> map = this.f442095a;
        if (map == null) {
            return;
        }
        synchronized (map) {
            this.f442095a.put(Long.valueOf(j3), str);
            if (LoginData.getInstance().getUin() == j3) {
                LocalMultiProcConfig.putString(QZoneHelper.FAMOUS_SPACE_ACTION_URL_CONFIG_NAME, String.valueOf(j3), str);
            }
        }
    }

    public void e(QZoneGetFriendFeedsRequest qZoneGetFriendFeedsRequest, mobile_feeds_rsp mobile_feeds_rspVar) {
        ArrayList<single_feed> arrayList;
        BusinessFeedData createFrom;
        long ownerUin = qZoneGetFriendFeedsRequest != null ? qZoneGetFriendFeedsRequest.getOwnerUin() : 0L;
        if (mobile_feeds_rspVar != null) {
            if (ownerUin == 0 && (arrayList = mobile_feeds_rspVar.all_feeds_data) != null && arrayList.size() > 0 && (createFrom = BusinessFeedData.createFrom(mobile_feeds_rspVar.all_feeds_data.get(0), 4097)) != null) {
                ownerUin = createFrom.getUser().uin;
            }
            if (ownerUin != 0) {
                f(ownerUin, mobile_feeds_rspVar);
            }
        }
    }

    public void f(long j3, mobile_feeds_rsp mobile_feeds_rspVar) {
        if (mobile_feeds_rspVar == null) {
            return;
        }
        int i3 = 0;
        try {
            String str = mobile_feeds_rspVar.extendinfo.get(5);
            if (str != null && str.length() > 0) {
                i3 = Integer.valueOf(str).intValue();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (i3 == 35) {
            if (CoverEnv.isSupprtWebviewCover()) {
                String str2 = mobile_feeds_rspVar.extendinfo.get(6);
                g(j3, str2 != null ? str2 : "");
            } else {
                QZLog.d("QzoneJumpSpecialFamousSpaceHelper", 1, "not support webview cover,not save uin to sp.");
                g(j3, "");
            }
        }
    }
}
