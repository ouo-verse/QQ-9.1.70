package tencent.im.oidb.cmd0xea0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xea0$DynamicBannerItem extends MessageMicro<oidb_cmd0xea0$DynamicBannerItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"dynamic_json", "unique_id", "card_report_json"}, new Object[]{"", "", ""}, oidb_cmd0xea0$DynamicBannerItem.class);
    public final PBStringField dynamic_json = PBField.initString("");
    public final PBStringField unique_id = PBField.initString("");
    public final PBStringField card_report_json = PBField.initString("");
}
