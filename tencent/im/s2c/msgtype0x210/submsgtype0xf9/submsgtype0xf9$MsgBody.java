package tencent.im.s2c.msgtype0x210.submsgtype0xf9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xf9$MsgBody extends MessageMicro<submsgtype0xf9$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_zip_AdInfo"}, new Object[]{ByteStringMicro.EMPTY}, submsgtype0xf9$MsgBody.class);
    public final PBBytesField bytes_zip_AdInfo = PBField.initBytes(ByteStringMicro.EMPTY);
}
