package tencent.im.oidb.cmd0x9d0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x9d0$ReqBody extends MessageMicro<oidb_0x9d0$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint64_req_uid", "uint32_feed_num", "bytes_cookie", "uint64_req_uin"}, new Object[]{0L, 0, ByteStringMicro.EMPTY, 0L}, oidb_0x9d0$ReqBody.class);
    public final PBUInt64Field uint64_req_uid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_feed_num = PBField.initUInt32(0);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_req_uin = PBField.initUInt64(0);
}
