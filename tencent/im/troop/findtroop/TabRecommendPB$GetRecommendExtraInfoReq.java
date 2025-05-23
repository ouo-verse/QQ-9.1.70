package tencent.im.troop.findtroop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class TabRecommendPB$GetRecommendExtraInfoReq extends MessageMicro<TabRecommendPB$GetRecommendExtraInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"source", "uin_list"}, new Object[]{0, 0L}, TabRecommendPB$GetRecommendExtraInfoReq.class);
    public final PBEnumField source = PBField.initEnum(0);
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
