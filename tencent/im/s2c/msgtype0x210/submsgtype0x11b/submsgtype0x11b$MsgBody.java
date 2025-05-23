package tencent.im.s2c.msgtype0x210.submsgtype0x11b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x11b$MsgBody extends MessageMicro<submsgtype0x11b$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_qr_sig", "enum_biz_type"}, new Object[]{ByteStringMicro.EMPTY, 1}, submsgtype0x11b$MsgBody.class);
    public final PBBytesField bytes_qr_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_biz_type = PBField.initEnum(1);
}
