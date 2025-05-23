package tencent.im.oidb.cmd0x777;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x777$ClientExtention extends MessageMicro<cmd0x777$ClientExtention> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_permission"}, new Object[]{ByteStringMicro.EMPTY}, cmd0x777$ClientExtention.class);
    public final PBBytesField bytes_permission = PBField.initBytes(ByteStringMicro.EMPTY);
}
