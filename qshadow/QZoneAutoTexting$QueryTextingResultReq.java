package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneAutoTexting$QueryTextingResultReq extends MessageMicro<QZoneAutoTexting$QueryTextingResultReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"textIds"}, new Object[]{""}, QZoneAutoTexting$QueryTextingResultReq.class);
    public final PBRepeatField<String> textIds = PBField.initRepeat(PBStringField.__repeatHelper__);
}
