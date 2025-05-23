package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qzone.QZoneHelper;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleReport$SingleDcData extends MessageMicro<QQCircleReport$SingleDcData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"dcid", "report_data", QZoneHelper.INTENT_EXTINFO, "byteExtinfo"}, new Object[]{0, null, null, null}, QQCircleReport$SingleDcData.class);
    public final PBUInt32Field dcid = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> report_data = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> extinfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBRepeatMessageField<FeedCloudCommon$BytesEntry> byteExtinfo = PBField.initRepeatMessage(FeedCloudCommon$BytesEntry.class);
}
