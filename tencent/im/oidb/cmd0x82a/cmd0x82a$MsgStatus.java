package tencent.im.oidb.cmd0x82a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x82a$MsgStatus extends MessageMicro<cmd0x82a$MsgStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_info", "uint32_status"}, new Object[]{null, 0}, cmd0x82a$MsgStatus.class);
    public cmd0x82a$MsgInfo msg_info = new cmd0x82a$MsgInfo();
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
}
