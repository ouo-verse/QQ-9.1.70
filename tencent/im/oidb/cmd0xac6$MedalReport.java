package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xac6$MedalReport extends MessageMicro<cmd0xac6$MedalReport> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_id", "uint32_level"}, new Object[]{0, 0}, cmd0xac6$MedalReport.class);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
}
