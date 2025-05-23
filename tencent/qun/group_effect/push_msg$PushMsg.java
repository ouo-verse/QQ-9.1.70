package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class push_msg$PushMsg extends MessageMicro<push_msg$PushMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 162, 168}, new String[]{"rc", "msg", "uin", "group_code", "svip_level", "svip_type", "group_level", "effect_info", "set_mode"}, new Object[]{0, "", 0L, 0L, 0, 0, 0, null, 0L}, push_msg$PushMsg.class);

    /* renamed from: rc, reason: collision with root package name */
    public final PBInt32Field f436068rc = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f436067msg = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt32Field svip_level = PBField.initUInt32(0);
    public final PBUInt32Field svip_type = PBField.initUInt32(0);
    public final PBUInt32Field group_level = PBField.initUInt32(0);
    public group_effect$EffectInfo effect_info = new group_effect$EffectInfo();
    public final PBUInt64Field set_mode = PBField.initUInt64(0);
}
