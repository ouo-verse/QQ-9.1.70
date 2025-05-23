package tencent.im.oidb.cmd0x8f1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8f1$ReqBody extends MessageMicro<oidb_0x8f1$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint32_req_num", "bytes_label_cookie", "uint64_req_uin", "uint64_label_id"}, new Object[]{0, ByteStringMicro.EMPTY, 0L, 0L}, oidb_0x8f1$ReqBody.class);
    public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
    public final PBBytesField bytes_label_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_req_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_label_id = PBField.initUInt64(0);
}
