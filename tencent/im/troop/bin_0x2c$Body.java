package tencent.im.troop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class bin_0x2c$Body extends MessageMicro<bin_0x2c$Body> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"group_code", "group_type", "opt", "msg_body"}, new Object[]{0L, 0L, 0L, null}, bin_0x2c$Body.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field group_type = PBField.initUInt64(0);
    public final PBUInt64Field opt = PBField.initUInt64(0);
    public bin_0x2c$MsgBody msg_body = new bin_0x2c$MsgBody();
}
