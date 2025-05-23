package tencent.im.oidb.cmd0xf7a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf7a$RspBody extends MessageMicro<oidb_cmd0xf7a$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret", "err_message", "emoji_detail_list"}, new Object[]{0, "", null}, oidb_cmd0xf7a$RspBody.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public final PBStringField err_message = PBField.initString("");
    public final PBRepeatMessageField<oidb_cmd0xf7a$EmojiDetail> emoji_detail_list = PBField.initRepeatMessage(oidb_cmd0xf7a$EmojiDetail.class);
}
