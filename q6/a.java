package q6;

import NS_MOBILE_CUSTOM.custom_list_switch_set_req;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_set_cover_req;
import NS_MOBILE_MAIN_PAGE.mobile_sub_set_cover_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_set_photo_wall_combinepic_rsp;
import android.os.Handler;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.EventCenter;
import com.qzone.cover.business.protocol.QZoneGetCoverRequest;
import com.qzone.cover.business.protocol.QZoneSetCoverRequest;
import com.qzone.cover.business.protocol.QZoneSetJigsawRequest;
import com.qzone.personalize.QZoneCustomListSwitchSetRequest;
import com.qzone.proxy.covercomponent.CoverComponentProxy;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.publish.business.task.QzoneSetCoverTask;
import com.qzone.util.ToastUtil;
import com.qzone.util.al;
import com.tencent.mobileqq.R;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a implements IQZoneServiceListener {

    /* renamed from: e, reason: collision with root package name */
    private static final al<a, Void> f428444e = new C11059a();

    /* renamed from: d, reason: collision with root package name */
    private HashMap<Long, String> f428445d = new HashMap<>();

    /* compiled from: P */
    /* renamed from: q6.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11059a extends al<a, Void> {
        C11059a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(Void r16) {
            return new a();
        }
    }

    public static a b() {
        return f428444e.get(null);
    }

    private void d(QZoneTask qZoneTask) {
        if (qZoneTask == null) {
            QZLog.w(QzoneCoverConst.QZONE_COVER_SERVICE_TAG, "onSetAlbumVideoToBeVideoCoverResponse task is null");
            return;
        }
        QZoneResult result = qZoneTask.getResult(1000011);
        if (qZoneTask.succeeded()) {
            QZLog.i(QzoneCoverConst.QZONE_COVER_SERVICE_TAG, 1, "set album video cover succ.");
            EventCenter.getInstance().post("Personalize", 12, (Object[]) null);
        } else {
            result.setMessage(qZoneTask.f45835msg);
            mobile_sub_set_cover_req mobile_sub_set_cover_reqVar = (mobile_sub_set_cover_req) ((QZoneSetCoverRequest) qZoneTask.mRequest).req;
            if (mobile_sub_set_cover_reqVar != null) {
                QZLog.w(QzoneCoverConst.QZONE_COVER_SERVICE_TAG, "on set album video cover failed: cover = " + mobile_sub_set_cover_reqVar.cover + ", type = " + mobile_sub_set_cover_reqVar.type + ", code = " + qZoneTask.mResultCode + ",msg = " + qZoneTask.f45835msg);
            }
            ToastUtil.o(R.string.gdg, 4);
        }
        result.setSucceed(qZoneTask.succeeded());
        qZoneTask.sendResultMsg(result);
    }

    private void g(QZoneTask qZoneTask) {
        if (qZoneTask == null) {
            QZLog.w(QzoneCoverConst.QZONE_COVER_SERVICE_TAG, "onSetVideoCoverSWitchResponse task is null");
            return;
        }
        QZoneResult result = qZoneTask.getResult(1000147);
        if (qZoneTask.succeeded()) {
            QZLog.i(QzoneCoverConst.QZONE_COVER_SERVICE_TAG, 1, "set album video cover succ.");
            EventCenter.getInstance().post("Personalize", 12, (Object[]) null);
        } else {
            result.setMessage(qZoneTask.f45835msg);
            custom_list_switch_set_req custom_list_switch_set_reqVar = (custom_list_switch_set_req) ((QZoneCustomListSwitchSetRequest) qZoneTask.mRequest).req;
            if (custom_list_switch_set_reqVar != null) {
                QZLog.w(QzoneCoverConst.QZONE_COVER_SERVICE_TAG, "on set video cover switch failed: code = " + custom_list_switch_set_reqVar.iCover + ", code = " + qZoneTask.mResultCode + ",msg = " + qZoneTask.f45835msg);
            }
            ToastUtil.o(R.string.gdj, 4);
        }
        result.setSucceed(qZoneTask.succeeded());
        qZoneTask.sendResultMsg(result);
    }

    private boolean h(IQueueTask iQueueTask) {
        boolean z16 = false;
        if (iQueueTask == null) {
            return false;
        }
        try {
            z16 = QZonePublishQueue.w().f(iQueueTask);
            if (!z16) {
                QZLog.d(QzoneCoverConst.QZONE_COVER_SERVICE_TAG, 2, "cancel fail");
            }
        } catch (Exception e16) {
            QZLog.e(QzoneCoverConst.QZONE_COVER_SERVICE_TAG, "syncronized ", e16);
        }
        return z16;
    }

    public void i(int i3) {
        CopyOnWriteArrayList<IQueueTask> a16 = QZonePublishQueue.w().a();
        if (a16 == null || a16.size() == 0) {
            return;
        }
        for (int i16 = 0; i16 < a16.size(); i16++) {
            if ((a16.get(i16) instanceof QzoneSetCoverTask) && ((QzoneSetCoverTask) a16.get(i16)).getSetSouce() == i3) {
                h(a16.get(i16));
                return;
            }
        }
    }

    public void k(Handler handler, String str, String str2, String str3, String str4, int i3, int i16, int i17) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneSetCoverRequest(LoginData.getInstance().getUin(), str3, str2, str, 0, 0, i17, "", 0, str4, i3, i16), handler, this, 1011));
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        int i3 = qZoneTask.mType;
        if (i3 == 1001) {
            c(qZoneTask);
            return;
        }
        if (i3 != 1002) {
            switch (i3) {
                case 1010:
                    f(qZoneTask);
                    return;
                case 1011:
                    d(qZoneTask);
                    return;
                case 1012:
                    g(qZoneTask);
                    return;
                default:
                    return;
            }
        }
        e(qZoneTask);
    }

    public void a(Handler handler) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneCustomListSwitchSetRequest(16, -1, -1, -1, -1, 1, "", -1, -1, -1), handler, this, 1012));
    }

    private void c(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1000010);
        if (qZoneTask.succeeded()) {
            mobile_sub_get_cover_rsp mobile_sub_get_cover_rspVar = (mobile_sub_get_cover_rsp) ((QZoneGetCoverRequest) qZoneTask.mRequest).rsp;
            if (mobile_sub_get_cover_rspVar != null) {
                CoverCacheData createFromResponse = CoverCacheData.createFromResponse(((Long) qZoneTask.getParameter("key_hostuin")).longValue(), mobile_sub_get_cover_rspVar);
                result.setData(createFromResponse);
                CoverComponentProxy.f50099g.getServiceInterface().saveCoverIntoCache(createFromResponse);
            }
            result.setSucceed(true);
        } else {
            result.setSucceed(false);
            QZLog.w(QZLog.TO_DEVICE_TAG, "QZoneCoverServiceonGetCoverResponse failed: " + qZoneTask.mResultCode);
        }
        qZoneTask.sendResultMsg(result);
    }

    private void e(QZoneTask qZoneTask) {
        Map<String, String> map;
        QZoneResult result = qZoneTask.getResult(1000011);
        mobile_sub_set_cover_req mobile_sub_set_cover_reqVar = (mobile_sub_set_cover_req) ((QZoneSetCoverRequest) qZoneTask.mRequest).req;
        if (!qZoneTask.succeeded()) {
            if (mobile_sub_set_cover_reqVar != null) {
                QZLog.w(QzoneCoverConst.QZONE_COVER_SERVICE_TAG, "onSetCoverResponse failed: cover = " + mobile_sub_set_cover_reqVar.cover + ", type = " + mobile_sub_set_cover_reqVar.type + ", code = " + qZoneTask.mResultCode);
            }
            result.setMessage(qZoneTask.f45835msg);
        } else {
            mobile_sub_set_cover_rsp mobile_sub_set_cover_rspVar = (mobile_sub_set_cover_rsp) qZoneTask.mRequest.rsp;
            if (mobile_sub_set_cover_rspVar != null && (map = mobile_sub_set_cover_rspVar.MulRelsotionUrl) != null && (!TextUtils.isEmpty(map.get("HigeResolutionCover")) || !TextUtils.isEmpty(map.get("LowResolutionCover")))) {
                result.setData(map);
            }
        }
        result.setSucceed(qZoneTask.succeeded());
        qZoneTask.sendResultMsg(result);
    }

    private void f(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1000012);
        if (qZoneTask.succeeded()) {
            mobile_sub_set_photo_wall_combinepic_rsp mobile_sub_set_photo_wall_combinepic_rspVar = (mobile_sub_set_photo_wall_combinepic_rsp) ((QZoneSetJigsawRequest) qZoneTask.mRequest).rsp;
            if (mobile_sub_set_photo_wall_combinepic_rspVar != null) {
                result.setData(Integer.valueOf(mobile_sub_set_photo_wall_combinepic_rspVar.ret));
                result.setSucceed(true);
            }
        } else {
            result.setSucceed(false);
            QZLog.w(QZLog.TO_DEVICE_TAG, "QZoneCoverServiceonSetJigsawResponse failed: " + qZoneTask.mResultCode);
        }
        qZoneTask.sendResultMsg(result);
    }

    public void j(Handler handler, String str, boolean z16, boolean z17, boolean z18, int i3) {
        i(i3);
        int i16 = z16 ? 2 : 0;
        if (z17) {
            i16 |= 1;
        }
        QzoneSetCoverTask qzoneSetCoverTask = new QzoneSetCoverTask(LoginData.getInstance().getUin(), null, str, null, null, UUID.randomUUID().toString(), 17, i16, i3, 0);
        qzoneSetCoverTask.setHandler(handler);
        if (z18) {
            QZonePublishQueue.w().b(qzoneSetCoverTask);
        } else {
            QZonePublishQueue.w().r(qzoneSetCoverTask);
        }
    }
}
