package tencent.im.s2c.msgtype0x210.submsgtype0x155;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x155$FoldingMsg extends MessageMicro<SubMsgType0x155$FoldingMsg> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField grey_prompt;
    public final PBBytesField toast;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"grey_prompt", "toast"}, new Object[]{byteStringMicro, byteStringMicro}, SubMsgType0x155$FoldingMsg.class);
    }

    public SubMsgType0x155$FoldingMsg() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.grey_prompt = PBField.initBytes(byteStringMicro);
        this.toast = PBField.initBytes(byteStringMicro);
    }
}
