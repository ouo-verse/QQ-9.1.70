package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.state.data.SquareJSConst;

/* loaded from: classes29.dex */
public final class QQCircleProfile$BatchGetPenguinProfileReq extends MessageMicro<QQCircleProfile$BatchGetPenguinProfileReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{SquareJSConst.Params.PARAMS_UIN_LIST}, new Object[]{0}, QQCircleProfile$BatchGetPenguinProfileReq.class);
    public final PBRepeatField<Integer> uinList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
