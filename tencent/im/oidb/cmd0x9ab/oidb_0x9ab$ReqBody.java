package tencent.im.oidb.cmd0x9ab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x9ab$ReqBody extends MessageMicro<oidb_0x9ab$ReqBody> {
    public static final int UINT32_TAB_ID_FIELD_NUMBER = 2;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_group_code", "uint32_tab_id"}, new Object[]{0L, 0}, oidb_0x9ab$ReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
}
