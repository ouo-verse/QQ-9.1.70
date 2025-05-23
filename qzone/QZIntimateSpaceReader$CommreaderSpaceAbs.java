package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$CommreaderSpaceAbs extends MessageMicro<QZIntimateSpaceReader$CommreaderSpaceAbs> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"space_type", "space_id"}, new Object[]{0, ""}, QZIntimateSpaceReader$CommreaderSpaceAbs.class);
    public final PBEnumField space_type = PBField.initEnum(0);
    public final PBStringField space_id = PBField.initString("");
}
