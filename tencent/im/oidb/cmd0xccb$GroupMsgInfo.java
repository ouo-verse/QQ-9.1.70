package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xccb$GroupMsgInfo extends MessageMicro<cmd0xccb$GroupMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"msg_seq", "roam_flag"}, new Object[]{0, 0}, cmd0xccb$GroupMsgInfo.class);
    public final PBUInt32Field msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field roam_flag = PBField.initUInt32(0);
}
