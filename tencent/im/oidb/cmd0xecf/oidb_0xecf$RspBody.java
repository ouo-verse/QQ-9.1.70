package tencent.im.oidb.cmd0xecf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xecf$RspBody extends MessageMicro<oidb_0xecf$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"msg_quest", "strCommentCookie", "int32_comment_fetch_over", "uint64_comment_total", "str_head_nick"}, new Object[]{null, "", 0, 0L, ""}, oidb_0xecf$RspBody.class);
    public oidb_0xecf$Quest msg_quest = new oidb_0xecf$Quest();
    public final PBStringField strCommentCookie = PBField.initString("");
    public final PBInt32Field int32_comment_fetch_over = PBField.initInt32(0);
    public final PBUInt64Field uint64_comment_total = PBField.initUInt64(0);
    public final PBStringField str_head_nick = PBField.initString("");
}
