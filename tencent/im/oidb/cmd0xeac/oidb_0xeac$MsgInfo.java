package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeac$MsgInfo extends MessageMicro<oidb_0xeac$MsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"msg_seq", "msg_random"}, new Object[]{0, 0}, oidb_0xeac$MsgInfo.class);
    public final PBUInt32Field msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field msg_random = PBField.initUInt32(0);
}
