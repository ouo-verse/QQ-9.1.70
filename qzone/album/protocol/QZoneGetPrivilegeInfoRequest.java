package qzone.album.protocol;

import NS_MOBILE_PHOTO.GetPrivilegeInfoReq;
import NS_MOBILE_PHOTO.GetPrivilegeInfoRsp;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.protocol.AbsCompatRequest;
import cooperation.qzone.util.QZLog;

/* loaded from: classes36.dex */
public class QZoneGetPrivilegeInfoRequest extends AbsCompatRequest<a> {
    private static final String FIELD_CMD = "asy_photo.GetPrivilegeInfo";
    private static final String TAG = "QZoneGetPrivilegeInfoRequest";
    private static final String UNI_KEY = "GetPrivilegeInfo";

    /* loaded from: classes36.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public long f430353a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f430354b = 0;

        /* renamed from: c, reason: collision with root package name */
        public long f430355c = 0;
    }

    public QZoneGetPrivilegeInfoRequest(long j3, int i3) {
        super(FIELD_CMD);
        super.setHostUin(j3);
        GetPrivilegeInfoReq getPrivilegeInfoReq = new GetPrivilegeInfoReq();
        getPrivilegeInfoReq.req_type = i3;
        this.req = getPrivilegeInfoReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UNI_KEY;
    }

    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 4, "QzoneGetPicContInfoRequest onJceRespParse");
        }
        if (!(jceStruct instanceof GetPrivilegeInfoRsp)) {
            QZLog.e(TAG, "response is not instanceof GetPrivilegeInfoRsp");
            return null;
        }
        GetPrivilegeInfoRsp getPrivilegeInfoRsp = (GetPrivilegeInfoRsp) jceStruct;
        a aVar = new a();
        aVar.f430353a = getPrivilegeInfoRsp.free_balance;
        aVar.f430354b = getPrivilegeInfoRsp.bought_balance;
        aVar.f430355c = getPrivilegeInfoRsp.used_count;
        return aVar;
    }
}
