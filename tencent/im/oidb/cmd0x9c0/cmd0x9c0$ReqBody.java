package tencent.im.oidb.cmd0x9c0;

import appoint.define.appoint_define$LBSInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9c0$ReqBody extends MessageMicro<cmd0x9c0$ReqBody> {
    public static final int MSG_LBS_INFO_FIELD_NUMBER = 3;
    public static final int UINT32_HEARTBEAT_FIELD_NUMBER = 2;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_uin", "uint32_heartbeat", "msg_lbs_info"}, new Object[]{0L, 0, null}, cmd0x9c0$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_heartbeat = PBField.initUInt32(0);
    public appoint_define$LBSInfo msg_lbs_info = new appoint_define$LBSInfo();
}
