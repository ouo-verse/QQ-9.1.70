package yk;

import NS_MOBILE_OPERATION.PicInfo;
import android.content.Intent;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.process.QZoneMediaDealWithManager;
import com.qzone.publish.business.process.base.QZoneProcessType;
import com.qzone.reborn.part.publish.mood.sync.o;
import com.qzone.util.ag;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends a {

    /* renamed from: c, reason: collision with root package name */
    private xk.b f450542c;

    public b(xk.a aVar) {
        super(aVar);
    }

    private LocalMediaInfo k(Intent intent) {
        List<LocalMediaInfo> l3 = l(intent);
        if (l3 != null && l3.size() > 0) {
            return l3.get(0);
        }
        return null;
    }

    private List<LocalMediaInfo> l(Intent intent) {
        try {
            return (ArrayList) intent.getSerializableExtra(QQWinkConstants.INPUT_MEDIA);
        } catch (Exception e16) {
            QLog.e("QZoneQCircleMediaParse", 1, "getMediaListFromIntent  e = " + e16);
            xe.b.f447841a.d(e16);
            return null;
        }
    }

    private ArrayList<String> m(Intent intent) {
        return (ArrayList) intent.getSerializableExtra("PhotoConst.WINK_MEDIA_PICKER_PATHS");
    }

    private HashMap<String, PicInfo> n(Intent intent) {
        return (HashMap) intent.getSerializableExtra("PhotoConst.WINK_MEDIA_PICKER_QZONE_PICS");
    }

    public static String o(String str) {
        int nextInt;
        if (!TextUtils.isEmpty(str)) {
            nextInt = str.hashCode();
        } else {
            nextInt = new Random(100L).nextInt();
        }
        return CacheManager.getVideoFileCacheDir() + "/" + System.currentTimeMillis() + nextInt + "_compose.mp4";
    }

    @Override // yk.a
    boolean b(Intent intent) {
        return intent.getBooleanExtra("PhotoConst.IS_FROM_CIRCLE_EDIT", false);
    }

    @Override // yk.a
    protected boolean c(Intent intent) {
        List<LocalMediaInfo> l3 = l(intent);
        if (bl.b(l3)) {
            return false;
        }
        for (LocalMediaInfo localMediaInfo : l3) {
            if (localMediaInfo != null && !TextUtils.isEmpty(localMediaInfo.missionID)) {
                return true;
            }
        }
        return false;
    }

    @Override // yk.a
    boolean d(Intent intent) {
        return intent.getBooleanExtra("PhotoConst.IS_FROM_WINK_MEDIA_PICKER", false);
    }

    @Override // yk.a
    boolean e(Intent intent) {
        return intent.getBooleanExtra("PhotoConst.IS_FROM_USER_QUIT_MEDIA_PAGE", false);
    }

    @Override // yk.a
    boolean f(Intent intent) {
        return intent.getBooleanExtra("PhotoConst.IS_FROM_CIRCLE_TAKE_PIC", false);
    }

    @Override // yk.a
    protected void g(Intent intent) {
        List<LocalMediaInfo> l3 = l(intent);
        if (bl.b(l3)) {
            return;
        }
        for (LocalMediaInfo localMediaInfo : l3) {
            if (localMediaInfo != null && !TextUtils.isEmpty(localMediaInfo.missionID)) {
                p(localMediaInfo, intent);
            }
        }
    }

    @Override // yk.a
    protected void h(Intent intent) {
        p(k(intent), intent);
    }

    @Override // yk.a
    protected void i(Intent intent) {
        LocalMediaInfo k3 = k(intent);
        if (k3 == null) {
            QZLog.d(this.f450541b, 1, "parseTakePicData localMediaInfo is null");
            return;
        }
        QZLog.d(this.f450541b, 1, "parseTakePicData localMediaInfo is " + k3);
        xk.a aVar = this.f450540a;
        if (aVar != null) {
            aVar.d(k3, intent);
        }
    }

    @Override // yk.a
    protected void j(Intent intent) {
        xk.a aVar;
        List<LocalMediaInfo> l3 = l(intent);
        ArrayList<String> m3 = m(intent);
        HashMap<String, PicInfo> n3 = n(intent);
        if (l3 == null || m3 == null || (aVar = this.f450540a) == null) {
            return;
        }
        aVar.a(m3, l3, n3, intent);
    }

    private void p(LocalMediaInfo localMediaInfo, Intent intent) {
        if (localMediaInfo == null) {
            QZLog.d(this.f450541b, 1, "parseEditData localMediaInfo is null");
            return;
        }
        QZLog.d(this.f450541b, 1, "parseEditData localMediaInfo is " + localMediaInfo);
        if (QAlbumUtil.getMediaType(localMediaInfo) == 1) {
            localMediaInfo.path = o(localMediaInfo.missionID);
        }
        xk.a aVar = this.f450540a;
        if (aVar != null) {
            aVar.c(localMediaInfo, intent);
        }
        if (o.a2(intent)) {
            QZLog.e(this.f450541b, "parseEditData \u9884\u89c8\u89c6\u9891case\u4e0d\u9700\u8981\u8d70\u9884\u5bfc\u51fa");
            return;
        }
        if (TextUtils.isEmpty(localMediaInfo.missionID)) {
            QZLog.e(this.f450541b, "parseEditData localMediaInfo.missionID is null");
            return;
        }
        if (!QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_PER_EXPORT_WHEN_EDIT_FINISH_QCIRCLE_PUBLISH, true)) {
            QZLog.d(this.f450541b, 1, "parseEditData perExport config value is false");
            return;
        }
        if (QAlbumUtil.getMediaType(localMediaInfo) == 1) {
            QZLog.d(this.f450541b, 1, "parseEditData add export task " + localMediaInfo.missionID);
            QZoneMediaDealWithManager.o().k(localMediaInfo.missionID);
            ShuoshuoVideoInfo b16 = ag.b(localMediaInfo);
            if (this.f450542c == null) {
                this.f450542c = new xk.b();
            }
            QZoneMediaDealWithManager.o().m(b16, QZoneProcessType.PROCESS_TYPE_QCIRCLE_EXPORT, this.f450542c, true);
        }
    }
}
