package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video_putinfo$VideoHardWareInfo extends MessageMicro<hd_video_putinfo$VideoHardWareInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_mobile_max_encodeframe", "uint32_mobile_max_decodeframe", "uint32_mobile_width", "uint32_mobile_height"}, new Object[]{0, 0, 0, 0}, hd_video_putinfo$VideoHardWareInfo.class);
    public final PBUInt32Field uint32_mobile_max_encodeframe = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_max_decodeframe = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_height = PBField.initUInt32(0);
}
