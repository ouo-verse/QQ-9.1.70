package tencent.im.oidb.cmd0x8fc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x8fc$RspBody extends MessageMicro<Oidb_0x8fc$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_group_code", "strErrInfo", "bytes_cool_group_card_rsp"}, new Object[]{0L, "", ByteStringMicro.EMPTY}, Oidb_0x8fc$RspBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBStringField strErrInfo = PBField.initString("");
    public final PBBytesField bytes_cool_group_card_rsp = PBField.initBytes(ByteStringMicro.EMPTY);
}
