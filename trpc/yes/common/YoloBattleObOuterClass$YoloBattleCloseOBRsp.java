package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleObOuterClass$YoloBattleCloseOBRsp extends MessageMicro<YoloBattleObOuterClass$YoloBattleCloseOBRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg", "game_matrix_ret"}, new Object[]{"", 0L}, YoloBattleObOuterClass$YoloBattleCloseOBRsp.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f437256msg = PBField.initString("");
    public final PBInt64Field game_matrix_ret = PBField.initInt64(0);
}
