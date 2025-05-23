package tencent.im.oidb.cmd0x8b8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0x8b8$GroupPicListInfo extends MessageMicro<oidb_0x8b8$GroupPicListInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint32_pic_id", "uint32_left_x", "uint32_left_y", "uint32_right_x", "uint32_right_y"}, new Object[]{0, 0, 0, 0, 0}, oidb_0x8b8$GroupPicListInfo.class);
    public final PBUInt32Field uint32_pic_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_left_x = PBField.initUInt32(0);
    public final PBUInt32Field uint32_left_y = PBField.initUInt32(0);
    public final PBUInt32Field uint32_right_x = PBField.initUInt32(0);
    public final PBUInt32Field uint32_right_y = PBField.initUInt32(0);
}
