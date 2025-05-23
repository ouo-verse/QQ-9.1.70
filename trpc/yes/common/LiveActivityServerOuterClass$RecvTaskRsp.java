package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$RecvTaskRsp extends MessageMicro<LiveActivityServerOuterClass$RecvTaskRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"award_list"}, new Object[]{null}, LiveActivityServerOuterClass$RecvTaskRsp.class);
    public final PBRepeatMessageField<LiveActivityServerOuterClass$AwardItem> award_list = PBField.initRepeatMessage(LiveActivityServerOuterClass$AwardItem.class);
}
