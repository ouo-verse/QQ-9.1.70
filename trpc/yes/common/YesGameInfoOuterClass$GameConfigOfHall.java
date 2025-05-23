package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YesGameInfoOuterClass$GameConfigOfHall extends MessageMicro<YesGameInfoOuterClass$GameConfigOfHall> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74}, new String[]{"icon_hall_back", "color_hall_title", "bg_head_area", "icon_online_user_more", "colors_content_area", "icon_fleet_fold", "icon_fleet_unfold", "icon_guild_setting", "colors_operations_indicator"}, new Object[]{"", "", "", "", "", "", "", "", ""}, YesGameInfoOuterClass$GameConfigOfHall.class);
    public final PBRepeatField<String> colors_content_area;
    public final PBRepeatField<String> colors_operations_indicator;
    public final PBStringField icon_fleet_fold;
    public final PBStringField icon_fleet_unfold;
    public final PBStringField icon_guild_setting;
    public final PBStringField icon_hall_back = PBField.initString("");
    public final PBStringField color_hall_title = PBField.initString("");
    public final PBStringField bg_head_area = PBField.initString("");
    public final PBStringField icon_online_user_more = PBField.initString("");

    public YesGameInfoOuterClass$GameConfigOfHall() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.colors_content_area = PBField.initRepeat(pBStringField);
        this.icon_fleet_fold = PBField.initString("");
        this.icon_fleet_unfold = PBField.initString("");
        this.icon_guild_setting = PBField.initString("");
        this.colors_operations_indicator = PBField.initRepeat(pBStringField);
    }
}
