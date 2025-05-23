package tencent.im.oidb.cmd0xdc0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xdc0$GroupInfo extends MessageMicro<oidb_0xdc0$GroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 90}, new String[]{"bytes_name", "uint32_order", "rpt_location_list"}, new Object[]{ByteStringMicro.EMPTY, 0, null}, oidb_0xdc0$GroupInfo.class);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_order = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xdc0$LocationInfo> rpt_location_list = PBField.initRepeatMessage(oidb_0xdc0$LocationInfo.class);
}
