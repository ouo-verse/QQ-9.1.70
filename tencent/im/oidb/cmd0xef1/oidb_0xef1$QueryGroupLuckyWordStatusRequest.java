package tencent.im.oidb.cmd0xef1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xef1$QueryGroupLuckyWordStatusRequest extends MessageMicro<oidb_0xef1$QueryGroupLuckyWordStatusRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"group_code"}, new Object[]{0L}, oidb_0xef1$QueryGroupLuckyWordStatusRequest.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
}
