package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRight$SyncBlacklistReq extends MessageMicro<QQCircleRight$SyncBlacklistReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"source", "uin", QCircleDaTongConstant.ElementParamValue.OPERATION}, new Object[]{0, 0L, 0}, QQCircleRight$SyncBlacklistReq.class);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field operation = PBField.initUInt32(0);
}
