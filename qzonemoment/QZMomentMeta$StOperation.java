package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentMeta$StOperation extends MessageMicro<QZMomentMeta$StOperation> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"opUser", "opTime"}, new Object[]{null, 0L}, QZMomentMeta$StOperation.class);
    public QZMomentMeta$StUser opUser = new QZMomentMeta$StUser();
    public final PBUInt64Field opTime = PBField.initUInt64(0);
}
