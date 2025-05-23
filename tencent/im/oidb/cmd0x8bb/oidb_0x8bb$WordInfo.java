package tencent.im.oidb.cmd0x8bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8bb$WordInfo extends MessageMicro<oidb_0x8bb$WordInfo> {
    public static final int STR_KEYWORD_FIELD_NUMBER = 1;
    public static final int UINT32_UPDATE_TIME_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"str_keyword", "uint32_update_time"}, new Object[]{"", 0}, oidb_0x8bb$WordInfo.class);
    public final PBStringField str_keyword = PBField.initString("");
    public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
}
