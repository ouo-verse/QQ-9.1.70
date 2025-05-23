package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentMeta$StLike extends MessageMicro<QZMomentMeta$StLike> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40}, new String[]{"id", "count", "status", "postUser", "ownerStatus"}, new Object[]{"", 0, 0, null, 0}, QZMomentMeta$StLike.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f430363id = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public QZMomentMeta$StUser postUser = new QZMomentMeta$StUser();
    public final PBUInt32Field ownerStatus = PBField.initUInt32(0);
}
