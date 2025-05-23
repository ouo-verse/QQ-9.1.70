package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoChannelList$VideoChannelData extends MessageMicro<TVideoChannelList$VideoChannelData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field channel_id = PBField.initInt32(0);
    public final PBStringField channel_title = PBField.initString("");
    public final PBStringField channel_icon = PBField.initString("");
    public final PBBoolField is_subscribed = PBField.initBool(false);
    public final PBInt32Field channel_page_type = PBField.initInt32(0);
    public final PBStringField page_url = PBField.initString("");
    public final PBStringField page_module_name = PBField.initString("");
    public final PBRepeatMessageField<TVideoChannelList$ReportMap> page_report_map = PBField.initRepeatMessage(TVideoChannelList$ReportMap.class);
    public final PBStringField channel_theme_co1or = PBField.initString("");
    public final PBBoolField show_red_dot = PBField.initBool(false);
    public final PBStringField red_dot_text = PBField.initString("");
    public final PBInt32Field red_dot_version = PBField.initInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 58, 66, 74, 80, 90, 96}, new String[]{"channel_id", "channel_title", "channel_icon", "is_subscribed", "channel_page_type", "page_url", "page_module_name", "page_report_map", "channel_theme_co1or", "show_red_dot", "red_dot_text", "red_dot_version"}, new Object[]{0, "", "", bool, 0, "", "", null, "", bool, "", 0}, TVideoChannelList$VideoChannelData.class);
    }
}
