package tencent.im.troop_search_popclassifc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class popclassifc$PopItem extends MessageMicro<popclassifc$PopItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"str_desc", "str_icon_url", "str_transfer_url"}, new Object[]{"", "", ""}, popclassifc$PopItem.class);
    public final PBStringField str_desc = PBField.initString("");
    public final PBStringField str_icon_url = PBField.initString("");
    public final PBStringField str_transfer_url = PBField.initString("");
}
