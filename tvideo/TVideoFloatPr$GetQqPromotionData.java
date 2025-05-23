package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class TVideoFloatPr$GetQqPromotionData extends MessageMicro<TVideoFloatPr$GetQqPromotionData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"promotions"}, new Object[]{null}, TVideoFloatPr$GetQqPromotionData.class);
    public final PBRepeatMessageField<TVideoFloatPr$QqPromotions> promotions = PBField.initRepeatMessage(TVideoFloatPr$QqPromotions.class);
}
