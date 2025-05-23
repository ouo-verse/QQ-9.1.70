package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LiveBusConfigCenterClass$DynamicConfigRsp extends MessageMicro<LiveBusConfigCenterClass$DynamicConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bool_config", "version_prompt", "freelove"}, new Object[]{null, "", null}, LiveBusConfigCenterClass$DynamicConfigRsp.class);
    public final PBRepeatMessageField<LiveBusConfigCenterClass$BoolConfig> bool_config = PBField.initRepeatMessage(LiveBusConfigCenterClass$BoolConfig.class);
    public final PBStringField version_prompt = PBField.initString("");
    public LiveBusConfigCenterClass$FreeLove freelove = new MessageMicro<LiveBusConfigCenterClass$FreeLove>() { // from class: trpc.yes.common.LiveBusConfigCenterClass$FreeLove
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField flag = PBField.initBool(false);
        public final PBUInt32Field materialID = PBField.initUInt32(0);
        public final PBFloatField start_gap = PBField.initFloat(0.0f);
        public final PBFloatField combo_gap = PBField.initFloat(0.0f);

        static {
            Float valueOf = Float.valueOf(0.0f);
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 29, 37}, new String[]{"flag", "materialID", "start_gap", "combo_gap"}, new Object[]{Boolean.FALSE, 0, valueOf, valueOf}, LiveBusConfigCenterClass$FreeLove.class);
        }
    };
}
