package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb61$ReqBody extends MessageMicro<oidb_0xb61$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90}, new String[]{"get_appinfo_req", "get_mqqapp_url_req"}, new Object[]{null, null}, oidb_0xb61$ReqBody.class);
    public oidb_0xb61$GetAppinfoReq get_appinfo_req = new oidb_0xb61$GetAppinfoReq();
    public oidb_0xb61$GetPkgUrlReq get_mqqapp_url_req = new oidb_0xb61$GetPkgUrlReq();
}
