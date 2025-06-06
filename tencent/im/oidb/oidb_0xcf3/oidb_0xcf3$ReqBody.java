package tencent.im.oidb.oidb_0xcf3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xcf3$ReqBody extends MessageMicro<oidb_0xcf3$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{"sub_cmd", "target_uin", "intimate_type", "source", "bind_time", "level", "chat_days"}, new Object[]{0, 0L, 0, 0, 0, 0, 0}, oidb_0xcf3$ReqBody.class);
    public final PBUInt32Field sub_cmd = PBField.initUInt32(0);
    public final PBUInt64Field target_uin = PBField.initUInt64(0);
    public final PBUInt32Field intimate_type = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field bind_time = PBField.initUInt32(0);
    public final PBUInt32Field level = PBField.initUInt32(0);
    public final PBUInt32Field chat_days = PBField.initUInt32(0);
}
