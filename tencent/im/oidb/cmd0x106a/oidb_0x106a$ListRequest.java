package tencent.im.oidb.cmd0x106a;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x106a$ListRequest extends MessageMicro<oidb_0x106a$ListRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50, 56}, new String[]{"guild_id", "start", WidgetCacheConstellationData.NUM, "filter", "channel_id", "client_info", "card_recommend_uins"}, new Object[]{0L, 0, 0, null, 0L, null, 0L}, oidb_0x106a$ListRequest.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public oidb_0x106a$ListFilter filter = new MessageMicro<oidb_0x106a$ListFilter>() { // from class: tencent.im.oidb.cmd0x106a.oidb_0x106a$ListFilter
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"audio"}, new Object[]{Boolean.FALSE}, oidb_0x106a$ListFilter.class);
        public final PBBoolField audio = PBField.initBool(false);
    };
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public oidb_0x106a$ClientInfo client_info = new MessageMicro<oidb_0x106a$ClientInfo>() { // from class: tencent.im.oidb.cmd0x106a.oidb_0x106a$ClientInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"platform", "version", "build_num"}, new Object[]{0, "", 0}, oidb_0x106a$ClientInfo.class);
        public final PBEnumField platform = PBField.initEnum(0);
        public final PBStringField version = PBField.initString("");
        public final PBUInt32Field build_num = PBField.initUInt32(0);
    };
    public final PBRepeatField<Long> card_recommend_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
