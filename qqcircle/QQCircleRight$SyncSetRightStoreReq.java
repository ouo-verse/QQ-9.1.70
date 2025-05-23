package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRight$SyncSetRightStoreReq extends MessageMicro<QQCircleRight$SyncSetRightStoreReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"opType", "key", "uid", "opTime"}, new Object[]{0, "", "", 0L}, QQCircleRight$SyncSetRightStoreReq.class);
    public final PBInt32Field opType = PBField.initInt32(0);
    public final PBStringField key = PBField.initString("");
    public final PBStringField uid = PBField.initString("");
    public final PBInt64Field opTime = PBField.initInt64(0);
}
