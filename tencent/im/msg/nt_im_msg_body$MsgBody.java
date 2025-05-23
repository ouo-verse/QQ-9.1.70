package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_im_msg_body$MsgBody extends MessageMicro<nt_im_msg_body$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField msg_content;
    public final PBBytesField msg_encrypt_content;
    public nt_im_msg_body$RichText rich_text = new nt_im_msg_body$RichText();

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"rich_text", "msg_content", "msg_encrypt_content"}, new Object[]{null, byteStringMicro, byteStringMicro}, nt_im_msg_body$MsgBody.class);
    }

    public nt_im_msg_body$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.msg_content = PBField.initBytes(byteStringMicro);
        this.msg_encrypt_content = PBField.initBytes(byteStringMicro);
    }
}
