package tencent.im.oidb.cmd0x935;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x935$GroupLabel extends MessageMicro<oidb_0x935$GroupLabel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"uin_info", "uint32_number_label", "uint32_label_style"}, new Object[]{null, 5, 0}, oidb_0x935$GroupLabel.class);
    public oidb_0x935$UinInfo uin_info = new MessageMicro<oidb_0x935$UinInfo>() { // from class: tencent.im.oidb.cmd0x935.oidb_0x935$UinInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int64_longitude", "int64_latitude"}, new Object[]{0L, 0L}, oidb_0x935$UinInfo.class);
        public final PBInt64Field int64_longitude = PBField.initInt64(0);
        public final PBInt64Field int64_latitude = PBField.initInt64(0);
    };
    public final PBUInt32Field uint32_number_label = PBField.initUInt32(5);
    public final PBUInt32Field uint32_label_style = PBField.initUInt32(0);
}
