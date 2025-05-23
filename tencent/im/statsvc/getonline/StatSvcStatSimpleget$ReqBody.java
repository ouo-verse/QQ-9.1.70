package tencent.im.statsvc.getonline;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class StatSvcStatSimpleget$ReqBody extends MessageMicro<StatSvcStatSimpleget$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"rept_bind_qq", "int32_battrey_status"}, new Object[]{0L, 0}, StatSvcStatSimpleget$ReqBody.class);
    public final PBRepeatField<Long> rept_bind_qq = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBInt32Field int32_battrey_status = PBField.initInt32(0);
}
