package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentWriter$StDeleteFeedReq extends MessageMicro<QZMomentWriter$StDeleteFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "feed", "from"}, new Object[]{null, null, 0}, QZMomentWriter$StDeleteFeedReq.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public QZMomentMeta$StFeed feed = new QZMomentMeta$StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
}
