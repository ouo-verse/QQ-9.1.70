package tencent.im.oidb.cmd0xe82;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe82$RspBody extends MessageMicro<cmd0xe82$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48}, new String[]{"cache_ts", "disabled", "app", "group_disabled", "redpoint_cache_ts", "switch_ts"}, new Object[]{0, 0, null, 0, 0, 0L}, cmd0xe82$RspBody.class);
    public final PBUInt32Field cache_ts = PBField.initUInt32(0);
    public final PBUInt32Field disabled = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0xe82$App> app = PBField.initRepeatMessage(cmd0xe82$App.class);
    public final PBUInt32Field group_disabled = PBField.initUInt32(0);
    public final PBUInt32Field redpoint_cache_ts = PBField.initUInt32(0);
    public final PBUInt64Field switch_ts = PBField.initUInt64(0);
}
