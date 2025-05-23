package tencent.im.oidb.cmd0xde0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xde0$GestureEvent extends MessageMicro<oidb_cmd0xde0$GestureEvent> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field ges_scroll_direction = PBField.initUInt32(0);
    public final PBUInt64Field delta_ts_from_last_scroll_mills = PBField.initUInt64(0);
    public final PBFloatField ges_scroll_distance = PBField.initFloat(0.0f);
    public final PBUInt64Field ges_scroll_mills = PBField.initUInt64(0);
    public final PBFloatField ges_scroll_speed = PBField.initFloat(0.0f);
    public final PBStringField ges_scroll_downNup = PBField.initString("");
    public final PBStringField ges_click_point = PBField.initString("");
    public final PBRepeatMessageField<oidb_cmd0xde0$FeedScrollStateInfo> get_scroll_feeds_info = PBField.initRepeatMessage(oidb_cmd0xde0$FeedScrollStateInfo.class);

    static {
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 29, 32, 45, 50, 58, 66}, new String[]{"ges_scroll_direction", "delta_ts_from_last_scroll_mills", "ges_scroll_distance", "ges_scroll_mills", "ges_scroll_speed", "ges_scroll_downNup", "ges_click_point", "get_scroll_feeds_info"}, new Object[]{0, 0L, valueOf, 0L, valueOf, "", "", null}, oidb_cmd0xde0$GestureEvent.class);
    }
}
