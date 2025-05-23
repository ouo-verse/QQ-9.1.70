package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.zplan.CsCommon$RspHeader;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMallMessage$BuyItemInAvatarModeReply extends MessageMicro<AvatarMallMessage$BuyItemInAvatarModeReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"rsp_header", "cost_diamond", "cost_bean", "item_ids"}, new Object[]{null, 0L, 0L, 0}, AvatarMallMessage$BuyItemInAvatarModeReply.class);
    public CsCommon$RspHeader rsp_header = new CsCommon$RspHeader();
    public final PBUInt64Field cost_diamond = PBField.initUInt64(0);
    public final PBUInt64Field cost_bean = PBField.initUInt64(0);
    public final PBRepeatField<Integer> item_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
