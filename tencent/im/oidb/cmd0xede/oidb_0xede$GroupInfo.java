package tencent.im.oidb.cmd0xede;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xede$GroupInfo extends MessageMicro<oidb_0xede$GroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_join_group_auth;
    public final PBRepeatMessageField<oidb_0xede$Label> rpt_group_label;
    public final PBBytesField string_group_finger_memo;
    public final PBBytesField string_group_name;
    public final PBBytesField string_group_rich_finger_memo;
    public final PBUInt32Field uint32_group_face;
    public final PBUInt32Field uint32_is_conf_group;
    public final PBUInt32Field uint32_role;
    public final PBUInt32Field uint32_seq;
    public final PBUInt32Field uint32_status;
    public final PBUInt32Field uint32_type;
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_group_member_max_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_member_num = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56, 64, 74, 82, 90, 98, 104, 112}, new String[]{"uint64_group_code", "uint32_group_member_max_num", "uint32_group_member_num", "string_group_name", "uint32_status", "uint32_type", "uint32_role", "uint32_seq", "bytes_join_group_auth", "rpt_group_label", "string_group_finger_memo", "string_group_rich_finger_memo", "uint32_group_face", "uint32_is_conf_group"}, new Object[]{0L, 0, 0, byteStringMicro, 0, 0, 0, 0, byteStringMicro, null, byteStringMicro, byteStringMicro, 0, 0}, oidb_0xede$GroupInfo.class);
    }

    public oidb_0xede$GroupInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.string_group_name = PBField.initBytes(byteStringMicro);
        this.uint32_status = PBField.initUInt32(0);
        this.uint32_type = PBField.initUInt32(0);
        this.uint32_role = PBField.initUInt32(0);
        this.uint32_seq = PBField.initUInt32(0);
        this.bytes_join_group_auth = PBField.initBytes(byteStringMicro);
        this.rpt_group_label = PBField.initRepeatMessage(oidb_0xede$Label.class);
        this.string_group_finger_memo = PBField.initBytes(byteStringMicro);
        this.string_group_rich_finger_memo = PBField.initBytes(byteStringMicro);
        this.uint32_group_face = PBField.initUInt32(0);
        this.uint32_is_conf_group = PBField.initUInt32(0);
    }
}
