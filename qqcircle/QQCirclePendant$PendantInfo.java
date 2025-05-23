package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCirclePendant$PendantInfo extends MessageMicro<QQCirclePendant$PendantInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 66}, new String[]{"id", "name", "desc", "url", "layerUrl", "pendantType", "pendantPrice", "commentUrl"}, new Object[]{"", "", "", "", "", 0, 0, ""}, QQCirclePendant$PendantInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429308id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField layerUrl = PBField.initString("");
    public final PBInt32Field pendantType = PBField.initInt32(0);
    public final PBInt32Field pendantPrice = PBField.initInt32(0);
    public final PBStringField commentUrl = PBField.initString("");
}
