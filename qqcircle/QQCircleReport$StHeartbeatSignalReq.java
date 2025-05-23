package qqcircle;

import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$BytesEntry;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleReport$StHeartbeatSignalReq extends MessageMicro<QQCircleReport$StHeartbeatSignalReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 410, 418, PlayUI.UIType.BIG_CARD_SHAPED_PIC}, new String[]{"uin", "interval_time_ms", "sig_optype", j.T0, "network_info", "byteExtinfo"}, new Object[]{0L, 0L, 0, null, null, null}, QQCircleReport$StHeartbeatSignalReq.class);
    public final PBInt64Field uin = PBField.initInt64(0);
    public final PBInt64Field interval_time_ms = PBField.initInt64(0);
    public final PBEnumField sig_optype = PBField.initEnum(0);
    public QQCircleBase$StAppInfo app_info = new QQCircleBase$StAppInfo();
    public QQCircleBase$StNetworkInfo network_info = new QQCircleBase$StNetworkInfo();
    public final PBRepeatMessageField<FeedCloudCommon$BytesEntry> byteExtinfo = PBField.initRepeatMessage(FeedCloudCommon$BytesEntry.class);
}
