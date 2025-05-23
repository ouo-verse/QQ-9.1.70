package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$UpdateProcessReq extends MessageMicro<FestivalPack$UpdateProcessReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"promotion_id", "question_list"}, new Object[]{0, 0}, FestivalPack$UpdateProcessReq.class);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    public final PBRepeatField<Integer> question_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
