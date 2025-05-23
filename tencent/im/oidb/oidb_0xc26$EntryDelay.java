package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc26$EntryDelay extends MessageMicro<oidb_0xc26$EntryDelay> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"em_entry", "uint32_delay"}, new Object[]{1, 0}, oidb_0xc26$EntryDelay.class);
    public final PBEnumField em_entry = PBField.initEnum(1);
    public final PBUInt32Field uint32_delay = PBField.initUInt32(0);
}
