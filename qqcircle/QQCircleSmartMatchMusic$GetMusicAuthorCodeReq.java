package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$GetMusicAuthorCodeReq extends MessageMicro<QQCircleSmartMatchMusic$GetMusicAuthorCodeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"code_type", "code"}, new Object[]{0, ""}, QQCircleSmartMatchMusic$GetMusicAuthorCodeReq.class);
    public final PBInt32Field code_type = PBField.initInt32(0);
    public final PBStringField code = PBField.initString("");
}
