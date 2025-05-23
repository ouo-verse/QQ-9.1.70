package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video_putinfo$MobileHardWareValue extends MessageMicro<hd_video_putinfo$MobileHardWareValue> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_mobile_cpu_struct", "uint32_mobile_cpu_number", "uint32_mobile_cpu_hertz", "uint32_mobile_camera_turn"}, new Object[]{0, 0, 0, 0}, hd_video_putinfo$MobileHardWareValue.class);
    public final PBUInt32Field uint32_mobile_cpu_struct = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_cpu_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_cpu_hertz = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_camera_turn = PBField.initUInt32(0);
}
