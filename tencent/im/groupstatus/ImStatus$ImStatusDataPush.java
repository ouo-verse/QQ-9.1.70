package tencent.im.groupstatus;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class ImStatus$ImStatusDataPush extends MessageMicro<ImStatus$ImStatusDataPush> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_imei;
    public final PBBytesField bytes_key;
    public final PBBytesField bytes_music_info;
    public final PBInt32Field int32_battery_status;
    public final PBUInt32Field uint32_ext_online_status;
    public final PBUInt32Field uint32_flag;
    public final PBUInt32Field uint32_music_info_refresh;
    public final PBUInt32Field uint32_rs_refresh;
    public final PBUInt32Field uint32_rs_seq;
    public final PBUInt32Field uint32_sub_flag;
    public final PBUInt32Field uint32_sub_state;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ptl = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 64, 72, 80, 88, 96, 106, 112, 120, 130, 136}, new String[]{"uint64_uin", "uint32_type", "uint32_ip", "uint32_port", "uint32_status", "uint32_ptl", "bytes_key", "uint32_flag", "uint32_rs_seq", "uint32_rs_refresh", "uint32_sub_state", "uint32_sub_flag", "bytes_imei", "uint32_ext_online_status", "int32_battery_status", "bytes_music_info", "uint32_music_info_refresh"}, new Object[]{0L, 0, 0, 0, 0, 0, byteStringMicro, 0, 0, 0, 0, 0, byteStringMicro, 0, 0, byteStringMicro, 0}, ImStatus$ImStatusDataPush.class);
    }

    public ImStatus$ImStatusDataPush() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_key = PBField.initBytes(byteStringMicro);
        this.uint32_flag = PBField.initUInt32(0);
        this.uint32_rs_seq = PBField.initUInt32(0);
        this.uint32_rs_refresh = PBField.initUInt32(0);
        this.uint32_sub_state = PBField.initUInt32(0);
        this.uint32_sub_flag = PBField.initUInt32(0);
        this.bytes_imei = PBField.initBytes(byteStringMicro);
        this.uint32_ext_online_status = PBField.initUInt32(0);
        this.int32_battery_status = PBField.initInt32(0);
        this.bytes_music_info = PBField.initBytes(byteStringMicro);
        this.uint32_music_info_refresh = PBField.initUInt32(0);
    }
}
