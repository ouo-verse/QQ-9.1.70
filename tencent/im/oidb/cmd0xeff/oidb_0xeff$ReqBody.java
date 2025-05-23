package tencent.im.oidb.cmd0xeff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeff$ReqBody extends MessageMicro<oidb_0xeff$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"cmd", "group_code", "word_id"}, new Object[]{0, 0L, 0L}, oidb_0xeff$ReqBody.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field word_id = PBField.initUInt64(0);
}
