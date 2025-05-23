package tencent.im.oidb.cmd0x74f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x74f$ReqBody extends MessageMicro<oidb_cmd0x74f$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_group_code"}, new Object[]{0L}, oidb_cmd0x74f$ReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
}
