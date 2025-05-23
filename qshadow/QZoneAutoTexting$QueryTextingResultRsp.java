package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneAutoTexting$QueryTextingResultRsp extends MessageMicro<QZoneAutoTexting$QueryTextingResultRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"textInfos"}, new Object[]{null}, QZoneAutoTexting$QueryTextingResultRsp.class);
    public final PBRepeatMessageField<QZoneAutoTexting$TextInfo> textInfos = PBField.initRepeatMessage(QZoneAutoTexting$TextInfo.class);
}
