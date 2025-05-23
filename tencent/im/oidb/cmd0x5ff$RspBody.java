package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x5ff$RspBody extends MessageMicro<cmd0x5ff$RspBody> {
    public static final int STR_ERROR_TIPS_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_error_tips"}, new Object[]{""}, cmd0x5ff$RspBody.class);
    public final PBStringField str_error_tips = PBField.initString("");
}
