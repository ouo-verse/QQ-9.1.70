package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class QQCircleCounter$GetRedPointsReq extends MessageMicro<QQCircleCounter$GetRedPointsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"from", "attachInfo"}, new Object[]{0, ByteStringMicro.EMPTY}, QQCircleCounter$GetRedPointsReq.class);
    public final PBEnumField from = PBField.initEnum(0);
    public final PBBytesField attachInfo = PBField.initBytes(ByteStringMicro.EMPTY);
}
