package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xccd$RspBody extends MessageMicro<oidb_0xccd$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"errcode", "Results"}, new Object[]{0, null}, oidb_0xccd$RspBody.class);
    public final PBInt32Field errcode = PBField.initInt32(0);
    public final PBRepeatMessageField<oidb_0xccd$Result> Results = PBField.initRepeatMessage(oidb_0xccd$Result.class);
}
