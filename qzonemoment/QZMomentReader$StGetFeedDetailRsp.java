package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentReader$StGetFeedDetailRsp extends MessageMicro<QZMomentReader$StGetFeedDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "feed"}, new Object[]{null, null}, QZMomentReader$StGetFeedDetailRsp.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public QZMomentMeta$StFeed feed = new QZMomentMeta$StFeed();
}
