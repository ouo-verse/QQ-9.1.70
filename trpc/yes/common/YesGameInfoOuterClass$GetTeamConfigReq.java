package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YesGameInfoOuterClass$GetTeamConfigReq extends MessageMicro<YesGameInfoOuterClass$GetTeamConfigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"game_id", "uid"}, new Object[]{0, 0L}, YesGameInfoOuterClass$GetTeamConfigReq.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
}
