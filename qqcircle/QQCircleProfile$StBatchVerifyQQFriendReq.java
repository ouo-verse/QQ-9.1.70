package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.state.data.SquareJSConst;

/* loaded from: classes29.dex */
public final class QQCircleProfile$StBatchVerifyQQFriendReq extends MessageMicro<QQCircleProfile$StBatchVerifyQQFriendReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{SquareJSConst.Params.PARAMS_UIN_LIST, "enable_cache", "uint64_uins"}, new Object[]{0, Boolean.FALSE, 0L}, QQCircleProfile$StBatchVerifyQQFriendReq.class);
    public final PBRepeatField<Integer> uinList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBBoolField enable_cache = PBField.initBool(false);
    public final PBRepeatField<Long> uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
