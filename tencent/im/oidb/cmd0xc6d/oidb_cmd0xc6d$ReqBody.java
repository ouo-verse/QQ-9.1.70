package tencent.im.oidb.cmd0xc6d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc6d$ReqBody extends MessageMicro<oidb_cmd0xc6d$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 88}, new String[]{"bytes_row_key", "uint64_client_switchs"}, new Object[]{ByteStringMicro.EMPTY, 0L}, oidb_cmd0xc6d$ReqBody.class);
    public final PBBytesField bytes_row_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_client_switchs = PBField.initUInt64(0);
}
