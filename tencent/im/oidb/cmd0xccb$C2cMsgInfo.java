package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xccb$C2cMsgInfo extends MessageMicro<cmd0xccb$C2cMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"msg_seq", ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "msg_random", "roam_flag"}, new Object[]{0, 0, 0, 0}, cmd0xccb$C2cMsgInfo.class);
    public final PBUInt32Field msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field msg_time = PBField.initUInt32(0);
    public final PBUInt32Field msg_random = PBField.initUInt32(0);
    public final PBUInt32Field roam_flag = PBField.initUInt32(0);
}
