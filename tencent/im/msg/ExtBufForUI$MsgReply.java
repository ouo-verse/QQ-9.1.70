package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ExtBufForUI$MsgReply extends MessageMicro<ExtBufForUI$MsgReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"msgHasReply"}, new Object[]{Boolean.FALSE}, ExtBufForUI$MsgReply.class);
    public final PBBoolField msgHasReply = PBField.initBool(false);
}
