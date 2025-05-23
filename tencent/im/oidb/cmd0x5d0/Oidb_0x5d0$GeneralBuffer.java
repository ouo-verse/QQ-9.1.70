package tencent.im.oidb.cmd0x5d0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x5d0$GeneralBuffer extends MessageMicro<Oidb_0x5d0$GeneralBuffer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_value"}, new Object[]{ByteStringMicro.EMPTY}, Oidb_0x5d0$GeneralBuffer.class);
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
}
