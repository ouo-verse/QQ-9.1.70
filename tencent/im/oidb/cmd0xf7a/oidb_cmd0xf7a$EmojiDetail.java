package tencent.im.oidb.cmd0xf7a;

import com.qzone.widget.u;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf7a$EmojiDetail extends MessageMicro<oidb_cmd0xf7a$EmojiDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{u.COLUMN_TAB_ID, "tab_name", u.COLUMN_TAB_ICON_URL, "emoji_list", "emoji_size"}, new Object[]{"", "", "", null, 0}, oidb_cmd0xf7a$EmojiDetail.class);
    public final PBStringField tab_id = PBField.initString("");
    public final PBStringField tab_name = PBField.initString("");
    public final PBStringField tab_icon_url = PBField.initString("");
    public final PBRepeatMessageField<oidb_cmd0xf7a$EmojiInfo> emoji_list = PBField.initRepeatMessage(oidb_cmd0xf7a$EmojiInfo.class);
    public final PBUInt32Field emoji_size = PBField.initUInt32(0);
}
