package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8dd$LBSInfo extends MessageMicro<oidb_0x8dd$LBSInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_location"}, new Object[]{null}, oidb_0x8dd$LBSInfo.class);
    public oidb_0x8dd$Location msg_location = new MessageMicro<oidb_0x8dd$Location>() { // from class: tencent.im.oidb.cmd0x8dd.oidb_0x8dd$Location
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"int32_latitude", "int32_longitude", "int32_coordinate"}, new Object[]{0, 0, 0}, oidb_0x8dd$Location.class);
        public final PBInt32Field int32_latitude = PBField.initInt32(0);
        public final PBInt32Field int32_longitude = PBField.initInt32(0);
        public final PBInt32Field int32_coordinate = PBField.initInt32(0);
    };
}
