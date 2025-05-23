package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$RelatedUser extends MessageMicro<QZIntimateSpaceReader$RelatedUser> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"user_uid", "relation_start_time"}, new Object[]{"", 0L}, QZIntimateSpaceReader$RelatedUser.class);
    public final PBStringField user_uid = PBField.initString("");
    public final PBInt64Field relation_start_time = PBField.initInt64(0);
}
