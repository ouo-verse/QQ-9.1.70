package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class MessageOuterClass$TextMsg extends MessageMicro<MessageOuterClass$TextMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"text", "show_type"}, new Object[]{"", 0}, MessageOuterClass$TextMsg.class);
    public final PBStringField text = PBField.initString("");
    public final PBInt32Field show_type = PBField.initInt32(0);
}
