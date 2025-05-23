package tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class mutualmark$MutualmarkInfo extends MessageMicro<mutualmark$MutualmarkInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_duplicate_removal_key;
    public final PBBytesField bytes_grade_resource_info;
    public final PBBytesField bytes_resource_info;
    public final PBBytesField bytes_wildcard_wording;
    public final PBBoolField is_wearing;
    public final PBUInt32Field mark_version;
    public final PBUInt32Field uint32_close_flag;
    public final PBUInt32Field uint32_graytip_type;
    public final PBUInt64Field uint64_icon_status;
    public final PBUInt64Field uint64_icon_status_end_time;
    public final PBUInt64Field uint64_notify_time;
    public final PBUInt64Field uint64_sub_level;
    public final PBUInt64Field uint64_last_action_time = PBField.initUInt64(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt64Field uint64_last_change_time = PBField.initUInt64(0);
    public final PBUInt32Field uint32_continue_days = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64, 72, 82, 88, 96, 106, 112, 120, 8002}, new String[]{"uint64_last_action_time", "uint32_level", "uint64_last_change_time", "uint32_continue_days", "bytes_wildcard_wording", "uint64_notify_time", "uint64_icon_status", "uint64_icon_status_end_time", "uint32_close_flag", "bytes_resource_info", "uint32_graytip_type", "uint64_sub_level", "bytes_grade_resource_info", "mark_version", "is_wearing", "bytes_duplicate_removal_key"}, new Object[]{0L, 0, 0L, 0, byteStringMicro, 0L, 0L, 0L, 0, byteStringMicro, 0, 0L, byteStringMicro, 0, Boolean.FALSE, byteStringMicro}, mutualmark$MutualmarkInfo.class);
    }

    public mutualmark$MutualmarkInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_wildcard_wording = PBField.initBytes(byteStringMicro);
        this.uint64_notify_time = PBField.initUInt64(0L);
        this.uint64_icon_status = PBField.initUInt64(0L);
        this.uint64_icon_status_end_time = PBField.initUInt64(0L);
        this.uint32_close_flag = PBField.initUInt32(0);
        this.bytes_resource_info = PBField.initBytes(byteStringMicro);
        this.uint32_graytip_type = PBField.initUInt32(0);
        this.uint64_sub_level = PBField.initUInt64(0L);
        this.bytes_grade_resource_info = PBField.initBytes(byteStringMicro);
        this.mark_version = PBField.initUInt32(0);
        this.is_wearing = PBField.initBool(false);
        this.bytes_duplicate_removal_key = PBField.initBytes(byteStringMicro);
    }
}
