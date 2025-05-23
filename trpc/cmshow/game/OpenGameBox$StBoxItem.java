package trpc.cmshow.game;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OpenGameBox$StBoxItem extends MessageMicro<OpenGameBox$StBoxItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 64, 74, 82, 90}, new String[]{"appid", "avatar", "name", "gamer_range", "background", "footer_icon", "ad_id", "box_type", "hall_jump_url", "miniapp_jump_url", MiniConst.WxMiniAppInfoConst.EXTRA_DESC}, new Object[]{"", "", "", "", "", "", 0, 0, "", "", ""}, OpenGameBox$StBoxItem.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField gamer_range = PBField.initString("");
    public final PBStringField background = PBField.initString("");
    public final PBStringField footer_icon = PBField.initString("");
    public final PBUInt32Field ad_id = PBField.initUInt32(0);
    public final PBUInt32Field box_type = PBField.initUInt32(0);
    public final PBStringField hall_jump_url = PBField.initString("");
    public final PBStringField miniapp_jump_url = PBField.initString("");
    public final PBStringField app_desc = PBField.initString("");
}
