package tencent.im.oidb.cmd0xe09;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe09$reqItem extends MessageMicro<oidb_0xe09$reqItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "bytes_sig"}, new Object[]{0L, ByteStringMicro.EMPTY}, oidb_0xe09$reqItem.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
}
