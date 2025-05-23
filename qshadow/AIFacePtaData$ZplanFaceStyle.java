package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.wink.api.QQWinkConstants;

/* loaded from: classes29.dex */
public final class AIFacePtaData$ZplanFaceStyle extends MessageMicro<AIFacePtaData$ZplanFaceStyle> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"thumbnail_url", "description", "pta_data", "style_id", QQWinkConstants.BUSINESS_MAIGC_STUDIO_STYLE_NAME, "total_price", "total_price_info"}, new Object[]{"", "", "", "", "", null, null}, AIFacePtaData$ZplanFaceStyle.class);
    public final PBStringField thumbnail_url = PBField.initString("");
    public final PBStringField description = PBField.initString("");
    public final PBStringField pta_data = PBField.initString("");
    public final PBStringField style_id = PBField.initString("");
    public final PBStringField style_name = PBField.initString("");
    public final PBRepeatMessageField<AIFacePtaData$CoinInfo> total_price = PBField.initRepeatMessage(AIFacePtaData$CoinInfo.class);
    public AIFacePtaData$TotalPriceInfo total_price_info = new MessageMicro<AIFacePtaData$TotalPriceInfo>() { // from class: qshadow.AIFacePtaData$TotalPriceInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"price", "needShow", "price_show_type"}, new Object[]{null, Boolean.FALSE, 0}, AIFacePtaData$TotalPriceInfo.class);
        public final PBRepeatMessageField<AIFacePtaData$CoinInfo> price = PBField.initRepeatMessage(AIFacePtaData$CoinInfo.class);
        public final PBBoolField needShow = PBField.initBool(false);
        public final PBEnumField price_show_type = PBField.initEnum(0);
    };
}
