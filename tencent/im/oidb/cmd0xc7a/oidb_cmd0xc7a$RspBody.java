package tencent.im.oidb.cmd0xc7a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc7a$RspBody extends MessageMicro<oidb_cmd0xc7a$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 90}, new String[]{"wording", "next_req_duration", "get_uin_info_rsp"}, new Object[]{"", 0, null}, oidb_cmd0xc7a$RspBody.class);
    public final PBStringField wording = PBField.initString("");
    public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
    public oidb_cmd0xc7a$GetUinInfoRsp get_uin_info_rsp = new oidb_cmd0xc7a$GetUinInfoRsp();
}
