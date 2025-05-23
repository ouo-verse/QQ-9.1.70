package tencent.im.oidb.cmd0x74b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x74b$VideoHeadInfo extends MessageMicro<oidb_0x74b$VideoHeadInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"str_url", "uint32_video_size"}, new Object[]{"", 0}, oidb_0x74b$VideoHeadInfo.class);
    public final PBStringField str_url = PBField.initString("");
    public final PBUInt32Field uint32_video_size = PBField.initUInt32(0);
}
