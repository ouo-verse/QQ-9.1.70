package tencent.im.s2c.msgtype0x210.submsgtype0x13a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x13a$SystemNotify extends MessageMicro<submsgtype0x13a$SystemNotify> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_custom_sound;
    public final PBBytesField bytes_extend_content;
    public PBBytesField bytes_msg_summary;
    public final PBBytesField bytes_msg_title;
    public final PBUInt32Field uint32_admn_flag;
    public final PBUInt32Field uint32_count_flag;
    public final PBUInt32Field uint32_filter_flag;
    public final PBUInt32Field uint32_filter_version;
    public final PBUInt32Field uint32_filter_version_upperlimit;
    public final PBUInt32Field uint32_filter_version_upperlimit_flag;
    public final PBUInt32Field uint32_ignore_pc_active;
    public final PBUInt32Field uint32_ignore_without_content;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48, 56, 64, 74, 80, 88, 98}, new String[]{"bytes_msg_summary", "uint32_filter_flag", "bytes_extend_content", "uint32_ignore_pc_active", "uint32_filter_version", "uint32_count_flag", "uint32_filter_version_upperlimit_flag", "uint32_filter_version_upperlimit", "bytes_custom_sound", "uint32_admn_flag", "uint32_ignore_without_content", "bytes_msg_title"}, new Object[]{byteStringMicro, 0, byteStringMicro, 0, 0, 0, 0, 0, byteStringMicro, 0, 0, byteStringMicro}, submsgtype0x13a$SystemNotify.class);
    }

    public submsgtype0x13a$SystemNotify() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_msg_summary = PBField.initBytes(byteStringMicro);
        this.uint32_filter_flag = PBField.initUInt32(0);
        this.bytes_extend_content = PBField.initBytes(byteStringMicro);
        this.uint32_ignore_pc_active = PBField.initUInt32(0);
        this.uint32_filter_version = PBField.initUInt32(0);
        this.uint32_count_flag = PBField.initUInt32(0);
        this.uint32_filter_version_upperlimit_flag = PBField.initUInt32(0);
        this.uint32_filter_version_upperlimit = PBField.initUInt32(0);
        this.bytes_custom_sound = PBField.initBytes(byteStringMicro);
        this.uint32_admn_flag = PBField.initUInt32(0);
        this.uint32_ignore_without_content = PBField.initUInt32(0);
        this.bytes_msg_title = PBField.initBytes(byteStringMicro);
    }
}
