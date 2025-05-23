package tencent.im.s2c.msgtype0x210.submsgtype0xaa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0xaa$InviteSource extends MessageMicro<SubMsgType0xaa$InviteSource> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "src"}, new Object[]{0, ""}, SubMsgType0xaa$InviteSource.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField src = PBField.initString("");
}
