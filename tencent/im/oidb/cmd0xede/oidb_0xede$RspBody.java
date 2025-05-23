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
public final class oidb_0xede$RspBody extends MessageMicro<oidb_0xede$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<oidb_0xede$GroupInfo> rpt_group_info;
    public final PBBytesField str_alliance_admin_name;
    public final PBBytesField str_err_msg;
    public final PBUInt32Field uint32_group_info_size;
    public final PBUInt64Field uint64_alliance_admin_uin;
    public final PBUInt64Field uint64_alliance_create_time;
    public final PBUInt64Field uint64_alliance_id;
    public final PBUInt64Field uint64_next_group_code;
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 56, 64, 72, 82, 88}, new String[]{"uint64_group_code", "uint32_type", "uint32_result", "str_err_msg", "rpt_group_info", "uint64_next_group_code", "uint32_group_info_size", "uint64_alliance_id", "uint64_alliance_admin_uin", "str_alliance_admin_name", "uint64_alliance_create_time"}, new Object[]{0L, 0, 0, byteStringMicro, null, 0L, 0, 0L, 0L, byteStringMicro, 0L}, oidb_0xede$RspBody.class);
    }

    public oidb_0xede$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.str_err_msg = PBField.initBytes(byteStringMicro);
        this.rpt_group_info = PBField.initRepeatMessage(oidb_0xede$GroupInfo.class);
        this.uint64_next_group_code = PBField.initUInt64(0L);
        this.uint32_group_info_size = PBField.initUInt32(0);
        this.uint64_alliance_id = PBField.initUInt64(0L);
        this.uint64_alliance_admin_uin = PBField.initUInt64(0L);
        this.str_alliance_admin_name = PBField.initBytes(byteStringMicro);
        this.uint64_alliance_create_time = PBField.initUInt64(0L);
    }
}
