package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearfield_discuss$BusiReqHead extends MessageMicro<nearfield_discuss$BusiReqHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int32_version", "int32_seq"}, new Object[]{1, 0}, nearfield_discuss$BusiReqHead.class);
    public final PBInt32Field int32_version = PBField.initInt32(1);
    public final PBInt32Field int32_seq = PBField.initInt32(0);
}
