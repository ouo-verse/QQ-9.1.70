package tencent.im.s2c.msgtype0x210.submsgtype0x14e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x14e$MsgBody extends MessageMicro<submsgtype0x14e$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "bytes_info"}, new Object[]{0, ByteStringMicro.EMPTY}, submsgtype0x14e$MsgBody.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBBytesField bytes_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
