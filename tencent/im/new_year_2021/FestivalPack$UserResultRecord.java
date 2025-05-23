package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class FestivalPack$UserResultRecord extends MessageMicro<FestivalPack$UserResultRecord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"result_list"}, new Object[]{null}, FestivalPack$UserResultRecord.class);
    public final PBRepeatMessageField<FestivalPack$PromotionResult> result_list = PBField.initRepeatMessage(FestivalPack$PromotionResult.class);
}
