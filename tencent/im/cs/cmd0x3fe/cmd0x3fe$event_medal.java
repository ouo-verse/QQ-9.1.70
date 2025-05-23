package tencent.im.cs.cmd0x3fe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x3fe$event_medal extends MessageMicro<cmd0x3fe$event_medal> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_id", "uint64_create_time"}, new Object[]{0, 0L}, cmd0x3fe$event_medal.class);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_create_time = PBField.initUInt64(0);
}
