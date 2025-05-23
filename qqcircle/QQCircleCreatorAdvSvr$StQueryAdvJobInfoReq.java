package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCreatorAdvSvr$StQueryAdvJobInfoReq extends MessageMicro<QQCircleCreatorAdvSvr$StQueryAdvJobInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"jobID", "jobType", "bizID"}, new Object[]{0L, 0, ""}, QQCircleCreatorAdvSvr$StQueryAdvJobInfoReq.class);
    public final PBInt64Field jobID = PBField.initInt64(0);
    public final PBInt32Field jobType = PBField.initInt32(0);
    public final PBStringField bizID = PBField.initString("");
}
