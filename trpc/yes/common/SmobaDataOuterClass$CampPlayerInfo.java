package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class SmobaDataOuterClass$CampPlayerInfo extends MessageMicro<SmobaDataOuterClass$CampPlayerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"partition_id", "game_openid", "game_uid"}, new Object[]{0, "", 0L}, SmobaDataOuterClass$CampPlayerInfo.class);
    public final PBInt32Field partition_id = PBField.initInt32(0);
    public final PBUInt64Field game_uid = PBField.initUInt64(0);
    public final PBStringField game_openid = PBField.initString("");
}
