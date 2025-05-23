package tencent.im.oidb.cmd0x983;

import appoint.define.appoint_define$LBSInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x983$ReqBody extends MessageMicro<oidb_cmd0x983$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_lbs_info", "uint32_network"}, new Object[]{null, 0}, oidb_cmd0x983$ReqBody.class);
    public appoint_define$LBSInfo msg_lbs_info = new appoint_define$LBSInfo();
    public final PBUInt32Field uint32_network = PBField.initUInt32(0);
}
