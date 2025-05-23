package tencent.im.oidb.cmd0xe3e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe3e$GroupList extends MessageMicro<oidb_0xe3e$GroupList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_group_code", "uint32_common_friend_count"}, new Object[]{0L, 0}, oidb_0xe3e$GroupList.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_common_friend_count = PBField.initUInt32(0);
}
