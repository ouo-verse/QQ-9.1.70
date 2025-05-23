package tencent.im.group_pro_proto.emoji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetRecentlyUsedEmojis$RspBody extends MessageMicro<GetRecentlyUsedEmojis$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"req_interval", "emoji_list"}, new Object[]{0, null}, GetRecentlyUsedEmojis$RspBody.class);
    public final PBInt32Field req_interval = PBField.initInt32(0);
    public final PBRepeatMessageField<GetRecentlyUsedEmojis$EmojiInfo> emoji_list = PBField.initRepeatMessage(GetRecentlyUsedEmojis$EmojiInfo.class);
}
