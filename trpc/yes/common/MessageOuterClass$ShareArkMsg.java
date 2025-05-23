package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class MessageOuterClass$ShareArkMsg extends MessageMicro<MessageOuterClass$ShareArkMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"game_id", "card_type", "ark_msg_info"}, new Object[]{0, 0, null}, MessageOuterClass$ShareArkMsg.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBInt32Field card_type = PBField.initInt32(0);
    public MessageOuterClass$ArkBaseInfo ark_msg_info = new MessageOuterClass$ArkBaseInfo();
}
