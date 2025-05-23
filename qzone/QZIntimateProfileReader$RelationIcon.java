package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$RelationIcon extends MessageMicro<QZIntimateProfileReader$RelationIcon> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"relation_icon", "icon_description", "memberUid"}, new Object[]{"", "", ""}, QZIntimateProfileReader$RelationIcon.class);
    public final PBStringField relation_icon = PBField.initString("");
    public final PBStringField icon_description = PBField.initString("");
    public final PBStringField memberUid = PBField.initString("");
}
