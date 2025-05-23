package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentReader$StGetFeedListReq extends MessageMicro<QZMomentReader$StGetFeedListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50}, new String[]{"extInfo", "listNum", "from", "feed", "feedAttchInfo", "userId"}, new Object[]{null, 0, 0, null, "", ""}, QZMomentReader$StGetFeedListReq.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBEnumField from = PBField.initEnum(0);
    public QZMomentMeta$StFeed feed = new QZMomentMeta$StFeed();
    public final PBStringField feedAttchInfo = PBField.initString("");
    public final PBStringField userId = PBField.initString("");
}
