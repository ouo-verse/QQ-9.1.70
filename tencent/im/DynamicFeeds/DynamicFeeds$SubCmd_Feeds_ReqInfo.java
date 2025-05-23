package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicFeeds$SubCmd_Feeds_ReqInfo extends MessageMicro<DynamicFeeds$SubCmd_Feeds_ReqInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 50}, new String[]{"uiReqEvent", "ReqResIDs", "uiLoadDayTimestamp", "HistoryFeedIDs", "ulFinishDayBitmap", "strReqCookie"}, new Object[]{0, null, 0, null, 0L, ""}, DynamicFeeds$SubCmd_Feeds_ReqInfo.class);
    public final PBUInt32Field uiReqEvent = PBField.initUInt32(0);
    public final PBRepeatMessageField<DynamicFeeds$FeedsItem_Req> ReqResIDs = PBField.initRepeatMessage(DynamicFeeds$FeedsItem_Req.class);
    public final PBUInt32Field uiLoadDayTimestamp = PBField.initUInt32(0);
    public final PBRepeatMessageField<DynamicFeeds$FeedsItem_History> HistoryFeedIDs = PBField.initRepeatMessage(DynamicFeeds$FeedsItem_History.class);
    public final PBUInt64Field ulFinishDayBitmap = PBField.initUInt64(0);
    public final PBStringField strReqCookie = PBField.initString("");
}
