package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QZMomentWriter$StPublishFeedRsp extends MessageMicro<QZMomentWriter$StPublishFeedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "feed", "nextPublishTime"}, new Object[]{null, null, 0L}, QZMomentWriter$StPublishFeedRsp.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public QZMomentMeta$StFeed feed = new QZMomentMeta$StFeed();
    public final PBUInt64Field nextPublishTime = PBField.initUInt64(0);
}
