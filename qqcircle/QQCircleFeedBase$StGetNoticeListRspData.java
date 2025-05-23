package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StGetNoticeListRspData extends MessageMicro<QQCircleFeedBase$StGetNoticeListRspData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 48}, new String[]{"rspTimestamp", "last_read_timestamp"}, new Object[]{0L, 0L}, QQCircleFeedBase$StGetNoticeListRspData.class);
    public final PBInt64Field rspTimestamp = PBField.initInt64(0);
    public final PBInt64Field last_read_timestamp = PBField.initInt64(0);
}
