package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicFeeds$SubCmd_Feeds_RespInfo extends MessageMicro<DynamicFeeds$SubCmd_Feeds_RespInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 48, 58, 64}, new String[]{"uiRetCode", "strError", "RespFeeds", "uiNextDayTimestamp", "strTodayTitle", "ulDelFeeds", "strReqCookie", "retFromRecsys"}, new Object[]{0, "", null, 0, "", 0L, "", 0}, DynamicFeeds$SubCmd_Feeds_RespInfo.class);
    public final PBUInt32Field uiRetCode = PBField.initUInt32(0);
    public final PBStringField strError = PBField.initString("");
    public final PBRepeatMessageField<DynamicFeeds$FeedsItem_Resp> RespFeeds = PBField.initRepeatMessage(DynamicFeeds$FeedsItem_Resp.class);
    public final PBUInt32Field uiNextDayTimestamp = PBField.initUInt32(0);
    public final PBStringField strTodayTitle = PBField.initString("");
    public final PBRepeatField<Long> ulDelFeeds = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBStringField strReqCookie = PBField.initString("");
    public final PBUInt32Field retFromRecsys = PBField.initUInt32(0);
}
