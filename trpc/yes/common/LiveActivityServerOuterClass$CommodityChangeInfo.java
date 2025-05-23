package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$CommodityChangeInfo extends MessageMicro<LiveActivityServerOuterClass$CommodityChangeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"title", "change_time"}, new Object[]{"", 0L}, LiveActivityServerOuterClass$CommodityChangeInfo.class);
    public final PBStringField title = PBField.initString("");
    public final PBUInt64Field change_time = PBField.initUInt64(0);
}
