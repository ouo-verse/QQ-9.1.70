package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xac6$ReqBody extends MessageMicro<cmd0xac6$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_medals", "uint32_clean"}, new Object[]{null, 0}, cmd0xac6$ReqBody.class);
    public final PBRepeatMessageField<cmd0xac6$MedalReport> rpt_medals = PBField.initRepeatMessage(cmd0xac6$MedalReport.class);
    public final PBUInt32Field uint32_clean = PBField.initUInt32(0);
}
