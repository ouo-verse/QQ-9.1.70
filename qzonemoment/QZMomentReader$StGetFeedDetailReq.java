package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentReader$StGetFeedDetailReq extends MessageMicro<QZMomentReader$StGetFeedDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"extInfo", "from", "entryFeed"}, new Object[]{null, 0, null}, QZMomentReader$StGetFeedDetailReq.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public final PBEnumField from = PBField.initEnum(0);
    public QZMomentMeta$StFeed entryFeed = new QZMomentMeta$StFeed();
}
