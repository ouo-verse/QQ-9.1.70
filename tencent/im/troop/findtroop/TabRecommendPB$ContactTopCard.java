package tencent.im.troop.findtroop;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class TabRecommendPB$ContactTopCard extends MessageMicro<TabRecommendPB$ContactTopCard> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 88, 98, 106, 114}, new String[]{"type", "title", "sub_title", "icon_light_url", "icon_dark_url", "background_light_url", "background_dark_url", "card_jump_url", QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, "button_jump_url", "close_delay_time", "hori_bar_title", "hori_bar_icon_light_url", "hori_bar_icon_dark_url"}, new Object[]{0L, "", "", "", "", "", "", "", "", "", 0L, "", "", ""}, TabRecommendPB$ContactTopCard.class);
    public final PBUInt64Field type = PBField.initUInt64(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField sub_title = PBField.initString("");
    public final PBStringField icon_light_url = PBField.initString("");
    public final PBStringField icon_dark_url = PBField.initString("");
    public final PBStringField background_light_url = PBField.initString("");
    public final PBStringField background_dark_url = PBField.initString("");
    public final PBStringField card_jump_url = PBField.initString("");
    public final PBStringField button_text = PBField.initString("");
    public final PBStringField button_jump_url = PBField.initString("");
    public final PBUInt64Field close_delay_time = PBField.initUInt64(0);
    public final PBStringField hori_bar_title = PBField.initString("");
    public final PBStringField hori_bar_icon_light_url = PBField.initString("");
    public final PBStringField hori_bar_icon_dark_url = PBField.initString("");
}
