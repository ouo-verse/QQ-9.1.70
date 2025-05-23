package tencent.im.s2c.msgtype0x210.security;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class S2cSafeInfo$SafeCheckInfo extends MessageMicro<S2cSafeInfo$SafeCheckInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field safe_code = PBField.initUInt32(0);
    public final PBBytesField safe_str;
    public final PBBytesField safe_url;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"safe_code", "safe_url", "safe_str"}, new Object[]{0, byteStringMicro, byteStringMicro}, S2cSafeInfo$SafeCheckInfo.class);
    }

    public S2cSafeInfo$SafeCheckInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.safe_url = PBField.initBytes(byteStringMicro);
        this.safe_str = PBField.initBytes(byteStringMicro);
    }
}
