package tencent.im.oidb.cmd0xa1e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa1e$AppClick extends MessageMicro<oidb_0xa1e$AppClick> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"appid", "click_num"}, new Object[]{0L, 0}, oidb_0xa1e$AppClick.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBUInt32Field click_num = PBField.initUInt32(0);
}
