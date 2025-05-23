package tencent.im.s2c.msgtype0x210.submsgtype0x165;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Submsgtype0x165$MsgBody extends MessageMicro<Submsgtype0x165$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"scene_id", "seq"}, new Object[]{0, 0L}, Submsgtype0x165$MsgBody.class);
    public final PBUInt32Field scene_id = PBField.initUInt32(0);
    public final PBUInt64Field seq = PBField.initUInt64(0);
}
