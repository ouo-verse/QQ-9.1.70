package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$GetDissSongListReq extends MessageMicro<QQCircleSmartMatchMusic$GetDissSongListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"code", "attachInfo"}, new Object[]{"", ""}, QQCircleSmartMatchMusic$GetDissSongListReq.class);
    public final PBStringField code = PBField.initString("");
    public final PBStringField attachInfo = PBField.initString("");
}
