package tencent.im.s2c.msgtype0x210.submsgtype0x78;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x78$MsgBody extends MessageMicro<submsgtype0x78$MsgBody> {
    public static final int UINT32_TYPE_FIELD_NUMBER = 1;
    public static final int UINT32_VERSION_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_type", "uint32_version"}, new Object[]{0, 0}, submsgtype0x78$MsgBody.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
}
