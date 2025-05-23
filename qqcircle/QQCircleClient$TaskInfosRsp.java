package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleClient$TaskInfosRsp extends MessageMicro<QQCircleClient$TaskInfosRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 82, 88}, new String[]{"title", "description", "bottom_text", "jump_url", "tips", "infos", "total_fuel"}, new Object[]{"", "", "", "", "", null, 0}, QQCircleClient$TaskInfosRsp.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField description = PBField.initString("");
    public final PBStringField bottom_text = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField tips = PBField.initString("");
    public final PBRepeatMessageField<QQCircleClient$TaskInfo> infos = PBField.initRepeatMessage(QQCircleClient$TaskInfo.class);
    public final PBUInt32Field total_fuel = PBField.initUInt32(0);
}
