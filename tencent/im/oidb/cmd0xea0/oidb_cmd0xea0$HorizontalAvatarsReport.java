package tencent.im.oidb.cmd0xea0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xea0$HorizontalAvatarsReport extends MessageMicro<oidb_cmd0xea0$HorizontalAvatarsReport> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"head_feeds_type", "show_limit_account"}, new Object[]{0, 0}, oidb_cmd0xea0$HorizontalAvatarsReport.class);
    public final PBUInt32Field head_feeds_type = PBField.initUInt32(0);
    public final PBUInt32Field show_limit_account = PBField.initUInt32(0);
}
