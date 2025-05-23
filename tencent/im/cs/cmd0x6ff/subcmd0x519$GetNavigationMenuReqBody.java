package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x519$GetNavigationMenuReqBody extends MessageMicro<subcmd0x519$GetNavigationMenuReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_puin", "uint64_uin", "uint32_ver_no"}, new Object[]{0L, 0L, 0}, subcmd0x519$GetNavigationMenuReqBody.class);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
}
