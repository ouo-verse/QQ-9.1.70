package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc26$RgroupInfo extends MessageMicro<oidb_0xc26$RgroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_algorithm;
    public final PBBytesField bytes_group_memo;
    public final PBBytesField bytes_group_name;
    public final PBBytesField bytes_join_group_auth;
    public final PBInt32Field int32_uin_privilege;
    public final PBRepeatMessageField<oidb_0xc26$RgoupLabel> rpt_group_label;
    public final PBEnumField source;
    public oidb_0xc26$RgoupLabel tag_wording;
    public final PBUInt32Field uint32_activity;
    public final PBUInt32Field uint32_group_flag;
    public final PBUInt32Field uint32_group_flag_ext;
    public final PBUInt32Field uint32_member_max_num;
    public final PBUInt32Field uint32_member_num;
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 56, 64, 72, 82, 90, 98, 104, 112, 120}, new String[]{"uint64_group_code", "uint64_owner_uin", "bytes_group_name", "bytes_group_memo", "uint32_member_num", "rpt_group_label", "uint32_group_flag_ext", "uint32_group_flag", "source", "tag_wording", "bytes_algorithm", "bytes_join_group_auth", "uint32_activity", "uint32_member_max_num", "int32_uin_privilege"}, new Object[]{0L, 0L, byteStringMicro, byteStringMicro, 0, null, 0, 0, 1, null, byteStringMicro, byteStringMicro, 0, 0, 0}, oidb_0xc26$RgroupInfo.class);
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [tencent.im.oidb.oidb_0xc26$RgoupLabel] */
    public oidb_0xc26$RgroupInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_group_name = PBField.initBytes(byteStringMicro);
        this.bytes_group_memo = PBField.initBytes(byteStringMicro);
        this.uint32_member_num = PBField.initUInt32(0);
        this.rpt_group_label = PBField.initRepeatMessage(oidb_0xc26$RgoupLabel.class);
        this.uint32_group_flag_ext = PBField.initUInt32(0);
        this.uint32_group_flag = PBField.initUInt32(0);
        this.source = PBField.initEnum(1);
        this.tag_wording = new MessageMicro<oidb_0xc26$RgoupLabel>() { // from class: tencent.im.oidb.oidb_0xc26$RgoupLabel
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48}, new String[]{"bytes_name", "enum_type", "text_color", "edging_color", "uint32_label_attr", "uint32_label_type"}, new Object[]{ByteStringMicro.EMPTY, 1, null, null, 0, 0}, oidb_0xc26$RgoupLabel.class);
            public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBEnumField enum_type = PBField.initEnum(1);
            public oidb_0xc26$RgroupColor text_color = new MessageMicro<oidb_0xc26$RgroupColor>() { // from class: tencent.im.oidb.oidb_0xc26$RgroupColor
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_r", "uint32_g", "uint32_b"}, new Object[]{0, 0, 0}, oidb_0xc26$RgroupColor.class);
                public final PBUInt32Field uint32_r = PBField.initUInt32(0);
                public final PBUInt32Field uint32_g = PBField.initUInt32(0);
                public final PBUInt32Field uint32_b = PBField.initUInt32(0);
            };
            public oidb_0xc26$RgroupColor edging_color = new MessageMicro<oidb_0xc26$RgroupColor>() { // from class: tencent.im.oidb.oidb_0xc26$RgroupColor
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_r", "uint32_g", "uint32_b"}, new Object[]{0, 0, 0}, oidb_0xc26$RgroupColor.class);
                public final PBUInt32Field uint32_r = PBField.initUInt32(0);
                public final PBUInt32Field uint32_g = PBField.initUInt32(0);
                public final PBUInt32Field uint32_b = PBField.initUInt32(0);
            };
            public final PBUInt32Field uint32_label_attr = PBField.initUInt32(0);
            public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
        };
        this.bytes_algorithm = PBField.initBytes(byteStringMicro);
        this.bytes_join_group_auth = PBField.initBytes(byteStringMicro);
        this.uint32_activity = PBField.initUInt32(0);
        this.uint32_member_max_num = PBField.initUInt32(0);
        this.int32_uin_privilege = PBField.initInt32(0);
    }
}
