package tencent.im.oidb.cmd0x972;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x972$RspBody extends MessageMicro<oidb_0x972$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"item_groups", "is_end", "cookie"}, new Object[]{null, 0, ByteStringMicro.EMPTY}, oidb_0x972$RspBody.class);
    public final PBRepeatMessageField<oidb_0x972$ResultItemGroup> item_groups = PBField.initRepeatMessage(oidb_0x972$ResultItemGroup.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
