package tencent.im.oidb.cmd0x8b2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8b2$RspBody extends MessageMicro<oidb_0x8b2$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField string_group_memo;
    public final PBBytesField string_hot_group_id;
    public final PBBytesField string_jumping_url;
    public final PBRepeatField<Long> uint64_administrator_uin;
    public final PBUInt64Field uint64_group_code;
    public final PBUInt64Field uint64_modify_time;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48}, new String[]{"string_hot_group_id", "uint64_administrator_uin", "string_group_memo", "string_jumping_url", "uint64_modify_time", "uint64_group_code"}, new Object[]{byteStringMicro, 0L, byteStringMicro, byteStringMicro, 0L, 0L}, oidb_0x8b2$RspBody.class);
    }

    public oidb_0x8b2$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.string_hot_group_id = PBField.initBytes(byteStringMicro);
        this.uint64_administrator_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        this.string_group_memo = PBField.initBytes(byteStringMicro);
        this.string_jumping_url = PBField.initBytes(byteStringMicro);
        this.uint64_modify_time = PBField.initUInt64(0L);
        this.uint64_group_code = PBField.initUInt64(0L);
    }
}
