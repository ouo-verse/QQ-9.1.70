package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$GetLotteryListRsp extends MessageMicro<LiveActivityServerOuterClass$GetLotteryListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"award_list"}, new Object[]{null}, LiveActivityServerOuterClass$GetLotteryListRsp.class);
    public final PBRepeatMessageField<LiveActivityServerOuterClass$LotteryAwardInfo> award_list = PBField.initRepeatMessage(LiveActivityServerOuterClass$LotteryAwardInfo.class);
}
