package trpc.qq_vgame.pk_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class AvGamePkManager$SyncGameVictorReq extends MessageMicro<AvGamePkManager$SyncGameVictorReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"victor_uin"}, new Object[]{0L}, AvGamePkManager$SyncGameVictorReq.class);
    public final PBUInt64Field victor_uin = PBField.initUInt64(0);
}
