package tencent.im.group_pro_proto.emoji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetRecentlyUsedEmojis$MsgData extends MessageMicro<GetRecentlyUsedEmojis$MsgData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "emojiInfo"}, new Object[]{0L, null}, GetRecentlyUsedEmojis$MsgData.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public GetRecentlyUsedEmojis$EmojiInfo emojiInfo = new MessageMicro<GetRecentlyUsedEmojis$EmojiInfo>() { // from class: tencent.im.group_pro_proto.emoji.GetRecentlyUsedEmojis$EmojiInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"update_time", "used_count", "emoji_type", "emoji_id"}, new Object[]{0L, 0, 0, ""}, GetRecentlyUsedEmojis$EmojiInfo.class);
        public final PBUInt64Field update_time = PBField.initUInt64(0);
        public final PBUInt32Field used_count = PBField.initUInt32(0);
        public final PBUInt32Field emoji_type = PBField.initUInt32(0);
        public final PBStringField emoji_id = PBField.initString("");
    };
}
