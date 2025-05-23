package tencent.im.oidb.cmd0x508;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x508$ReqBody extends MessageMicro<oidb_0x508$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_uint64_update_seq"}, new Object[]{0L}, oidb_0x508$ReqBody.class);
    public final PBUInt64Field rpt_uint64_update_seq = PBField.initUInt64(0);
}
