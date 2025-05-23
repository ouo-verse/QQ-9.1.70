package tencent.im.confess.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RedpointInfo extends MessageMicro<RedpointInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82}, new String[]{"feedid", "data"}, new Object[]{"", ""}, RedpointInfo.class);
    public final PBStringField feedid = PBField.initString("");
    public final PBStringField data = PBField.initString("");
}
