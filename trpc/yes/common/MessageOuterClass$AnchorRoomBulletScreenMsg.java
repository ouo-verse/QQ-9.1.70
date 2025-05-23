package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class MessageOuterClass$AnchorRoomBulletScreenMsg extends MessageMicro<MessageOuterClass$AnchorRoomBulletScreenMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"text", "uid", "avator", "nickname"}, new Object[]{"", 0L, "", ""}, MessageOuterClass$AnchorRoomBulletScreenMsg.class);
    public final PBStringField text = PBField.initString("");
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField avator = PBField.initString("");
    public final PBStringField nickname = PBField.initString("");
}
