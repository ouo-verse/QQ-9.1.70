package tencent.im.oidb.cmd0x777;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x777$ReqBody extends MessageMicro<cmd0x777$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 58, 64}, new String[]{"bytes_msg", "uint32_source_id", "uint32_sub_source_id", "rpt_uint64_uin", "uint64_group_uin", "uint32_friend_group", "bytes_client_ext", "uint32_no_remark"}, new Object[]{"", 0, 0, 0L, 0L, 0, ByteStringMicro.EMPTY, 0}, cmd0x777$ReqBody.class);
    public final PBStringField bytes_msg = PBField.initString("");
    public final PBUInt32Field uint32_source_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_source_id = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_friend_group = PBField.initUInt32(0);
    public final PBBytesField bytes_client_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_no_remark = PBField.initUInt32(0);
}
