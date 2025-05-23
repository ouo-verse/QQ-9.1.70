package tencent.im.oidb.cmd0xbec;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbec$Cookies extends MessageMicro<oidb_cmd0xbec$Cookies> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_page_index", "int64_timestamp"}, new Object[]{0, 0L}, oidb_cmd0xbec$Cookies.class);
    public final PBUInt32Field uint32_page_index = PBField.initUInt32(0);
    public final PBInt64Field int64_timestamp = PBField.initInt64(0);
}
