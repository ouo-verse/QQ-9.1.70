package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleObOuterClass$YoloBattleStartOBRsp extends MessageMicro<YoloBattleObOuterClass$YoloBattleStartOBRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"msg", "ob_id", "url", "yolo_battle_id", "game_matrix_ret"}, new Object[]{"", 0L, "", 0L, 0L}, YoloBattleObOuterClass$YoloBattleStartOBRsp.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f437258msg = PBField.initString("");
    public final PBInt64Field ob_id = PBField.initInt64(0);
    public final PBStringField url = PBField.initString("");
    public final PBUInt64Field yolo_battle_id = PBField.initUInt64(0);
    public final PBInt64Field game_matrix_ret = PBField.initInt64(0);
}
