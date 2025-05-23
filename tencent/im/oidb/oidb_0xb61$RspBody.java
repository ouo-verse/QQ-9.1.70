package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb61$RspBody extends MessageMicro<oidb_0xb61$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 82, 90}, new String[]{"wording", "next_req_duration", "get_appinfo_rsp", "get_mqqapp_url_rsp"}, new Object[]{"", 0, null, null}, oidb_0xb61$RspBody.class);
    public final PBStringField wording = PBField.initString("");
    public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
    public oidb_0xb61$GetAppinfoRsp get_appinfo_rsp = new oidb_0xb61$GetAppinfoRsp();
    public oidb_0xb61$GetPkgUrlRsp get_mqqapp_url_rsp = new oidb_0xb61$GetPkgUrlRsp();
}
