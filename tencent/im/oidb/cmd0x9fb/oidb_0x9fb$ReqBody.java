package tencent.im.oidb.cmd0x9fb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x9fb$ReqBody extends MessageMicro<oidb_0x9fb$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48}, new String[]{"uint32_appid", "uint32_cmdid", "int32_channel", "uint64_last_group_code", "msg_group_label", "uint32_reason"}, new Object[]{0, 0, 0, 0L, null, 0}, oidb_0x9fb$ReqBody.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cmdid = PBField.initUInt32(0);
    public final PBInt32Field int32_channel = PBField.initInt32(0);
    public final PBUInt64Field uint64_last_group_code = PBField.initUInt64(0);
    public oidb_0x9fb$GroupLabel msg_group_label = new MessageMicro<oidb_0x9fb$GroupLabel>() { // from class: tencent.im.oidb.cmd0x9fb.oidb_0x9fb$GroupLabel
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"uin_info", "uint32_number_label", "uint32_label_style"}, new Object[]{null, 5, 0}, oidb_0x9fb$GroupLabel.class);
        public oidb_0x9fb$UinInfo uin_info = new MessageMicro<oidb_0x9fb$UinInfo>() { // from class: tencent.im.oidb.cmd0x9fb.oidb_0x9fb$UinInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int64_longitude", "int64_latitude"}, new Object[]{0L, 0L}, oidb_0x9fb$UinInfo.class);
            public final PBInt64Field int64_longitude = PBField.initInt64(0);
            public final PBInt64Field int64_latitude = PBField.initInt64(0);
        };
        public final PBUInt32Field uint32_number_label = PBField.initUInt32(5);
        public final PBUInt32Field uint32_label_style = PBField.initUInt32(0);
    };
    public final PBUInt32Field uint32_reason = PBField.initUInt32(0);
}
