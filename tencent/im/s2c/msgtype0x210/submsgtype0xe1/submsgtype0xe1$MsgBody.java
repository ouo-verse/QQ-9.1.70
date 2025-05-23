package tencent.im.s2c.msgtype0x210.submsgtype0xe1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xe1$MsgBody extends MessageMicro<submsgtype0xe1$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_push_ext"}, new Object[]{ByteStringMicro.EMPTY}, submsgtype0xe1$MsgBody.class);
    public final PBBytesField bytes_push_ext = PBField.initBytes(ByteStringMicro.EMPTY);
}
