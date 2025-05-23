package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes29.dex */
public final class QZMomentWriter$StPublishFeedReq extends MessageMicro<QZMomentWriter$StPublishFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "feed", "from"}, new Object[]{null, null, 0}, QZMomentWriter$StPublishFeedReq.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public QZMomentMeta$StFeed feed = new QZMomentMeta$StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
}
