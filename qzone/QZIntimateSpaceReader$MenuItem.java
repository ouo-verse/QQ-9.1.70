package qzone;

import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$MenuItem extends MessageMicro<QZIntimateSpaceReader$MenuItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 41, 50}, new String[]{"menu_id", "menu_type", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "notify", "sort_num", "icon_url"}, new Object[]{0, 0, "", "", Double.valueOf(0.0d), ""}, QZIntimateSpaceReader$MenuItem.class);
    public final PBEnumField menu_id = PBField.initEnum(0);
    public final PBEnumField menu_type = PBField.initEnum(0);
    public final PBStringField link = PBField.initString("");
    public final PBStringField notify = PBField.initString("");
    public final PBDoubleField sort_num = PBField.initDouble(0.0d);
    public final PBStringField icon_url = PBField.initString("");
}
