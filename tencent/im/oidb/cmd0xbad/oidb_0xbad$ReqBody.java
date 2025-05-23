package tencent.im.oidb.cmd0xbad;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xbad$ReqBody extends MessageMicro<oidb_0xbad$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint64_appid", "bytes_openid", "uint64_uin"}, new Object[]{0L, ByteStringMicro.EMPTY, 0L}, oidb_0xbad$ReqBody.class);
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0);
    public final PBBytesField bytes_openid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
}
