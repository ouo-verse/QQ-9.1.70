package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class AIFacePtaData$MaterialInfoTimiV2 extends MessageMicro<AIFacePtaData$MaterialInfoTimiV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"item_id", "material_info"}, new Object[]{0, null}, AIFacePtaData$MaterialInfoTimiV2.class);
    public final PBUInt32Field item_id = PBField.initUInt32(0);
    public AIFacePtaData$MaterialInfoTimi material_info = new MessageMicro<AIFacePtaData$MaterialInfoTimi>() { // from class: qshadow.AIFacePtaData$MaterialInfoTimi
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field item_id = PBField.initUInt32(0);
        public final PBStringField item_icon = PBField.initString("");
        public final PBBoolField is_have = PBField.initBool(false);
        public final PBBoolField is_discount = PBField.initBool(false);
        public final PBRepeatMessageField<AIFacePtaData$CoinInfo> coin_info = PBField.initRepeatMessage(AIFacePtaData$CoinInfo.class);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"item_id", "item_icon", "is_have", "is_discount", "coin_info"}, new Object[]{0, "", bool, bool, null}, AIFacePtaData$MaterialInfoTimi.class);
        }
    };
}
