package tencent.im.oidb.cmd0xde0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xde0$ReqBody extends MessageMicro<oidb_cmd0xde0$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"ctx_feature", "usr_gesture_feature", "feeds_exp_feature", "active_zone"}, new Object[]{null, null, null, null}, oidb_cmd0xde0$ReqBody.class);
    public oidb_cmd0xde0$FeedsCtxFeature ctx_feature = new MessageMicro<oidb_cmd0xde0$FeedsCtxFeature>() { // from class: tencent.im.oidb.cmd0xde0.oidb_cmd0xde0$FeedsCtxFeature
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField ctx_device_id = PBField.initString("");
        public final PBUInt64Field timestamp = PBField.initUInt64(0);
        public final PBUInt32Field ctx_enter_reason = PBField.initUInt32(0);
        public final PBStringField ctx_device_model = PBField.initString("");
        public final PBUInt32Field ctx_network_type = PBField.initUInt32(0);
        public final PBFloatField ctx_power = PBField.initFloat(0.0f);
        public final PBStringField ctx_screen_info = PBField.initString("");
        public final PBFloatField ctx_lightness = PBField.initFloat(0.0f);
        public final PBFloatField ctx_volume = PBField.initFloat(0.0f);
        public final PBBoolField ctx_headset = PBField.initBool(false);
        public final PBUInt64Field ctx_scene = PBField.initUInt64(0);

        static {
            Float valueOf = Float.valueOf(0.0f);
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 53, 58, 69, 77, 80, 88}, new String[]{"ctx_device_id", "timestamp", "ctx_enter_reason", "ctx_device_model", "ctx_network_type", "ctx_power", "ctx_screen_info", "ctx_lightness", "ctx_volume", "ctx_headset", "ctx_scene"}, new Object[]{"", 0L, 0, "", 0, valueOf, "", valueOf, valueOf, Boolean.FALSE, 0L}, oidb_cmd0xde0$FeedsCtxFeature.class);
        }
    };
    public oidb_cmd0xde0$GestureFeature usr_gesture_feature = new MessageMicro<oidb_cmd0xde0$GestureFeature>() { // from class: tencent.im.oidb.cmd0xde0.oidb_cmd0xde0$GestureFeature
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"gesture_event"}, new Object[]{null}, oidb_cmd0xde0$GestureFeature.class);
        public final PBRepeatMessageField<oidb_cmd0xde0$GestureEvent> gesture_event = PBField.initRepeatMessage(oidb_cmd0xde0$GestureEvent.class);
    };
    public oidb_cmd0xde0$FeedsExpFeature feeds_exp_feature = new MessageMicro<oidb_cmd0xde0$FeedsExpFeature>() { // from class: tencent.im.oidb.cmd0xde0.oidb_cmd0xde0$FeedsExpFeature
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"exp_feeds", "exp_chnl_duration", "is_user_active", "exp_first_scrn_duration", "exp_last_scrn_duration"}, new Object[]{null, 0L, Boolean.FALSE, 0L, 0L}, oidb_cmd0xde0$FeedsExpFeature.class);
        public final PBRepeatMessageField<oidb_cmd0xde0$FeedExpInfo> exp_feeds = PBField.initRepeatMessage(oidb_cmd0xde0$FeedExpInfo.class);
        public final PBUInt64Field exp_chnl_duration = PBField.initUInt64(0);
        public final PBBoolField is_user_active = PBField.initBool(false);
        public final PBUInt64Field exp_first_scrn_duration = PBField.initUInt64(0);
        public final PBUInt64Field exp_last_scrn_duration = PBField.initUInt64(0);
    };
    public oidb_cmd0xde0$ActiveZoneFeature active_zone = new MessageMicro<oidb_cmd0xde0$ActiveZoneFeature>() { // from class: tencent.im.oidb.cmd0xde0.oidb_cmd0xde0$ActiveZoneFeature
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"top", "bottom"}, new Object[]{0, 0}, oidb_cmd0xde0$ActiveZoneFeature.class);
        public final PBUInt32Field top = PBField.initUInt32(0);
        public final PBUInt32Field bottom = PBField.initUInt32(0);
    };
}
