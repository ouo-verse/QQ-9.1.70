package tencent.im.oidb.cmd0xde0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xde0$FeedScrollStateInfo extends MessageMicro<oidb_cmd0xde0$FeedScrollStateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 53, 56, 64, 72, 80}, new String[]{"feeds_id", "enter_active_zone_speed", "start_top", "start_bottom", "stop_top", "stop_bottom"}, new Object[]{"", Float.valueOf(0.0f), 0L, 0L, 0L, 0L}, oidb_cmd0xde0$FeedScrollStateInfo.class);
    public final PBStringField feeds_id = PBField.initString("");
    public final PBFloatField enter_active_zone_speed = PBField.initFloat(0.0f);
    public final PBInt64Field start_top = PBField.initInt64(0);
    public final PBInt64Field start_bottom = PBField.initInt64(0);
    public final PBInt64Field stop_top = PBField.initInt64(0);
    public final PBInt64Field stop_bottom = PBField.initInt64(0);
}
