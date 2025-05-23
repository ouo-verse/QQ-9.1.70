package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video_comm$UTime extends MessageMicro<hd_video_comm$UTime> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_time", "uint32_utime"}, new Object[]{0, 0}, hd_video_comm$UTime.class);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_utime = PBField.initUInt32(0);
}
