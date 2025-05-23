package tencent.im.s2c.msgtype0x210.submsgtype0x15d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class SubMsgType0x15d$PCSupportInfo extends MessageMicro<SubMsgType0x15d$PCSupportInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"is_pc", "support_dataline", "support_print", "support_view_pc_file", "pc_version"}, new Object[]{0, 0, 0, 0, 0}, SubMsgType0x15d$PCSupportInfo.class);
    public final PBUInt32Field is_pc = PBField.initUInt32(0);
    public final PBUInt32Field support_dataline = PBField.initUInt32(0);
    public final PBUInt32Field support_print = PBField.initUInt32(0);
    public final PBUInt32Field support_view_pc_file = PBField.initUInt32(0);
    public final PBUInt32Field pc_version = PBField.initUInt32(0);
}
