package tencent.im.oidb.cmd0x8b3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8b3$RspBody extends MessageMicro<oidb_0x8b3$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"string_hot_group_id"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0x8b3$RspBody.class);
    public final PBBytesField string_hot_group_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
