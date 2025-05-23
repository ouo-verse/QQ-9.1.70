package tencent.im.oidb.cmd0xaf4;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xaf4$ReqBody extends MessageMicro<oidb_0xaf4$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64}, new String[]{"group_id", "client_info", "last_game_dynamic_ts", "page", WidgetCacheConstellationData.NUM, "mini_appids", "mini_app_disable", "mode"}, new Object[]{0L, null, 0, 0, 0, 0L, 0, 0}, oidb_0xaf4$ReqBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public oidb_0xaf4$ClientInfo client_info = new MessageMicro<oidb_0xaf4$ClientInfo>() { // from class: tencent.im.oidb.cmd0xaf4.oidb_0xaf4$ClientInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"platform", "version"}, new Object[]{0, ""}, oidb_0xaf4$ClientInfo.class);
        public final PBUInt32Field platform = PBField.initUInt32(0);
        public final PBStringField version = PBField.initString("");
    };
    public final PBUInt32Field last_game_dynamic_ts = PBField.initUInt32(0);
    public final PBUInt32Field page = PBField.initUInt32(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBRepeatField<Long> mini_appids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field mini_app_disable = PBField.initUInt32(0);
    public final PBUInt32Field mode = PBField.initUInt32(0);
}
