package tencent.im.oidb.cmd0xec4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xec4$ReqBody extends MessageMicro<oidb_0xec4$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"uint64_uin", "uint64_quest_num", "uint64_comment_num", "bytes_cookie", "uint32_fetch_type"}, new Object[]{0L, 0L, 0L, ByteStringMicro.EMPTY, 0}, oidb_0xec4$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_quest_num = PBField.initUInt64(0);
    public final PBUInt64Field uint64_comment_num = PBField.initUInt64(0);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_fetch_type = PBField.initUInt32(0);
}
