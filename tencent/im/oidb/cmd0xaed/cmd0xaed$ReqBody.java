package tencent.im.oidb.cmd0xaed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xaed$ReqBody extends MessageMicro<cmd0xaed$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_qq_uin", "rpt_uint64_add_qim_uins"}, new Object[]{0L, 0L}, cmd0xaed$ReqBody.class);
    public final PBUInt64Field uint64_qq_uin = PBField.initUInt64(0);
    public final PBRepeatField<Long> rpt_uint64_add_qim_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
