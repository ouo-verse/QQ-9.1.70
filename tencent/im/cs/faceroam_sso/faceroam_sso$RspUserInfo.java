package tencent.im.cs.faceroam_sso;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class faceroam_sso$RspUserInfo extends MessageMicro<faceroam_sso$RspUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50}, new String[]{"filename", "delete_file", "bid", "max_roam_size", "uint32_emoji_type", "emoji_items"}, new Object[]{"", "", "", 0, 0, null}, faceroam_sso$RspUserInfo.class);
    public final PBStringField bid;
    public final PBRepeatField<String> delete_file;
    public final PBRepeatMessageField<faceroam_sso$EmojiItem> emoji_items;
    public final PBRepeatField<String> filename;
    public final PBUInt32Field max_roam_size;
    public final PBRepeatField<Integer> uint32_emoji_type;

    public faceroam_sso$RspUserInfo() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.filename = PBField.initRepeat(pBStringField);
        this.delete_file = PBField.initRepeat(pBStringField);
        this.bid = PBField.initString("");
        this.max_roam_size = PBField.initUInt32(0);
        this.uint32_emoji_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        this.emoji_items = PBField.initRepeatMessage(faceroam_sso$EmojiItem.class);
    }
}
