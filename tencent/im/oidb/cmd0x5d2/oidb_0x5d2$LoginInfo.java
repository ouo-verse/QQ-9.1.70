package tencent.im.oidb.cmd0x5d2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x5d2$LoginInfo extends MessageMicro<oidb_0x5d2$LoginInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"id", "name"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0x5d2$LoginInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f435974id = PBField.initUInt32(0);
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
}
