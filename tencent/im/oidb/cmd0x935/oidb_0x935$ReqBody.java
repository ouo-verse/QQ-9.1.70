package tencent.im.oidb.cmd0x935;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x935$ReqBody extends MessageMicro<oidb_0x935$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50, 56, 64, 74, 80}, new String[]{"uint32_appid", "uint32_pos", "msg_gps", "uint64_join_gc", "uint32_max_pos_count", "bytes_class_param", "uint64_black_gc", "uint32_is_new", "msg_notify_info", "uint32_group_memo_type"}, new Object[]{0, 0, null, 0L, 0, ByteStringMicro.EMPTY, 0L, 0, null, 0}, oidb_0x935$ReqBody.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pos = PBField.initUInt32(0);
    public oidb_0x935$GPS msg_gps = new MessageMicro<oidb_0x935$GPS>() { // from class: tencent.im.oidb.cmd0x935.oidb_0x935$GPS
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 72}, new String[]{"uint32_latitude", "uint32_longitude", "uint32_altitude", "uint32_accuracy", "uint32_time", "uint32_flag", "uint32_cityid", "bytes_client_version", "uint32_client"}, new Object[]{0, 0, 0, 0, 0, 0, 0, ByteStringMicro.EMPTY, 0}, oidb_0x935$GPS.class);
        public final PBUInt32Field uint32_latitude = PBField.initUInt32(0);
        public final PBUInt32Field uint32_longitude = PBField.initUInt32(0);
        public final PBUInt32Field uint32_altitude = PBField.initUInt32(0);
        public final PBUInt32Field uint32_accuracy = PBField.initUInt32(0);
        public final PBUInt32Field uint32_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_cityid = PBField.initUInt32(0);
        public final PBBytesField bytes_client_version = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_client = PBField.initUInt32(0);
    };
    public final PBUInt64Field uint64_join_gc = PBField.initUInt64(0);
    public final PBUInt32Field uint32_max_pos_count = PBField.initUInt32(0);
    public final PBBytesField bytes_class_param = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_black_gc = PBField.initUInt64(0);
    public final PBUInt32Field uint32_is_new = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x935$NotifyInfo> msg_notify_info = PBField.initRepeatMessage(oidb_0x935$NotifyInfo.class);
    public final PBUInt32Field uint32_group_memo_type = PBField.initUInt32(0);
}
