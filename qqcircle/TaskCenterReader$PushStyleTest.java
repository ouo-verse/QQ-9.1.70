package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class TaskCenterReader$PushStyleTest extends MessageMicro<TaskCenterReader$PushStyleTest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"adtestID", "isHitABTest"}, new Object[]{"", Boolean.FALSE}, TaskCenterReader$PushStyleTest.class);
    public final PBStringField adtestID = PBField.initString("");
    public final PBBoolField isHitABTest = PBField.initBool(false);
}
