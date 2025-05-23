package tencent.im.c2c.msgtype0x210.submsgtype0x79;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x79$MsgBody extends MessageMicro<submsgtype0x79$MsgBody> {
    public static final int UINT32_SRC_APP_ID_FIELD_NUMBER = 1;
    public static final int UINT32_UNDEAL_COUNT_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_src_app_id", "uint32_undeal_count"}, new Object[]{0, 0}, submsgtype0x79$MsgBody.class);
    public final PBUInt32Field uint32_src_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_undeal_count = PBField.initUInt32(0);
}
