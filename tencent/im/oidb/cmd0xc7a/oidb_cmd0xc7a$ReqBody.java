package tencent.im.oidb.cmd0xc7a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc7a$ReqBody extends MessageMicro<oidb_cmd0xc7a$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90}, new String[]{"cmd", "get_uin_info_req"}, new Object[]{0, null}, oidb_cmd0xc7a$ReqBody.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public oidb_cmd0xc7a$GetUinInfoReq get_uin_info_req = new oidb_cmd0xc7a$GetUinInfoReq();
}
