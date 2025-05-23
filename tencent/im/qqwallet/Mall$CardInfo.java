package tencent.im.qqwallet;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;
import com.tencent.raft.codegenmeta.utils.Constants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Mall$CardInfo extends MessageMicro<Mall$CardInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 64, 72, 80, 88, 98, 104, 114, 122, 130, 138, 146, 154, 162, 168, 176, 186, 194}, new String[]{"field", "app_id", "card_id", "title", "subtitle", "from", "icon", "quantity", "priority", "percent", Constants.Raft.TASKS, "tag", "status", "code", QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, "obtained_button_text", "style", "price", "origin_price", "main_image", VasQQSettingMeImpl.EXPIRE_TIME, "is_direct", "apply_url", "category"}, new Object[]{0, 0, "", "", "", "", "", 0, 0, 0, 0, "", 0, "", "", "", "", "", "", "", 0L, Boolean.FALSE, "", ""}, Mall$CardInfo.class);
    public final PBInt32Field field = PBField.initInt32(0);
    public final PBInt32Field app_id = PBField.initInt32(0);
    public final PBStringField card_id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField subtitle = PBField.initString("");
    public final PBStringField from = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBInt32Field quantity = PBField.initInt32(0);
    public final PBInt32Field priority = PBField.initInt32(0);
    public final PBInt32Field percent = PBField.initInt32(0);
    public final PBInt32Field tasks = PBField.initInt32(0);
    public final PBStringField tag = PBField.initString("");
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBStringField code = PBField.initString("");
    public final PBStringField button_text = PBField.initString("");
    public final PBStringField obtained_button_text = PBField.initString("");
    public final PBStringField style = PBField.initString("");
    public final PBStringField price = PBField.initString("");
    public final PBStringField origin_price = PBField.initString("");
    public final PBStringField main_image = PBField.initString("");
    public final PBInt64Field expire_time = PBField.initInt64(0);
    public final PBBoolField is_direct = PBField.initBool(false);
    public final PBStringField apply_url = PBField.initString("");
    public final PBStringField category = PBField.initString("");
}
