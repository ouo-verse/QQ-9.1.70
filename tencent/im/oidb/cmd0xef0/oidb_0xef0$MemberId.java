package tencent.im.oidb.cmd0xef0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xef0$MemberId extends MessageMicro<oidb_0xef0$MemberId> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"member_uin", "member_uid"}, new Object[]{0L, ByteStringMicro.EMPTY}, oidb_0xef0$MemberId.class);
    public final PBUInt64Field member_uin = PBField.initUInt64(0);
    public final PBBytesField member_uid = PBField.initBytes(ByteStringMicro.EMPTY);
}
