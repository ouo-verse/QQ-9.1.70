package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$PKInfo extends MessageMicro<QzoneActivityPB$PKInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"uin", "frd_uin", "win_uin", "win_score", "text"}, new Object[]{"", "", "", 0, ""}, QzoneActivityPB$PKInfo.class);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField frd_uin = PBField.initString("");
    public final PBStringField win_uin = PBField.initString("");
    public final PBInt32Field win_score = PBField.initInt32(0);
    public final PBStringField text = PBField.initString("");
}
