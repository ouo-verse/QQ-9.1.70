package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentFCMata$FcRecomInfo extends MessageMicro<QZMomentFCMata$FcRecomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"recomReason", "orgUid", "orgFeedKey", "orgFeedTime", "currentRecomFeedUid"}, new Object[]{"", "", "", 0, ""}, QZMomentFCMata$FcRecomInfo.class);
    public final PBStringField recomReason = PBField.initString("");
    public final PBStringField orgUid = PBField.initString("");
    public final PBStringField orgFeedKey = PBField.initString("");
    public final PBUInt32Field orgFeedTime = PBField.initUInt32(0);
    public final PBStringField currentRecomFeedUid = PBField.initString("");
}
