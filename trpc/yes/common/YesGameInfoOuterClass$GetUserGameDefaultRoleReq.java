package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YesGameInfoOuterClass$GetUserGameDefaultRoleReq extends MessageMicro<YesGameInfoOuterClass$GetUserGameDefaultRoleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uid", "game_id", "scene"}, new Object[]{0L, 0, 0}, YesGameInfoOuterClass$GetUserGameDefaultRoleReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBInt32Field scene = PBField.initInt32(0);
}
