package tencent.im.oidb.cmd0x1122;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x1122$ClientExtention extends MessageMicro<oidb_0x1122$ClientExtention> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_permission"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0x1122$ClientExtention.class);
    public final PBBytesField bytes_permission = PBField.initBytes(ByteStringMicro.EMPTY);
}
