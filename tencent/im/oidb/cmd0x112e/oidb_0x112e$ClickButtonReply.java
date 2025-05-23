package tencent.im.oidb.cmd0x112e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x112e$ClickButtonReply extends MessageMicro<oidb_0x112e$ClickButtonReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"status", "prompt_text", "prompt_type", "prompt_icon"}, new Object[]{0, "", 0, 0}, oidb_0x112e$ClickButtonReply.class);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBStringField prompt_text = PBField.initString("");
    public final PBUInt32Field prompt_type = PBField.initUInt32(0);
    public final PBUInt32Field prompt_icon = PBField.initUInt32(0);
}
