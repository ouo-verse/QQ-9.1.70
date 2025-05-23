package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x346$AddrList extends MessageMicro<cmd0x346$AddrList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 26, 32}, new String[]{"rpt_str_ip", "rpt_str_domain", "uint32_port"}, new Object[]{"", "", 0}, cmd0x346$AddrList.class);
    public final PBRepeatField<String> rpt_str_ip = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField rpt_str_domain = PBField.initString("");
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
}
