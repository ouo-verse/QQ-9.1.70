package tencent.im.oidb.cmd0x9fb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x9fb$RgroupInfo extends MessageMicro<oidb_0x9fb$RgroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_group_class_text;
    public final PBBytesField bytes_group_face_url;
    public final PBBytesField bytes_group_memo;
    public final PBBytesField bytes_group_name;
    public final PBBytesField bytes_recommend_reason;
    public final PBRepeatMessageField<oidb_0x9fb$Label> rpt_group_label;
    public final PBUInt32Field uint32_group_bitmap;
    public final PBUInt32Field uint32_group_class;
    public final PBUInt32Field uint32_group_face;
    public final PBUInt32Field uint32_group_flag;
    public final PBUInt32Field uint32_group_hot_degree;
    public final PBUInt32Field uint32_group_level;
    public final PBUInt32Field uint32_max_member_num;
    public final PBUInt32Field uint32_member_num;
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 56, 66, 74, 82, 88, 96, 104, 112, 120, 130}, new String[]{"uint64_group_code", "uint64_owner_uin", "bytes_group_name", "bytes_group_memo", "uint32_member_num", "uint32_group_face", "uint32_group_class", "bytes_group_face_url", "rpt_group_label", "bytes_group_class_text", "uint32_max_member_num", "uint32_group_level", "uint32_group_bitmap", "uint32_group_hot_degree", "uint32_group_flag", "bytes_recommend_reason"}, new Object[]{0L, 0L, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro, null, byteStringMicro, 0, 0, 0, 0, 0, byteStringMicro}, oidb_0x9fb$RgroupInfo.class);
    }

    public oidb_0x9fb$RgroupInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_group_name = PBField.initBytes(byteStringMicro);
        this.bytes_group_memo = PBField.initBytes(byteStringMicro);
        this.uint32_member_num = PBField.initUInt32(0);
        this.uint32_group_face = PBField.initUInt32(0);
        this.uint32_group_class = PBField.initUInt32(0);
        this.bytes_group_face_url = PBField.initBytes(byteStringMicro);
        this.rpt_group_label = PBField.initRepeatMessage(oidb_0x9fb$Label.class);
        this.bytes_group_class_text = PBField.initBytes(byteStringMicro);
        this.uint32_max_member_num = PBField.initUInt32(0);
        this.uint32_group_level = PBField.initUInt32(0);
        this.uint32_group_bitmap = PBField.initUInt32(0);
        this.uint32_group_hot_degree = PBField.initUInt32(0);
        this.uint32_group_flag = PBField.initUInt32(0);
        this.bytes_recommend_reason = PBField.initBytes(byteStringMicro);
    }
}
