package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRead$CertificationDetailV2 extends MessageMicro<QQCircleRead$CertificationDetailV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"circleType", "circleStatue", "studentInfo", "staffInfo"}, new Object[]{0, 0, null, null}, QQCircleRead$CertificationDetailV2.class);
    public final PBInt32Field circleType = PBField.initInt32(0);
    public final PBInt32Field circleStatue = PBField.initInt32(0);
    public QQCircleBase$StudentInfo studentInfo = new QQCircleBase$StudentInfo();
    public QQCircleBase$StaffInfo staffInfo = new QQCircleBase$StaffInfo();
}
