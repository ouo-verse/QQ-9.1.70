package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class hd_video_comm$ClientConnectInterfaceRetryParam extends MessageMicro<hd_video_comm$ClientConnectInterfaceRetryParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_retry_time", "uint32_timeout", "uint32_send_interval"}, new Object[]{0, 0, 0}, hd_video_comm$ClientConnectInterfaceRetryParam.class);
    public final PBUInt32Field uint32_retry_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timeout = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_interval = PBField.initUInt32(0);
}
