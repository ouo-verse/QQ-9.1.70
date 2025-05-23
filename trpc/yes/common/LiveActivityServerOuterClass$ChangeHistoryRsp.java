package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$ChangeHistoryRsp extends MessageMicro<LiveActivityServerOuterClass$ChangeHistoryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"list"}, new Object[]{null}, LiveActivityServerOuterClass$ChangeHistoryRsp.class);
    public final PBRepeatMessageField<LiveActivityServerOuterClass$CommodityChangeInfo> list = PBField.initRepeatMessage(LiveActivityServerOuterClass$CommodityChangeInfo.class);
}
