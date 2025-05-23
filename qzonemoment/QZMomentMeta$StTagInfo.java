package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentMeta$StTagInfo extends MessageMicro<QZMomentMeta$StTagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"tagId", "tagName", "tagDec"}, new Object[]{"", "", ""}, QZMomentMeta$StTagInfo.class);
    public final PBStringField tagId = PBField.initString("");
    public final PBStringField tagName = PBField.initString("");
    public final PBStringField tagDec = PBField.initString("");
}
