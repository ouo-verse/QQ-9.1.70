package tencent.im.oidb.cmd0xf7a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf7a$EmojiInfo extends MessageMicro<oidb_cmd0xf7a$EmojiInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"emoji_id", "emoji_name", "emoji_icon_url", "emoji_show_text"}, new Object[]{"", "", "", ""}, oidb_cmd0xf7a$EmojiInfo.class);
    public final PBStringField emoji_id = PBField.initString("");
    public final PBStringField emoji_name = PBField.initString("");
    public final PBStringField emoji_icon_url = PBField.initString("");
    public final PBStringField emoji_show_text = PBField.initString("");
}
