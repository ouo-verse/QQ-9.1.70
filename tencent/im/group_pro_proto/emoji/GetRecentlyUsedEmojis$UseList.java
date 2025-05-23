package tencent.im.group_pro_proto.emoji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetRecentlyUsedEmojis$UseList extends MessageMicro<GetRecentlyUsedEmojis$UseList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"use_list"}, new Object[]{null}, GetRecentlyUsedEmojis$UseList.class);
    public final PBRepeatMessageField<GetRecentlyUsedEmojis$EmojiInfo> use_list = PBField.initRepeatMessage(GetRecentlyUsedEmojis$EmojiInfo.class);
}
