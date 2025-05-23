package tencent.im.oidb.cmd0x1122;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x1122$SNSUpdateResult extends MessageMicro<oidb_0x1122$SNSUpdateResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "result"}, new Object[]{0L, 0}, oidb_0x1122$SNSUpdateResult.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
}
