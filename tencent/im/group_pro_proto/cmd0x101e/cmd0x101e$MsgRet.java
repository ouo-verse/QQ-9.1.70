package tencent.im.group_pro_proto.cmd0x101e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x101e$MsgRet extends MessageMicro<cmd0x101e$MsgRet> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "ret_msg"}, new Object[]{0L, ""}, cmd0x101e$MsgRet.class);
    public final PBUInt64Field ret_code = PBField.initUInt64(0);
    public final PBStringField ret_msg = PBField.initString("");
}
