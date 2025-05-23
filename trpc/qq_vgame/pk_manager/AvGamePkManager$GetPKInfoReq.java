package trpc.qq_vgame.pk_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class AvGamePkManager$GetPKInfoReq extends MessageMicro<AvGamePkManager$GetPKInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field pk_id = PBField.initUInt32(0);
    public final PBUInt32Field pool_id = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBUInt64Field pull_count = PBField.initUInt64(0);
    public final PBBoolField pk_start = PBField.initBool(false);
    public final PBBoolField in_game = PBField.initBool(false);
    public final PBBoolField support_fresh_at_midfield = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"pk_id", "pool_id", "uin", "scene", "pull_count", "pk_start", "in_game", "support_fresh_at_midfield"}, new Object[]{0, 0, 0L, 0, 0L, bool, bool, bool}, AvGamePkManager$GetPKInfoReq.class);
    }
}
