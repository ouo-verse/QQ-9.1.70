package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xac7$RspBody extends MessageMicro<cmd0xac7$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_extd"}, new Object[]{ByteStringMicro.EMPTY}, cmd0xac7$RspBody.class);
    public final PBBytesField bytes_extd = PBField.initBytes(ByteStringMicro.EMPTY);
}
