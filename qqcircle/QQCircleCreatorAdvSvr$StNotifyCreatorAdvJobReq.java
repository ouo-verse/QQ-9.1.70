package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCreatorAdvSvr$StNotifyCreatorAdvJobReq extends MessageMicro<QQCircleCreatorAdvSvr$StNotifyCreatorAdvJobReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"jobID", "uid", "detail"}, new Object[]{0L, "", null}, QQCircleCreatorAdvSvr$StNotifyCreatorAdvJobReq.class);
    public final PBInt64Field jobID = PBField.initInt64(0);
    public final PBStringField uid = PBField.initString("");
    public QQCircleCreatorAdvSvr$AdvJobDetail detail = new QQCircleCreatorAdvSvr$AdvJobDetail();
}
