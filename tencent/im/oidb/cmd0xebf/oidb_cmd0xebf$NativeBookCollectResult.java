package tencent.im.oidb.cmd0xebf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xebf$NativeBookCollectResult extends MessageMicro<oidb_cmd0xebf$NativeBookCollectResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"book_id", "is_collected"}, new Object[]{"", 0}, oidb_cmd0xebf$NativeBookCollectResult.class);
    public final PBStringField book_id = PBField.initString("");
    public final PBUInt32Field is_collected = PBField.initUInt32(0);
}
